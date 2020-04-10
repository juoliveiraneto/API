package com.summit.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summit.api.datasource.model.Produto;
import com.summit.api.repository.ProdutoRepository;

@Service
public class BuscarProdutos {

	@Autowired
	public ProdutoRepository produtoRepository;
	
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
}
