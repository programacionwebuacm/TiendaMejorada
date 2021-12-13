package mx.edu.uacm.progweb.tienda.dominio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.TiendaMejoradaApplication;
import mx.edu.uacm.progweb.tienda.repository.ProductoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;

@SpringBootTest(classes = {TiendaMejoradaApplication.class})
@Slf4j
public class ProductoTest {
	
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	@Disabled
	public void debeGuardarProducto() {
		log.debug("> Entrando a debeGuardarProducto <");
		Producto p = new Producto();
		p.setClave(23);
		p.setNombre("pesas");
		p.setPrecio(Double.valueOf("200"));
		p.setCantidad(100);
		Producto productoGuardado = productoRepository.save(p);
		assertNotNull(productoGuardado);
	}
	
	@Test
	public void debeObtenerProductosPaginados() {
		log.debug("> Entrando a debeObtenerProductosPaginados <");
		
		Pageable pageable = PageRequest.of(0, 5);
		
		//pagina 0 que tiene del 0 al 4
		assertThat(productoRepository.findAll(pageable)).hasSize(5);
		
		//pagina 1 que tiene 5 10
		Pageable nextPageable = pageable.next();
		assertThat(productoRepository.findAll(nextPageable)).hasSize(5);
		assertThat(nextPageable.getPageNumber()).isEqualTo(1);
		
	}

}
