package edu.usal.tp.negocio.dao.dominio;

public class PasajeroFrecuente {

	private int idPasFre;
	private String alianza; // o pasarlo a num
	private Aerolinea aerolinea; // ObjetoAerolinea?
	private String numeroPF;
	private String categoria;

	public String getAlianza() {
		return alianza;
	}

	public void setAlianza(String alianza) {
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

	public PasajeroFrecuente(int idPasFre, String alianza, Aerolinea aerolinea, String numeroPF, String categoria) {
		this.idPasFre = idPasFre;
		this.alianza = alianza;
		this.aerolinea = aerolinea;
		this.numeroPF = numeroPF;
		this.categoria = categoria;
	}

	public PasajeroFrecuente() {
		// TODO Auto-generated constructor stub
	}

	public void setAerolineaID(String id) {
		this.aerolinea.setId(id);

	}

	public int getIdPasFre() {
		return idPasFre;
	}

	public void setIdPasFre(int idPasFre) {
		this.idPasFre = idPasFre;
	}

}
