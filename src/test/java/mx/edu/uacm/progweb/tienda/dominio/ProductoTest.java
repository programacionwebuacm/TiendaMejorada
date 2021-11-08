package mx.edu.uacm.progweb.tienda.dominio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.edu.uacm.progweb.tienda.TiendaMejoradaApplication;
import mx.edu.uacm.progweb.tienda.repository.ProductoRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {TiendaMejoradaApplication.class})
public class ProductoTest {
	
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	public void debeGuardarProducto() {
		System.out.println("> Entrando a debeGuardarProducto <");
		Producto p = new Producto();
		p.setClave(23);
		p.setNombre("pesas");
		p.setPrecio(Double.valueOf("200"));
		p.setCantidad(100);
		Producto productoGuardado = productoRepository.save(p);
		assertNotNull(productoGuardado);
	}

}
