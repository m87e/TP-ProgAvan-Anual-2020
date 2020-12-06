package edu.usal.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import util.EstadoDePanel;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ClientesABM_view extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private JTextField textField_alianza;
	private JTextField textField_Pas_pais;
	private JTextField textField_categoria;

	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	private static EstadoDePanel estadoPanel = EstadoDePanel.NADA;

	private JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento, dateChooser_fechaEmision;

	private JList<String> listCliente;

	private JScrollPane scrollPane;

	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	private ClienteController_GUI clienteController = new ClienteController_GUI(this);

	private DefaultListModel<String> modelo;
	private JTextField textField_autEmision;

	public ClientesABM_view() {
		
		// Instanciazion de objetos controllers
		// ClienteController_GUI clienteController;

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, lblClientes, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblClientes, 10, SpringLayout.WEST, this);
		add(lblClientes);

		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 17, SpringLayout.SOUTH, lblClientes);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 730, SpringLayout.WEST, this);
		add(scrollPane);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 75, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 11, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -268, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, panel);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));

		btnAlta = new JButton("Alta");
		panel.add(btnAlta);
		btnAlta.addActionListener(this);
		panel.add(btnAlta);

		btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		btnModificar.addActionListener(this);
		panel.add(btnModificar);

		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 43, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 5, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 2, 0, 0));

		

		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		panel_2.add(textField_nombre);

		JLabel varDPapellido = new JLabel("Apellido");
		panel_2.add(varDPapellido);

		textField_apellido = new JTextField();
		textField_apellido.setColumns(10);
		panel_2.add(textField_apellido);

		JLabel varDPDNI = new JLabel("DNI");
		panel_2.add(varDPDNI);

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);
		panel_2.add(textField_DNI);

		JLabel varDPCuit = new JLabel("CUIT");
		panel_2.add(varDPCuit);

		textField_cuit = new JTextField();
		panel_2.add(textField_cuit);
		textField_cuit.setColumns(10);

		JLabel varDPfechaNacimiento = new JLabel("Fecha de Nacimiento");
		panel_2.add(varDPfechaNacimiento);

		dateChooser_fechaNac = new JDateChooser();
		panel_2.add(dateChooser_fechaNac);

		JLabel varDPemail = new JLabel("Email");
		panel_2.add(varDPemail);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		panel_2.add(textField_email);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel varDcalle = new JLabel("Calle");
		panel_3.add(varDcalle);

		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		panel_3.add(textField_calle);

		JLabel varDaltura = new JLabel("Altura");
		panel_3.add(varDaltura);

		textField_altura = new JTextField();
		textField_altura.setColumns(10);
		panel_3.add(textField_altura);

		JLabel varDciudad = new JLabel("Ciudad");
		panel_3.add(varDciudad);

		textField_ciudad = new JTextField();
		textField_ciudad.setColumns(10);
		panel_3.add(textField_ciudad);

		JLabel varDcp = new JLabel("C.P.");
		panel_3.add(varDcp);

		textField_CP = new JTextField();
		textField_CP.setColumns(10);
		panel_3.add(textField_CP);

		JLabel varDpais = new JLabel("Pais");
		panel_3.add(varDpais);

		JList list_pais = new JList();
		panel_3.add(list_pais);

		JLabel varDprovincia = new JLabel("Provincia");
		panel_3.add(varDprovincia);

		JList list_provincia = new JList();
		panel_3.add(list_provincia);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel varTpersonal = new JLabel("Nro. Personal");
		panel_4.add(varTpersonal);

		textField_nroPersonal = new JTextField();
		textField_nroPersonal.setColumns(10);
		panel_4.add(textField_nroPersonal);

		JLabel varTcelular = new JLabel("Nro. Celular");
		panel_4.add(varTcelular);

		textField_nroCelular = new JTextField();
		textField_nroCelular.setColumns(10);
		panel_4.add(textField_nroCelular);

		JLabel varTlaboral = new JLabel("Nro. Laboral");
		panel_4.add(varTlaboral);

		textField_nroLaboral = new JTextField();
		textField_nroLaboral.setColumns(10);
		panel_4.add(textField_nroLaboral);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel varPnroPasaporte = new JLabel("Nro. Pasaporte");
		panel_5.add(varPnroPasaporte);

		textField_nroPasaporte = new JTextField();
		textField_nroPasaporte.setColumns(10);
		panel_5.add(textField_nroPasaporte);

		JLabel varPfechaVecimiento = new JLabel("Fecha vecimiento");
		panel_5.add(varPfechaVecimiento);

		dateChooser_fechaVencimiento = new JDateChooser();
		panel_5.add(dateChooser_fechaVencimiento);

		JLabel varPfechaEmision = new JLabel("Fecha de emision");
		panel_5.add(varPfechaEmision);

		dateChooser_fechaEmision = new JDateChooser();
		panel_5.add(dateChooser_fechaEmision);

		JLabel varPpais = new JLabel("Paises");
		panel_5.add(varPpais);

		textField_Pas_pais = new JTextField();
		panel_5.add(textField_Pas_pais);
		textField_Pas_pais.setColumns(10);

		JLabel varPautEmision = new JLabel("Aut. Emision");
		panel_5.add(varPautEmision);

		textField_autEmision = new JTextField();
		panel_5.add(textField_autEmision);
		textField_autEmision.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel varPFnumero = new JLabel("Numero");
		panel_6.add(varPFnumero);

		textField_numeroPasaFrec = new JTextField();
		panel_6.add(textField_numeroPasaFrec);
		textField_numeroPasaFrec.setColumns(10);

		JLabel varPFalianza = new JLabel("Alianza");
		panel_6.add(varPFalianza);

		textField_alianza = new JTextField();
		panel_6.add(textField_alianza);
		textField_alianza.setColumns(10);

		JLabel varPFcategoria = new JLabel("Categoria");
		panel_6.add(varPFcategoria);

		textField_categoria = new JTextField();
		panel_6.add(textField_categoria);
		textField_categoria.setColumns(10);

		JPanel panel_7 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_7, 519, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_7, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_7);
		springLayout.putConstraint(SpringLayout.WEST, panel_7, -138, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel);
		add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));

		btnGuardar = new JButton("Guardar");
		panel_7.add(btnGuardar);
		btnGuardar.addActionListener(this);
		panel_7.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		panel_7.add(btnCancelar);
		btnCancelar.addActionListener(this);
		panel_7.add(btnCancelar);

		JPanel panel_8 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_8, -34, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, scrollPane);

		modelo = new DefaultListModel<>();

		listCliente = new JList();
		listCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		/*
		 * listCliente.setModel(new AbstractListModel() { String[] values = new String[]
		 * {"item1", "item2", "item3", "item4", "item5", "item6"}; public int getSize()
		 * { return values.length; } public Object getElementAt(int index) { return
		 * values[index]; } });
		 */

		/*
		 * initComponents(); listCliente.setModel(new AbstractListModel() { String[]
		 * values = new String[] {}; public int getSize() { return values.length; }
		 * public Object getElementAt(int index) { return values[index]; } });
		 */

		ArrayList<Cliente> listaAux = (ArrayList<Cliente>) clienteController.mostrarTodo();

		for (int i = 0; i < listaAux.size(); i++) {
			modelo.addElement(listaAux.get(i).getNombre() + " | " + listaAux.get(i).getApellido() + " | "
					+ listaAux.get(i).getDni() + " | " + listaAux.get(i).getEmail());
		}

		listCliente.setModel(modelo);

		scrollPane.setViewportView(listCliente);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_8, -6, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel);
		add(panel_8);
		panel_8.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		panel_8.add(lblDatosPersonales);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		panel_8.add(lblDireccion);

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		panel_8.add(lblTelefonos);

		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		panel_8.add(lblPasaporte);

		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		panel_8.add(lblPasajeroFrecuente);

		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}

	private void initComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Cliente cli = null;

		if (e.getSource() == btnAlta) {
			System.out.println("seteando alta...");
			btnModificar.setEnabled(false);
			btnBorrar.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnCancelar.setEnabled(true);
			System.out.println("botones deshabilitados..");
			// cli = new Cliente();
			// clienteController.altaCliente();

			estadoPanel = EstadoDePanel.ALTA;
			// Menu_view.RecargarPanelCambiante(this);
		}

		if (e.getSource() == btnModificar) {
			System.out.println("Seteando update...");
			estadoPanel = EstadoDePanel.MODIFICACION;

			btnAlta.setEnabled(false);
			btnBorrar.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnCancelar.setEnabled(true);

			String cliSelect = (String) listCliente.getSelectedValue();
			String[] partes = cliSelect.split("\\|");
			// String dniToSearch = ("'"+partes[2]+"'").trim().replace(" ", "");
			String dniToSearch = (partes[2]).trim().replace(" ", "");

			cli = clienteController.mostrarClientePorDni(dniToSearch);
			System.out.println("Cliente a modificar: " + cli.getId());
			MostrarCliente(cli);

		}

		if (e.getSource() == btnBorrar) {

			estadoPanel = EstadoDePanel.BAJA;

			String cliSelect = (String) listCliente.getSelectedValue();
			String[] partes = cliSelect.split("\\|");
			String dniToSearch = (partes[2]).trim().replace(" ", "");

			cli = clienteController.mostrarClientePorDni(dniToSearch);
			// Agregar pantalla emergente que solicite confirmacion

			BorrarCliente(cli);
			Menu_view.RecargarPanelCambiante(this);
		}

		if (e.getSource() == btnGuardar) {

			if (estadoPanel == EstadoDePanel.ALTA) {
				try {
					clienteController.altaCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Menu_view.RecargarPanelCambiante(this);

			}
			if (estadoPanel == EstadoDePanel.MODIFICACION) {
				String cliSelect = (String) listCliente.getSelectedValue();
				String[] partes = cliSelect.split("\\|");
				// String dniToSearch = ("'"+partes[2]+"'").trim().replace(" ", "");
				String dniToSearch = (partes[2]).trim().replace(" ", "");

				cli = clienteController.mostrarClientePorDni(dniToSearch);

				// clienteController.modificarCliente();

				ModificarCliente(cli.getId(), cli);

				Menu_view.RecargarPanelCambiante(this);
			}
		}

		if (e.getSource() == btnCancelar) {
			Menu_view.RecargarPanelCambiante(this);
			estadoPanel = EstadoDePanel.NADA;
		}
	}

	public Cliente cargarCliente() {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();

		c.setNombre(textField_nombre.getText());
		c.setApellido(textField_apellido.getText());
		c.setDni(textField_DNI.getText());
		c.setCuit(textField_cuit.getText());
		// String fechaNac = sdf.format(dateChooser_fechaNac.getDateFormatString());
		// c.setFechaNac(LocalDate.parse(fechaNac,dtf));

		LocalDate d = LocalDate.now();
		c.setFechaNac(d);

		c.setEmail(textField_email.getText());

		return c;
	}

	public Pasaporte cargarPasaporte() {
		// TODO Auto-generated method stub
		Pasaporte pas = new Pasaporte();

		pas.setNumeroPasaporte(textField_nroPasaporte.getText());
		Pais p = new Pais(1, "Argentina");
		pas.setPais(p);
		LocalDate d = LocalDate.now();
		// String fechaVen = sdf.format(dateChooser_fechaVencimiento.getDate());
		// pas.setFechaVencimiento(LocalDate.parse(fechaVen,dtf));
		pas.setFechaVencimiento(d);

		// String fechaEmi = sdf.format(dateChooser_fechaEmision.getDate());
		// pas.setFechaEmision(LocalDate.parse(fechaEmi,dtf));
		pas.setFechaEmision(d);
		pas.setAutoridadEmision(textField_autEmision.getText());
		// pendiente lista paises

		return pas;
	}

	public Telefono cargarTelefono() {
		// TODO Auto-generated method stub
		Telefono t = new Telefono();

		t.setNumPersonal(textField_nroPersonal.getText());
		t.setNumCelular(textField_nroCelular.getText());
		t.setNumLaboral(textField_nroLaboral.getText());

		return t;
	}

	public DireccionCompleta cargarDirCompleta() {
		// TODO Auto-generated method stub
		DireccionCompleta dir = new DireccionCompleta();

		Pais p = new Pais(1, "Argentina");
		Provincia prov = new Provincia(1, "Buenos");

		dir.setCalle(textField_calle.getText());
		dir.setAltura(textField_altura.getText());
		dir.setCiudad(textField_ciudad.getText());
		dir.setCodigoPostal(textField_CP.getText());
		// pendiente lista provincia
		dir.setPais(p);
		// pendiente lista paises
		dir.setProvincia(prov);
		return dir;
	}

	public PasajeroFrecuente cargarPasFrecuente() {
		// TODO Auto-generated method stub
		PasajeroFrecuente pas = new PasajeroFrecuente();

		Aerolinea aerolinea = new Aerolinea(1, "United Airlines", Alianza.StarAlliance);

		pas.setAlianza(Alianza.StarAlliance);
		pas.setAerolinea(aerolinea);
		pas.setNumeroPF(textField_numeroPasaFrec.getText());
		// Setear la alianza
		// Setear la aerolinea
		pas.setCategoria(textField_categoria.getText());

		return pas;
	}

	private void MostrarCliente(Cliente c) {
/*		LocalDate d = LocalDate.now();
		DireccionCompleta dirAux = new DireccionCompleta();
		Telefono telAux = new Telefono();
		Pasaporte pasAux = new Pasaporte();
		PasajeroFrecuente pasFreAux = new PasajeroFrecuente();

		textField_nombre.setText(c.getNombre());
		textField_apellido.setText(c.getApellido());
		textField_DNI.setText(c.getDni());
		textField_cuit.setText(c.getCuit());
		// dateChooser_fechaNac.setDate(Date.valueOf(c.getFechaNac()));
		dateChooser_fechaNac.setDate(Date.valueOf(d));
		textField_email.setText(c.getEmail());

		dirAux = clienteController.mostrarDirCompleta(c.getDireccionCompleta().getId());

		textField_calle.setText(dirAux.getCalle());
		textField_altura.setText(dirAux.getAltura());
		textField_ciudad.setText(dirAux.getCiudad());
		textField_CP.setText(dirAux.getCodigoPostal());

		telAux = clienteController.mostrarTelefono(c.getTelefono().getId());

		textField_nroPersonal.setText(telAux.getNumPersonal());
		textField_nroCelular.setText(telAux.getNumCelular());
		textField_nroLaboral.setText(telAux.getNumLaboral());

		pasAux = clienteController.mostrarPasaporte(c.getPasaporte().getId());

		textField_nroPasaporte.setText(pasAux.getNumeroPasaporte());
		// dateChooser_fechaVencimiento.setDate(Date.valueOf(c.getPasaporte().getFechaVencimiento()));
		// dateChooser_fechaEmision.setDate(Date.valueOf(c.getPasaporte().getFechaEmision()));
		dateChooser_fechaVencimiento.setDate(Date.valueOf(d));
		dateChooser_fechaEmision.setDate(Date.valueOf(d));
		// textField_Pas_pais.setText(pasAux.getPais().getNombre());
		System.out.println(pasAux.getPais().getId());
		textField_Pas_pais.setText("Argentina");
		textField_autEmision.setText(pasAux.getAutoridadEmision());

		pasFreAux = clienteController.mostrasPasFre(c.getPasajeroFrecuente().getId());

		textField_numeroPasaFrec.setText(pasFreAux.getNumeroPF());
		textField_categoria.setText(pasFreAux.getCategoria());
		textField_alianza.setText(pasFreAux.getAlianza().toString());
	*/	 
	}

	private void BorrarCliente(Cliente cli) {
		clienteController.bajaCliente(cli);
	}

	private void ModificarCliente(int cliID, Cliente cliObj) {
		try {
			clienteController.modificarCliente(cliID, cliObj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getter & Setters

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

	public JTextField getTextField_alianza() {
		return textField_alianza;
	}

	public void setTextField_alianza(JTextField textField_alianza) {
		this.textField_alianza = textField_alianza;
	}

	public JTextField getTextField_Pas_pais() {
		return textField_Pas_pais;
	}

	public void setTextField_Pas_pais(JTextField textField_Pas_pais) {
		this.textField_Pas_pais = textField_Pas_pais;
	}

	public JTextField getTextField_categoria() {
		return textField_categoria;
	}

	public void setTextField_categoria(JTextField textField_categoria) {
		this.textField_categoria = textField_categoria;
	}

	public JButton getBtnAlta() {
		return btnAlta;
	}

	public void setBtnAlta(JButton btnAlta) {
		this.btnAlta = btnAlta;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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

	public JList<String> getListCliente() {
		return listCliente;
	}

	public void setListCliente(JList<String> listCliente) {
		this.listCliente = listCliente;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public ClienteController_GUI getClienteController() {
		return clienteController;
	}

	public void setClienteController(ClienteController_GUI clienteController) {
		this.clienteController = clienteController;
	}

	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<String> modelo) {
		this.modelo = modelo;
	}

	public JTextField getTextField_autEmision() {
		return textField_autEmision;
	}

	public void setTextField_autEmision(JTextField textField_autEmision) {
		this.textField_autEmision = textField_autEmision;
	}

}
