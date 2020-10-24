package edu.usal.tp.negocio.dao.dominio;

public class Telefono {

	private int id;
	private String numPersonal;
	private String numCelular;
	private String numLaboral;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumPersonal() {
		return numPersonal;
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

	public Telefono() {
		// TODO Auto-generated constructor stub
	}

	public Telefono(int id, String numPersonal, String numCelular, String numLaboral) {
		this.id = id;
		this.numPersonal = numPersonal;
		this.numCelular = numCelular;
		this.numLaboral = numLaboral;
	}

}
