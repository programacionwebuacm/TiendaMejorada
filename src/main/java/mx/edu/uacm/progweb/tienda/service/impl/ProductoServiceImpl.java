package mx.edu.uacm.progweb.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.repository.ProductoRepository;
import mx.edu.uacm.progweb.tienda.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	//inyeccion de dependencias
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> obtenerProductos() {
		
		return (List<Producto>) productoRepository.findAll();
	}

}
