package edu.usal.tp.negocio.dao.dominio;

public class Aeropuerto {
	private String idAeropuerto;
	private String ciudad;
	private Provincias provincia;
	private Paises pais;

	public String getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
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

	public Aeropuerto(String idAeropuerto, String ciudad, Provincias provincia, Paises pais) {

		this.idAeropuerto = idAeropuerto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Aeropuerto() {

		// TODO Auto-generated constructor stub
	}

}
