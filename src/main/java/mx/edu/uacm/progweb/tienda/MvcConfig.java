package mx.edu.uacm.progweb.tienda;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/agregar").setViewName("agregarProducto");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login");
	}

}
