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

public class VuelosModificarView extends JFrame {

	private JTextField textID, textNumVuelo, textCantidadAsientos;
	private JLabel lblNumVuelo, lblCantidadAsientos, lblAeropuertoSalida, lblAeropuertoLlegada, lblAerolinea,
			lblFechaHoraSalida, lblFechaHoraLlegada, lblTiempoVuelo, lblTiempoVueloCalculado;
	private JComboBox comboBox_aeropuertosSalida, comboBox_aeropuertosLlegada, comboBox_aerolinea;
	private JDateChooser dateChooser_fechaHoraSalida, dateChooser_fechaHoraLlegada;
	private JButton btnCancel, btnSubmit;

	private VueloModificarController_GUI vueloModificarController = new VueloModificarController_GUI(this);

	public VuelosModificarView(Vuelo vuelo) {

		setTitle("Modifcar Vuelo");
		getContentPane().setLayout(null);

		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(32, 11, 122, 23);
		getContentPane().add(lbl_id);

		textID = new JTextField();
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setBounds(159, 11, 86, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		textID.setText(String.valueOf((vuelo.getId())));

		lblNumVuelo = new JLabel("Numero Vuelo");
		lblNumVuelo.setBounds(46, 26, 106, 22);
		getContentPane().add(lblNumVuelo);

		textNumVuelo = new JTextField();
		textNumVuelo.setBounds(164, 27, 206, 20);
		getContentPane().add(textNumVuelo);
		textNumVuelo.setColumns(10);
		textNumVuelo.setText(vuelo.getNumVuelo());

		lblCantidadAsientos = new JLabel("Cantidad Asientos");
		lblCantidadAsientos.setBounds(46, 60, 106, 22);
		getContentPane().add(lblCantidadAsientos);

		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setBounds(164, 59, 206, 20);
		getContentPane().add(textCantidadAsientos);
		textCantidadAsientos.setColumns(10);
		textCantidadAsientos.setText(String.valueOf(vuelo.getCantAsientos()));

		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloModificarController.mostrarAeropuertos();

		lblAeropuertoSalida = new JLabel("Aeropuerto salida");
		lblAeropuertoSalida.setBounds(46, 93, 105, 14);
		getContentPane().add(lblAeropuertoSalida);

		comboBox_aeropuertosSalida = new JComboBox();
		comboBox_aeropuertosSalida.setBounds(164, 91, 206, 21);
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
		comboBox_aeropuertosLlegada.setBounds(164, 117, 206, 21);
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

		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloModificarController.mostrarAerolinea();

		lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(46, 145, 72, 14);
		getContentPane().add(lblAerolinea);

		comboBox_aerolinea = new JComboBox();
		comboBox_aerolinea.setBounds(164, 143, 206, 21);
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
		lblFechaHoraSalida.setBounds(46, 172, 72, 14);
		getContentPane().add(lblFechaHoraSalida);

		dateChooser_fechaHoraSalida = new JDateChooser();
		getContentPane().add(dateChooser_fechaHoraSalida);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate_fechaHoraSalida = vuelo.getFechaHoraSalida();
		Date date_fechaHoraSalida = Date.from(localDate_fechaHoraSalida.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaHoraSalida.setDate(date_fechaHoraSalida);

		lblFechaHoraLlegada = new JLabel("Fecha/Hora Llegada");
		lblFechaHoraLlegada.setBounds(46, 198, 72, 14);
		getContentPane().add(lblFechaHoraLlegada);

		dateChooser_fechaHoraLlegada = new JDateChooser();
		getContentPane().add(dateChooser_fechaHoraLlegada);

		LocalDate localDate_fechaHoraLlegada = vuelo.getFechaHoraLlegada();
		Date date_fechaHoraLlegada = Date.from(localDate_fechaHoraLlegada.atStartOfDay(defaultZoneId).toInstant());
		dateChooser_fechaHoraLlegada.setDate(date_fechaHoraLlegada);

		lblTiempoVuelo = new JLabel("Tiempo de vuelo");
		lblTiempoVuelo.setBounds(46, 217, 72, 14);
		getContentPane().add(lblTiempoVuelo);

		lblTiempoVueloCalculado = new JLabel();
		lblTiempoVueloCalculado.setBounds(163, 217, 72, 14);
		getContentPane().add(lblTiempoVueloCalculado);
		// Botones submit y cancel
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(0, 105, 161, 23);
		getContentPane().add(btnCancel);
		getBtnCancel().addActionListener(new VueloModificarEvents(this));

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(161, 105, 206, 23);
		getContentPane().add(btnSubmit);
		getBtnSubmit().addActionListener(new VueloModificarEvents(this));

	}

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
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
