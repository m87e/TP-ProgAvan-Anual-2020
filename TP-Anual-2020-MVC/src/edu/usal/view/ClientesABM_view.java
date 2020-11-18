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

public class ClientesABM_view extends JPanel implements ActionListener{
	
	
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
	private JTextField textField_paisEmision;
	private JTextField textField_categoria;
	
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private static EstadoDePanel estadoPanel = EstadoDePanel.NADA;
	
	private JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento , dateChooser_fechaEmision;
	
	private JList<String> listCliente;
	
	private JScrollPane scrollPane;
	
	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	private ClienteController_GUI clienteController = new ClienteController_GUI(this);
	
	private DefaultListModel<String> modelo;
	
	public ClientesABM_view() {
		
		//Instanciazion de objetos controllers
		//ClienteController_GUI	clienteController;
		
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
		
		JLabel varDPnombre = new JLabel("Nombre");
		panel_2.add(varDPnombre);
		
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
		panel_5.setLayout(new GridLayout(4, 2, 0, 0));
		
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
		
		JLabel varPpaisEmision = new JLabel("Pa\u00EDs emisi\u00F3n");
		panel_5.add(varPpaisEmision);
		
		textField_paisEmision = new JTextField();
		panel_5.add(textField_paisEmision);
		textField_paisEmision.setColumns(10);
		
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
		/*	listCliente.setModel(new AbstractListModel() {
			String[] values = new String[] {"item1", "item2", "item3", "item4", "item5", "item6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
				
			initComponents();
			listCliente.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	//	modelo.addElement("HOLA MUNDO");
		
		ArrayList<Cliente> listaAux = (ArrayList<Cliente>) clienteController.mostrarTodo();
		
		for (int i = 0; i < listaAux.size(); i++) {
			modelo.addElement(listaAux.get(i).getNombre()+" | "+
							  listaAux.get(i).getApellido()+" | "+
							  listaAux.get(i).getDni()+" | "+
							  listaAux.get(i).getEmail()
							  );
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
		
		if(e.getSource()== btnAlta) {
			System.out.println("seteando alta...");
			btnModificar.setEnabled(false);
			btnBorrar.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnCancelar.setEnabled(true);
			System.out.println("botones deshabilitados..");
			//cli = new Cliente();
			//clienteController.altaCliente();
			
			estadoPanel = EstadoDePanel.ALTA;
			//Menu_view.RecargarPanelCambiante(this);
		}
		
		if(e.getSource()== btnModificar) {
			System.out.println("Seteando update...");
			estadoPanel = EstadoDePanel.MODIFICACION;
			
			btnAlta.setEnabled(false);
			btnBorrar.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnCancelar.setEnabled(true);
			
			String cliSelect = (String) listCliente.getSelectedValue();
			String[] partes = cliSelect.split("\\|");
			//String dniToSearch = ("'"+partes[2]+"'").trim().replace(" ", "");
			String dniToSearch = (partes[2]).trim().replace(" ", "");
			
			cli = clienteController.mostrarClientePorDni(dniToSearch);
			
			MostrarCliente(cli);
		
		}

		if(e.getSource()== btnBorrar) {
		
		}
		
		if(e.getSource()== btnGuardar) {
			
			/*if(estadoPanel == EstadoDePanel.ALTA) {
			
				System.out.println("iniciando carga");
				cargarCliente();
				cargarDirCompleta();
				cargarPasaporte();
				cargarPasFrecuente();
				cargarTelefono();
				System.out.println("guardar");
				try {
					System.out.println("procesando alta...");
					clienteController.altaCliente();
					System.out.println("alta realizada!");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Menu_view.RecargarPanelCambiante(this);

			}*/
			if(estadoPanel == EstadoDePanel.ALTA) {
				try {
					clienteController.altaCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Menu_view.RecargarPanelCambiante(this);
				
				}		
			if(estadoPanel == EstadoDePanel.MODIFICACION) {
				String a = (String) listCliente.getSelectedValue();
				clienteController.mostrarClientePorDni(a);
				
			}
			}
		
		if(e.getSource()== btnCancelar){
			Menu_view.RecargarPanelCambiante(this);
			estadoPanel = EstadoDePanel.NADA;
		}
	}
	
