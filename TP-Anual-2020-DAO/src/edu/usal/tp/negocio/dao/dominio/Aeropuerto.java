package edu.usal.tp.negocio.dao.dominio;

public class Aeropuerto {
	private int id;
	private String codigo;
	private String ciudad;
	private Provincia provincia;
	private Pais pais;

	// Getter & Setter

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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	// Constructors

	public Aeropuerto() {

		// TODO Auto-generated constructor stub
	}

	public Aeropuerto(int id, String codigo, String ciudad, Provincia provincia, Pais pais) {

		this.id = id;
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}

}
