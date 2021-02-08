package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.usal.controllers.GUI.ClienteModificarController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.view.ClienteModificar_view;

public class ClienteModificarEvents implements ActionListener{

	private ClienteModificar_view viewModificarCliente;
	private ClienteModificarController_GUI clienteModificarController;
	
	public ClienteModificarEvents(ClienteModificar_view viewModificarCliente) {
		this.viewModificarCliente = viewModificarCliente;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.viewModificarCliente.getBtn_Guardar()){
			System.out.println("... Procensando modificacion de Cliente...");
			Cliente c = CargarCliente();
			Pasaporte p = CargarPasaporte();
			Telefono tel = CargarTelefono();
			DireccionCompleta dir = CargarDirCompleta();
			PasajeroFrecuente pasFrec = CargarPasFrecuente();
			
			try {
				clienteModificarController.modificarCliente(c, p, tel, dir, pasFrec);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente");
		}
		
		if (e.getSource() == this.viewModificarCliente.getBtnCancelar()){
			this.viewModificarCliente.setVisible(false);
		}
	}

	//Metodos de carga
	
	private Cliente CargarCliente() {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();

		c.setNombre(this.viewModificarCliente.getTextField_nombre().getText());
		c.setApellido(this.viewModificarCliente.getTextField_apellido().getText());
		c.setDni(this.viewModificarCliente.getTextField_DNI().getText());
		c.setCuit(this.viewModificarCliente.getTextField_cuit().getText());
		Date date = this.viewModificarCliente.getDateChooser_fechaNac().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		c.setFechaNac(localDate);

		c.setEmail(this.viewModificarCliente.getTextField_email().getText());

		return c;
	}

	private Pasaporte CargarPasaporte() {
		// TODO Auto-generated method stub
		Pasaporte pas = new Pasaporte();
		pas.setNumeroPasaporte(this.viewModificarCliente.getTextField_nroPasaporte().getText());
		
		Pais p = new Pais();
		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteModificarController.mostrarPaises();
		for (int i = 0; i < listPaises.size(); i++) {
			if (listPaises.get(i).getNombre().equals(this.viewModificarCliente.getComboBox_Dpais().getSelectedItem())) {
				p.setId(listPaises.get(i).getId());
				p.setNombre(listPaises.get(i).getNombre());
			}
		}
		pas.setPais(p);

		Date date = this.viewModificarCliente.getDateChooser_fechaVencimiento().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(date);
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		pas.setFechaVencimiento(localDate);

		date = this.viewModificarCliente.getDateChooser_fechaEmision().getDate();
		sdf.format(date);
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		pas.setFechaEmision(localDate);
		pas.setAutoridadEmision(this.viewModificarCliente.getTextField_autEmision().getText());

		return pas;	
	}

	private Telefono CargarTelefono() {
		// TODO Auto-generated method stub
		Telefono t = new Telefono();

		t.setNumPersonal(this.viewModificarCliente.getTextField_nroPersonal().getText());
		t.setNumCelular(this.viewModificarCliente.getTextField_nroCelular().getText());
		t.setNumLaboral(this.viewModificarCliente.getTextField_nroLaboral().getText());

		return t;
	}

	private DireccionCompleta CargarDirCompleta() {
		// TODO Auto-generated method stub
		DireccionCompleta dir = new DireccionCompleta();

		Pais p = new Pais();
		Provincia prov = new Provincia();

		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteModificarController.mostrarPaises();
		ArrayList<Provincia> listProv = (ArrayList<Provincia>) clienteModificarController.mostrarProvincias();
		for (int i = 0; i < listPaises.size(); i++) {
			if (listPaises.get(i).getNombre().equals(this.viewModificarCliente.getComboBox_pasaportePais().getSelectedItem())) {
				p.setId(listPaises.get(i).getId());
				p.setNombre(listPaises.get(i).getNombre());
			}
		}
		for (int i = 0; i < listProv.size(); i++) {
			if (listProv.get(i).getNombre().equals(this.viewModificarCliente.getComboBox_provincia().getSelectedItem())) {
				prov.setId(listProv.get(i).getId());
				prov.setNombre(listProv.get(i).getNombre());
			}
		}
		
		dir.setCalle(this.viewModificarCliente.getTextField_calle().getText());
		dir.setAltura(this.viewModificarCliente.getTextField_altura().getText());
		dir.setCiudad(this.viewModificarCliente.getTextField_ciudad().getText());
		dir.setCodigoPostal(this.viewModificarCliente.getTextField_CP().getText());
		dir.setPais(p);
		dir.setProvincia(prov);
		return dir;
	}

	private PasajeroFrecuente CargarPasFrecuente() {
		// TODO Auto-generated method stub
		PasajeroFrecuente pas = new PasajeroFrecuente();
		Aerolinea aerolinea = new Aerolinea();
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) clienteModificarController.mostrarAerolinea();
		for (int i = 0; i < listAerolinea.size(); i++) {
			if (listAerolinea.get(i).getNombre().equals(this.viewModificarCliente.getComboBox_aerolinea().getSelectedItem())) {
				aerolinea.setId(listAerolinea.get(i).getId());
				aerolinea.setNombre(listAerolinea.get(i).getNombre());
				aerolinea.setAlianza(listAerolinea.get(i).getAlianza());
				pas.setAlianza(listAerolinea.get(i).getAlianza());
			}
		}		
		
	//	pas.setAlianza(Alianza.StarAlliance);
		pas.setAerolinea(aerolinea);
		pas.setNumeroPF(this.viewModificarCliente.getTextField_numeroPasaFrec().getText());
		pas.setCategoria(this.viewModificarCliente.getTextField_categoria().getText());

		return pas;
	}
}
