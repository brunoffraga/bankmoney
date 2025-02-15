package com.example.bancodinheiro.Banco.Dinheiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*https://www.devmedia.com.br/tipos-de-heranca-no-hibernate/28641
* implementar a pessoa
*/
//Erro corigido no perplexity, verificar o novo erro
//Erro ao atualizar o contato.
@SpringBootApplication
@ComponentScan(basePackages = "com.example.bancodinheiro.Banco.Dinheiro")
public class BancoDinheiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoDinheiroApplication.class, args);
	}

}
