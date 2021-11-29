package mx.edu.uacm.progweb.tienda.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String correo;
	private String contrasenia;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCorreo(String correo) {
		//TODO validaciones
		this.correo = correo;
	}
	
	public Usuario(String correo,  String contrasenia){
		this.contrasenia = contrasenia;
		this.correo  = correo;
	}
	

}
