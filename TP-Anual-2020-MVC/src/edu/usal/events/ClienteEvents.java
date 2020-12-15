package edu.usal.events;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.view.ClientesABM_view;
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
		}
		if (e.getSource() == this.view.getBtnModificar()) {
		//	tablaMouseClicked(e,this.view);
		}
		if (e.getSource() == this.view.getBtnBorrar()) {

		}

	}
	
	private void tablaMouseClicked (java.awt.event.MouseEvent e, JTable table) {
		
		int column = table.getColumnModel().getColumnIndexAtX(e.getX());
		int row = e.getY()/table.getRowHeight();
		
		if(row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column>=0) {
			Object value = table.getValueAt(row, column);
			if(value instanceof JButton) {
				((JButton)value).doClick();
				JButton boton = (JButton) value;
				System.out.println("boton");
				if(boton.getName().equals("m")) {
					System.out.println("Modificar");
				}
				if(boton.getName().equals("e")) {
					System.out.println("Eliminar");
				}
			}
		}
		
	}
}
