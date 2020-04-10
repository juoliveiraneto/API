package com.summit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.api.datasource.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
