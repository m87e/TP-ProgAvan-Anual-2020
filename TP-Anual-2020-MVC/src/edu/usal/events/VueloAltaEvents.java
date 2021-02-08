package edu.usal.events;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.VueloAltaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VuelosAltaView;

public class VueloAltaEvents implements ActionListener {

	private VuelosAltaView viewAltaVuelo;
	private VueloAltaController_GUI vueloAltaController = new VueloAltaController_GUI();

	public VueloAltaEvents(VuelosAltaView viewAltaVuelo) {
		this.viewAltaVuelo = viewAltaVuelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Este boton es el Submit del modal
		if (e.getSource() == this.viewAltaVuelo.getBtnSubmit()) {
			System.out.println("... Procensando alta de vuelo...");
			Vuelo vuelo = CargarVuelo();

			vueloAltaController.altaVuelo(vuelo);

			JOptionPane.showMessageDialog(null, "vuelo agregado exitosamente");
			this.viewAltaVuelo.setVisible(false);

		}
		if (e.getSource() == this.viewAltaVuelo.getBtnCancel()) {

			this.viewAltaVuelo.setVisible(false);
		}
	}

	private Vuelo CargarVuelo() {
		// TODO Auto-generated method stub

		Vuelo vuelo = new Vuelo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		vuelo.setNumVuelo(this.viewAltaVuelo.getTextNumVuelo().getText());
		vuelo.setCantAsientos(Integer.parseInt(this.viewAltaVuelo.getTextCantidadAsientos().getText()));

		Aeropuerto aepSalida = CargarAeropuerto("salida");
		Aeropuerto aepLlegada = CargarAeropuerto("llegada");

		vuelo.setAeropuertoSalida(aepSalida);
		vuelo.setAeropuertoLlegada(aepLlegada);

		Aerolinea aerolinea = CargarAerolinea();
		vuelo.setAerolinea(aerolinea);

		Date dateSalida = this.viewAltaVuelo.getDateChooser_fechaHoraSalida().getDate();
		sdf.format(dateSalida);
		LocalDate localDateSalida = dateSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		vuelo.setFechaHoraSalida(localDateSalida);

		Date dateLlegada = this.viewAltaVuelo.getDateChooser_fechaHoraLlegada().getDate();
		sdf.format(dateLlegada);
		LocalDate localDateLlegada = dateLlegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		vuelo.setFechaHoraLlegada(localDateLlegada);

		vuelo.setTiempoVuelo(this.viewAltaVuelo.getLblTiempoVueloCalculado().getText());

		return vuelo;
	}

	private Aeropuerto CargarAeropuerto(String salidaOLlegada) {

		Aeropuerto aeropuerto = new Aeropuerto();
		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloAltaController.mostrarAeropuertos();

		if (salidaOLlegada.equals("salida")) {
			for (int i = 0; i < listAeropuertos.size(); i++) {
				System.out.println("Aeropuerto salida seleccionado: "
						+ this.viewAltaVuelo.getComboBoxAeropuertoSalida().getSelectedItem());
				if (listAeropuertos.get(i).getCodigo()
						.equals(this.viewAltaVuelo.getComboBoxAeropuertoSalida().getSelectedItem())) {
					aeropuerto.setId(listAeropuertos.get(i).getId());
					aeropuerto.setCodigo(listAeropuertos.get(i).getCodigo());

				}
			}
		} else {
			for (int i = 0; i < listAeropuertos.size(); i++) {
				System.out.println("Aeropuerto llegada seleccionado: "
						+ this.viewAltaVuelo.getComboBoxAeropuertoLlegada().getSelectedItem());
				if (listAeropuertos.get(i).getCodigo()
						.equals(this.viewAltaVuelo.getComboBoxAeropuertoLlegada().getSelectedItem())) {
					aeropuerto.setId(listAeropuertos.get(i).getId());
					aeropuerto.setCodigo(listAeropuertos.get(i).getCodigo());

				}
			}
		}

		System.out.println("Aeropuerto ID: " + aeropuerto.getId());
		return aeropuerto;

	}

	private Aerolinea CargarAerolinea() {

		Aerolinea aerolinea = new Aerolinea();
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloAltaController.mostrarAerolinea();

		for (int i = 0; i < listAerolinea.size(); i++) {
			System.out
					.println("Aerolinea seleccionada: " + this.viewAltaVuelo.getComboBoxAerolinea().getSelectedItem());
			if (listAerolinea.get(i).getNombre().equals(this.viewAltaVuelo.getComboBoxAerolinea().getSelectedItem())) {
				aerolinea.setId(listAerolinea.get(i).getId());
				aerolinea.setNombre(listAerolinea.get(i).getNombre());
				aerolinea.setAlianza(listAerolinea.get(i).getAlianza());
			}
		}

		return aerolinea;

	}

}
