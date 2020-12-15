package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import edu.usal.controllers.GUI.ClienteAltaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.view.ClientesAltaView;
import edu.usal.view.ClientesView;
import edu.usal.view.Menu_view;

public class ClienteAltaEvents implements ActionListener{


	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	//private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	
	private ClientesAltaView viewAltaCliente;
	private ClienteAltaController_GUI clienteAltaController = new ClienteAltaController_GUI();
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	
	public ClienteAltaEvents(ClientesAltaView viewAltaCliente) {
		this.viewAltaCliente = viewAltaCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.viewAltaCliente.getBtn_Guardar()){
			Cliente c = CargarCliente();
			Pasaporte p = CargarPasaporte();
			Telefono tel = CargarTelefono();
			DireccionCompleta dir = CargarDirCompleta();
			PasajeroFrecuente pasFrec = CargarPasFrecuente();
			
			try {
					this.viewAltaCliente.getLblMensajeExito().setVisible(true);
					clienteAltaController.altaCliente(c, p, tel, dir, pasFrec);
					this.viewAltaCliente.getLblMensajeExito().setVisible(false);
					Menu_view.RecargarPanelCambiante(this.viewAltaCliente);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

		}
		if (e.getSource() == this.viewAltaCliente.getBtnCancelar()) {
			this.viewAltaCliente.getLblMensajeCancelado().setVisible(true);
			Menu_view.RecargarPanelCambiante(this.viewAltaCliente);
		}
		if(e.getSource() == this.viewAltaCliente.getBtn_GoConsultaCliente()) {
			//Menu_view.RecargarPanelCambiante(new ClientesView());
		}
		
	}
	private Cliente CargarCliente() {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();

		c.setNombre(this.viewAltaCliente.getTextField_nombre().getText());
		c.setApellido(this.viewAltaCliente.getTextField_apellido().getText());
		c.setDni(this.viewAltaCliente.getTextField_DNI().getText());
		c.setCuit(this.viewAltaCliente.getTextField_cuit().getText());
		Date date = this.viewAltaCliente.getDateChooser_fechaNac().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		c.setFechaNac(localDate);

		c.setEmail(this.viewAltaCliente.getTextField_email().getText());

		return c;
	}

	private Pasaporte CargarPasaporte() {
		// TODO Auto-generated method stub
		Pasaporte pas = new Pasaporte();
		pas.setNumeroPasaporte(this.viewAltaCliente.getTextField_nroPasaporte().getText());
		
		Pais p = new Pais();
		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteAltaController.mostrarPaises();
		for (int i = 0; i < listPaises.size(); i++) {
			if (listPaises.get(i).getNombre().equals(this.viewAltaCliente.getComboBox_Dpais().getSelectedItem())) {
				p.setId(listPaises.get(i).getId());
				p.setNombre(listPaises.get(i).getNombre());
			}
		}
		pas.setPais(p);

		Date date = this.viewAltaCliente.getDateChooser_fechaVencimiento().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		pas.setFechaVencimiento(localDate);

		date = this.viewAltaCliente.getDateChooser_fechaEmision().getDate();
		sdf.format(date);
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		pas.setFechaEmision(localDate);
		pas.setAutoridadEmision(this.viewAltaCliente.getTextField_autEmision().getText());

		return pas;	
	}

	private Telefono CargarTelefono() {
		// TODO Auto-generated method stub
		Telefono t = new Telefono();

		t.setNumPersonal(this.viewAltaCliente.getTextField_nroPersonal().getText());
		t.setNumCelular(this.viewAltaCliente.getTextField_nroCelular().getText());
		t.setNumLaboral(this.viewAltaCliente.getTextField_nroLaboral().getText());

		return t;
	}

	private DireccionCompleta CargarDirCompleta() {
		// TODO Auto-generated method stub
		DireccionCompleta dir = new DireccionCompleta();

		Pais p = new Pais();
		Provincia prov = new Provincia();

		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteAltaController.mostrarPaises();
		ArrayList<Provincia> listProv = (ArrayList<Provincia>) clienteAltaController.mostrarProvincias();
		for (int i = 0; i < listPaises.size(); i++) {
			if (listPaises.get(i).getNombre().equals(this.viewAltaCliente.getComboBox_pasaportePais().getSelectedItem())) {
				p.setId(listPaises.get(i).getId());
				p.setNombre(listPaises.get(i).getNombre());
			}
		}
		for (int i = 0; i < listProv.size(); i++) {
			if (listProv.get(i).getNombre().equals(this.viewAltaCliente.getComboBox_provincia().getSelectedItem())) {
				prov.setId(listProv.get(i).getId());
				prov.setNombre(listProv.get(i).getNombre());
			}
		}
		
		dir.setCalle(this.viewAltaCliente.getTextField_calle().getText());
		dir.setAltura(this.viewAltaCliente.getTextField_altura().getText());
		dir.setCiudad(this.viewAltaCliente.getTextField_ciudad().getText());
		dir.setCodigoPostal(this.viewAltaCliente.getTextField_CP().getText());
		dir.setPais(p);
		dir.setProvincia(prov);
		return dir;
	}

	private PasajeroFrecuente CargarPasFrecuente() {
		// TODO Auto-generated method stub
		PasajeroFrecuente pas = new PasajeroFrecuente();
		Aerolinea aerolinea = new Aerolinea();
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) clienteAltaController.mostrarAerolinea();
		for (int i = 0; i < listAerolinea.size(); i++) {
			if (listAerolinea.get(i).getNombre().equals(this.viewAltaCliente.getComboBox_aerolinea().getSelectedItem())) {
				aerolinea.setId(listAerolinea.get(i).getId());
				aerolinea.setNombre(listAerolinea.get(i).getNombre());
				aerolinea.setAlianza(listAerolinea.get(i).getAlianza());
				pas.setAlianza(listAerolinea.get(i).getAlianza());
			}
		}		
		
	//	pas.setAlianza(Alianza.StarAlliance);
		pas.setAerolinea(aerolinea);
		pas.setNumeroPF(this.viewAltaCliente.getTextField_numeroPasaFrec().getText());
		pas.setCategoria(this.viewAltaCliente.getTextField_categoria().getText());

		return pas;
	}
}
