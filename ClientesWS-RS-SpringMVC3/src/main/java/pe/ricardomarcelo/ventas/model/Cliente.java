package pe.ricardomarcelo.ventas.model;

import java.io.Serializable;


public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
