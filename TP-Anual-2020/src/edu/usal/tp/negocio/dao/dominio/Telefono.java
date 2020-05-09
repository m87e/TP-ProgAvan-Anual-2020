package edu.usal.tp.negocio.dao.dominio;

public class Telefono {
// agregar at odas las entidaeds ID
	private int idTelefono;
	private String numPersonal;
	private String numCelular;
	private String numLaboral;


	// Getter & Setter
	
	public String getNumPersonal() {
		return numPersonal;
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setID(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public void setNumPersonal(String numPersonal) {
		this.numPersonal = numPersonal;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getNumLaboral() {
		return numLaboral;
	}

	public void setNumLaboral(String numLaboral) {
		this.numLaboral = numLaboral;
	}


	// Constructor 
	
	public Telefono(int idTelefono, String numPersonal, String numCelular, String numLaboral) {
		this.idTelefono = idTelefono;
		this.numPersonal = numPersonal;
		this.numCelular = numCelular;
		this.numLaboral = numLaboral;
	}

	public Telefono() {
		// TODO Auto-generated constructor stub
	}
}
