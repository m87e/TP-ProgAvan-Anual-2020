package edu.usal.tp.negocio.dao.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Pasaporte {

	private int id;
	private String numeroPasaporte;
	private Paises pais;
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

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
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
	// Constructor

	public Pasaporte(int id, String numeroPasaporte, Paises pais, String autoridadEmision, LocalDate fechaEmision,
			LocalDate fechaVencimiento) {
		this.id = id;
		this.numeroPasaporte = numeroPasaporte;
		this.pais = pais;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
	}

	public Pasaporte() {
		// TODO Auto-generated constructor stub
	}

}
