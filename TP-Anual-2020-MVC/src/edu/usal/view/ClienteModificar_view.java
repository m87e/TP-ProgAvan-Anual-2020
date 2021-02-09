package edu.usal.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;

import edu.usal.controllers.GUI.ClienteAltaController_GUI;
import edu.usal.controllers.GUI.ClienteModificarController_GUI;
import edu.usal.events.ClienteAltaEvents;
import edu.usal.events.ClienteModificarEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.SwingConstants;

public class ClienteModificar_view extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox comboBox_Dpais = null;
	private JComboBox comboBox_provincia = null;
	private JComboBox comboBox_pasaportePais = null;
	private JComboBox comboBox_aerolinea = null;
	private JTextField textField_provincia;
	private JLabel varProvinciaAux = null;
	private JLabel varDprovincia;
	private JLabel lblMensajeCancelado = null;
	private JLabel lblMensajeExito = null;
	private JTextField textField_categoria;
	private JTextField textField_alianza;
	private JTextField textField_nombre;
	private JTextField textField_apellido;
	private JTextField textField_DNI;
	private JTextField textField_cuit;
	private JTextField textField_email;
	private JTextField textField_calle;
	private JTextField textField_altura;
	private JTextField textField_ciudad;
	private JTextField textField_CP;
	private JTextField textField_nroPersonal;
	private JTextField textField_nroCelular;
	private JTextField textField_nroLaboral;
	private JTextField textField_nroPasaporte;
	private JTextField textField_numeroPasaFrec;
	private JTextField textField_autEmision;
	private JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento, dateChooser_fechaEmision;
	private JButton btn_Guardar,btnCancelar;
	
	private ClienteModificarController_GUI clienteModificarController = new ClienteModificarController_GUI(this);
	private JTextField textField_idCliente;
	private JTextField textField_idDireccion;
	private JTextField textField_idTelefono;
	private JTextField textField_idPasaporte;
	private JTextField textField_idPasFre;

	public ClienteModificar_view(Cliente c, DireccionCompleta d, Pasaporte p, PasajeroFrecuente pasFre, Telefono t) {
		setTitle("Modifcar cliente");
		
		//Panel Datos Personales
		JPanel panel_datosPersonales = new JPanel(new GridLayout(8,2,0,0));
		getContentPane().add(panel_datosPersonales);
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setVerticalAlignment(SwingConstants.TOP);
		lblDatosPersonales.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblDatosPersonales.setForeground(Color.BLUE);
		panel_datosPersonales.add(lblDatosPersonales);
		
		JLabel dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_datosPersonales.add(dosPuntos);
		
		JLabel lbl_idCliente = new JLabel("ID Cliente");
		panel_datosPersonales.add(lbl_idCliente);
		
		textField_idCliente = new JTextField();
		textField_idCliente.setEnabled(false);
		textField_idCliente.setEditable(false);
		panel_datosPersonales.add(textField_idCliente);
		textField_idCliente.setColumns(10);
		textField_idCliente.setText(String.valueOf(c.getId()));
		
		JLabel varDPnombre = new JLabel("Nombre");
		panel_datosPersonales.add(varDPnombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		panel_datosPersonales.add(textField_nombre);
		textField_nombre.setText(c.getNombre());

		JLabel varDPapellido = new JLabel("Apellido");
		panel_datosPersonales.add(varDPapellido);

		textField_apellido = new JTextField();
		textField_apellido.setColumns(10);
		panel_datosPersonales.add(textField_apellido);
		textField_apellido.setText(c.getApellido());

		JLabel varDPDNI = new JLabel("DNI");
		panel_datosPersonales.add(varDPDNI);

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);
		panel_datosPersonales.add(textField_DNI);
		textField_DNI.setText(c.getDni());

		JLabel varDPCuit = new JLabel("CUIT");
		panel_datosPersonales.add(varDPCuit);

		textField_cuit = new JTextField();
		panel_datosPersonales.add(textField_cuit);
		textField_cuit.setColumns(10);
		textField_cuit.setText(c.getCuit());

		JLabel varDPfechaNacimiento = new JLabel("Fecha de Nacimiento");
		panel_datosPersonales.add(varDPfechaNacimiento);

		dateChooser_fechaNac = new JDateChooser();
		panel_datosPersonales.add(dateChooser_fechaNac);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate_fechaNac = p.getFechaVencimiento();
		Date date_fechaNac = Date.from(localDate_fechaNac.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaNac.setDate(date_fechaNac);


		JLabel varDPemail = new JLabel("Email");
		panel_datosPersonales.add(varDPemail);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		panel_datosPersonales.add(textField_email);
		getContentPane().setLayout(new GridLayout(2, 3, 0, 0));
		textField_email.setText(c.getEmail());
		
		//Panel Direccion
		JPanel panel_direccion = new JPanel();
		getContentPane().add(panel_direccion);
		panel_direccion.setLayout(new GridLayout(9, 2, 0, 0));

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setVerticalAlignment(SwingConstants.TOP);
		lblDireccion.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblDireccion.setForeground(Color.BLUE);
		panel_direccion.add(lblDireccion);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_direccion.add(dosPuntos);
		
		JLabel lbl_idDireccion = new JLabel("ID Direccion");
		panel_direccion.add(lbl_idDireccion);
		
		textField_idDireccion = new JTextField();
		textField_idDireccion.setEnabled(false);
		textField_idDireccion.setEditable(false);
		panel_direccion.add(textField_idDireccion);
		textField_idDireccion.setColumns(10);
		textField_idDireccion.setText(String.valueOf(d.getId()));

		
		JLabel varDcalle = new JLabel("Calle");
		panel_direccion.add(varDcalle);

		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		panel_direccion.add(textField_calle);
		textField_calle.setText(d.getCalle());

		JLabel varDaltura = new JLabel("Altura");
		panel_direccion.add(varDaltura);

		textField_altura = new JTextField();
		textField_altura.setColumns(10);
		panel_direccion.add(textField_altura);
		textField_altura.setText(d.getAltura());

		JLabel varDciudad = new JLabel("Ciudad");
		panel_direccion.add(varDciudad);

		textField_ciudad = new JTextField();
		textField_ciudad.setColumns(10);
		panel_direccion.add(textField_ciudad);
		textField_ciudad.setText(d.getCiudad());

		JLabel varDcp = new JLabel("C.P.");
		panel_direccion.add(varDcp);

		textField_CP = new JTextField();
		textField_CP.setColumns(10);
		panel_direccion.add(textField_CP);
		textField_CP.setText(d.getCodigoPostal());

		JLabel varDpais = new JLabel("Pais");
		panel_direccion.add(varDpais);
		
		comboBox_Dpais = new JComboBox();
		panel_direccion.add(comboBox_Dpais);
		comboBox_Dpais.setVisible(true);
				
		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteModificarController.mostrarPaises();
		for (int i = 0; i < listPaises.size(); i++) {
			comboBox_Dpais.addItem(listPaises.get(i).getNombre());
		}
		
		comboBox_Dpais.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox_Dpais.getSelectedItem().equals("")) {
					varDprovincia.setVisible(false);
					varProvinciaAux.setVisible(false);
					
					textField_provincia.setVisible(false);
					comboBox_provincia.setVisible(false);
				}
				if (comboBox_Dpais.getSelectedItem().equals("Argentina")) {
					varDprovincia.setVisible(true);
					varProvinciaAux.setVisible(false);
					
					comboBox_provincia.setVisible(true);
					textField_provincia.setVisible(false);
				}
				else{
					varDprovincia.setVisible(false);
					varProvinciaAux.setVisible(true);
					
					comboBox_provincia.setVisible(false);
					textField_provincia.setVisible(true);
				}
			}
		});
		
		varDprovincia = new JLabel();
		varDprovincia.setText("Provincia");
		panel_direccion.add(varDprovincia);
		varDprovincia.setVisible(false);
		
			
		ArrayList<Provincia> listProv = (ArrayList<Provincia>) clienteModificarController.mostrarProvincias();
		
		comboBox_provincia = new JComboBox();
		for (int i = 0; i < listProv.size(); i++) {
			comboBox_provincia.addItem(listProv.get(i).getNombre());
		}
		panel_direccion.add(comboBox_provincia);
		comboBox_provincia.setVisible(false);
		
		varProvinciaAux = new JLabel("Estado");
		panel_direccion.add(varProvinciaAux);
		varProvinciaAux.setVisible(false);
		
		textField_provincia = new JTextField();
		panel_direccion.add(textField_provincia);
		textField_provincia.setColumns(10);
		textField_provincia.setVisible(false);
		
		//Panel Telefono
		
		JPanel panel_telefono = new JPanel();
		getContentPane().add(panel_telefono);
		panel_telefono.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setVerticalAlignment(SwingConstants.TOP);
		lblTelefonos.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblTelefonos.setForeground(Color.BLUE);
		panel_telefono.add(lblTelefonos);

		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_telefono.add(dosPuntos);
		
		JLabel lbl_idTelefono = new JLabel("ID Telefono");
		panel_telefono.add(lbl_idTelefono);
		
		textField_idTelefono = new JTextField();
		textField_idTelefono.setEnabled(false);
		textField_idTelefono.setEditable(false);
		panel_telefono.add(textField_idTelefono);
		textField_idTelefono.setColumns(10);
		textField_idTelefono.setText(String.valueOf(t.getId()));
		
		JLabel varTpersonal = new JLabel("Nro. Personal");
		panel_telefono.add(varTpersonal);

		textField_nroPersonal = new JTextField();
		textField_nroPersonal.setColumns(10);
		panel_telefono.add(textField_nroPersonal);
		textField_nroPersonal.setText(t.getNumPersonal());
		
		JLabel varTcelular = new JLabel("Nro. Celular");
		panel_telefono.add(varTcelular);

		textField_nroCelular = new JTextField();
		textField_nroCelular.setColumns(10);
		panel_telefono.add(textField_nroCelular);
		textField_nroCelular.setText(t.getNumCelular());

		JLabel varTlaboral = new JLabel("Nro. Laboral");
		panel_telefono.add(varTlaboral);

		textField_nroLaboral = new JTextField();
		textField_nroLaboral.setColumns(10);
		panel_telefono.add(textField_nroLaboral);
		textField_nroLaboral.setText(t.getNumLaboral());
		
		//Panel Pasaporte
		
		JPanel panel_pasaporte = new JPanel();
		getContentPane().add(panel_pasaporte);
		panel_pasaporte.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setVerticalAlignment(SwingConstants.TOP);
		lblPasaporte.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblPasaporte.setForeground(Color.BLUE);
		panel_pasaporte.add(lblPasaporte);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_pasaporte.add(dosPuntos);
		
		JLabel lbl_idPasaporte = new JLabel("ID Pasaporte");
		panel_pasaporte.add(lbl_idPasaporte);
		
		textField_idPasaporte = new JTextField();
		textField_idPasaporte.setEnabled(false);
		textField_idPasaporte.setEditable(false);
		panel_pasaporte.add(textField_idPasaporte);
		textField_idPasaporte.setColumns(10);
		textField_idPasaporte.setText(String.valueOf(p.getId()));

		JLabel varPnroPasaporte = new JLabel("Nro. Pasaporte");
		panel_pasaporte.add(varPnroPasaporte);

		textField_nroPasaporte = new JTextField();
		textField_nroPasaporte.setColumns(10);
		panel_pasaporte.add(textField_nroPasaporte);
		textField_nroPasaporte.setText(p.getNumeroPasaporte());

		JLabel varPfechaVecimiento = new JLabel("Fecha vecimiento");
		panel_pasaporte.add(varPfechaVecimiento);

		dateChooser_fechaVencimiento = new JDateChooser();
		panel_pasaporte.add(dateChooser_fechaVencimiento);
		
	
		LocalDate localDate_fechaVen = p.getFechaVencimiento();
		Date date_fechaVen = Date.from(localDate_fechaVen.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaVencimiento.setDate(date_fechaVen);

		JLabel varPfechaEmision = new JLabel("Fecha de emision");
		panel_pasaporte.add(varPfechaEmision);

		dateChooser_fechaEmision = new JDateChooser();
		panel_pasaporte.add(dateChooser_fechaEmision);
		
	
		LocalDate localDate_fechaEmi = p.getFechaEmision();
		Date date_fechaEmi = Date.from(localDate_fechaEmi.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaEmision.setDate(date_fechaEmi);

		JLabel varPpais = new JLabel("Pais");
		panel_pasaporte.add(varPpais);
		
		comboBox_pasaportePais =  new JComboBox();
		for (int i = 0; i < listPaises.size(); i++) {
			comboBox_pasaportePais.addItem(listPaises.get(i).getNombre());
		}
		comboBox_pasaportePais.setSelectedItem("Austria");
		
		panel_pasaporte.add(comboBox_pasaportePais);

		JLabel varPautEmision = new JLabel("Aut. Emision");
		panel_pasaporte.add(varPautEmision);

		textField_autEmision = new JTextField();
		panel_pasaporte.add(textField_autEmision);
		textField_autEmision.setColumns(10);
		textField_autEmision.setText(p.getAutoridadEmision());
		
		//Panel pasajero Frecuente
		JPanel panel_pasajeroFrecuente = new JPanel();
		getContentPane().add(panel_pasajeroFrecuente);
		panel_pasajeroFrecuente.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setVerticalAlignment(SwingConstants.TOP);
		lblPasajeroFrecuente.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		lblPasajeroFrecuente.setForeground(Color.BLUE);
		panel_pasajeroFrecuente.add(lblPasajeroFrecuente);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_pasajeroFrecuente.add(dosPuntos);
		
		JLabel lbl_idPasFre = new JLabel("ID Pasajero Frecuente");
		panel_pasajeroFrecuente.add(lbl_idPasFre);
		
		textField_idPasFre = new JTextField();
		textField_idPasFre.setEditable(false);
		textField_idPasFre.setEnabled(false);
		panel_pasajeroFrecuente.add(textField_idPasFre);
		textField_idPasFre.setColumns(10);
		textField_idPasFre.setText(String.valueOf(pasFre.getId()));
		
		JLabel varPFnumero = new JLabel("Numero");
		panel_pasajeroFrecuente.add(varPFnumero);

		textField_numeroPasaFrec = new JTextField();
		panel_pasajeroFrecuente.add(textField_numeroPasaFrec);
		textField_numeroPasaFrec.setColumns(10);
		textField_numeroPasaFrec.setText(pasFre.getNumeroPF());
		
		JLabel varPFaerolinea = new JLabel("Aerolinea");
		panel_pasajeroFrecuente.add(varPFaerolinea);
		
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) clienteModificarController.mostrarAerolinea();
		
		comboBox_aerolinea = new JComboBox();
		panel_pasajeroFrecuente.add(comboBox_aerolinea);
		comboBox_aerolinea.setVisible(true);
		
		comboBox_aerolinea.setSelectedItem(pasFre.getAerolinea().getNombre());
		for (int i = 0; i < listAerolinea.size(); i++) {
			comboBox_aerolinea.addItem(listAerolinea.get(i).getNombre());
		}
		comboBox_aerolinea.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String aerolinea = comboBox_aerolinea.getSelectedItem().toString();
				for (int i = 0; i < listAerolinea.size(); i++) {
					if (listAerolinea.get(i).getNombre().equals(aerolinea)) {
						textField_alianza.setText(listAerolinea.get(i).getAlianza().name());
					}
				}
			}
		});

		JLabel varPFalianza = new JLabel("Alianza");
		panel_pasajeroFrecuente.add(varPFalianza);
		
		textField_alianza = new JTextField();
		textField_alianza.setEditable(false);
		panel_pasajeroFrecuente.add(textField_alianza);
		textField_alianza.setColumns(10);
		

		JLabel varPFcategoria = new JLabel("Categoria");
		panel_pasajeroFrecuente.add(varPFcategoria);
		
		textField_categoria = new JTextField();
		panel_pasajeroFrecuente.add(textField_categoria);
		textField_categoria.setColumns(10);
		textField_categoria.setText(pasFre.getCategoria());
		
		JPanel panel_botones = new JPanel();

		getContentPane().add(panel_botones);
		SpringLayout sl_panel_botones = new SpringLayout();
		panel_botones.setLayout(sl_panel_botones);
		
		btn_Guardar = new JButton("Guardar");
		sl_panel_botones.putConstraint(SpringLayout.WEST, btn_Guardar, 64, SpringLayout.WEST, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.SOUTH, btn_Guardar, -51, SpringLayout.SOUTH, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.EAST, btn_Guardar, -71, SpringLayout.EAST, panel_botones);
		btn_Guardar.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		panel_botones.add(btn_Guardar);
		getBtn_Guardar().addActionListener(new ClienteModificarEvents(this));
		
		
		btnCancelar = new JButton("Cancelar");
		sl_panel_botones.putConstraint(SpringLayout.NORTH, btnCancelar, 45, SpringLayout.NORTH, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.WEST, btnCancelar, 64, SpringLayout.WEST, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.SOUTH, btnCancelar, -121, SpringLayout.SOUTH, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.EAST, btnCancelar, -71, SpringLayout.EAST, panel_botones);
		sl_panel_botones.putConstraint(SpringLayout.NORTH, btn_Guardar, 26, SpringLayout.SOUTH, btnCancelar);
		btnCancelar.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		panel_botones.add(btnCancelar);
		getBtnCancelar().addActionListener(new ClienteModificarEvents(this));
		
		
	}

	public JComboBox getComboBox_Dpais() {
		return comboBox_Dpais;
	}

	public void setComboBox_Dpais(JComboBox comboBox_Dpais) {
		this.comboBox_Dpais = comboBox_Dpais;
	}

	public JComboBox getComboBox_provincia() {
		return comboBox_provincia;
	}

	public void setComboBox_provincia(JComboBox comboBox_provincia) {
		this.comboBox_provincia = comboBox_provincia;
	}

	public JTextField getTextField_provincia() {
		return textField_provincia;
	}

	public void setTextField_provincia(JTextField textField_provincia) {
		this.textField_provincia = textField_provincia;
	}

	public JLabel getVarProvinciaAux() {
		return varProvinciaAux;
	}

	public void setVarProvinciaAux(JLabel varProvinciaAux) {
		this.varProvinciaAux = varProvinciaAux;
	}

	public JLabel getVarDprovincia() {
		return varDprovincia;
	}

	public void setVarDprovincia(JLabel varDprovincia) {
		this.varDprovincia = varDprovincia;
	}

	public JTextField getTextField_categoria() {
		return textField_categoria;
	}

	public void setTextField_categoria(JTextField textField_categoria) {
		this.textField_categoria = textField_categoria;
	}

	public JTextField getTextField_alianza() {
		return textField_alianza;
	}

	public void setTextField_alianza(JTextField textField_alianza) {
		this.textField_alianza = textField_alianza;
	}

	public JTextField getTextField_nombre() {
		return textField_nombre;
	}

	public void setTextField_nombre(JTextField textField_nombre) {
		this.textField_nombre = textField_nombre;
	}

	public JTextField getTextField_apellido() {
		return textField_apellido;
	}

	public void setTextField_apellido(JTextField textField_apellido) {
		this.textField_apellido = textField_apellido;
	}

	public JTextField getTextField_DNI() {
		return textField_DNI;
	}

	public void setTextField_DNI(JTextField textField_DNI) {
		this.textField_DNI = textField_DNI;
	}

	public JTextField getTextField_cuit() {
		return textField_cuit;
	}

	public void setTextField_cuit(JTextField textField_cuit) {
		this.textField_cuit = textField_cuit;
	}

	public JTextField getTextField_email() {
		return textField_email;
	}

	public void setTextField_email(JTextField textField_email) {
		this.textField_email = textField_email;
	}

	public JTextField getTextField_calle() {
		return textField_calle;
	}

	public void setTextField_calle(JTextField textField_calle) {
		this.textField_calle = textField_calle;
	}

	public JTextField getTextField_altura() {
		return textField_altura;
	}

	public void setTextField_altura(JTextField textField_altura) {
		this.textField_altura = textField_altura;
	}

	public JTextField getTextField_ciudad() {
		return textField_ciudad;
	}

	public void setTextField_ciudad(JTextField textField_ciudad) {
		this.textField_ciudad = textField_ciudad;
	}

	public JTextField getTextField_CP() {
		return textField_CP;
	}

	public void setTextField_CP(JTextField textField_CP) {
		this.textField_CP = textField_CP;
	}

	public JTextField getTextField_nroPersonal() {
		return textField_nroPersonal;
	}

	public void setTextField_nroPersonal(JTextField textField_nroPersonal) {
		this.textField_nroPersonal = textField_nroPersonal;
	}

	public JTextField getTextField_nroCelular() {
		return textField_nroCelular;
	}

	public void setTextField_nroCelular(JTextField textField_nroCelular) {
		this.textField_nroCelular = textField_nroCelular;
	}

	public JTextField getTextField_nroLaboral() {
		return textField_nroLaboral;
	}

	public void setTextField_nroLaboral(JTextField textField_nroLaboral) {
		this.textField_nroLaboral = textField_nroLaboral;
	}

	public JTextField getTextField_nroPasaporte() {
		return textField_nroPasaporte;
	}

	public void setTextField_nroPasaporte(JTextField textField_nroPasaporte) {
		this.textField_nroPasaporte = textField_nroPasaporte;
	}

	public JTextField getTextField_numeroPasaFrec() {
		return textField_numeroPasaFrec;
	}

	public void setTextField_numeroPasaFrec(JTextField textField_numeroPasaFrec) {
		this.textField_numeroPasaFrec = textField_numeroPasaFrec;
	}

	public JTextField getTextField_autEmision() {
		return textField_autEmision;
	}

	public void setTextField_autEmision(JTextField textField_autEmision) {
		this.textField_autEmision = textField_autEmision;
	}

	public JDateChooser getDateChooser_fechaNac() {
		return dateChooser_fechaNac;
	}

	public void setDateChooser_fechaNac(JDateChooser dateChooser_fechaNac) {
		this.dateChooser_fechaNac = dateChooser_fechaNac;
	}

	public JDateChooser getDateChooser_fechaVencimiento() {
		return dateChooser_fechaVencimiento;
	}

	public void setDateChooser_fechaVencimiento(JDateChooser dateChooser_fechaVencimiento) {
		this.dateChooser_fechaVencimiento = dateChooser_fechaVencimiento;
	}

	public JDateChooser getDateChooser_fechaEmision() {
		return dateChooser_fechaEmision;
	}

	public void setDateChooser_fechaEmision(JDateChooser dateChooser_fechaEmision) {
		this.dateChooser_fechaEmision = dateChooser_fechaEmision;
	}

	public JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	public void setBtn_Guardar(JButton btn_Guardar) {
		this.btn_Guardar = btn_Guardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public ClienteModificarController_GUI getClienteAltaController() {
		return clienteModificarController;
	}

	public void setClienteModificarController(ClienteModificarController_GUI clienteModificarController) {
		this.clienteModificarController = clienteModificarController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JComboBox getComboBox_pasaportePais() {
		return comboBox_pasaportePais;
	}

	public void setComboBox_pasaportePais(JComboBox comboBox_pasaportePais) {
		this.comboBox_pasaportePais = comboBox_pasaportePais;
	}

	public JComboBox getComboBox_aerolinea() {
		return comboBox_aerolinea;
	}

	public void setComboBox_aerolinea(JComboBox comboBox_aerolinea) {
		this.comboBox_aerolinea = comboBox_aerolinea;
	}

	public JLabel getLblMensajeCancelado() {
		return lblMensajeCancelado;
	}

	public void setLblMensajeCancelado(JLabel lblMensajeCancelado) {
		this.lblMensajeCancelado = lblMensajeCancelado;
	}

	public JLabel getLblMensajeExito() {
		return lblMensajeExito;
	}

	public void setLblMensajeExito(JLabel lblMensajeExito) {
		this.lblMensajeExito = lblMensajeExito;
	}

	public JTextField getTextField_idCliente() {
		return textField_idCliente;
	}

	public void setTextField_idCliente(JTextField textField_idCliente) {
		this.textField_idCliente = textField_idCliente;
	}

	public JTextField getTextField_idDireccion() {
		return textField_idDireccion;
	}

	public void setTextField_idDireccion(JTextField textField_idDireccion) {
		this.textField_idDireccion = textField_idDireccion;
	}

	public JTextField getTextField_idTelefono() {
		return textField_idTelefono;
	}

	public void setTextField_idTelefono(JTextField textField_idTelefono) {
		this.textField_idTelefono = textField_idTelefono;
	}

	public JTextField getTextField_idPasaporte() {
		return textField_idPasaporte;
	}

	public void setTextField_idPasaporte(JTextField textField_idPasaporte) {
		this.textField_idPasaporte = textField_idPasaporte;
	}

	public JTextField getTextField_idPasFre() {
		return textField_idPasFre;
	}

	public void setTextField_idPasFre(JTextField textField_idPasFre) {
		this.textField_idPasFre = textField_idPasFre;
	}
	
	
	
}
