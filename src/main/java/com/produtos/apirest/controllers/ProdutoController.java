package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Produto>> listarProdutos() {

		List<Produto> produtos = produtoService.listarProdutos();

		return ResponseEntity.ok().body(produtos);
	}

	@Operation(summary = "listar produto por id")
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Optional<Produto>> listarProdutoUnico(@PathVariable(value = "id") Integer id) throws NotFoundException {
		Optional<Produto> produto = produtoService.listarProdutoUnico(id);

		return ResponseEntity.ok().body(produto);
	}

	@Operation(summary = "salvar produto")
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		 produtoService.salvarProduto(produto);

		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}

	@Operation(summary = "deletar produto")
	@DeleteMapping("/produtos")
	public ResponseEntity<Void> deletarProduto(@RequestBody Produto produto) {
		produtoService.deletarProduto(produto);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Operation(summary = "alterar produto")
	@PutMapping("/produtos")
	public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) {
		produtoService.atualizarProduto(produto);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
