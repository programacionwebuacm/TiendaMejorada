package mx.edu.uacm.progweb.tienda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.edu.uacm.progweb.tienda.dominio.Usuario;
import mx.edu.uacm.progweb.tienda.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession;
	
	@PostMapping("/login")
	public String login(@RequestParam("correo") String correo, @RequestParam("contrasenia") String password,
			Model model) {
		
		Usuario usuario = usuarioService.obtenerUsuarioPorCorreoYContrasenia(correo, password);
		
		if(usuario != null) {
			httpSession.setAttribute("userLoggedIn", usuario);
			
		} else {
			model.addAttribute("error", "Usuario/Contrasenia no validos");
			return "redirect:/login";
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		httpSession.removeAttribute("userLoggedIn");
		
		return "redirect:/";
	}
	
	

}
