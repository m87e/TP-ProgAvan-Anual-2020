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
import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VentasAlta_view;

public class VentaAltaEvents implements ActionListener {

	private VentasAlta_view viewAltaVenta;
	private VentasAltaController_GUI ventaAltaController = new VentasAltaController_GUI();
	private ClienteManager managerCliente = new ClienteManager();
	private VueloManager managerVuelo = new VueloManager();
	
	
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
			
			int idPas = 0;
			for (int i = 0; i < listCliente.size(); i++) {
				if (listCliente.get(i).getDni().equals(c.getDni())) {
					LocalDate fechaNac = listCliente.get(i).getFechaNac();
					idPas = listCliente.get(i).getPasaporte().getId();
					c.setFechaNac(fechaNac);
				}
			}
			
			ArrayList<Vuelo> listVuelo = (ArrayList<Vuelo>) managerVuelo.MostrarVuelos();
			
			for (int i = 0; i < listVuelo.size(); i++) {
				if (listVuelo.get(i).getNumVuelo().equals(v.getNumVuelo())) {
					LocalDate fechaSalida = listVuelo.get(i).getFechaHoraSalida();
					LocalDate fechaLlegada = listVuelo.get(i).getFechaHoraLlegada();
					
					v.setCantAsientos(listVuelo.get(i).getCantAsientos());
					v.setFechaHoraLlegada(fechaLlegada);
					v.setFechaHoraSalida(fechaSalida);
					v.setId(listVuelo.get(i).getId());
					v.setAeropuertoLlegada(listVuelo.get(i).getAeropuertoLlegada());
					v.setAeropuertoSalida(listVuelo.get(i).getAeropuertoSalida());
					v.setAerolinea(listVuelo.get(i).getAerolinea());
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
			fechaVenta = LocalDate.of(fechaVenta.getYear(), fechaVenta.getMonth(), fechaVenta.getDayOfMonth());
			
			LocalDate fechaNacimiento = c.getFechaNac();
			System.out.println(fechaNacimiento);
			fechaNacimiento = LocalDate.of(fechaNacimiento.getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
			
			//Validacion Edad
			long diasValidarMenor = DAYS.between(fechaNacimiento,fechaVenta);
			System.out.println(diasValidarMenor);
			
			if((diasValidarMenor)<18*365)  {
				this.viewAltaVenta.setLblClienteMenor(true);
			}else {
				validarMenor = true;
			}
			
			//ValidarPasaporteVencido
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(idPas);
			System.out.println(managerCliente.ObtenerPasaporte(idPas).getId());
			System.out.println("-----------------------------------------------------------------------------------");
			Pasaporte p = managerCliente.ObtenerPasaporte(idPas);
			long diasValidarPasaporteVencido = DAYS.between(fechaVenta,p.getFechaVencimiento());
			
			if((diasValidarPasaporteVencido)<0)  {
				this.viewAltaVenta.setLblPasaporteVencido(true);
			}else {
				validarPasaporteVencido = true;
			}
			
			//Validar Pasaporte Por Vencer
			
			long diasValidarPasaportePorVencer = DAYS.between(v.getFechaHoraLlegada(),p.getFechaVencimiento());
			if((diasValidarPasaportePorVencer)<(6*30))  {
				this.viewAltaVenta.setLblPorVencer(true);
			}else {
				validarPasaportePorVencer = true;
			}
			
			//Vuelo completo
			
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(v.getNumVuelo());
			System.out.println(v.getCantAsientos());
			System.out.println("-----------------------------------------------------------------------------------");
			
			if(v.getCantAsientos()==0)  {
				this.viewAltaVenta.setLblVueloCompleto(true);
			}else {
				validarVueloLleno  = true;
			}
			
			//Validacion completa
			if(validarMenor && validarPasaporteVencido && validarPasaportePorVencer&&validarVueloLleno) {
				ventaAltaController.altaVenta(vt, c, v, a, f, fP);
				int asientos = v.getCantAsientos();
				v.setCantAsientos(asientos-1);
				managerVuelo.ModificacionVuelo(v);
				JOptionPane.showMessageDialog(null, "Venta agregada exitosamente!");
				this.viewAltaVenta.setVisible(false);
			}
			
		}
	}
	

	public long diasEntreLocalDate(LocalDate inicio, LocalDate fin){
	    return DAYS.between(inicio, fin);
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
