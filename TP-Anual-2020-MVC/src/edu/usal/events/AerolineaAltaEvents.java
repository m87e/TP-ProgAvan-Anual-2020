package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.AerolineaAltaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.view.AerolineaAlta_view;
import edu.usal.view.Menu_view;

public class AerolineaAltaEvents implements ActionListener{

	private AerolineaAlta_view viewAltaAerolinea;
	private AerolineaAltaController_GUI aerolineaAltaController = new AerolineaAltaController_GUI();
	
	
	
	public AerolineaAltaEvents(AerolineaAlta_view viewAltaAerolinea) {
		this.viewAltaAerolinea = viewAltaAerolinea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Este boton es el Submit del modal
		if (e.getSource() == this.viewAltaAerolinea.getBtnSubmit()) {
			System.out.println("... Procensando alta de Aerolinea...");
			Aerolinea aerolinea = CargarAerolinea();

			aerolineaAltaController.altaAerolinea(aerolinea);
			
			JOptionPane.showMessageDialog(null, "Aerolinea agregada exitosamente");
			this.viewAltaAerolinea.setVisible(false);
			
		}
		if (e.getSource() == this.viewAltaAerolinea.getBtnCancel()) {
		
			this.viewAltaAerolinea.setVisible(false);
		}
	
	}
	
	private Aerolinea CargarAerolinea() {
		// TODO Auto-generated method stub
		Aerolinea aerolinea = new Aerolinea();
		String alianza = (String) this.viewAltaAerolinea.getComboBoxAlianza().getSelectedItem();
				//.getTextAlianza().getText();
		System.out.println(alianza);
		aerolinea.setNombre(this.viewAltaAerolinea.getTextNombre().getText());

		aerolinea.setAlianza(Alianza.valueOf(alianza));

		return aerolinea;
	}

}
