package edu.usal.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.EventQueue;
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
import java.util.Collection;
import java.util.Vector;

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
import util.BuildTableModel;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;

public class ClientesView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;

	private static EstadoDePanel estadoPanel = EstadoDePanel.NADA;

	private JScrollPane scrollPaneDatosPersonales;

	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	private ClienteController_GUI clienteController = new ClienteController_GUI(this);

	private DefaultListModel<String> modelo;
	private JTable table;
	private JPanel panelDatosSec;
	private JPanel panelDireccion;
	private JPanel panelTelefono;
	private JPanel panelPasaporte;
	private JPanel panelPasFrecuente;
	JTextField textField_nombre;
	JTextField textField_apellido;
	JTextField textField_DNI;
	JTextField textField_cuit;
	JTextField textField_email;
	JTextField textField_calle;
	JTextField textField_altura;
	JTextField textField_ciudad;
	JTextField textField_CP;
	JTextField textField_nroPersonal;
	JTextField textField_nroCelular;
	JTextField textField_nroLaboral;
	JTextField textField_nroPasaporte;
	JTextField textField_numeroPasaFrec;
	JTextField textField_alianza;
	JTextField textField_Pas_pais;
	JTextField textField_categoria;
	JTextField textField_autEmision;
	JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento, dateChooser_fechaEmision;

	public ClientesView() {

		// Instanciazion de objetos controllers
		// ClienteController_GUI clienteController;

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, lblClientes, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblClientes, 10, SpringLayout.WEST, this);
		add(lblClientes);

		scrollPaneDatosPersonales = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneDatosPersonales, 17, SpringLayout.SOUTH, lblClientes);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneDatosPersonales, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneDatosPersonales, 728, SpringLayout.WEST, this);
		add(scrollPaneDatosPersonales);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 13, SpringLayout.EAST, scrollPaneDatosPersonales);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneDatosPersonales, 38, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 75, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -268, SpringLayout.SOUTH, this);
		
		ArrayList<Object[]> data = new ArrayList<>();
		
		ArrayList<Cliente> datosCargar = (ArrayList<Cliente>) clienteController.mostrarTodo();
		
		
		for (int i = 0; i < datosCargar.size(); i++) {
			System.out.println(datosCargar.get(i).getApellido());
			data.add(new Object[] {datosCargar.get(i).getId(), 
					datosCargar.get(i).getNombre(), 
					datosCargar.get(i).getApellido(), 
					datosCargar.get(i).getDni(), 
					datosCargar.get(i).getCuit(), 
					datosCargar.get(i).getFechaNac(), 
					datosCargar.get(i).getEmail(),
					datosCargar.get(i).getDireccionCompleta().getId(),
					datosCargar.get(i).getTelefono().getId(),
					datosCargar.get(i).getPasaporte().getId(),
					datosCargar.get(i).getPasajeroFrecuente().getId()});
		}
		
		String[] header1 = {"id",
				  "Nombre", 
				  "Apellido", 
				  "DNI", 
				  "CUIT", 
				  "Fecha de nacimiento", 
				  "e-mail",
				  /*"Direccion", 
				  "Telefono", 
				  "Pasaporte",
				  "Pasajero Frecuente"*/};
		
		TableModel model = new BuildTableModel(data, header1);		
		
		
		table = new JTable(model);
		scrollPaneDatosPersonales.setViewportView(table);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));

		btnAlta = new JButton("Alta");
		panel.add(btnAlta);
	//	btnAlta.addActionListener(this);
		panel.add(btnAlta);

		btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
	//	btnModificar.addActionListener(this);
		panel.add(btnModificar);

		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
	//	btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		panelDatosSec = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelDatosSec, 19, SpringLayout.SOUTH, scrollPaneDatosPersonales);
		springLayout.putConstraint(SpringLayout.WEST, panelDatosSec, 0, SpringLayout.WEST, scrollPaneDatosPersonales);
		springLayout.putConstraint(SpringLayout.SOUTH, panelDatosSec, -22, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panelDatosSec, 0, SpringLayout.EAST, panel);
		add(panelDatosSec);
		panelDatosSec.setLayout(new GridLayout(0, 4, 0, 0));
		
		// Definicion layout de paneles secundarios
		panelDireccion = new JPanel();
		panelDatosSec.add(panelDireccion);
		panelDireccion.setLayout(new GridLayout(7, 2, 0, 0));
				
		panelTelefono = new JPanel();
		panelDatosSec.add(panelTelefono);
		panelTelefono.setLayout(new GridLayout(4, 2, 0, 0));
		
		panelPasaporte = new JPanel();
		panelDatosSec.add(panelPasaporte);
		panelPasaporte.setLayout(new GridLayout(6, 2, 0, 0));
		
		panelPasFrecuente = new JPanel();
		panelDatosSec.add(panelPasFrecuente);
		panelPasFrecuente.setLayout(new GridLayout(4, 2, 0, 0));
		
		//Panel Direccion
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelDireccion.add(lblDireccion);
				
		JLabel dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelDireccion.add(dosPuntos);

				
		JLabel varDcalle = new JLabel("Calle");
		panelDireccion.add(varDcalle);

		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		panelDireccion.add(textField_calle);

		JLabel varDaltura = new JLabel("Altura");
		panelDireccion.add(varDaltura);

		textField_altura = new JTextField();
		textField_altura.setColumns(10);
		panelDireccion.add(textField_altura);

		JLabel varDciudad = new JLabel("Ciudad");
		panelDireccion.add(varDciudad);

		textField_ciudad = new JTextField();
		textField_ciudad.setColumns(10);
		panelDireccion.add(textField_ciudad);

		JLabel varDcp = new JLabel("C.P.");
		panelDireccion.add(varDcp);

		textField_CP = new JTextField();
		textField_CP.setColumns(10);
		panelDireccion.add(textField_CP);

		JLabel varDpais = new JLabel("Pais");
		panelDireccion.add(varDpais);

		JList list_pais = new JList();
		panelDireccion.add(list_pais);

		JLabel varDprovincia = new JLabel("Provincia");
		panelDireccion.add(varDprovincia);

		JList list_provincia = new JList();
		panelDireccion.add(list_provincia);
				
		//Panel Telefono
				
		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelTelefono.add(lblTelefonos);

		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelTelefono.add(dosPuntos);

		JLabel varTpersonal = new JLabel("Nro. Personal");
		panelTelefono.add(varTpersonal);

		textField_nroPersonal = new JTextField();
		textField_nroPersonal.setColumns(10);
		panelTelefono.add(textField_nroPersonal);

		JLabel varTcelular = new JLabel("Nro. Celular");
		panelTelefono.add(varTcelular);

		textField_nroCelular = new JTextField();
		textField_nroCelular.setColumns(10);
		panelTelefono.add(textField_nroCelular);

		JLabel varTlaboral = new JLabel("Nro. Laboral");
		panelTelefono.add(varTlaboral);

		textField_nroLaboral = new JTextField();
		textField_nroLaboral.setColumns(10);
		panelTelefono.add(textField_nroLaboral);
				
		//Panel Pasaporte
				
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelPasaporte.add(lblPasaporte);
				
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelPasaporte.add(dosPuntos);

		JLabel varPnroPasaporte = new JLabel("Nro. Pasaporte");
		panelPasaporte.add(varPnroPasaporte);

		textField_nroPasaporte = new JTextField();
		textField_nroPasaporte.setColumns(10);
		panelPasaporte.add(textField_nroPasaporte);

		JLabel varPfechaVecimiento = new JLabel("Fecha vecimiento");
		panelPasaporte.add(varPfechaVecimiento);

		dateChooser_fechaVencimiento = new JDateChooser();
		panelPasaporte.add(dateChooser_fechaVencimiento);

		JLabel varPfechaEmision = new JLabel("Fecha de emision");
		panelPasaporte.add(varPfechaEmision);

		dateChooser_fechaEmision = new JDateChooser();
		panelPasaporte.add(dateChooser_fechaEmision);

		JLabel varPpais = new JLabel("Pais");
		panelPasaporte.add(varPpais);

		textField_Pas_pais = new JTextField();
		panelPasaporte.add(textField_Pas_pais);
		textField_Pas_pais.setColumns(10);

		JLabel varPautEmision = new JLabel("Aut. Emision");
		panelPasaporte.add(varPautEmision);

		textField_autEmision = new JTextField();
		panelPasaporte.add(textField_autEmision);
		textField_autEmision.setColumns(10);
				
		//Panel pasajero Frecuente
			
		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelPasFrecuente.add(lblPasajeroFrecuente);
				
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panelPasFrecuente.add(dosPuntos);
				
		JLabel varPFnumero = new JLabel("Numero");
		panelPasFrecuente.add(varPFnumero);

		textField_numeroPasaFrec = new JTextField();
		panelPasFrecuente.add(textField_numeroPasaFrec);
		textField_numeroPasaFrec.setColumns(10);

		JLabel varPFalianza = new JLabel("Alianza");
		panelPasFrecuente.add(varPFalianza);

		textField_alianza = new JTextField();
		panelPasFrecuente.add(textField_alianza);
		textField_alianza.setColumns(10);

		JLabel varPFcategoria = new JLabel("Categoria");
		panelPasFrecuente.add(varPFcategoria);

		textField_categoria = new JTextField();
		panelPasFrecuente.add(textField_categoria);
		textField_categoria.setColumns(10);
	}
}
