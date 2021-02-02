package edu.usal.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.util.ArrayList;
import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.events.ClienteEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import util.BuildTableModel;
import util.CeldaRenderer;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
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

	private TableModel model;

	private JScrollPane scrollPaneDatosPersonales;

	private ClienteController_GUI clienteController = new ClienteController_GUI(this);

	private JTable table;
	private JComboBox comboBox_provincia;
	private JComboBox comboBox_pasPais;
	private JComboBox comboBox_aerolinea;

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
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneDatosPersonales, -73, SpringLayout.SOUTH, this);
		scrollPaneDatosPersonales.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneDatosPersonales.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDatosPersonales.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDatosPersonales.setToolTipText("");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneDatosPersonales, 6, SpringLayout.SOUTH, lblClientes);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneDatosPersonales, 0, SpringLayout.WEST, lblClientes);
		add(scrollPaneDatosPersonales);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneDatosPersonales, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 519, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 351, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -23, SpringLayout.EAST, this);
		
		// Declaramos datos de tabla y el header
		ArrayList<Object[]> data = new ArrayList<>();
		
		ArrayList<Cliente> datosCargar = (ArrayList<Cliente>) clienteController.mostrarTodo();
		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteController.mostrarPaises();
		ArrayList<Provincia> listProv = (ArrayList<Provincia>) clienteController.mostrarProvincias();
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) clienteController.mostrarAerolinea();
		
		for (int i = 0; i < datosCargar.size(); i++) {
			for (int j = 0; j < listPaises.size(); j++) {
				if (datosCargar.get(i).getDireccionCompleta().getPais().getId()==listPaises.get(j).getId()) {
					datosCargar.get(i).getDireccionCompleta().getPais().setNombre(listPaises.get(j).getNombre());
				}
				if (datosCargar.get(i).getPasaporte().getPais().getId()==listPaises.get(j).getId()) {
					datosCargar.get(i).getPasaporte().getPais().setNombre(listPaises.get(j).getNombre());
				}
			}
			for (int j = 0; j < listProv.size(); j++) {
				if (datosCargar.get(i).getDireccionCompleta().getProvincia().getId()==listProv.get(j).getId()) {
					datosCargar.get(i).getDireccionCompleta().getProvincia().setNombre(listProv.get(j).getNombre());
				}	
			}
			for (int j = 0; j < listAerolinea.size(); j++) {
				if (datosCargar.get(i).getPasajeroFrecuente().getAerolinea().getId()==listAerolinea.get(j).getId()) {
					datosCargar.get(i).getPasajeroFrecuente().getAerolinea().setAlianza(listAerolinea.get(j).getAlianza());
					datosCargar.get(i).getPasajeroFrecuente().getAerolinea().setNombre(listAerolinea.get(j).getNombre());
				}	
			}
		}
	
		for (int i = 0; i < datosCargar.size(); i++) {
			
			data.add(new Object[] {
					//datosCargar.get(i).getId(), 
					//DP 1 to 6
					datosCargar.get(i).getNombre(), 
					datosCargar.get(i).getApellido(), 
					datosCargar.get(i).getDni(), 
					datosCargar.get(i).getCuit(), 
					datosCargar.get(i).getFechaNac(), 
					datosCargar.get(i).getEmail(),
					//DIR 7 to 13
					//datosCargar.get(i).getDireccionCompleta().getId(),
					datosCargar.get(i).getDireccionCompleta().getCalle(),
					datosCargar.get(i).getDireccionCompleta().getAltura(),
					datosCargar.get(i).getDireccionCompleta().getCiudad(),
					datosCargar.get(i).getDireccionCompleta().getPais().getNombre(),
					datosCargar.get(i).getDireccionCompleta().getProvincia().getNombre(),
					datosCargar.get(i).getDireccionCompleta().getCodigoPostal(),
					//TEL 14 to 17
					//datosCargar.get(i).getTelefono().getId(),
					datosCargar.get(i).getTelefono().getNumPersonal(),
					datosCargar.get(i).getTelefono().getNumCelular(),
					datosCargar.get(i).getTelefono().getNumLaboral(),
					//PAS 18 to 23
					//datosCargar.get(i).getPasaporte().getId(),
					datosCargar.get(i).getPasaporte().getNumeroPasaporte(),
					datosCargar.get(i).getPasaporte().getAutoridadEmision(),
					datosCargar.get(i).getPasaporte().getFechaEmision(),
					datosCargar.get(i).getPasaporte().getFechaVencimiento(),
					datosCargar.get(i).getPasaporte().getPais().getNombre(),
					//PASFRE 24 to 28
					//datosCargar.get(i).getPasajeroFrecuente().getId(),
					datosCargar.get(i).getPasajeroFrecuente().getAlianza().Oneworld,
					datosCargar.get(i).getPasajeroFrecuente().getAerolinea().getNombre(),
					datosCargar.get(i).getPasajeroFrecuente().getNumeroPF(),
					datosCargar.get(i).getPasajeroFrecuente().getCategoria(),
			});
		System.out.println(datosCargar.get(i).getDireccionCompleta().getPais().getNombre());
		}
		
		String[] header = {
				  "Nombre", "Apellido", "DNI", "CUIT", "Fecha de nacimiento", "e-mail",
				  "Calle", "Altura", "Ciudad","Pais","Provincia", "C.P.",
				  "Tel. Personal","Tel. Cellular","Tel. Laboral",
				  "# Pasaporte", "Aut. Emision","Fecha emision", "Fecha vencimiento", "Pais ID pas",
				  "Alianza","Aerolinea ID","# Pasajero frecuente","Categoria",
		};
		
		//Llama a la clase para crear la jtable con AbstractModel
		model = new BuildTableModel(data, header) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};		

		//crearTablaCombo();
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	
		comboBox_pasPais = new JComboBox();
	        comboBox_pasPais.addItem("Argentina");
	        comboBox_pasPais.addItem("Bolivia");
	        comboBox_pasPais.addItem("Brasil");
	        comboBox_pasPais.addItem("Canada");
	        comboBox_pasPais.addItem("España");
	        comboBox_pasPais.addItem("Guatemala");
	        comboBox_pasPais.addItem("Mexico");
		
		table.setModel(model);
		table.setRowHeight(22);
	    table.setDefaultRenderer(Object.class, new CeldaRenderer(10));	
	    
		scrollPaneDatosPersonales.setViewportView(table);
		add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

		btnAlta = new JButton("Nuevo Cliente");
		panel.add(btnAlta);
		System.out.println("Generando nuevo cliente...");
		btnAlta.addActionListener(new ClienteEvents(this));
		System.out.println("... Procensando ...");
		panel.add(btnAlta);

		btnModificar = new JButton("Modificar");
		btnModificar.setName("m");
		panel.add(btnModificar);
		btnModificar.getMouseListeners();
	//	btnModificar.addActionListener(this);
		panel.add(btnModificar);

		btnBorrar = new JButton("Eliminar");
		btnBorrar.setName("e");
		panel.add(btnBorrar);
	//	btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
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
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
}
