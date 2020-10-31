package edu.usal.tp.negocio.dao.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Venta {

	private int id;
	private Cliente cliente;
	private Vuelo vuelo;
	private Aerolinea aerolinea;
	private LocalDate fechaHoraVenta;
	private String formaPago;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cli) {
		this.cliente = cli;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vue) {
		this.vuelo = vue;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aero) {
		this.aerolinea = aero;
	}

	public LocalDate getFechaHoraVenta() {
		return fechaHoraVenta;
	}

	public void setFechaHoraVenta(LocalDate fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	// Constructors

	public Venta() {

		// TODO Auto-generated constructor stub
	}

	public Venta(int id, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea, LocalDate fechaHoraVenta,
			String formaPago) {

		this.id = id;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fechaHoraVenta = fechaHoraVenta;
		this.formaPago = formaPago;
	}

}
