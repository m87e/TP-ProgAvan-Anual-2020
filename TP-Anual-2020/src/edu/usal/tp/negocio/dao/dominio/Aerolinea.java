package edu.usal.tp.negocio.dao.dominio;

import java.util.List;

public class Aerolinea {

	private String id;
	private String nombre;
	private Alianza alianza;
	private List<Vuelos> vuelos;

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

	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	public List<Vuelos> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelos> vuelo) {
		this.vuelos = vuelo;
	}

	public Aerolinea() {

		// TODO Auto-generated constructor stub
	}

	public Aerolinea(String id, String nombre, Alianza alianza, List<Vuelos> vuelo) {
		this.id = id;
		this.nombre = nombre;
		this.alianza = alianza;
		this.vuelos = vuelo;
	}

}
