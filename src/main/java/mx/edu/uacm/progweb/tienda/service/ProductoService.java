package mx.edu.uacm.progweb.tienda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.error.AplicacionExcepcion;

public interface ProductoService {
	
	/**
	 * 
	 * @return
	 */
	List<Producto> obtenerProductos();
	
	/**
	 * 
	 * @param producto
	 * @return
	 * @throws AplicacionExcepcion
	 */
	Producto agregarProducto(Producto producto) throws AplicacionExcepcion;
	/**
	 * Metodo para obtener productos de manera paginada
	 * @param pageable
	 * @return
	 */
	Page<Producto> obtenerProductosPaginados(Pageable pageable);

}
