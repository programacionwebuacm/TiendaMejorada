package mx.edu.uacm.progweb.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import mx.edu.uacm.progweb.tienda.dominio.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByCorreoAndContrasenia(String correo, String contrasenia);

	Usuario findByCorreo(String correo);
}
