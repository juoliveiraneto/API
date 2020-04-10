package com.summit.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.api.datasource.model.Produto;
import com.summit.api.exception.ProdutoNotFoundException;
import com.summit.api.repository.ProdutoRepository;

@Service
public class DeletarPorId {

	@Autowired
	public ProdutoRepository produtoRepository;
	
	public void deletarPorId(Long id) throws Exception {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		
		if (!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException("Produto não encontrado através do ID: " + id);
		} else {
			produtoRepository.delete(optionalProduto.get());
		}
		
	}
	
}
