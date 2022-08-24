package com.produtos.apirest.services;

import com.produtos.apirest.exceptions.ObjectNotFoundException;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Optional<Produto> listarProdutoUnico(@PathVariable(value = "id") Integer id) throws NotFoundException {
		Optional<Produto>  prod = produtoRepository.findById(id);
		if(!prod.isPresent()){
			throw new ObjectNotFoundException("Produto não encontrado");
		}
		return prod;
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
