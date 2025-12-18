package edu.ar.listovoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ListovoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListovoyApplication.class, args);
		System.out.println(":)Aplicacion LISTOVOY iniciada correctamente en http://localhost:8080/");
	}

}
 
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "edu.ar.listovoy.repository")
//public class ListovoyApplication {
    //public static void main(String[] args) {
        //SpringApplication.run(ListovoyApplication.class, args);
   // }
//}
