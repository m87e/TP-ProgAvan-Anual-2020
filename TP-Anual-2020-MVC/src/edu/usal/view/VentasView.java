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
import edu.usal.events.VentaEvents;
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
				setLayout(null);

				JLabel lblVentas = new JLabel("Ventas");
				lblVentas.setBounds(10, 10, 140, 48);
				lblVentas.setFont(new Font("Lucida Sans", Font.BOLD, 40));
				add(lblVentas);

				scrollPaneVentas = new JScrollPane();
				scrollPaneVentas.setBounds(10, 64, 741, 348);
				scrollPaneVentas.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				scrollPaneVentas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPaneVentas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPaneVentas.setToolTipText("");
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
				panel.setBounds(366, 423, 385, 48);
				add(panel);
				panel.setLayout(new GridLayout(0, 3, 0, 0));
				
				btnAlta = new JButton("Nueva Venta");
				panel.add(btnAlta);
				btnAlta.addActionListener(new VentaEvents(this));
				
				btnModificar = new JButton("Modificar");
				btnModificar.setName("m");
				panel.add(btnModificar);
				btnModificar.addActionListener(new VentaEvents(this));
				
				btnBorrar = new JButton("Eliminar");
				btnBorrar.setName("e");
				panel.add(btnBorrar);
				btnBorrar.addActionListener(new VentaEvents(this));
				
				
				
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

	public JScrollPane getScrollPaneVentas() {
		return scrollPaneVentas;
	}

	public void setScrollPaneVentas(JScrollPane scrollPaneVentas) {
		this.scrollPaneVentas = scrollPaneVentas;
	}

	public VentasController_GUI getVentaController() {
		return ventaController;
	}

	public void setVentaController(VentasController_GUI ventaController) {
		this.ventaController = ventaController;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
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
	
	
}
