package mx.edu.uacm.progweb.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uacm.progweb.tienda.dominio.Producto;
import mx.edu.uacm.progweb.tienda.error.AplicacionExcepcion;
import mx.edu.uacm.progweb.tienda.service.ProductoService;

@Controller
@RequestMapping("/producto")
@Slf4j
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@PostMapping("/guardar")
	public String guardarProducto(Model model,Producto producto) {
		if(log.isDebugEnabled()) {
			log.debug("> Entrando a ProductoController.guardarProducto");
			log.debug("Producto {}", producto);
		}
		
		Producto productoGuardado = null;
		
		try {
			productoGuardado = productoService.agregarProducto(producto);
			if(productoGuardado != null && productoGuardado.getId() != null)
				model.addAttribute("mensajeExitoso", "Registro guardado exitosamente");
		} catch (AplicacionExcepcion e) {
			log.error(e.getMessage());
			model.addAttribute("mensajeError", e.getMessage());
		}
		
		return "redirect:/admin-cat";
	}

}
