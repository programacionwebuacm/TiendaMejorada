package mx.edu.uacm.progweb.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TiendaMejoradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaMejoradaApplication.class, args);
	}

}
