package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.VueloModificarController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VuelosModificarView;

public class VueloModificarEvents implements ActionListener {

	private VuelosModificarView viewModificarVuelo;
	private VueloModificarController_GUI vueloModificarController;

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
		return null;
	}

}
