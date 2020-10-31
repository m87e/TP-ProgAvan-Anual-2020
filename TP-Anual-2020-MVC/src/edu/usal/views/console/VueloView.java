package edu.usal.views.console;

import java.time.LocalDate;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.util.IOGeneral;

public class VueloView {

	public int mostrarMenu() {
		System.out.println("1 - Alta vuelo");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}

	public Vuelo CargarVuelo() {

		Vuelo vuelo = new Vuelo();

		LocalDate d = LocalDate.now();

		vuelo.setNumVuelo(IOGeneral.leerLinea("ingrese numero de vuelo"));
		vuelo.setCantAsientos(IOGeneral.leerInt("ingrese cantidad de asientos", "dato no valido"));
		vuelo.setFechaHoraLlegada(d);
		vuelo.setFechaHoraSalida(d);

		return vuelo;

	}

	public Aeropuerto CargarAeropuerto() {

		Aeropuerto aeropuerto = new Aeropuerto();

		aeropuerto.setId(IOGeneral.leerInt("ingrese id de aeropuerto", "dato no valido"));

		return aeropuerto;

	}

	public Aerolinea CargarAerolinea() {

		Aerolinea aerolinea = new Aerolinea();

		aerolinea.setId(IOGeneral.leerInt("ingrese id de la aerolinea", "dato no valido"));

		return aerolinea;
	}
}
