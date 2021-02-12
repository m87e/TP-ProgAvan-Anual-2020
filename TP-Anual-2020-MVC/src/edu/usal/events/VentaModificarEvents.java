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
import edu.usal.controllers.GUI.VentasModificarController_GUI;
import edu.usal.managers.ClienteManager;
import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VentasAlta_view;
import edu.usal.view.VentasModificar_view;

public class VentaModificarEvents implements ActionListener {

	private VentasModificar_view viewModificarVenta;
	private VentasModificarController_GUI ventaModificarController = new VentasModificarController_GUI();
	private ClienteManager managerCliente = new ClienteManager();
	private VueloManager managerVuelo = new VueloManager();
	
	
	public VentaModificarEvents(VentasModificar_view viewModificarVenta) {
		this.viewModificarVenta = viewModificarVenta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.viewModificarVenta.getBtnGuardar()) {
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
			
			Date date = this.viewModificarVenta.getDateChooser_fechaVenta().getDate();
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
				this.viewModificarVenta.setLblClienteMenor(true);
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
				this.viewModificarVenta.setLblPasaporteVencido(true);
			}else {
				validarPasaporteVencido = true;
			}
			
			//Validar Pasaporte Por Vencer
			
			long diasValidarPasaportePorVencer = DAYS.between(v.getFechaHoraLlegada(),p.getFechaVencimiento());
			if((diasValidarPasaportePorVencer)<(6*30))  {
				this.viewModificarVenta.setLblPorVencer(true);
			}else {
				validarPasaportePorVencer = true;
			}
			
			//Vuelo completo
			
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(v.getNumVuelo());
			System.out.println(v.getCantAsientos());
			System.out.println("-----------------------------------------------------------------------------------");
			
			if(v.getCantAsientos()==0)  {
				this.viewModificarVenta.setLblVueloCompleto(true);
			}else {
				validarVueloLleno  = true;
			}
			
			//Validacion completa
			if(validarMenor && validarPasaporteVencido && validarPasaportePorVencer&&validarVueloLleno) {
				ventaModificarController.modificarVenta(vt);
				int asientos = v.getCantAsientos();
				v.setCantAsientos(asientos-1);
				managerVuelo.ModificacionVuelo(v);
				JOptionPane.showMessageDialog(null, "Venta agregada exitosamente!");
				this.viewModificarVenta.setVisible(false);
			}
			
		}
	}
		
	private Aerolinea CargarAerolinea() {
		Aerolinea ae = new Aerolinea();
		String nombreAerolineaSeleccionada = this.viewModificarVenta.getTextField_aerolinea().getText();
		
		List<Aerolinea> aerolinea = ventaModificarController.mostrarAerolinea();
		
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
		String numeroVueloSeleccionada = this.viewModificarVenta.getComboBox_vuelo().getSelectedItem().toString();
		v.setNumVuelo(numeroVueloSeleccionada);
		return v;
	}
	private Cliente CargaCliente() {
		Cliente c = new Cliente();
		c.setDni(this.viewModificarVenta.getTextField_cliente().getText());
		return c;
	}
	private Venta CargaVenta() {
		Venta v = new Venta ();
		
		Date date = this.viewModificarVenta.getDateChooser_fechaVenta().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		v.setFechaHoraVenta(localDate);
		
		if(this.viewModificarVenta.getComboBox_formaPago().getSelectedItem().equals("Contado")) {
			v.setFormaPago(this.viewModificarVenta.getComboBox_formaPago().getSelectedItem().toString());
		}
		else {
			System.out.println("cuota: "+ this.viewModificarVenta.getComboBox_cuotas().getSelectedItem().toString());
			v.setFormaPago(this.viewModificarVenta.getComboBox_cuotas().getSelectedItem().toString());
		}
		return v;
	}

}
