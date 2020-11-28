package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.view.ClientesABM_view;

public class ClienteEvents implements ActionListener {

	private ClientesABM_view view;
	private ClienteController_GUI clienteController = new ClienteController_GUI();

	public ClienteEvents(ClientesABM_view view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Este boton deberia ser el Submit del modal
		if (e.getSource() == this.view.getBtnAlta()) {

			Cliente cliente = CargarCliente();

			try {
				this.clienteController.altaCliente();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("Ocurrio un error parseando los datos del cliente");
			}
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
