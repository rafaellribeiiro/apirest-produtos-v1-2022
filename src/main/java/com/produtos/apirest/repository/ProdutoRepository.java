package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findById(Integer id);

}