	private void SaveCliente(Cliente cli) {
		//Datos personales
		cli.setNombre(textField_nombre.getText());
		cli.setApellido(textField_apellido.getText());
		cli.setDni(textField_DNI.getText());
		cli.setCuit(textField_cuit.getText());
		String fechaNac = sdf.format(dateChooser_fechaNac.getDateFormatString());
		cli.setFechaNac(LocalDate.parse(fechaNac,dtf));
		cli.setEmail(textField_email.getText());
		
		//Direccion complete
		cli.getDireccionCompleta().setCalle(textField_calle.getText());
		cli.getDireccionCompleta().setAltura(textField_altura.getText());
		cli.getDireccionCompleta().setCiudad(textField_ciudad.getText());
		cli.getDireccionCompleta().setCodigoPostal(textField_CP.getText());
		//pendiente lista provincia
		//pendiente lista paises
		
		//Telefono
		cli.getTelefono().setNumPersonal(textField_nroPersonal.getText());
		cli.getTelefono().setNumCelular(textField_nroCelular.getText());
		cli.getTelefono().setNumLaboral(textField_nroLaboral.getText());
		
		//Pasaporte
		cli.getPasaporte().setNumeroPasaporte(textField_nroPasaporte.getText());
		String fechaVen = sdf.format(dateChooser_fechaVencimiento.getDate());
		cli.getPasaporte().setFechaVencimiento(LocalDate.parse(fechaVen,dtf));
		String fechaEmi = sdf.format(dateChooser_fechaEmision.getDate());
		cli.getPasaporte().setFechaEmision(LocalDate.parse(fechaEmi,dtf));
		//pendiente lista paises
		
		//Pasajero frecuente
		cli.getPasajeroFrecuente().setNumeroPF(textField_numeroPasaFrec.getText());
		//Setear la alianza
		//Setear la aerolinea
		cli.getPasajeroFrecuente().setCategoria(textField_categoria.getText());
		
		}
	
	public Cliente cargarCliente() {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		
		c.setNombre(textField_nombre.getText());
		c.setApellido(textField_apellido.getText());
		c.setDni(textField_DNI.getText());
		c.setCuit(textField_cuit.getText());
		//String fechaNac = sdf.format(dateChooser_fechaNac.getDateFormatString());
		//c.setFechaNac(LocalDate.parse(fechaNac,dtf));
		
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
	//	String fechaVen = sdf.format(dateChooser_fechaVencimiento.getDate());
	//	pas.setFechaVencimiento(LocalDate.parse(fechaVen,dtf));
		pas.setFechaVencimiento(d);
		
	//	String fechaEmi = sdf.format(dateChooser_fechaEmision.getDate());
	//	pas.setFechaEmision(LocalDate.parse(fechaEmi,dtf));
		pas.setFechaEmision(d);
		
		//pendiente lista paises
		
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
		//pendiente lista provincia
		dir.setPais(p);
		//pendiente lista paises
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
		//Setear la alianza
		//Setear la aerolinea
		pas.setCategoria(textField_categoria.getText());
		
		return pas;
	}
	
	private void MostrarCliente(Cliente c) {
		LocalDate d = LocalDate.now();
		DireccionCompleta dirAux = new DireccionCompleta();		
		Telefono telAux = new Telefono();
		Pasaporte pasAux = new Pasaporte();
		PasajeroFrecuente pasFreAux = new PasajeroFrecuente();
		
		textField_nombre.setText(c.getNombre());
		textField_apellido.setText(c.getApellido());
		textField_DNI.setText(c.getDni());
		textField_cuit.setText(c.getCuit());
		//dateChooser_fechaNac.setDate(Date.valueOf(c.getFechaNac()));
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
		
		pasAux = clienteController.mostrarPasaporte(c.getPasaporte().getNumeroPasaporte());
				
		textField_nroPasaporte.setText(pasAux.getNumeroPasaporte());
		//dateChooser_fechaVencimiento.setDate(Date.valueOf(c.getPasaporte().getFechaVencimiento()));
		//dateChooser_fechaEmision.setDate(Date.valueOf(c.getPasaporte().getFechaEmision()));
		dateChooser_fechaVencimiento.setDate(Date.valueOf(d));
		dateChooser_fechaEmision.setDate(Date.valueOf(d));
		textField_paisEmision.setText(pasAux.getAutoridadEmision());
		
		pasFreAux = clienteController.mostrasPasFre(c.getPasajeroFrecuente().getId());
		
		textField_numeroPasaFrec.setText(pasFreAux.getNumeroPF());
		textField_categoria.setText(pasFreAux.getCategoria());
		textField_alianza.setText(pasFreAux.getAlianza().toString());
				
	}
	
	
	
}
