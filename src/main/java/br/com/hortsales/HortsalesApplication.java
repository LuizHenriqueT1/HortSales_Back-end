package br.com.hortsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HortsalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HortsalesApplication.class, args);
        System.out.println("Servidor HortSales.com Funcionando localhost:8080");
	}

}
