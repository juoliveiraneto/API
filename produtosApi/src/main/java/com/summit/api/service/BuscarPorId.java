package com.summit.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.api.datasource.model.Produto;
import com.summit.api.exception.ProdutoNotFoundException;
import com.summit.api.repository.ProdutoRepository;

@Service
public class BuscarPorId {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public Produto buscarPorId(Long id) throws Exception {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		Produto produto = null;
		
		if (!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException("Produto não encontrado através do ID: " + id);
		} else {
			produto = optionalProduto.get();
		}
		
		return produto;
	}
	
}
