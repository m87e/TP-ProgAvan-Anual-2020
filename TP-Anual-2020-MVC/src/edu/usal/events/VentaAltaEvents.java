package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.VentasAltaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VentasAlta_view;

public class VentaAltaEvents implements ActionListener {

	private VentasAlta_view viewAltaVenta;
	private VentasAltaController_GUI ventaAltaController = new VentasAltaController_GUI();
	
	public VentaAltaEvents(VentasAlta_view viewAltaVenta) {
		this.viewAltaVenta = viewAltaVenta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.viewAltaVenta.getBtnGuardar()) {
			Venta vt = CargaVenta();
			Vuelo v = CargaVuelo();
			Cliente c = CargaCliente();
			Aerolinea a = CargarAerolinea();
			LocalDate f = CargaVenta().getFechaHoraVenta();
			String fP = CargaVenta().getFormaPago();
		
			Boolean validacion = false;
		/*	
			if(c.getFechaNac() - fecha hoy <18) {
				this.viewAltaVenta.setLblClienteMenor(true);
			}else {
				validacion = true;
			}
			
			
			if(validacionFecha && validacionPasaporte ) {
				ventaAltaController.altaVenta(vt, c, v, a, f, fP);
				JOptionPane.showMessageDialog(null, "Venta agregada exitosamente!");
				this.viewAltaVenta.setVisible(false);
			}
			*/
		}
	}
	private Aerolinea CargarAerolinea() {
		Aerolinea ae = new Aerolinea();
		String nombreAerolineaSeleccionada = this.viewAltaVenta.getTextField_aerolinea().getText();
		
		List<Aerolinea> aerolinea = ventaAltaController.mostrarAerolinea();
		
		for (int i = 0; i < aerolinea.size(); i++) {
			System.out.println(aerolinea.get(i).getNombre());
			System.out.println(nombreAerolineaSeleccionada);
			if (aerolinea.get(i).getNombre().equals(nombreAerolineaSeleccionada)) {
				
				ae.setId(aerolinea.get(i).getId());
			}
		}
		System.out.println("Ae ID: "+ae.getId());
		return ae;
	}
	private Vuelo CargaVuelo() {
		Vuelo v = new Vuelo();
		String numeroVueloSeleccionada = this.viewAltaVenta.getComboBox_vuelo().getSelectedItem().toString();
		v.setNumVuelo(numeroVueloSeleccionada);
		return v;
	}
	private Cliente CargaCliente() {
		Cliente c = new Cliente();
		c.setDni(this.viewAltaVenta.getTextField_cliente().getText());
		return c;
	}
	private Venta CargaVenta() {
		Venta v = new Venta ();
		
		Date date = this.viewAltaVenta.getDateChooser_fechaVenta().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		v.setFechaHoraVenta(localDate);
		
		if(this.viewAltaVenta.getComboBox_formaPago().getSelectedItem().equals("Contado")) {
			v.setFormaPago(this.viewAltaVenta.getComboBox_formaPago().getSelectedItem().toString());
		}
		else {
			System.out.println("cuota: "+ this.viewAltaVenta.getComboBox_cuotas().getSelectedItem().toString());
			v.setFormaPago(this.viewAltaVenta.getComboBox_cuotas().getSelectedItem().toString());
		}
		return v;
	}

}
