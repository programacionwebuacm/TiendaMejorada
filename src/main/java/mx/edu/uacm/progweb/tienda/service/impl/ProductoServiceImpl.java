package mx.edu.uacm.progweb.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.error.AplicacionExcepcion;
import mx.edu.uacm.progweb.tienda.repository.ProductoRepository;
import mx.edu.uacm.progweb.tienda.service.ProductoService;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {
	
	//inyeccion de dependencias
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> obtenerProductos() {
		
		return (List<Producto>) productoRepository.findAll();
	}

	
	public Producto agregarProducto(Producto producto) throws AplicacionExcepcion {
		
		if(log.isDebugEnabled())
			log.debug("> Entrando a agregarProducto <");
		
		Producto productoGuardado = null;
		
		try {
			
			productoGuardado = productoRepository.save(producto);
		
		} catch (DataAccessException e) {
			log.error(e.getMessage());
			//Hardcode
			//TODO implementar localizacion mediante message resources
			throw new AplicacionExcepcion("Hubo un error al guardar el registro");
		}
		
		
		return productoGuardado;
	}


	@Override
	public Page<Producto> obtenerProductosPaginados(Pageable pageable) {
		
		return productoRepository.findAll(pageable);
	}

}
