package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.view.ClientesABM_view;

public class ClienteEvents implements ActionListener {

	private ClientesABM_view view;

	public ClienteEvents(ClientesABM_view view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == this.view.getBtnAlta()) {

		}
		if (e.getSource() == this.view.getBtnModificar()) {

		}
		if (e.getSource() == this.view.getBtnBorrar()) {

		}

	}

}
