package edu.usal.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import edu.usal.controllers.GUI.VentasController_GUI;
import edu.usal.events.ClienteEvents;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import util.BuildTableModel;
import util.CeldaRenderer;

public class VentasView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private static final long serialVersionUID = 1L;

	private TableModel model;

	private JScrollPane scrollPaneVentas;
	
	private VentasController_GUI ventaController = new VentasController_GUI();
	
	private JTable table;
	private JButton btnAlta;
	private JButton btnModificar;
	private JButton btnBorrar;
	
	public VentasView() {
		// Instanciazion de objetos controllers
		
				SpringLayout springLayout = new SpringLayout();
				setLayout(springLayout);

				JLabel lblVentas = new JLabel("Ventas");
				lblVentas.setFont(new Font("Lucida Sans", Font.BOLD, 40));
				springLayout.putConstraint(SpringLayout.NORTH, lblVentas, 10, SpringLayout.NORTH, this);
				springLayout.putConstraint(SpringLayout.WEST, lblVentas, 10, SpringLayout.WEST, this);
				add(lblVentas);

				scrollPaneVentas = new JScrollPane();
				springLayout.putConstraint(SpringLayout.WEST, scrollPaneVentas, 10, SpringLayout.WEST, this);
				springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneVentas, -101, SpringLayout.SOUTH, this);
				springLayout.putConstraint(SpringLayout.EAST, scrollPaneVentas, -23, SpringLayout.EAST, this);
				scrollPaneVentas.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				scrollPaneVentas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPaneVentas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPaneVentas.setToolTipText("");
				springLayout.putConstraint(SpringLayout.NORTH, scrollPaneVentas, 6, SpringLayout.SOUTH, lblVentas);
				add(scrollPaneVentas);
				
				// Declaramos datos de tabla y el header
				ArrayList<Object[]> data = new ArrayList<>();
				
				ArrayList<Venta> datosCargar = (ArrayList<Venta>) ventaController.mostrarTodo();
				
				for (int i = 0; i < datosCargar.size(); i++) {
					data.add(new Object[] {
						datosCargar.get(i).getId(),
						datosCargar.get(i).getCliente().getId(),
						datosCargar.get(i).getVuelo().getId(),
						datosCargar.get(i).getAerolinea().getId(),
						datosCargar.get(i).getFormaPago(),
						datosCargar.get(i).getFechaHoraVenta(),
					});
				}	
				
				String[] header = {"Venta ID", "Cliente ID", "Vuelo ID", "Aerolinea ID", "Forma de pago", "Fecha de venta"};
				
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
			    
				scrollPaneVentas.setViewportView(table);
				
				JPanel panel = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panel, 18, SpringLayout.SOUTH, scrollPaneVentas);
				springLayout.putConstraint(SpringLayout.WEST, panel, -422, SpringLayout.EAST, this);
				springLayout.putConstraint(SpringLayout.SOUTH, panel, 66, SpringLayout.SOUTH, scrollPaneVentas);
				springLayout.putConstraint(SpringLayout.EAST, panel, -37, SpringLayout.EAST, this);
				add(panel);
				panel.setLayout(new GridLayout(0, 3, 0, 0));
				
				btnAlta = new JButton("Nueva Venta");
				panel.add(btnAlta);
				
				btnModificar = new JButton("Modificar");
				btnModificar.setName("m");
				panel.add(btnModificar);
				
				btnBorrar = new JButton("Eliminar");
				btnBorrar.setName("e");
				panel.add(btnBorrar);
				
				
	}
}
