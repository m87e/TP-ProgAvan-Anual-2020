package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.VentasController_GUI;
import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VentasAlta_view;
import edu.usal.view.VentasView;


public class VentaEvents implements ActionListener {

	private VentasView view;
	private VentasController_GUI ventasController = new VentasController_GUI();
	private VueloManager managerVuelo = new VueloManager();
	
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
				
				Venta v = new Venta();
				ventasController.bajaVenta(v);
				
				String numeroVuelo = v.getVuelo().getNumVuelo();
				ArrayList<Vuelo> listVuelo = (ArrayList<Vuelo>) managerVuelo.MostrarVuelos();
				
				Vuelo vu = new Vuelo();
				for (int i = 0; i < listVuelo.size(); i++) {
					if (listVuelo.get(i).getNumVuelo().equals(numeroVuelo)) {
						LocalDate fechaSalida = listVuelo.get(i).getFechaHoraSalida();
						LocalDate fechaLlegada = listVuelo.get(i).getFechaHoraLlegada();
						
						vu.setCantAsientos(listVuelo.get(i).getCantAsientos());
						vu.setFechaHoraLlegada(fechaLlegada);
						vu.setFechaHoraSalida(fechaSalida);
						vu.setId(listVuelo.get(i).getId());
						vu.setAeropuertoLlegada(listVuelo.get(i).getAeropuertoLlegada());
						vu.setAeropuertoSalida(listVuelo.get(i).getAeropuertoSalida());
						vu.setAerolinea(listVuelo.get(i).getAerolinea());
					}
				}
				int asientos = vu.getCantAsientos();
				vu.setCantAsientos(asientos+1);
				managerVuelo.ModificacionVuelo(vu);
				JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente!");
			}
		}
	}
}
