package edu.usal.tp.negocio.dao.dominio;

public class Paises {

	private int id;
	private String nombre;

	public Paises() {

	}

	public Paises(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

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

}
