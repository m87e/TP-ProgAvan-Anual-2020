package edu.usal.events;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.AerolineaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineaAlta_view;
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
		
		if (e.getSource() == this.view.getBtnBorrar()) {
			int filaSeleccionada = this.view.getTable().getRowCount();
			
			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
			}
			else {
				TableModel m = this.view.getTable().getModel();
				Object id = m.getValueAt(filaSeleccionada, 0); 
				//Integer id = (Integer) m.getValueAt(filaSeleccionada, 0);
				
				System.out.println(id);
			//	aerolineaController.BajaAerolinea(BuscarAerolinea(id));
				
			}
			
			
		}

	}

	private Aerolinea BuscarAerolinea(int id) {
		Aerolinea a = new Aerolinea();
		a.setId(129);
		return a;
	}

}
