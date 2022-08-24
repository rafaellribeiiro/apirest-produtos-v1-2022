package com.produtos.apirest.services;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto listarProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@Override
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@Override
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

}
