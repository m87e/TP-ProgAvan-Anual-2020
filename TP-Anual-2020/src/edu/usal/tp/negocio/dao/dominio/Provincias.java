package edu.usal.tp.negocio.dao.dominio;

public class Provincias {

	private int id;
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincias(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Provincias() {
		// TODO Auto-generated constructor stub
	}

}
