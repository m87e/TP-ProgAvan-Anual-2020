package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import edu.usal.controllers.GUI.AerolineaModificarController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.view.AerolineaModificar_view;

public class AerolineaModificarEvents implements ActionListener {

	
	private AerolineaModificar_view viewModificarAerolinea;
	private AerolineaModificarController_GUI aerolineaModificarController = new AerolineaModificarController_GUI();
	
	
	
	public AerolineaModificarEvents(AerolineaModificar_view viewModificarAerolinea) {
		this.viewModificarAerolinea = viewModificarAerolinea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.viewModificarAerolinea.getBtnSubmit()) {
			System.out.println("... Procensando modificacion de Aerolinea...");
			Aerolinea aerolinea = CargarAerolinea();

			aerolineaModificarController.modificarAerolinea(aerolinea);
			
			JOptionPane.showMessageDialog(null, "Aerolinea modificada exitosamente");
			this.viewModificarAerolinea.setVisible(false);
		}
		if (e.getSource() == this.viewModificarAerolinea.getBtnCancel()) {
		
			this.viewModificarAerolinea.setVisible(false);
		}
	}
	
	private Aerolinea CargarAerolinea() {
		// TODO Auto-generated method stub
		Aerolinea aerolinea = new Aerolinea();
		String alianza = this.viewModificarAerolinea.getTextAlianza().getText();

		aerolinea.setNombre(this.viewModificarAerolinea.getTextNombre().getText());

		aerolinea.setAlianza(Alianza.valueOf(alianza));
		
		String id = this.viewModificarAerolinea.getTextID().getText();
		
		aerolinea.setId(Integer.parseInt(id));

		return aerolinea;
	}

}
