package mx.edu.uacm.progweb.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.dominio.Usuario;
import mx.edu.uacm.progweb.tienda.repository.UsuarioRepository;
import mx.edu.uacm.progweb.tienda.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;    
	/**
	 * {@link mx.edu.uacm.progweb.tienda.service.UsuarioService#obtenerUsuarioPorCorreoYContrasenia(String, String)}
	 */
	public Usuario obtenerUsuarioPorCorreoYContrasenia(String correo, String contraseniaPlana) {
		
		if(log.isDebugEnabled())
			log.debug("> Entrando a UsuarioServiceImpl.obtenerUsuarioPorCorreoYContrasenia()");
		
		//--> incorrecto contrasenia = passwordEncoder.encode(contrasenia);
		//Usuario usuarioRecuperado = usuarioRepository.findByCorreoAndContrasenia(correo, contrasenia);
		
		Usuario usuarioRecuperado = usuarioRepository.findByCorreo(correo);
		
		log.debug("usuario recuperado: " + usuarioRecuperado);
		
		if(usuarioRecuperado != null && passwordEncoder.matches(contraseniaPlana, usuarioRecuperado.getContrasenia())) {
			
			return usuarioRecuperado;
		} else {
			
			return null;
		}

	}

}
