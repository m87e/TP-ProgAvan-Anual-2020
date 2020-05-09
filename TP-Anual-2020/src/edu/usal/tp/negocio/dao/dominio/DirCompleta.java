package edu.usal.tp.negocio.dao.dominio;

public class DirCompleta {
	
	private int ID;
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	
	public DirCompleta(int ID, String calle, String altura, String ciudad, Paises pais, Provincias provincia, String codigoPostal) {
		this.ID = ID;
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
