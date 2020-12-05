package edu.usal.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.events.ClienteEvents;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import util.BuildTableModel;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientesView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;

	private JScrollPane scrollPaneDatosPersonales;

	private ClienteController_GUI clienteController = new ClienteController_GUI(this);

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
	private JLabel varPFAerolinea;
	private JTextField textField_aerolinea;

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
					datosCargar.get(i).getDireccionCompleta().getCalle(),
					datosCargar.get(i).getDireccionCompleta().getAltura(),
					datosCargar.get(i).getDireccionCompleta().getCiudad(),
					datosCargar.get(i).getDireccionCompleta().getCodigoPostal(),
					datosCargar.get(i).getTelefono().getId(),
					datosCargar.get(i).getTelefono().getNumPersonal(),
					datosCargar.get(i).getTelefono().getNumCelular(),
					datosCargar.get(i).getTelefono().getNumLaboral(),
					datosCargar.get(i).getPasaporte().getId(),
					datosCargar.get(i).getPasaporte().getNumeroPasaporte(),
					datosCargar.get(i).getPasaporte().getFechaVencimiento(),
					datosCargar.get(i).getPasaporte().getFechaEmision(),
					datosCargar.get(i).getPasaporte().getPais().getNombre(),
					datosCargar.get(i).getPasaporte().getAutoridadEmision(),
					datosCargar.get(i).getPasajeroFrecuente().getId(),
					datosCargar.get(i).getPasajeroFrecuente().getNumeroPF(),
					datosCargar.get(i).getPasajeroFrecuente().getAlianza().Oneworld,
					datosCargar.get(i).getPasajeroFrecuente().getCategoria(),
					datosCargar.get(i).getPasajeroFrecuente().getAerolinea().getNombre(),
					
			
			});
		}
		
		String[] header1 = {"id",
				  "Nombre", 
				  "Apellido", 
				  "DNI", 
				  "CUIT", 
				  "Fecha de nacimiento", 
				  "e-mail",
				/*  "Direccion_ID",
				  "Direccion_CALLE",
				  "Direccion_ALTURA",
				  "CIUDAD",
				  "Telefono", 
				  "Pasaporte",
				  "Pasajero Frecuente"
				*/  
				  };
		
		TableModel model = new BuildTableModel(data, header1);		
		
		
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AbstractTableModel model = (AbstractTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				textField_calle.setText((String) model.getValueAt(selectedRowIndex, 8).toString());
				textField_altura.setText((String) model.getValueAt(selectedRowIndex, 9).toString());
				textField_ciudad.setText((String) model.getValueAt(selectedRowIndex, 10).toString());
				
				textField_nroPersonal.setText((String) model.getValueAt(selectedRowIndex, 12).toString());
				textField_nroCelular.setText((String) model.getValueAt(selectedRowIndex, 13).toString());
				textField_nroLaboral.setText((String) model.getValueAt(selectedRowIndex, 14).toString());
				
				textField_nroPasaporte.setText((String) model.getValueAt(selectedRowIndex, 16).toString());
				//Fecha vencimiento
				//Fecha emision
				textField_Pas_pais.setText((String) model.getValueAt(selectedRowIndex, 19).toString());
				textField_autEmision.setText((String) model.getValueAt(selectedRowIndex, 20).toString());
				
				textField_nroPasaporte.setText((String) model.getValueAt(selectedRowIndex, 22).toString());
				textField_alianza.setText((String) model.getValueAt(selectedRowIndex, 23).toString());
				textField_categoria.setText((String) model.getValueAt(selectedRowIndex, 24).toString());
				textField_aerolinea.setText((String) model.getValueAt(selectedRowIndex, 25).toString());
			}
		});
		scrollPaneDatosPersonales.setViewportView(table);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));

		btnAlta = new JButton("Alta");
		panel.add(btnAlta);
		btnAlta.addActionListener(new ClienteEvents(this));
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
		panelPasFrecuente.setLayout(new GridLayout(5, 2, 0, 0));
		
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
		
		varPFAerolinea = new JLabel("Aerolinea");
		panelPasFrecuente.add(varPFAerolinea);
		
		textField_aerolinea = new JTextField();
		panelPasFrecuente.add(textField_aerolinea);
		textField_aerolinea.setColumns(10);
	}
	
	// Getter & setters
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

	public JScrollPane getScrollPaneDatosPersonales() {
		return scrollPaneDatosPersonales;
	}

	public void setScrollPaneDatosPersonales(JScrollPane scrollPaneDatosPersonales) {
		this.scrollPaneDatosPersonales = scrollPaneDatosPersonales;
	}

	public ClienteController_GUI getClienteController() {
		return clienteController;
	}

	public void setClienteController(ClienteController_GUI clienteController) {
		this.clienteController = clienteController;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JPanel getPanelDatosSec() {
		return panelDatosSec;
	}

	public void setPanelDatosSec(JPanel panelDatosSec) {
		this.panelDatosSec = panelDatosSec;
	}

	public JPanel getPanelDireccion() {
		return panelDireccion;
	}

	public void setPanelDireccion(JPanel panelDireccion) {
		this.panelDireccion = panelDireccion;
	}

	public JPanel getPanelTelefono() {
		return panelTelefono;
	}

	public void setPanelTelefono(JPanel panelTelefono) {
		this.panelTelefono = panelTelefono;
	}

	public JPanel getPanelPasaporte() {
		return panelPasaporte;
	}

	public void setPanelPasaporte(JPanel panelPasaporte) {
		this.panelPasaporte = panelPasaporte;
	}

	public JPanel getPanelPasFrecuente() {
		return panelPasFrecuente;
	}

	public void setPanelPasFrecuente(JPanel panelPasFrecuente) {
		this.panelPasFrecuente = panelPasFrecuente;
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

	public JLabel getVarPFAerolinea() {
		return varPFAerolinea;
	}

	public void setVarPFAerolinea(JLabel varPFAerolinea) {
		this.varPFAerolinea = varPFAerolinea;
	}

	public JTextField getTextField_aerolinea() {
		return textField_aerolinea;
	}

	public void setTextField_aerolinea(JTextField textField_aerolinea) {
		this.textField_aerolinea = textField_aerolinea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
