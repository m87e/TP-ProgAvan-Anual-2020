package edu.usal.tp.negocio.dao.dominio;

public class Aeropuerto {
	private String id;
	private String ciudad;
	private Provincias provincia;
	private Paises pais;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Aeropuerto(String id, String ciudad, Provincias provincia, Paises pais) {

		this.id = id;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Aeropuerto() {

		// TODO Auto-generated constructor stub
	}

}
