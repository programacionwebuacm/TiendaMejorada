package mx.edu.uacm.progweb.tienda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import mx.edu.uacm.progweb.tienda.dominio.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	Page<Producto> findAll(Pageable pageable);

}
