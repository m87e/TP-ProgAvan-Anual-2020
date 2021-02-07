package edu.usal.events;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.AerolineaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineaAlta_view;
import edu.usal.view.AerolineaModificar_view;
import edu.usal.view.AerolineasView;

public class AerolineaEvents implements ActionListener {

	private AerolineasView view;
	private AerolineaController_GUI aerolineaController = new AerolineaController_GUI();

	public AerolineaEvents(AerolineasView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == this.view.getBtnAlta()) {

			AerolineaAlta_view tV = new AerolineaAlta_view();
			tV.setVisible(true);

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

				Aerolinea a = new Aerolinea();

				a = aerolineaController.BuscarAerolineaID(id);
				System.out.println(a.getId());
				System.out.println(a.getNombre());

				AerolineaModificar_view tV = new AerolineaModificar_view(a);
				tV.setVisible(true);

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

				Aerolinea a = new Aerolinea();
				a.setId(id);
				aerolineaController.BajaAerolinea(a);
				JOptionPane.showMessageDialog(null, "La aerolinea con ID: " + id + " ha sido borrada.");
			}
		}

	}

}
