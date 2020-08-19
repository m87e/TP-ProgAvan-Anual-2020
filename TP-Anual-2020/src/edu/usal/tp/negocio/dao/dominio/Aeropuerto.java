package edu.usal.tp.negocio.dao.dominio;

public class Aeropuerto {
	private int id;
	private String codigo;
	private String ciudad;
	private Provincias provincia;
	private Paises pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Aeropuerto(int id, String codigo, String ciudad, Provincias provincia, Paises pais) {

		this.id = id;
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Aeropuerto() {

		// TODO Auto-generated constructor stub
	}

}
