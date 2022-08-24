package com.produtos.apirest;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApirestApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {

		Produto prod1 = new Produto(null,"Computador", 2000.00, 1);
		Produto prod2 = new Produto(null,"celular", 1000.00, 1);
		Produto prod3 = new Produto(null,"mouse", 80.00, 1);
		Produto prod4 = new Produto(null,"teclado", 20.00, 1);
		Produto prod5 = new Produto(null,"suporte", 200.00, 1);
		Produto prod6 = new Produto(null,"pendrive", 30.00, 1);


		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6));

	}
}
