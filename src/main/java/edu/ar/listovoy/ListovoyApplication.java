package edu.ar.listovoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListovoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListovoyApplication.class, args);
		System.out.println(":)Aplicacion LISTOVOY iniciada correctamente en http://localhost:8081/");
	}

}
