package mx.edu.uacm.progweb.tienda.service.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.edu.uacm.progweb.tienda.TiendaMejoradaApplication;
import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.service.ProductoService;

@SpringBootTest(classes = {TiendaMejoradaApplication.class})
public class ProductoServiceImplTest {

	@Autowired
	private ProductoService productoService;
	
	//Spring resuelva la inyeccion de dependencias es decir la creacion de instancias dentro de una clase
	//private ProductoService productoService = new ProductoServiceImpl();
	
	@Test
	public void debeObtenerProductos() {
		
		System.out.println("Entrando a debeObtenerProductos");
		
		List<Producto> lista = productoService.obtenerProductos();
		
		for (Producto producto : lista) {
			System.out.println(producto.toString());
		}
		
		
	}
}
