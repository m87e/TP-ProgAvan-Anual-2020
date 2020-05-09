package edu.usal.tp.negocio.dao.dominio;

import java.util.Date;

public class Venta {

	private int idVenta;
	private Cliente cli;
	private Vuelos vue;
	private Aerolinea aero;
	private Date fechaHoraVenta;
	private String formaPago;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCli() {
		return cli;
	}

	public int getCliID() {
		return cli.getIdCliente();
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public void setCliID(int id) {
		this.cli.setIdCliente(id);
	}

	public Vuelos getVue() {
		return vue;
	}

	public String getVueID() {
		return vue.getNumVuelo();
	}

	public void setVue(Vuelos vue) {
		this.vue = vue;
	}

	public void setVueID(String id) {
		this.vue.setNumVuelo(id);
	}

	public Aerolinea getAero() {
		return aero;
	}

	public String getAeroID() {
		return aero.getId();
	}

	public void setAero(Aerolinea aero) {
		this.aero = aero;
	}

	public void setAeroID(String id) {
		this.aero.setId(id);
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

	public Venta(int idVenta, Cliente cli, Vuelos vue, Aerolinea aero, Date fechaHoraVenta, String formaPago) {

		this.idVenta = idVenta;
		this.cli = cli;
		this.vue = vue;
		this.aero = aero;
		this.fechaHoraVenta = fechaHoraVenta;
		this.formaPago = formaPago;
	}

	public Venta() {

		// TODO Auto-generated constructor stub
	}

}
