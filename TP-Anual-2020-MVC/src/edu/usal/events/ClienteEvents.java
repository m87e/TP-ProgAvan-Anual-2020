package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.view.AerolineaModificar_view;
import edu.usal.view.ClienteModificar_view;
import edu.usal.view.ClientesAltaView;
import edu.usal.view.ClientesView;

public class ClienteEvents implements ActionListener {

	private ClientesView view;
	private ClienteController_GUI clienteController = new ClienteController_GUI();

	public ClienteEvents(ClientesView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.view.getBtnAlta()) {
			System.out.println("Generando nuevo cliente...");
			System.out.println("... Procensando ...");
			
			ClientesAltaView cV = new ClientesAltaView();
			cV.setVisible(true);
		}
		if (e.getSource() == this.view.getBtnModificar()) {
			int filaSeleccionada = this.view.getTable().getSelectedRow();
			System.out.println("fila seleccionada" + filaSeleccionada);
			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
			}
			else {
				TableModel m = this.view.getTable().getModel();
				
				Object objectoSeleccionado = m.getValueAt(filaSeleccionada, 0); 
				
				String dni = objectoSeleccionado.toString();
				System.out.println("Cliente con DNI a modificar: "+dni);
				
				Cliente c = new Cliente();
				
				c = clienteController.BuscarClienteDNI(dni);
				System.out.println(c.getId());
				System.out.println(c.getNombre());
				
			//	ClienteModificar_view cV = new ClienteModificar_view(c);
			//	cV.setVisible(true);
			
			}
		}
		if (e.getSource() == this.view.getBtnBorrar()) {
			int filaSeleccionada = this.view.getTable().getSelectedRow();
			System.out.println("fila seleccionada" + filaSeleccionada);
			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
			}
			else {
				TableModel m = this.view.getTable().getModel();
				
				Object objectoSeleccionado = m.getValueAt(filaSeleccionada, 0); 
				System.out.println("Objeto a borrar"+objectoSeleccionado.toString());
				int id = ((Integer) objectoSeleccionado).intValue();
				System.out.println("ID a borrar: "+id);
				
				Cliente c = new Cliente();
				c.setId(id);
				clienteController.bajaCliente(c);
				JOptionPane.showMessageDialog(null, "El cliente con ID: "+id+" ha sido borrado." );
			}
		}

	} 	
}
