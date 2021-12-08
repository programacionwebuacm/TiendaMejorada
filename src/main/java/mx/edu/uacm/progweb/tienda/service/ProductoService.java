package mx.edu.uacm.progweb.tienda.service;

import java.util.List;

import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.error.AplicacionExcepcion;

public interface ProductoService {
	
	List<Producto> obtenerProductos();
	
	Producto agregarProducto(Producto producto) throws AplicacionExcepcion;

}
