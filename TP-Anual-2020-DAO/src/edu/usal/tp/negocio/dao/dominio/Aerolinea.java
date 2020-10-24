package edu.usal.tp.negocio.dao.dominio;

public class Aerolinea {

	private int id;
	private String nombre;
	private Alianza alianza;

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

	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	// Constructors

	public Aerolinea() {

		// TODO Auto-generated constructor stub
	}

	public Aerolinea(int id, String nombre, Alianza alianza) {
		this.id = id;
		this.nombre = nombre;
		this.alianza = alianza;
	}

}
