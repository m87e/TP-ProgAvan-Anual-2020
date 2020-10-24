package edu.usal.tp.negocio.dao.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Pasaporte {

	private int id;
	private String numeroPasaporte;
	private Pais pais;
	private String autoridadEmision;
	private LocalDate fechaEmision;
	private LocalDate fechaVencimiento;

	// Getter & Setter

	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}

	public void setNumeroPasaporte(String numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getAutoridadEmision() {
		return autoridadEmision;
	}

	public void setAutoridadEmision(String autoridadEmision) {
		this.autoridadEmision = autoridadEmision;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setPaisID(int idPais) {
		this.pais.setId(idPais);

	}

	public int getPaisID() {
		return this.pais.getId();
	}

	public int getIdPasaporte() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Constructors

	public Pasaporte() {
		// TODO Auto-generated constructor stub
	}

	public Pasaporte(int id, String numeroPasaporte, Pais pais, String autoridadEmision, LocalDate fechaEmision,
			LocalDate fechaVencimiento) {
		this.id = id;
		this.numeroPasaporte = numeroPasaporte;
		this.pais = pais;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
	}

}
