package com.summit.api.service;

import java.math.BigDecimal;
import java.text.Normalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.api.datasource.model.Produto;
import com.summit.api.repository.ProdutoRepository;
import com.summit.api.resource.model.ProdutoResource;

import javassist.tools.web.BadHttpRequest;

@Service
public class UpdateProduto {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public Produto update (Long id, ProdutoResource produto) throws BadHttpRequest {
		
		if (produtoRepository.existsById(id)) {
			Produto p = produtoRepository.getOne(id);
			p.setDescricao(validaString(produto.getDescricao()));
			p.setCodigoProduto(validaString(produto.getCodigo()));
			p.setUnidade(validaString(produto.getUnidade()));
			
			BigDecimal preco = checkNumerics(produto.getPreco());
			if (preco.compareTo(BigDecimal.ZERO) < 0) {
				preco = BigDecimal.ZERO;
			}
			
			BigDecimal quantidade = checkNumerics(produto.getQuantidade());
			if (quantidade.compareTo(BigDecimal.ZERO) < 0) {
				quantidade = BigDecimal.ZERO;
			}
			
			p.setPreco(preco);
			p.setQuantidade(quantidade);
			
			return produtoRepository.save(p) ;
		} else {
			throw new BadHttpRequest();
		}
	}
	
	private String validaString(String texto) {
		String resultado = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD);
		resultado = resultado.replaceAll("[^\\p{ASCII}]", "");
		
		return resultado;
	}
	
	private BigDecimal checkNumerics(String valor) {
		return new BigDecimal(valor);
	}

}
