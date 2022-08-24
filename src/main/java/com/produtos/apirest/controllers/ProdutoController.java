package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@Operation(summary = "listar todos os produtos")
	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@Operation(summary = "listar produto por id")
	@GetMapping("/produtos/{id}")
	public Optional<Produto> listarProdutoUnico(@PathVariable(value = "id") Integer id) throws NotFoundException {
		return produtoService.listarProdutoUnico(id);
	}

	@Operation(summary = "salvar produto")
	@PostMapping("/produtos")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@Operation(summary = "deletar produto")
	@DeleteMapping("/produtos")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoService.deletarProduto(produto);
	}

	@Operation(summary = "alterar produto")
	@PutMapping("/produtos")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoService.atualizarProduto(produto);

	}

}
