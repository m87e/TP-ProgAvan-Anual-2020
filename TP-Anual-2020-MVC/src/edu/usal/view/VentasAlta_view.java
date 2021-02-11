package edu.usal.view;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.VentasAltaController_GUI;
import edu.usal.controllers.GUI.VueloAltaController_GUI;
import edu.usal.events.VentaAltaEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Vuelo;

import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class VentasAlta_view extends JFrame{
	private JTextField textField_cliente;
	
	private JLabel lblCuotas;
	private JComboBox comboBox_cuotas, comboBox_vuelo,comboBox_formaPago;
	
	private JLabel lblClienteMenor, lblVueloCompleto, lblPasaporteVencido, lblPorVencer;
	
	private JDateChooser dateChooser_fechaVenta;
	private JTextField textField_aerolinea;
	
	private JButton btnCancel, btnGuardar;
	
	private VentasAltaController_GUI ventaController = new VentasAltaController_GUI();
	
	public VentasAlta_view() {
		setTitle("Agregar Venta");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 626, 302);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha de venta");
		lblNewLabel.setBounds(0, 0, 97, 35);
		panel.add(lblNewLabel);
		
	
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(0, 47, 97, 35);
		panel.add(lblCliente);
		
		textField_cliente = new JTextField();
		textField_cliente.setBounds(107, 44, 173, 40);
		panel.add(textField_cliente);
		textField_cliente.setColumns(10);
		
		JLabel lblNewLabel_vuelo = new JLabel("Vuelo");
		lblNewLabel_vuelo.setBounds(0, 100, 97, 35);
		panel.add(lblNewLabel_vuelo);
		
		JLabel lblNewLabel_formaPago = new JLabel("Forma de pago");
		lblNewLabel_formaPago.setBounds(0, 197, 97, 35);
		panel.add(lblNewLabel_formaPago);
		
		comboBox_formaPago = new JComboBox();
		comboBox_formaPago.setModel(new DefaultComboBoxModel(new String[] {"Contado", "Tar. de Debito/Credito"}));
		comboBox_formaPago.setBounds(107, 199, 173, 35);
		panel.add(comboBox_formaPago);
		
		comboBox_formaPago.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_formaPago.getSelectedItem().equals("")) {
					lblCuotas.setVisible(false);
					comboBox_cuotas.setVisible(false);
				}
				if(comboBox_formaPago.getSelectedItem().equals("Contado")) {
					lblCuotas.setVisible(false);
					comboBox_cuotas.setVisible(false);				
				}
				if(comboBox_formaPago.getSelectedItem().equals("Tar. de Debito/Credito")) {
					lblCuotas.setVisible(true);
					comboBox_cuotas.setVisible(true);
				}
				
			}
		});
		
		JLabel lblNewLabel_aerolinea = new JLabel("Aerolinea");
		lblNewLabel_aerolinea.setBounds(0, 151, 97, 35);
		panel.add(lblNewLabel_aerolinea);
		
		lblCuotas = new JLabel("Cuotas");
		lblCuotas.setBounds(0, 251, 97, 35);
		panel.add(lblCuotas);
		lblCuotas.setVisible(false);
		
		comboBox_cuotas = new JComboBox();
		comboBox_cuotas.setModel(new DefaultComboBoxModel(new String[] {"3 o 6 (Sin interes)", "12 o 24 (10% de interes)"}));
		comboBox_cuotas.setBounds(107, 251, 173, 35);
		panel.add(comboBox_cuotas);
		comboBox_cuotas.setVisible(false);
		
		JPanel panel_mensajes = new JPanel();
		panel_mensajes.setBounds(357, 0, 259, 286);
		panel.add(panel_mensajes);
		panel_mensajes.setLayout(new GridLayout(4, 0, 0, 0));
		
		
		lblClienteMenor = new JLabel("El cliente seleccionado tiene menos de 18 a\u00F1os.");
		lblClienteMenor.setEnabled(false);
		lblClienteMenor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblClienteMenor.setForeground(Color.RED);
		panel_mensajes.add(lblClienteMenor);
		lblClienteMenor.setVisible(false);
		
		lblVueloCompleto = new JLabel("El vuelo esta completo");
		lblVueloCompleto.setEnabled(false);
		lblVueloCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVueloCompleto.setForeground(Color.RED);
		panel_mensajes.add(lblVueloCompleto);
		lblVueloCompleto.setVisible(false);
		
		lblPasaporteVencido = new JLabel("El pasaporte del cliente esta vencido.");
		lblPasaporteVencido.setEnabled(false);
		lblPasaporteVencido.setForeground(Color.RED);
		lblPasaporteVencido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_mensajes.add(lblPasaporteVencido);
		lblPasaporteVencido.setVisible(false);
		
		lblPorVencer = new JLabel("El pasaporte vence en menos de 6 meses.\r\n");
		lblPorVencer.setEnabled(false);
		lblPorVencer.setForeground(Color.RED);
		lblPorVencer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_mensajes.add(lblPorVencer);
		
		dateChooser_fechaVenta = new JDateChooser();
		dateChooser_fechaVenta.setForeground(Color.WHITE);
		dateChooser_fechaVenta.setBackground(Color.DARK_GRAY);
		dateChooser_fechaVenta.setBounds(107, 0, 173, 35);
		panel.add(dateChooser_fechaVenta);
		dateChooser_fechaVenta.setEnabled(false);
		lblPorVencer.setVisible(false);
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate_fechaActual = LocalDate.now();
		Date date_fechaActual = Date.from(localDate_fechaActual.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaVenta.setDate(date_fechaActual);
		
		
		ArrayList<Vuelo> listVuelos = (ArrayList<Vuelo>) ventaController.mostrarVuelo();
		
		comboBox_vuelo = new JComboBox();
		panel.add(comboBox_vuelo);
		comboBox_vuelo.setVisible(true);
		comboBox_vuelo.setBounds(107, 95, 173, 40);
		comboBox_vuelo.addItem("Seleccionar");
		for (int i = 0; i < listVuelos.size() ; i++) {
			comboBox_vuelo.addItem(listVuelos.get(i).getNumVuelo());
		}
		comboBox_vuelo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				//Obtengo el vuelo ID
				String numeroVuelo = comboBox_vuelo.getSelectedItem().toString();
				ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) ventaController.mostrarAerolinea();
				for (int i = 0; i < listVuelos.size(); i++) {
					if(textField_aerolinea.setText.get(i).getNombre().equals(numeroVuelo)) {
						textField_aerolinea.setText(arg0);
					}
				}
				
				
				for (int i = 0; i < listVuelos.size(); i++) {
					if(listVuelos.get(i).getId() == vueloID) {
						textField_aerolinea.setText(listVuelos.get(i).getAerolinea().getNombre());		
					}
				}
			}
		});
				
		textField_aerolinea = new JTextField();
		textField_aerolinea.setEditable(false);
		textField_aerolinea.setColumns(10);
		textField_aerolinea.setBounds(107, 148, 173, 40);
		panel.add(textField_aerolinea);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setBounds(198, 348, 337, 48);
		getContentPane().add(panel_botones);
		panel_botones.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnCancel = new JButton("Cancel");
		panel_botones.add(btnCancel);
		getBtnCancel().addActionListener(new VentaAltaEvents(this));
		
		btnGuardar =  new JButton("Submit");
		panel_botones.add(btnGuardar);
		getBtnGuardar().addActionListener(new VentaAltaEvents(this));
	}

	public JTextField getTextField_cliente() {
		return textField_cliente;
	}

	public void setTextField_cliente(JTextField textField_cliente) {
		this.textField_cliente = textField_cliente;
	}

	public JLabel getLblCuotas() {
		return lblCuotas;
	}

	public void setLblCuotas(JLabel lblCuotas) {
		this.lblCuotas = lblCuotas;
	}

	public JComboBox getComboBox_cuotas() {
		return comboBox_cuotas;
	}

	public void setComboBox_cuotas(JComboBox comboBox_cuotas) {
		this.comboBox_cuotas = comboBox_cuotas;
	}

	public JComboBox getComboBox_vuelo() {
		return comboBox_vuelo;
	}

	public void setComboBox_vuelo(JComboBox comboBox_vuelo) {
		this.comboBox_vuelo = comboBox_vuelo;
	}

	public JLabel getLblClienteMenor() {
		return lblClienteMenor;
	}

	public void setLblClienteMenor(JLabel lblClienteMenor) {
		this.lblClienteMenor = lblClienteMenor;
	}

	public JLabel getLblVueloCompleto() {
		return lblVueloCompleto;
	}

	public void setLblVueloCompleto(JLabel lblVueloCompleto) {
		this.lblVueloCompleto = lblVueloCompleto;
	}

	public JLabel getLblPasaporteVencido() {
		return lblPasaporteVencido;
	}

	public void setLblPasaporteVencido(JLabel lblPasaporteVencido) {
		this.lblPasaporteVencido = lblPasaporteVencido;
	}

	public JLabel getLblPorVencer() {
		return lblPorVencer;
	}

	public void setLblPorVencer(JLabel lblPorVencer) {
		this.lblPorVencer = lblPorVencer;
	}

	public JDateChooser getDateChooser_fechaVenta() {
		return dateChooser_fechaVenta;
	}

	public void setDateChooser_fechaVenta(JDateChooser dateChooser_fechaVenta) {
		this.dateChooser_fechaVenta = dateChooser_fechaVenta;
	}

	public JTextField getTextField_aerolinea() {
		return textField_aerolinea;
	}

	public void setTextField_aerolinea(JTextField textField_aerolinea) {
		this.textField_aerolinea = textField_aerolinea;
	}

	public VentasAltaController_GUI getVentaController() {
		return ventaController;
	}

	public void setVentaController(VentasAltaController_GUI ventaController) {
		this.ventaController = ventaController;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JComboBox getComboBox_formaPago() {
		return comboBox_formaPago;
	}

	public void setComboBox_formaPago(JComboBox comboBox_formaPago) {
		this.comboBox_formaPago = comboBox_formaPago;
	}
	
	
	
	
}
