package mx.edu.uacm.progweb.tienda.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "admin-catalogos::#modalMensaje";
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model) {
		
		if(log.isDebugEnabled())
			log.debug("> Entrando a buscar <");
		
		List<Producto> productos = productoService.obtenerProductos();
		
		model.addAttribute("productos", productos);
		
		
		return "admin-catalogos";
	}
	
	@GetMapping("/buscarPaginado")
	public String buscarPaginado(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		if(log.isDebugEnabled()) {
			log.debug("> Entrando a ProductoController.buscarPaginado");
			
		}
		
		//numero pagina
		final int paginaActual = page.orElse(1);
		//tamanio de registros 
		final int tamanioPagina = size.orElse(10);
		
		Page<Producto> productosPaginados = productoService.obtenerProductosPaginados(PageRequest.of(paginaActual-1, tamanioPagina));
		
		
		model.addAttribute("productos", productosPaginados);
		
		int totalPaginas = productosPaginados.getTotalPages();
		
		if(totalPaginas > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPaginas).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		return "admin-catalogos-paginacion::#resultado";
		
	}

}
