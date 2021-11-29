package mx.edu.uacm.progweb.tienda.service;

import mx.edu.uacm.progweb.tienda.dominio.Usuario;

public interface UsuarioService {
	
	/**
	 * Metodo para obtener al usuario 
	 * @param correo
	 * @param contrasenia
	 * @return Objeto usuario
	 */
	Usuario obtenerUsuarioPorCorreoYContrasenia(String correo, String contrasenia);
	

}
