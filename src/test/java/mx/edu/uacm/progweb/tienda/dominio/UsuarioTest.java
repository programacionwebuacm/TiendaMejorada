package mx.edu.uacm.progweb.tienda.dominio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.TiendaMejoradaApplication;
import mx.edu.uacm.progweb.tienda.repository.UsuarioRepository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {TiendaMejoradaApplication.class})
@Slf4j
public class UsuarioTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;   
	
	
	@Test
	public void debeGuardarUsuario() {
		log.debug("Entrando a debeGuardarUsuario");
		
		Usuario usuario = new Usuario("sergio.mena@uacm.edu.mx", passwordEncoder.encode("1234"));
		
		
		Usuario usuarioGuardado = usuarioRepository.save(usuario);
		
		assertNotNull(usuarioGuardado);
		assertNotNull(usuarioGuardado.getId());
	}

}
