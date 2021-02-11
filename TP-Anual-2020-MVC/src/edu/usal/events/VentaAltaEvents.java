package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.VentasAltaController_GUI;
import edu.usal.managers.ClienteManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VentasAlta_view;

public class VentaAltaEvents implements ActionListener {

	private VentasAlta_view viewAltaVenta;
	private VentasAltaController_GUI ventaAltaController = new VentasAltaController_GUI();
	private ClienteManager managerCliente = new ClienteManager();
	
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
			
			ArrayList<Cliente> listCliente = (ArrayList<Cliente>) managerCliente.MostrarClientes();
			
			for (int i = 0; i < listCliente.size(); i++) {
				if (listCliente.get(i).getId() == c.getId()) {
					c.getPasaporte().setId(listCliente.get(i).getPasaporte().getId());
					LocalDate fechaNac = listCliente.get(i).getFechaNac();
					c.setFechaNac(fechaNac);
				}
			}
		
			Boolean validarMenor = false;
			Boolean validarPasaporteVencido = false;
			Boolean validarPasaportePorVencer = false;
			Boolean validarVueloLleno = false;
			
			Date date = this.viewAltaVenta.getDateChooser_fechaVenta().getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			sdf.format(date);
			LocalDate fechaVenta = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			System.out.println("CantDias: "+CalcularFecha(fechaVenta, c.getFechaNac()));
			
			if((CalcularFecha(fechaVenta, c.getFechaNac())<18*365) ) {
				this.viewAltaVenta.setLblClienteMenor(true);
			}else {
				validarMenor = true;
			}
			
			/*
			if(validacionFecha && validacionPasaporte ) {
				ventaAltaController.altaVenta(vt, c, v, a, f, fP);
				JOptionPane.showMessageDialog(null, "Venta agregada exitosamente!");
				this.viewAltaVenta.setVisible(false);
			}
			*/
		}
	}
	
	public long CalcularFecha(LocalDate inicio, LocalDate fin) {

		LocalDate start = LocalDate.of(inicio.getYear(), inicio.getMonth(), inicio.getDayOfMonth());
		LocalDate end = LocalDate.of(fin.getYear(), fin.getMonth(), fin.getDayOfMonth());
		
		long dias = DAYS.between(start, end);

		
		return dias;

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
