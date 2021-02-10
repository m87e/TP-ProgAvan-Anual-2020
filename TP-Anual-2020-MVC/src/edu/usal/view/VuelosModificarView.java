package edu.usal.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.VueloModificarController_GUI;
import edu.usal.events.VueloModificarEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class VuelosModificarView extends JFrame {

	private VueloModificarController_GUI vueloModificarController = new VueloModificarController_GUI(this);
	private JTextField textID;
	private JTextField textField_1;
	private JTextField textCantidadAsientos;
	
	private JComboBox comboBox_aeropuertosSalida,comboBox_aeropuertosLlegada,comboBox_aerolinea;
	private JButton btnCancel, btnSubmit;
	private JDateChooser dateChooser_fechaHoraSalida , dateChooser_fechaHoraLlegada;
	private JLabel lblTiempoVueloCalculado;

	public VuelosModificarView(Vuelo vuelo) {

		setTitle("Modifcar Vuelo");
		getContentPane().setLayout(null);

		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloModificarController.mostrarAeropuertos();
		for (int i = 0; i < listAeropuertos.size(); i++) {
			comboBox_aeropuertosSalida.addItem(listAeropuertos.get(i).getCodigo());
		}
		for (int i = 0; i < listAeropuertos.size(); i++) {
			comboBox_aeropuertosLlegada.addItem(listAeropuertos.get(i).getCodigo());
		}

		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloModificarController.mostrarAerolinea();
		for (int i = 0; i < listAerolinea.size(); i++) {
			comboBox_aerolinea.addItem(listAerolinea.get(i).getNombre());
		}

		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate_fechaHoraSalida = vuelo.getFechaHoraSalida();
		Date date_fechaHoraSalida = Date.from(localDate_fechaHoraSalida.atStartOfDay(defaultZoneId).toInstant());

		LocalDate localDate_fechaHoraLlegada = vuelo.getFechaHoraLlegada();
		Date date_fechaHoraLlegada = Date.from(localDate_fechaHoraLlegada.atStartOfDay(defaultZoneId).toInstant());
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 24, 460, 321);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl_id = new JLabel("ID");
		panel.add(lbl_id);
		
		textID = new JTextField();
		textID.setText("0");
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setColumns(10);
		panel.add(textID);
		
		JLabel lblNumVuelo = new JLabel("Numero Vuelo");
		panel.add(lblNumVuelo);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblCantidadAsientos = new JLabel("Cantidad Asientos");
		panel.add(lblCantidadAsientos);
		
		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setText("null");
		textCantidadAsientos.setColumns(10);
		panel.add(textCantidadAsientos);
		
		JLabel lblAeropuertoSalida = new JLabel("Aeropuerto salida");
		panel.add(lblAeropuertoSalida);
		
		comboBox_aeropuertosSalida = new JComboBox();
		panel.add(comboBox_aeropuertosSalida);
		
		JLabel lblAeropuertoLlegada = new JLabel("Aeropuerto Llegada");
		panel.add(lblAeropuertoLlegada);
		
		comboBox_aeropuertosLlegada = new JComboBox();
		panel.add(comboBox_aeropuertosLlegada);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		panel.add(lblAerolinea);
		
		comboBox_aerolinea = new JComboBox();
		panel.add(comboBox_aerolinea);
		
		JLabel lblFechaHoraSalida = new JLabel("Fecha/Hora Salida");
		panel.add(lblFechaHoraSalida);
		
		dateChooser_fechaHoraSalida = new JDateChooser();
		panel.add(dateChooser_fechaHoraSalida);
		
		JLabel lblFechaHoraLlegada = new JLabel("Fecha/Hora Llegada");
		panel.add(lblFechaHoraLlegada);
		
		dateChooser_fechaHoraLlegada = new JDateChooser();
		panel.add(dateChooser_fechaHoraLlegada);
		
		JLabel lblTiempoVuelo = new JLabel("Tiempo de vuelo");
		panel.add(lblTiempoVuelo);
		
		lblTiempoVueloCalculado = new JLabel();
		panel.add(lblTiempoVueloCalculado);
		
		JPanel panel_btns = new JPanel();
		panel_btns.setBounds(146, 361, 346, 51);
		getContentPane().add(panel_btns);
		panel_btns.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnCancel = new JButton("Cancel");
		panel_btns.add(btnCancel);
		
		btnSubmit = new JButton("Submit");
		panel_btns.add(btnSubmit);
	
	}

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

	// Getter & setters

	public JTextField getTextCantidadAsientos() {
		return textCantidadAsientos;
	}

	public void setTextCantidadAsientos(JTextField textCantidadAsientos) {
		this.textCantidadAsientos = textCantidadAsientos;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
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
	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JLabel getLblTiempoVueloCalculado() {
		return lblTiempoVueloCalculado;
	}

	public void setLblTiempoVueloCalculado(JLabel lblTiempoVueloCalculado) {
		this.lblTiempoVueloCalculado = lblTiempoVueloCalculado;
	}
	
	
}
