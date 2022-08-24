package com.produtos.apirest.services;

import com.produtos.apirest.models.Produto;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

	List<Produto> listarProdutos();

	Optional<Produto> listarProdutoUnico(Integer id) throws NotFoundException;

	Produto salvarProduto(Produto produto);

	void deletarProduto(Produto produto);

	Produto atualizarProduto(Produto produto);

}
