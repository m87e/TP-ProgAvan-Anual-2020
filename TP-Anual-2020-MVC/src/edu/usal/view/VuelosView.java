package edu.usal.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.ClienteController_GUI;
import edu.usal.controllers.GUI.VueloController_GUI;
import edu.usal.events.AerolineaEvents;
import edu.usal.events.ClienteEvents;
import edu.usal.events.VueloEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import util.BuildTableModel;
import util.CeldaRenderer;

import javax.swing.JList;

public class VuelosView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;

	private TableModel model;

	private JScrollPane scrollPaneVuelos;

	private VueloController_GUI vueloController = new VueloController_GUI(this);

	private JTable table;

	public VuelosView() {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblvuelo = new JLabel("Vuelos");
		lblvuelo.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, lblvuelo, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblvuelo, 10, SpringLayout.WEST, this);
		add(lblvuelo);

		scrollPaneVuelos = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneVuelos, -73, SpringLayout.SOUTH, this);
		scrollPaneVuelos.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneVuelos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVuelos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneVuelos.setToolTipText("");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneVuelos, 6, SpringLayout.SOUTH, lblvuelo);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneVuelos, 0, SpringLayout.WEST, lblvuelo);
		add(scrollPaneVuelos);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneVuelos, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 519, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 351, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -23, SpringLayout.EAST, this);

		// Declaramos datos de tabla y el header
		ArrayList<Object[]> data = new ArrayList<>();

		ArrayList<Vuelo> datosCargar = (ArrayList<Vuelo>) vueloController.MostrarTodo();

		for (int i = 0; i < datosCargar.size(); i++) {

			data.add(new Object[] { datosCargar.get(i).getId(), datosCargar.get(i).getNumVuelo(),
					datosCargar.get(i).getCantAsientos(), datosCargar.get(i).getAerolinea().getNombre(),
					datosCargar.get(i).getAeropuertoSalida().getCodigo(),
					datosCargar.get(i).getAeropuertoLlegada().getCodigo(), datosCargar.get(i).getFechaHoraSalida(),
					datosCargar.get(i).getFechaHoraLlegada()});
		}
		

		String[] header = { "ID", "Num Vuelo", "Cantidad Asientos", "Aerolinea", "Aeropuerto Salida",
				"Aeropuerto Llegada", "Fecha/Hora Salida", "Fecha/Hora Llegada" };

		// Llama a la clase para crear la jtable con AbstractModel
		model = new BuildTableModel(data, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// crearTablaCombo();
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setModel(model);
		table.setRowHeight(22);
		table.setDefaultRenderer(Object.class, new CeldaRenderer(10));

		scrollPaneVuelos.setViewportView(table);
		add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

		// ALTA
		btnAlta = new JButton("Nuevo vuelo");
		panel.add(btnAlta);
		btnAlta.addActionListener(new VueloEvents(this));

		panel.add(btnAlta);

		// MODIFICAR
		btnModificar = new JButton("Modificar");
		btnModificar.setName("m");
		panel.add(btnModificar);
		btnModificar.getMouseListeners();
		btnModificar.addActionListener(new VueloEvents(this));
		panel.add(btnModificar);

		// ELIMINAR
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setName("e");
		panel.add(btnBorrar);
		btnBorrar.addActionListener(new VueloEvents(this));
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
