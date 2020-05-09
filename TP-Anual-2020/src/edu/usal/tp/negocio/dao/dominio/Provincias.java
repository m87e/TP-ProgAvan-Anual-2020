package edu.usal.tp.negocio.dao.dominio;

public class Provincias {
	private String id;
	private String nombre;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Provincias(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public Provincias() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
