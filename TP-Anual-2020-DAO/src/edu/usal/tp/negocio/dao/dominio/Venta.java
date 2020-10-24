package edu.usal.tp.negocio.dao.dominio;

import java.util.Date;

public class Venta {

	private int id;
	private Cliente cliente;
	private Vuelo vuelo;
	private Aerolinea aerolinea;
	private Date fechaHoraVenta;
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

	public int getClienteID() {
		return cliente.getId();
	}

	public void setCliente(Cliente cli) {
		this.cliente = cli;
	}

	public void setClienteID(int id) {
		this.cliente.setId(id);
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public int getVueloID() {
		return vuelo.getId();
	}

	public void setVuelo(Vuelo vue) {
		this.vuelo = vue;
	}

	public void setVueloID(int id) {
		this.vuelo.setId(id);
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public int getAerolineaID() {
		return aerolinea.getId();
	}

	public void setAerolinea(Aerolinea aero) {
		this.aerolinea = aero;
	}

	public void setAerolineaID(int id) {
		this.aerolinea.setId(id);
	}

	public Date getFechaHoraVenta() {
		return fechaHoraVenta;
	}

	public void setFechaHoraVenta(Date fechaHoraVenta) {
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

	public Venta(int id, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea, Date fechaHoraVenta, String formaPago) {

		this.id = id;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fechaHoraVenta = fechaHoraVenta;
		this.formaPago = formaPago;
	}

}
