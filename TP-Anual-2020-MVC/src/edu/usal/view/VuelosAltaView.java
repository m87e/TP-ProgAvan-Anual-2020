package edu.usal.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.usal.events.AerolineaAltaEvents;
import edu.usal.events.VueloAltaEvents;

import java.awt.BorderLayout;

public class VuelosAltaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNumVuelo;
	private JTextField textCantidadAsientos;

	private JLabel lblNumVuelo;
	private JLabel lblCantidadAsientos;
	private JLabel lblAeropuertoSalida;
	private JLabel lblAeropuertoLlegada;
	private JLabel lblAerolinea;

	private JButton btnCancel;
	private JButton btnSubmit;

	private JComboBox comboBox_aeropuertosSalida;
	private JComboBox comboBox_aeropuertosLlegada;
	private JComboBox comboBox_aerolinea;

	public VuelosAltaView() {
		setTitle("Agregar vuelo");
		getContentPane().setLayout(null);

		lblNumVuelo = new JLabel("Numero Vuelo");
		lblNumVuelo.setBounds(46, 26, 106, 22);
		getContentPane().add(lblNumVuelo);

		textNumVuelo = new JTextField();
		textNumVuelo.setBounds(164, 27, 206, 20);
		getContentPane().add(textNumVuelo);
		textNumVuelo.setColumns(10);

		lblCantidadAsientos = new JLabel("Cantidad Asientos");
		lblCantidadAsientos.setBounds(46, 63, 106, 22);
		getContentPane().add(lblCantidadAsientos);

		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setBounds(163, 63, 206, 20);
		getContentPane().add(textCantidadAsientos);
		textCantidadAsientos.setColumns(10);

		lblAeropuertoSalida = new JLabel("Aeropuerto salida");
		lblAeropuertoSalida.setBounds(46, 101, 105, 14);
		getContentPane().add(lblAeropuertoSalida);

		comboBox_aeropuertosSalida = new JComboBox();
		comboBox_aeropuertosSalida.setBounds(164, 99, 206, 21);
		getContentPane().add(comboBox_aeropuertosSalida);
		comboBox_aeropuertosSalida.addItem("San Pablo");
		comboBox_aeropuertosSalida.addItem("Ezeiza");
		comboBox_aeropuertosSalida.addItem("Houston");

		lblAeropuertoLlegada = new JLabel("Aeropuerto Llegada");
		lblAeropuertoLlegada.setBounds(46, 127, 105, 14);
		getContentPane().add(lblAeropuertoLlegada);

		comboBox_aeropuertosLlegada = new JComboBox();
		comboBox_aeropuertosLlegada.setBounds(164, 125, 206, 21);
		getContentPane().add(comboBox_aeropuertosLlegada);
		comboBox_aeropuertosLlegada.addItem("San Pablo");
		comboBox_aeropuertosLlegada.addItem("Ezeiza");
		comboBox_aeropuertosLlegada.addItem("Houston");

		lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(46, 153, 72, 14);
		getContentPane().add(lblAerolinea);

		comboBox_aerolinea = new JComboBox();
		comboBox_aerolinea.setBounds(164, 151, 206, 21);
		getContentPane().add(comboBox_aerolinea);
		comboBox_aerolinea.addItem("LATAM");
		comboBox_aerolinea.addItem("United");
		comboBox_aerolinea.addItem("American Airlines");

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(46, 224, 140, 23);
		getContentPane().add(btnCancel);
		getBtnCancel().addActionListener(new VueloAltaEvents(this));

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(193, 224, 189, 23);
		getContentPane().add(btnSubmit);
		getBtnSubmit().addActionListener(new VueloAltaEvents(this));
	}
	// Getter & setters

	public JTextField getTextNumVuelo() {
		return textNumVuelo;
	}

	public void setTextNumVuelo(JTextField textNumVuelo) {
		this.textNumVuelo = textNumVuelo;
	}

	public JTextField getTextCantidadAsientos() {
		return textCantidadAsientos;
	}

	public void setTextCantidadAsientos(JTextField textCantidadAsientos) {
		this.textCantidadAsientos = textCantidadAsientos;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JComboBox getComboBoxAeropuertoSalida() {
		return comboBox_aeropuertosSalida;
	}

	public void setComboBoxAeropuertoSalida(JComboBox comboBox) {
		this.comboBox_aeropuertosSalida = comboBox;
	}

	public JComboBox getComboBoxAeropuertoLlegada() {
		return comboBox_aeropuertosLlegada;
	}

	public void setComboBoxAeropuertoLlegada(JComboBox comboBox) {
		this.comboBox_aeropuertosLlegada = comboBox;
	}

	public JComboBox getComboBoxAerolinea() {
		return comboBox_aerolinea;
	}

	public void setComboBoxAerolinea(JComboBox comboBox) {
		this.comboBox_aerolinea = comboBox;
	}
}
