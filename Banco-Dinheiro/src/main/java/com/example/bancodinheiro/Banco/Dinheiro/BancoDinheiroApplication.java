package com.example.bancodinheiro.Banco.Dinheiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Erro corigido no perplexity, verificar o novo erro
@SpringBootApplication
@ComponentScan(basePackages = "com.example.bancodinheiro.Banco.Dinheiro")
public class BancoDinheiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoDinheiroApplication.class, args);
	}

}
