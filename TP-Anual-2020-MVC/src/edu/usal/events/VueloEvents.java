package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.VueloController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.AerolineaModificar_view;
import edu.usal.view.VuelosAltaView;
import edu.usal.view.VuelosModificarView;
import edu.usal.view.VuelosView;

public class VueloEvents implements ActionListener {

	private VuelosView view;
	private VueloController_GUI vueloController = new VueloController_GUI();

	public VueloEvents(VuelosView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == this.view.getBtnAlta()) {
			VuelosAltaView alta = new VuelosAltaView();
			alta.setVisible(true);
		}

		if (e.getSource() == this.view.getBtnModificar()) {

			int filaSeleccionada = this.view.getTable().getSelectedRow();
			System.out.println("fila seleccionada" + filaSeleccionada);
			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
			} else {
				TableModel m = this.view.getTable().getModel();

				Object objectoSeleccionado = m.getValueAt(filaSeleccionada, 0);

				int id = ((Integer) objectoSeleccionado).intValue();
				System.out.println("ID a modificar: " + id);

				Vuelo vuelo = new Vuelo();

				vuelo = vueloController.BuscarVueloID(id);
				System.out.println(vuelo.getId());

				VuelosModificarView modificar = new VuelosModificarView(vuelo);
				modificar.setVisible(true);

			}
		}
		if (e.getSource() == this.view.getBtnBorrar()) {
			int filaSeleccionada = this.view.getTable().getSelectedRow();
			System.out.println("fila seleccionada" + filaSeleccionada);
			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
			} else {
				TableModel m = this.view.getTable().getModel();

				Object objectoSeleccionado = m.getValueAt(filaSeleccionada, 0);

				int id = ((Integer) objectoSeleccionado).intValue();
				System.out.println("ID a borrar: " + id);

				Vuelo vuelo = new Vuelo();
				vuelo.setId(id);
				vueloController.BajaVuelo(vuelo);
				JOptionPane.showMessageDialog(null, "El vuelo con ID: " + id + " ha sido borrado.");
			}
		}

	}

}
