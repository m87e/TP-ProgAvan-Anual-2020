package edu.usal.tp.negocio.dao.dominio;

public class PasajeroFrecuente {

	private int id;
	private Alianza alianza;
	private Aerolinea aerolinea;
	private String numeroPF;
	private String categoria;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getNumeroPF() {
		return numeroPF;
	}

	public void setNumeroPF(String numeroPF) {
		this.numeroPF = numeroPF;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Constructors

	public PasajeroFrecuente() {
		// TODO Auto-generated constructor stub
	}

	public PasajeroFrecuente(int id, Alianza alianza, Aerolinea aerolinea, String numeroPF, String categoria) {
		this.id = id;
		this.alianza = alianza;
		this.aerolinea = aerolinea;
		this.numeroPF = numeroPF;
		this.categoria = categoria;
	}

}
