package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.VueloModificarController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VuelosModificarView;

public class VueloModificarEvents implements ActionListener {

	private VuelosModificarView viewModificarVuelo;
	private VueloModificarController_GUI vueloModificarController = new VueloModificarController_GUI();

	public VueloModificarEvents(VuelosModificarView viewModificarVuelo) {
		this.viewModificarVuelo = viewModificarVuelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.viewModificarVuelo.getBtnSubmit()) {
			System.out.println("... Procensando modificacion de Vuelo...");
			Vuelo vuelo = CargarVuelo();
			vueloModificarController.modificarVuelo(vuelo);

			JOptionPane.showMessageDialog(null, "Vuelo modificado exitosamente");
			this.viewModificarVuelo.setVisible(false);
		}
		if (e.getSource() == this.viewModificarVuelo.getBtnCancel()) {

			this.viewModificarVuelo.setVisible(false);
		}
	}

	private Vuelo CargarVuelo() {
		// TODO Auto-generated method stub

		Vuelo vuelo = new Vuelo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String id = this.viewModificarVuelo.getTextID().getText();
		vuelo.setId(Integer.parseInt(id));
		vuelo.setCantAsientos(Integer.parseInt(this.viewModificarVuelo.getTextCantidadAsientos().getText()));
		vuelo.setNumVuelo(this.viewModificarVuelo.getTextField_NumVuelo().getText());

		Aeropuerto aepSalida = CargarAeropuerto("salida");
		Aeropuerto aepLlegada = CargarAeropuerto("llegada");

		vuelo.setAeropuertoSalida(aepSalida);
		vuelo.setAeropuertoLlegada(aepLlegada);

		Aerolinea aerolinea = CargarAerolinea();
		vuelo.setAerolinea(aerolinea);

		Date dateSalida = this.viewModificarVuelo.getDateChooser_fechaHoraSalida().getDate();
		sdf.format(dateSalida);
		LocalDate localDateSalida = dateSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		vuelo.setFechaHoraSalida(localDateSalida);
		Date dateLlegada = this.viewModificarVuelo.getDateChooser_fechaHoraLlegada().getDate();
		sdf.format(dateLlegada);
		LocalDate localDateLlegada = dateLlegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		vuelo.setFechaHoraLlegada(localDateLlegada);

		return vuelo;
	}

	private Aeropuerto CargarAeropuerto(String salidaOLlegada) {

		Aeropuerto aeropuerto = new Aeropuerto();
		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloModificarController.mostrarAeropuertos();
		System.out.println("### AEP encontrados: " + listAeropuertos.size());

		if (salidaOLlegada.equals("salida")) {
			for (int i = 0; i < listAeropuertos.size(); i++) {

				if (listAeropuertos.get(i).getCodigo()
						.equals(this.viewModificarVuelo.getComboBoxAeropuertoSalida().getSelectedItem())) {
					System.out.println("Aeropuerto salida seleccionado: "
							+ this.viewModificarVuelo.getComboBoxAeropuertoSalida().getSelectedItem());
					aeropuerto.setId(listAeropuertos.get(i).getId());
					aeropuerto.setCodigo(listAeropuertos.get(i).getCodigo());

				}
			}
		} else {
			for (int i = 0; i < listAeropuertos.size(); i++) {

				if (listAeropuertos.get(i).getCodigo()
						.equals(this.viewModificarVuelo.getComboBoxAeropuertoLlegada().getSelectedItem())) {
					System.out.println("Aeropuerto llegada seleccionado: "
							+ this.viewModificarVuelo.getComboBoxAeropuertoLlegada().getSelectedItem());
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
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloModificarController.mostrarAerolinea();

		for (int i = 0; i < listAerolinea.size(); i++) {

			if (listAerolinea.get(i).getNombre()
					.equals(this.viewModificarVuelo.getComboBoxAerolinea().getSelectedItem())) {
				System.out.println(
						"Aerolinea seleccionada: " + this.viewModificarVuelo.getComboBoxAerolinea().getSelectedItem());
				aerolinea.setId(listAerolinea.get(i).getId());
				aerolinea.setNombre(listAerolinea.get(i).getNombre());
				aerolinea.setAlianza(listAerolinea.get(i).getAlianza());
			}
		}

		return aerolinea;

	}

}
