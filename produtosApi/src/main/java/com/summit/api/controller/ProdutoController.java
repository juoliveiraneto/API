package com.summit.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.summit.api.datasource.model.Produto;
import com.summit.api.exception.ProdutoResourceException;
import com.summit.api.resource.model.ProdutoResource;
import com.summit.api.service.CadastroProduto;
import com.summit.api.service.DeletarPorId;
import com.summit.api.service.UpdateProduto;
import com.summit.api.service.BuscarPorId;
import com.summit.api.service.BuscarProdutos;

@Api(value = "API REST Produtos")
@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	@Autowired
	private BuscarProdutos serviceBuscarTodos;
	
	@Autowired
	private CadastroProduto serviceCadastro;
	
	@Autowired
	private BuscarPorId serviceBuscarPorId;
	
	@Autowired
	private DeletarPorId serviceDeletarPorId;
	
	@Autowired
	private UpdateProduto serviceUpdateProduto;
	
	@ApiOperation(value = "Retorna uma lista de Produtos")
	@GetMapping(path = "/produtos")
	public List<Produto> getAll() {
		return serviceBuscarTodos.listaProdutos();
	}
	
	@ApiOperation(value = "Retorna um produto de acordo com o ID")
	@GetMapping(path = "/produto/id/{id}")
	public Produto getById(@PathVariable (name =  "id", required = true) Long id) throws Exception {
		return serviceBuscarPorId.buscarPorId(id);
	}
	
	@ApiOperation(value = "Cadastra um produto")
	@PostMapping(path = "/produto/save")
	public void saveProduto(@RequestBody ProdutoResource produto) throws ProdutoResourceException {
		serviceCadastro.cadastro(produto);
	}
	
	@ApiOperation(value = "Deleta um produto pelo ID")
	@DeleteMapping(path = "/produto/delete/{id}")
	public void deleteProduto(@PathVariable (name = "id", required = true) Long id) throws Exception {
		serviceDeletarPorId.deletarPorId(id);
	}
	
	@ApiOperation(value = "Atualiza os dados de um produto pelo ID")
	@PutMapping(path = "/produto/update/{id}")
	public void updateProduto(@PathVariable (name = "id", required = true) Long id, 
			@RequestBody ProdutoResource produto) throws Exception {
		serviceUpdateProduto.update(id, produto);
	}
	
}
