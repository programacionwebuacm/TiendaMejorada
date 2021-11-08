package mx.edu.uacm.progweb.tienda.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	//esta propiedad sera la columna id
	//la estrategia de generacion sera auto incrementable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int clave;
	private String nombre;
	private Double precio;
	private int cantidad;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}
	
	

}
