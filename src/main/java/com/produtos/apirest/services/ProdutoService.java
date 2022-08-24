package com.produtos.apirest.services;

import com.produtos.apirest.models.Produto;

import java.util.List;

public interface ProdutoService {

	List<Produto> listarProdutos();

	Produto listarProdutoUnico(long id);

	Produto salvarProduto(Produto produto);

	void deletarProduto(Produto produto);

	Produto atualizarProduto(Produto produto);

}
