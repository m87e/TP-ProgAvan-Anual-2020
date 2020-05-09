package edu.usal.tp.negocio.dao.dominio;

public class Aerolinea {

	private String id;
	private String nombre;
	private String alianza; // pasarlo a lista (No deberia ser ni un list ni un string
							// la alianza puede ser solo un nombre, ej OneWorld
							// y cada aerolinea pertenece a una alianza

	private Vuelos[] vuelo; // pasarlo a lista

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

	public String getAlianza() {
		return alianza;
	}

	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}

	public Vuelos[] getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelos[] vuelo) {
		this.vuelo = vuelo;
	}

	public Aerolinea() {

		// TODO Auto-generated constructor stub
	}

	public Aerolinea(String id, String nombre, String alianza, Vuelos[] vuelo) {
		this.id = id;
		this.nombre = nombre;
		this.alianza = alianza;
		this.vuelo = vuelo;
	}

}
