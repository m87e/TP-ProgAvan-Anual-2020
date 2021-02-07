package edu.usal.controllers;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.views.console.VueloView;

public class VueloController {

	private VueloView view;
	private VueloManager manager = new VueloManager();

	public VueloController(VueloView view) {
		this.view = view;
	}

	public void mostrarMenu() throws ClassNotFoundException, IOException, ParseException {
		boolean fin = false;
		while (!fin) {
			int opcion = this.view.mostrarMenu();
			switch (opcion) {
			case 0:
				System.out.println("Aplicacion cerrada");
				fin = true;
				break;
			case 1:
				this.altaVuelo();
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}
		}
	}

	private void altaVuelo() {

		Vuelo vuelo = this.view.CargarVuelo();
		Aeropuerto aeropuertoSalida = this.view.CargarAeropuerto();
		Aeropuerto aeropuertoLlegada = this.view.CargarAeropuerto();
		Aerolinea aerolinea = this.view.CargarAerolinea();

		this.manager.AltaVuelo(vuelo);
	}

	private void modificarVuelo() {

	}

	private void bajaVuelo() {

	}

	private void mostrarVueloPorId() {

	}

	private void mostrarVuelos() {

	}

}
