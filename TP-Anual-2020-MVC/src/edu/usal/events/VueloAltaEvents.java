package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.VueloController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VuelosAltaView;

public class VueloAltaEvents implements ActionListener {

	private VuelosAltaView viewAltaVuelo;
	private VueloController_GUI vueloAltaController = new VueloController_GUI();

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

			vueloAltaController.AltaVuelo(vuelo);

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
		// vuelo.setAeropuertoSalida(this.viewAltaVuelo.getComboBoxAeropuertoSalida().getSelectedItem().toString());
		// vuelo.setAeropuertoLlegada(this.viewAltaVuelo.getComboBoxAeropuertoLlegada().getSelectedItem().toString());

		Date dateSalida = this.viewAltaVuelo.getDateChooser_fechaHoraSalida().getDate();
		sdf.format(dateSalida);
		LocalDate localDateSalida = dateSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		vuelo.setFechaHoraSalida(localDateSalida);

		Date dateLlegada = this.viewAltaVuelo.getDateChooser_fechaHoraLlegada().getDate();
		sdf.format(dateLlegada);
		LocalDate localDateLlegada = dateLlegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		vuelo.setFechaHoraSalida(localDateLlegada);

		vuelo.setTiempoVuelo(this.viewAltaVuelo.getLblTiempoVueloCalculado().getText());

		return vuelo;
	}

}
