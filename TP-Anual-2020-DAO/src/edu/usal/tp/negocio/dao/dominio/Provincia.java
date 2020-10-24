package edu.usal.tp.negocio.dao.dominio;

public class Provincia {

	private int id;
	private String nombre;

	// Getter & Setter

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

	// Constructors

	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public Provincia(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

}
