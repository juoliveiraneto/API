package com.summit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.api.datasource.model.Produto;
import com.summit.api.exception.ProdutoResourceException;
import com.summit.api.repository.ProdutoRepository;
import com.summit.api.resource.model.ProdutoResource;

@Service
public class CadastroProduto {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoConversor serviceConversor;
	
	public void cadastro(ProdutoResource produtoResource) throws ProdutoResourceException {
		Produto produto = null;
		try {
			produto = serviceConversor.conversor(produtoResource);
			produtoRepository.saveAndFlush(produto);
		} catch (ProdutoResourceException e) {
			e.printStackTrace();
			throw new ProdutoResourceException("Falha ao converter para entidade: " + produtoResource);
		}
	}
	
}
