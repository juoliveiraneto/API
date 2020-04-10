package com.summit.api.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResource {
	
	@JsonProperty("codigo_produto")
	private String codigo;
	
	@JsonProperty("descricao_produto")
	private String descricao;
	
	@JsonProperty("preco_produto")
	private String preco;

	@JsonProperty("quantidade_produto")
	private String quantidade;
	
	@JsonProperty("unidade_produto")
	private String unidade;
	

	public ProdutoResource(String codigo, String descricao, String preco, String quantidade, String unidade) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}

	public ProdutoResource() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "ProdutoResource [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", unidade=" + unidade + "]";
	}

}
