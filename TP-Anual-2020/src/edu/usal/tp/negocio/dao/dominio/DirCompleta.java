package edu.usal.tp.negocio.dao.dominio;

public class DirCompleta {
	
	private int idDirCompleta;
	private String calle;
	private String altura;
	private String ciudad;
	private Paises pais; 
	private Provincias provincia;
	private String codigoPostal;
	
	//Getter & Setter
	
	
	public String getCalle() {
		return calle;
	}
	public int getIdDirCompleta() {
		return idDirCompleta;
	}
	public void setIdDirCompleta(int idDirCompleta) {
		this.idDirCompleta = idDirCompleta;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}
	public void setProvincia(Provincias provincia) {
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
	
	
	//Constructors
	
	public DirCompleta(int idDirCompleta, String calle, String altura, String ciudad, Paises pais, Provincias provincia, String codigoPostal) {
		this.idDirCompleta = idDirCompleta;
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}
	public DirCompleta() {
		
	}
	public Paises getPais() {
		return pais;
	}
	public Provincias getProvincia() {
		return provincia;
	}
	public void setPaisID(String id) {
		this.pais.setId(id);
		
	}
	public void setProvinciaID(String id) {
		this.provincia.setId(id);
		
	}
	
}
