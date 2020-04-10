package com.summit.api.service;

import java.math.BigDecimal;
import java.text.Normalizer;

import org.springframework.stereotype.Component;

import com.summit.api.datasource.model.Produto;
import com.summit.api.exception.ProdutoResourceException;
import com.summit.api.resource.model.ProdutoResource;

@Component
public class ProdutoConversor {
	
	public Produto conversor(ProdutoResource produtoResource) throws ProdutoResourceException {
		
		try {
			Produto produto = new Produto();
			
			BigDecimal preco = checkNumerics(produtoResource.getPreco());
			if (preco.compareTo(BigDecimal.ZERO) < 0) {
				preco = BigDecimal.ZERO;
			}
			
			BigDecimal quantidade = checkNumerics(produtoResource.getQuantidade());
			if (quantidade.compareTo(BigDecimal.ZERO) < 0) {
				quantidade = BigDecimal.ZERO;
			}
			
			produto.setPreco(preco);
			produto.setQuantidade(quantidade);
			produto.setDescricao(validaString(produtoResource.getDescricao()));
			produto.setUnidade(validaString(produtoResource.getUnidade()));
			produto.setCodigoProduto(validaString(produtoResource.getCodigo()));
			
			return produto;
			
		} catch (Exception e) {
			throw new ProdutoResourceException("Falha ao converter para entidade: " + produtoResource);
		}
		
	}
	
	private BigDecimal checkNumerics(String valor) {
		return new BigDecimal(valor);
	}
	
	private String validaString(String texto) {
		String resultado = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD);
		resultado = resultado.replaceAll("[^\\p{ASCII}]", "");
		
		return resultado;
	}

}
