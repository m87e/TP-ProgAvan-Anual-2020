package edu.usal.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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
	private JTextField textID, textField_NumVuelo, textCantidadAsientos, textField_tiempoVuelo;

	private JComboBox comboBox_aeropuertosSalida, comboBox_aeropuertosLlegada, comboBox_aerolinea;
	private JButton btnCancel, btnSubmit;
	private JDateChooser dateChooser_fechaHoraSalida, dateChooser_fechaHoraLlegada;

	public VuelosModificarView(Vuelo vuelo) {

		setTitle("Modifcar Vuelo");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(32, 24, 460, 321);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbl_id = new JLabel("ID");
		panel.add(lbl_id);

		textID = new JTextField();
		textID.setText(String.valueOf(vuelo.getId()));
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setColumns(10);
		panel.add(textID);

		JLabel lblNumVuelo = new JLabel("Numero Vuelo");
		panel.add(lblNumVuelo);

		textField_NumVuelo = new JTextField();
		textField_NumVuelo.setText((vuelo.getNumVuelo()));
		textField_NumVuelo.setEnabled(false);
		textField_NumVuelo.setColumns(10);
		panel.add(textField_NumVuelo);

		JLabel lblCantidadAsientos = new JLabel("Cantidad Asientos");
		panel.add(lblCantidadAsientos);

		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setText(String.valueOf(vuelo.getCantAsientos()));
		textCantidadAsientos.setColumns(10);
		panel.add(textCantidadAsientos);

		JLabel lblAeropuertoSalida = new JLabel("Aeropuerto salida");
		getContentPane().add(lblAeropuertoSalida);

		comboBox_aeropuertosSalida = new JComboBox();
		getContentPane().add(comboBox_aeropuertosSalida);

		ArrayList<Aeropuerto> listAeropuertos = (ArrayList<Aeropuerto>) vueloModificarController.mostrarAeropuertos();
		for (int i = 0; i < listAeropuertos.size(); i++) {
			comboBox_aeropuertosSalida.addItem(listAeropuertos.get(i).getCodigo());
		}

		comboBox_aeropuertosSalida.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String codigo = comboBox_aeropuertosSalida.getSelectedItem().toString();
			}
		});

		JLabel lblAeropuertoLlegada = new JLabel("Aeropuerto Llegada");
		getContentPane().add(lblAeropuertoLlegada);

		comboBox_aeropuertosLlegada = new JComboBox();
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

		JLabel lblAerolinea = new JLabel("Aerolinea");
		panel.add(lblAerolinea);

		comboBox_aerolinea = new JComboBox();
		panel.add(comboBox_aerolinea);

		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) vueloModificarController.mostrarAerolinea();
		for (int i = 0; i < listAerolinea.size(); i++) {
			comboBox_aerolinea.addItem(listAerolinea.get(i).getNombre());
		}

		comboBox_aerolinea.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String aerolinea = comboBox_aerolinea.getSelectedItem().toString();
			}
		});

		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate_fechaHoraSalida = vuelo.getFechaHoraSalida();
		Date date_fechaHoraSalida = Date.from(localDate_fechaHoraSalida.atStartOfDay(defaultZoneId).toInstant());

		LocalDate localDate_fechaHoraLlegada = vuelo.getFechaHoraLlegada();
		Date date_fechaHoraLlegada = Date.from(localDate_fechaHoraLlegada.atStartOfDay(defaultZoneId).toInstant());

		JLabel lblFechaHoraSalida = new JLabel("Fecha/Hora Salida");
		panel.add(lblFechaHoraSalida);

		dateChooser_fechaHoraSalida = new JDateChooser();
		panel.add(dateChooser_fechaHoraSalida);
		dateChooser_fechaHoraSalida.setDate(date_fechaHoraSalida);

		JLabel lblFechaHoraLlegada = new JLabel("Fecha/Hora Llegada");
		panel.add(lblFechaHoraLlegada);

		dateChooser_fechaHoraLlegada = new JDateChooser();
		panel.add(dateChooser_fechaHoraLlegada);
		dateChooser_fechaHoraLlegada.setDate(date_fechaHoraLlegada);

		dateChooser_fechaHoraLlegada.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					System.out.println(e.getPropertyName() + ": " + (Date) e.getNewValue());
					// Calculo de diferencia horas
					System.out.println("###Fecha/hora salida: " + getDateChooser_fechaHoraSalida());
					System.out.println("###Fecha/hora llegada: " + getDateChooser_fechaHoraLlegada());
					String tiempoTotal = CalcularTiempoVueloTotal(getDateChooser_fechaHoraSalida(),
							getDateChooser_fechaHoraLlegada());
					textField_tiempoVuelo.setText(tiempoTotal);
				}
			}
		});
		// this.add(dateChooser_fechaHoraLlegada);

		JLabel lblTiempoVuelo = new JLabel("Tiempo de vuelo");
		panel.add(lblTiempoVuelo);

		textField_tiempoVuelo = new JTextField();
		panel.add(textField_tiempoVuelo);

		JPanel panel_btns = new JPanel();
		panel_btns.setBounds(146, 361, 346, 51);
		getContentPane().add(panel_btns);
		panel_btns.setLayout(new GridLayout(0, 2, 0, 0));

		btnCancel = new JButton("Cancel");
		panel_btns.add(btnCancel);

		btnSubmit = new JButton("Submit");
		panel_btns.add(btnSubmit);

	}

	public String CalcularTiempoVueloTotal(JDateChooser salida, JDateChooser llegada) {

		String tiempoTotal = null;

		ZonedDateTime start = ZonedDateTime.ofInstant(salida.getDate().toInstant(), ZoneId.systemDefault());
		ZonedDateTime end = ZonedDateTime.ofInstant(llegada.getDate().toInstant(), ZoneId.systemDefault());
		Duration total = Duration.ofMinutes(ChronoUnit.MINUTES.between(start, end));

		long hours = total.toHours();
		long minutes = total.minusHours(hours).toMinutes();

		tiempoTotal = String.valueOf(hours) + " horas " + String.valueOf(minutes) + " minutos";

		return tiempoTotal;

	}

	// Getter & setters

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

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

	public JTextField getTextField_tiempoVuelo() {
		return textField_tiempoVuelo;
	}

	public void setTextField_tiempoVuelo(JTextField textField_tiempoVuelo) {
		this.textField_tiempoVuelo = textField_tiempoVuelo;
	}

	public JTextField getTextField_NumVuelo() {
		return textField_NumVuelo;
	}

	public void setTextField_NumVuelo(JTextField textField_NumVuelo) {
		this.textField_NumVuelo = textField_NumVuelo;
	}

}
