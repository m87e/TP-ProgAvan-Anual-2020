package edu.usal.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableModel;

import edu.usal.controllers.GUI.AerolineaController_GUI;
import edu.usal.events.AerolineaEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import util.BuildTableModel;
import util.CeldaRenderer;

public class AerolineasView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;

	private TableModel model;

	private JScrollPane scrollPaneAerolineas;

	private AerolineaController_GUI aerolineaController = new AerolineaController_GUI(this);

	private JTable table;


	public AerolineasView() {


		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblAerolinea = new JLabel("Aerolineas");
		lblAerolinea.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, lblAerolinea, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblAerolinea, 10, SpringLayout.WEST, this);
		add(lblAerolinea);

		scrollPaneAerolineas = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneAerolineas, -73, SpringLayout.SOUTH, this);
		scrollPaneAerolineas.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPaneAerolineas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAerolineas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneAerolineas.setToolTipText("");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneAerolineas, 6, SpringLayout.SOUTH, lblAerolinea);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneAerolineas, 0, SpringLayout.WEST, lblAerolinea);
		add(scrollPaneAerolineas);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneAerolineas, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 519, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 351, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -23, SpringLayout.EAST, this);
		
		// Declaramos datos de tabla y el header
		ArrayList<Object[]> data = new ArrayList<>();
		
		ArrayList<Aerolinea> datosCargar = (ArrayList<Aerolinea>) aerolineaController.MostrarTodo();
		
	
	
		for (int i = 0; i < datosCargar.size(); i++) {
			
			data.add(new Object[] {
			datosCargar.get(i).getId(),
			datosCargar.get(i).getNombre(),
			datosCargar.get(i).getAlianza(),
			});
		}
		
		String[] header = {"# Aerolinea","Nombre", "Alianza"};
		
		//Llama a la clase para crear la jtable con AbstractModel
		model = new BuildTableModel(data, header) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};		

		//crearTablaCombo();
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	
		
		table.setModel(model);
		table.setRowHeight(22);
	    table.setDefaultRenderer(Object.class, new CeldaRenderer(10));	
	    
		scrollPaneAerolineas.setViewportView(table);
		add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

		
		
		//ALTA 
		btnAlta = new JButton("Nuevo Cliente");
		panel.add(btnAlta);
		btnAlta.addActionListener(new AerolineaEvents(this));
		
		panel.add(btnAlta);

		//MODIFICAR
		btnModificar = new JButton("Modificar");
		btnModificar.setName("m");
		panel.add(btnModificar);
		btnModificar.getMouseListeners();
		//btnModificar.addActionListener(this);
		panel.add(btnModificar);

		//ELIMINAR
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setName("e");
		panel.add(btnBorrar);
		btnBorrar.addActionListener(new AerolineaEvents(this));
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
