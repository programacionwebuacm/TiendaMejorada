package mx.edu.uacm.progweb.tienda.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.dominio.Usuario;
import mx.edu.uacm.progweb.tienda.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession;
	
	private ServletContext servletContext;
	
	public UsuarioController(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@PostMapping("/login")
	public String iniciarSesion(@RequestParam("correo") String correo, @RequestParam("contrasenia") String password,
			Model model) {
		
		if(log.isDebugEnabled())
			log.debug("> Entrando al metodo iniciarSesion <");
		
		Usuario usuario = usuarioService.obtenerUsuarioPorCorreoYContrasenia(correo, password);
		
		if(usuario != null) {
			
			httpSession.setAttribute("usuarioLogueado", usuario);
			
		} else {
			
			//Si algo va mal te regresa a la misma vista login y te regresa el  fragmento cuyo id es contenedor html 
			servletContext.setAttribute("errorMensaje", "Usuario/Contrasenia no validos");
			//model.addAttribute("errorMensaje", "Usuario/Contrasenia no validos");
			//model.addAttribute("correoRecibido", correo);
			//return "login::#contenedor";
			return "redirect:/login";
		}
		
		//si fue exitoso te redirecciona a la vista home con el atributo en sesion llamado usuarioLogueado
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		httpSession.removeAttribute("usuarioLogueado");
		
		return "redirect:/";
	}
	

	@GetMapping("/initlogin")
	public String iniciarLogin() {
		
		servletContext.removeAttribute("errorMensaje");
		
		return "redirect:/login";
	}
	
	

}
