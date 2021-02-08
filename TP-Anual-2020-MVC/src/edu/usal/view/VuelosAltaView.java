package edu.usal.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.VueloAltaController_GUI;
import edu.usal.events.AerolineaAltaEvents;
import edu.usal.events.VueloAltaEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Pais;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class VuelosAltaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNumVuelo, textCantidadAsientos;

	private JLabel lblNumVuelo, lblCantidadAsientos, lblAeropuertoSalida, lblAeropuertoLlegada, lblAerolinea,
			lblFechaHoraSalida, lblFechaHoraLlegada, lblTiempoVuelo, lblTiempoVueloCalculado;

	private JButton btnCancel, btnSubmit;

	private JComboBox comboBox_aeropuertosSalida, comboBox_aeropuertosLlegada, comboBox_aerolinea;

	private JDateChooser dateChooser_fechaHoraSalida, dateChooser_fechaHoraLlegada;
	
	private VueloAltaController_GUI vueloAltaController = new VueloAltaController_GUI(this);
	private JTextField textField_tiempoVuelo;

	public VuelosAltaView() {
		setTitle("Agregar Vuelo");
		getContentPane().setLayout(null);

		lblNumVuelo = new JLabel("Numero Vuelo");
		lblNumVuelo.setBounds(46, 26, 106, 22);
		getContentPane().add(lblNumVuelo);

		textNumVuelo = new JTextField();
		textNumVuelo.setBounds(214, 26, 206, 20);
		getContentPane().add(textNumVuelo);
		textNumVuelo.setColumns(10);

		lblCantidadAsientos = new JLabel("Cantidad Asientos");
		lblCantidadAsientos.setBounds(46, 60, 106, 22);
		getContentPane().add(lblCantidadAsientos);

		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setBounds(214, 58, 206, 20);
		getContentPane().add(textCantidadAsientos);
		textCantidadAsientos.setColumns(10);

		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloAltaController.mostrarAeropuertos();

		lblAeropuertoSalida = new JLabel("Aeropuerto salida");
		lblAeropuertoSalida.setBounds(46, 93, 105, 14);
		getContentPane().add(lblAeropuertoSalida);

		comboBox_aeropuertosSalida = new JComboBox();
		comboBox_aeropuertosSalida.setBounds(214, 90, 206, 21);
		getContentPane().add(comboBox_aeropuertosSalida);
		for (int i = 0; i < listAeropuertos.size(); i++) {
			comboBox_aeropuertosSalida.addItem(listAeropuertos.get(i).getCodigo());
		}

		comboBox_aeropuertosSalida.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String codigo = comboBox_aeropuertosSalida.getSelectedItem().toString();
			}
		});

		lblAeropuertoLlegada = new JLabel("Aeropuerto Llegada");
		lblAeropuertoLlegada.setBounds(47, 119, 105, 14);
		getContentPane().add(lblAeropuertoLlegada);

		comboBox_aeropuertosLlegada = new JComboBox();
		comboBox_aeropuertosLlegada.setBounds(214, 116, 206, 21);
		getContentPane().add(comboBox_aeropuertosLlegada);
		for (int i = 0; i < listAeropuertos.size(); i++) {
			comboBox_aeropuertosLlegada.addItem(listAeropuertos.get(i).getCodigo());
		}

		comboBox_aeropuertosLlegada.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String codigo = comboBox_aeropuertosLlegada.getSelectedItem().toString();
			}
		});

		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloAltaController.mostrarAerolinea();

		lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(46, 145, 72, 14);
		getContentPane().add(lblAerolinea);

		comboBox_aerolinea = new JComboBox();
		comboBox_aerolinea.setBounds(214, 142, 206, 21);
		getContentPane().add(comboBox_aerolinea);
		for (int i = 0; i < listAerolinea.size(); i++) {
			comboBox_aerolinea.addItem(listAerolinea.get(i).getNombre());
		}

		comboBox_aerolinea.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String aerolinea = comboBox_aerolinea.getSelectedItem().toString();
			}
		});

		lblFechaHoraSalida = new JLabel("Fecha/Hora Salida");
		lblFechaHoraSalida.setBounds(46, 172, 140, 14);
		getContentPane().add(lblFechaHoraSalida);

		
		lblTiempoVuelo = new JLabel("Tiempo de vuelo");
		lblTiempoVuelo.setBounds(46, 232, 140, 14);
		getContentPane().add(lblTiempoVuelo);

		lblTiempoVueloCalculado = new JLabel();
		lblTiempoVueloCalculado.setBounds(163, 217, 72, 14);
		getContentPane().add(lblTiempoVueloCalculado);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(46, 274, 183, 23);
		getContentPane().add(btnCancel);
		getBtnCancel().addActionListener(new VueloAltaEvents(this));

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(247, 274, 189, 23);
		getContentPane().add(btnSubmit);
		
		dateChooser_fechaHoraSalida = new JDateChooser();
		dateChooser_fechaHoraSalida.setBounds(214, 166, 206, 23);
		getContentPane().add(dateChooser_fechaHoraSalida);
		
		dateChooser_fechaHoraLlegada = new JDateChooser();
		dateChooser_fechaHoraLlegada.setBounds(214, 198, 206, 20);
		getContentPane().add(dateChooser_fechaHoraLlegada);
		
		textField_tiempoVuelo = new JTextField();
		textField_tiempoVuelo.setEditable(false);
		textField_tiempoVuelo.setBounds(214, 229, 206, 20);
		getContentPane().add(textField_tiempoVuelo);
		textField_tiempoVuelo.setColumns(10);
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

	public JDateChooser getDateChooser_fechaHoraSalida() {
		return dateChooser_fechaHoraSalida;
	}

	public void setDateChooser_fechaHoraSalida(JDateChooser dateChooser_fechaHoraSalida) {
		this.dateChooser_fechaHoraSalida = dateChooser_fechaHoraSalida;
	}

	public JDateChooser getDateChooser_fechaHoraLlegada() {
		return dateChooser_fechaHoraLlegada;
	}

	public void setDateChooser_fechaHoraLlegada(JDateChooser dateChooser_fechaHoraLlegada) {
		this.dateChooser_fechaHoraLlegada = dateChooser_fechaHoraLlegada;
	}

	public JLabel getLblTiempoVueloCalculado() {
		return lblTiempoVueloCalculado;
	}

	public void setLblTiempoVueloCalculado(JLabel lblTiempoVueloCalculado) {
		this.lblTiempoVueloCalculado = lblTiempoVueloCalculado;
	}
}
