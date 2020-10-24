package edu.usal.tp.negocio.dao.dominio;

public class DireccionCompleta {

	private int id;
	private String calle;
	private String altura;
	private String ciudad;
	private Pais pais;
	private Provincia provincia;
	private String codigoPostal;

	// Getter & Setter

	public String getCalle() {
		return calle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Pais getPais() {
		return pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setPaisID(int idPais) {
		this.pais.setId(idPais);

	}

	public void setProvinciaID(int idProvincia) {
		this.provincia.setId(idProvincia);

	}

	// Constructors

	public DireccionCompleta() {

	}

	public DireccionCompleta(int id, String calle, String altura, String ciudad, Pais pais, Provincia provincia,
			String codigoPostal) {
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

}
