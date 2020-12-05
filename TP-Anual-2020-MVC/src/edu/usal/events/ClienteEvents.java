package edu.usal.events;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.view.ClientesABM_view;
import edu.usal.view.ClientesAlta_view;
import edu.usal.view.ClientesView;

public class ClienteEvents implements ActionListener {

	private ClientesView view;
	private ClienteController_GUI clienteController = new ClienteController_GUI();

	public ClienteEvents(ClientesView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Este boton deberia ser el Submit del modal
		if (e.getSource() == this.view.getBtnAlta()) {
			EventQueue.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                ClientesAlta_view.display();
	            }
	        });
		}
		if (e.getSource() == this.view.getBtnModificar()) {

		}
		if (e.getSource() == this.view.getBtnBorrar()) {

		}

	}

	private Cliente CargarCliente() {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente();

		return cliente;
	}

}
