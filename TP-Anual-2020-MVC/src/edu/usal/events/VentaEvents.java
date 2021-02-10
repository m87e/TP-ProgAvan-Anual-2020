package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.controllers.GUI.VentasController_GUI;
import edu.usal.view.VentasAlta_view;
import edu.usal.view.VentasView;


public class VentaEvents implements ActionListener {

	private VentasView view;
	private VentasController_GUI ventasController = new VentasController_GUI();
	
	public VentaEvents(VentasView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.view.getBtnAlta()) {
			System.out.println("Generando nueva venta...");
			System.out.println("... Procensando ...");
			
			VentasAlta_view vV = new VentasAlta_view();
			vV.setVisible(true);
		}

		if (e.getSource() == this.view.getBtnBorrar()) {
			
		}
		
	}

	
}
