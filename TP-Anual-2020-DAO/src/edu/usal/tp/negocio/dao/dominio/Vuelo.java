package edu.usal.tp.negocio.dao.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Vuelo {

	private int id;
	private String numVuelo;
	private Integer cantAsientos;
	private Aeropuerto aeropuertoSalida;
	private Aeropuerto aeropuertoLlegada;
	private LocalDate fechaHoraSalida;
	private LocalDate fechaHoraLlegada;
	private String tiempoVuelo;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumVuelo() {
		return numVuelo;
	}

	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}

	public Integer getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(Integer cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public int getAeropuertoSalidaID() {
		return aeropuertoSalida.getId();
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public void setAeropuertoSalida(int idAeropuerto) {
		this.aeropuertoSalida.setId(idAeropuerto);
	}

	public int getAeropuertoLlegadaID() {
		return aeropuertoLlegada.getId();
	}

	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(int idAeropuerto) {
		this.aeropuertoLlegada.setId(idAeropuerto);
	}

	public LocalDate getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public LocalDate getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(LocalDate fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public String getTiempoVuelo() {
		return tiempoVuelo;
	}

	public void setTiempoVuelo(String tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}

	// Constructor

	public Vuelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vuelo(int id, String numVuelo, Integer cantAsientos, Aeropuerto aeropuertoSalida,
			Aeropuerto aeropuertoLlegada, LocalDate fechaHoraSalida, LocalDate fechaHoraLlegada, String tiempoVuelo) {
		super();
		this.id = id;
		this.numVuelo = numVuelo;
		this.cantAsientos = cantAsientos;
		this.aeropuertoSalida = aeropuertoSalida;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.tiempoVuelo = tiempoVuelo;
	}

}

//Los numeros de vuelo deberian formarse como:
//a. Las primeras 2 letras del nombre de la aerolinea, en el caso que sea un nombre compuesto (Ej. Aerolineas Argentinas)
//se formaran con la primer letra de los primeras 2 palabras (en el ejemplo: AA), si ya existiese un nombre asi 
//(American Airlines es AA) se tomaran la primer letra (A de aerolineas) y se probaran con las siguientes 
//letras de la segunda palabra hasta encontrar uno no usado (R de aRgentinas).
//b. Un guion medio (-)
//c. El valor nuumero del numero con una longitud de 4 digitos
//d. Ejemplo: AR-1234