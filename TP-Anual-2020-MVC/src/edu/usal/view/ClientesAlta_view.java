package edu.usal.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.usal.controllers.GUI.ClienteAltaController_GUI;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Provincia;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ClientesAlta_view {

	
	private static JComboBox comboBox_Dpais = null;
	private static JComboBox comboBox_provincia = null;
	private static JTextField textField_provincia;
	private static JLabel varProvinciaAux = null;
	private static JLabel varDprovincia;
	private static JTextField textField_categoria;
	private static JTextField textField_alianza;
	
	public static void display() {

		JTextField textField_nombre;
		JTextField textField_apellido;
		JTextField textField_DNI;
		JTextField textField_cuit;
		JTextField textField_email;
		JTextField textField_calle;
		JTextField textField_altura;
		JTextField textField_ciudad;
		JTextField textField_CP;
		JTextField textField_nroPersonal;
		JTextField textField_nroCelular;
		JTextField textField_nroLaboral;
		JTextField textField_nroPasaporte;
		JTextField textField_numeroPasaFrec;
		JTextField textField_autEmision;
		JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento, dateChooser_fechaEmision;
		ClienteAltaController_GUI clienteAltaController = new ClienteAltaController_GUI();
		
		JPanel panel_altaForm = new JPanel();
		panel_altaForm.setLayout(new GridLayout(2, 3, 0, 0));
		
		
		//Panel Datos Personales
		JPanel panel_datosPersonales = new JPanel(new GridLayout(7,2,0,0));
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblDatosPersonales.setForeground(Color.BLUE);
		panel_datosPersonales.add(lblDatosPersonales);
		
		JLabel dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_datosPersonales.add(dosPuntos);
		
		JLabel varDPnombre = new JLabel("Nombre");
		panel_datosPersonales.add(varDPnombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		panel_datosPersonales.add(textField_nombre);

		JLabel varDPapellido = new JLabel("Apellido");
		panel_datosPersonales.add(varDPapellido);

		textField_apellido = new JTextField();
		textField_apellido.setColumns(10);
		panel_datosPersonales.add(textField_apellido);

		JLabel varDPDNI = new JLabel("DNI");
		panel_datosPersonales.add(varDPDNI);

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);
		panel_datosPersonales.add(textField_DNI);

		JLabel varDPCuit = new JLabel("CUIT");
		panel_datosPersonales.add(varDPCuit);

		textField_cuit = new JTextField();
		panel_datosPersonales.add(textField_cuit);
		textField_cuit.setColumns(10);

		JLabel varDPfechaNacimiento = new JLabel("Fecha de Nacimiento");
		panel_datosPersonales.add(varDPfechaNacimiento);

		dateChooser_fechaNac = new JDateChooser();
		panel_datosPersonales.add(dateChooser_fechaNac);

		JLabel varDPemail = new JLabel("Email");
		panel_datosPersonales.add(varDPemail);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		panel_datosPersonales.add(textField_email);
		
		//Panel Direccion
		JPanel panel_direccion = new JPanel();
		panel_altaForm.add(panel_direccion);
		panel_direccion.setLayout(new GridLayout(8, 2, 0, 0));

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblDireccion.setForeground(Color.BLUE);
		panel_direccion.add(lblDireccion);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_direccion.add(dosPuntos);

		
		JLabel varDcalle = new JLabel("Calle");
		panel_direccion.add(varDcalle);

		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		panel_direccion.add(textField_calle);

		JLabel varDaltura = new JLabel("Altura");
		panel_direccion.add(varDaltura);

		textField_altura = new JTextField();
		textField_altura.setColumns(10);
		panel_direccion.add(textField_altura);

		JLabel varDciudad = new JLabel("Ciudad");
		panel_direccion.add(varDciudad);

		textField_ciudad = new JTextField();
		textField_ciudad.setColumns(10);
		panel_direccion.add(textField_ciudad);

		JLabel varDcp = new JLabel("C.P.");
		panel_direccion.add(varDcp);

		textField_CP = new JTextField();
		textField_CP.setColumns(10);
		panel_direccion.add(textField_CP);

		JLabel varDpais = new JLabel("Pais");
		panel_direccion.add(varDpais);
		
		comboBox_Dpais = new JComboBox();
		panel_direccion.add(comboBox_Dpais);
		comboBox_Dpais.setVisible(true);
		
		ArrayList<Pais> listPaises = (ArrayList<Pais>) clienteAltaController.mostrarPaises();
		for (int i = 0; i < listPaises.size(); i++) {
			comboBox_Dpais.addItem(listPaises.get(i).getNombre());
		}
		
		comboBox_Dpais.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox_Dpais.getSelectedItem().equals("")) {
					varDprovincia.setVisible(false);
					varProvinciaAux.setVisible(false);
					
					textField_provincia.setVisible(false);
					comboBox_provincia.setVisible(false);
				}
				if (comboBox_Dpais.getSelectedItem().equals("Argentina")) {
					varDprovincia.setVisible(true);
					varProvinciaAux.setVisible(false);
					
					comboBox_provincia.setVisible(true);
					textField_provincia.setVisible(false);
				}
				else{
					varDprovincia.setVisible(false);
					varProvinciaAux.setVisible(true);
					
					comboBox_provincia.setVisible(false);
					textField_provincia.setVisible(true);
				}
			}
		});
		
		varDprovincia = new JLabel();
		varDprovincia.setText("Provincia");
		panel_direccion.add(varDprovincia);
		varDprovincia.setVisible(false);
		
			
		ArrayList<Provincia> listProv = (ArrayList<Provincia>) clienteAltaController.mostrarProvincias();
		
		comboBox_provincia = new JComboBox();
		for (int i = 0; i < listProv.size(); i++) {
			comboBox_provincia.addItem(listProv.get(i).getNombre());
		}
		panel_direccion.add(comboBox_provincia);
		comboBox_provincia.setVisible(false);
		
		varProvinciaAux = new JLabel("Estado");
		panel_direccion.add(varProvinciaAux);
		varProvinciaAux.setVisible(false);
		
		textField_provincia = new JTextField();
		panel_direccion.add(textField_provincia);
		textField_provincia.setColumns(10);
		textField_provincia.setVisible(false);
		
		//Panel Telefono
		
		JPanel panel_telefono = new JPanel();
		panel_altaForm.add(panel_telefono);
		panel_telefono.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblTelefonos.setForeground(Color.BLUE);
		panel_telefono.add(lblTelefonos);

		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_telefono.add(dosPuntos);

		
		JLabel varTpersonal = new JLabel("Nro. Personal");
		panel_telefono.add(varTpersonal);

		textField_nroPersonal = new JTextField();
		textField_nroPersonal.setColumns(10);
		panel_telefono.add(textField_nroPersonal);

		JLabel varTcelular = new JLabel("Nro. Celular");
		panel_telefono.add(varTcelular);

		textField_nroCelular = new JTextField();
		textField_nroCelular.setColumns(10);
		panel_telefono.add(textField_nroCelular);

		JLabel varTlaboral = new JLabel("Nro. Laboral");
		panel_telefono.add(varTlaboral);

		textField_nroLaboral = new JTextField();
		textField_nroLaboral.setColumns(10);
		panel_telefono.add(textField_nroLaboral);
		
		//Panel Pasaporte
		
		JPanel panel_pasaporte = new JPanel();
		panel_altaForm.add(panel_pasaporte);
		panel_pasaporte.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblPasaporte.setForeground(Color.BLUE);
		panel_pasaporte.add(lblPasaporte);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_pasaporte.add(dosPuntos);


		JLabel varPnroPasaporte = new JLabel("Nro. Pasaporte");
		panel_pasaporte.add(varPnroPasaporte);

		textField_nroPasaporte = new JTextField();
		textField_nroPasaporte.setColumns(10);
		panel_pasaporte.add(textField_nroPasaporte);

		JLabel varPfechaVecimiento = new JLabel("Fecha vecimiento");
		panel_pasaporte.add(varPfechaVecimiento);

		dateChooser_fechaVencimiento = new JDateChooser();
		panel_pasaporte.add(dateChooser_fechaVencimiento);

		JLabel varPfechaEmision = new JLabel("Fecha de emision");
		panel_pasaporte.add(varPfechaEmision);

		dateChooser_fechaEmision = new JDateChooser();
		panel_pasaporte.add(dateChooser_fechaEmision);

		JLabel varPpais = new JLabel("Pais");
		panel_pasaporte.add(varPpais);
		
		JComboBox comboBox_pasaportePais =  new JComboBox();
		for (int i = 0; i < listPaises.size(); i++) {
			comboBox_pasaportePais.addItem(listPaises.get(i).getNombre());
		}
		
		panel_pasaporte.add(comboBox_pasaportePais);

		JLabel varPautEmision = new JLabel("Aut. Emision");
		panel_pasaporte.add(varPautEmision);

		textField_autEmision = new JTextField();
		panel_pasaporte.add(textField_autEmision);
		textField_autEmision.setColumns(10);
		
		//Panel pasajero Frecuente
		JPanel panel_pasajeroFrecuente = new JPanel();
		panel_altaForm.add(panel_pasajeroFrecuente);
		panel_pasajeroFrecuente.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblPasajeroFrecuente.setForeground(Color.BLUE);
		panel_pasajeroFrecuente.add(lblPasajeroFrecuente);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_pasajeroFrecuente.add(dosPuntos);
		
		JLabel varPFnumero = new JLabel("Numero");
		panel_pasajeroFrecuente.add(varPFnumero);

		textField_numeroPasaFrec = new JTextField();
		panel_pasajeroFrecuente.add(textField_numeroPasaFrec);
		textField_numeroPasaFrec.setColumns(10);
		
		JLabel varPFaerolinea = new JLabel("Aerolinea");
		panel_pasajeroFrecuente.add(varPFaerolinea);
		
		ArrayList<Aerolinea> listAerolinea = (ArrayList<Aerolinea>) clienteAltaController.mostrarAerolinea();
		
		JComboBox comboBox_aerolinea = new JComboBox();
		panel_pasajeroFrecuente.add(comboBox_aerolinea);
		comboBox_aerolinea.setVisible(true);
		for (int i = 0; i < listAerolinea.size(); i++) {
			comboBox_aerolinea.addItem(listAerolinea.get(i).getNombre());
		}
		comboBox_aerolinea.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String aerolinea = comboBox_aerolinea.getSelectedItem().toString();
				for (int i = 0; i < listAerolinea.size(); i++) {
					if (listAerolinea.get(i).getNombre().equals(aerolinea)) {
						textField_alianza.setText(listAerolinea.get(i).getAlianza().name());
					}
				}
			}
		});

		JLabel varPFalianza = new JLabel("Alianza");
		panel_pasajeroFrecuente.add(varPFalianza);
		
		textField_alianza = new JTextField();
		textField_alianza.setEditable(false);
		panel_pasajeroFrecuente.add(textField_alianza);
		textField_alianza.setColumns(10);

		JLabel varPFcategoria = new JLabel("Categoria");
		panel_pasajeroFrecuente.add(varPFcategoria);
		
		//Agregando paneles
		panel_altaForm.add(panel_datosPersonales);
		panel_altaForm.add(panel_direccion);
			
		panel_altaForm.add(panel_telefono);
		panel_altaForm.add(panel_pasaporte);
		panel_altaForm.add(panel_pasajeroFrecuente);
		
		textField_categoria = new JTextField();
		panel_pasajeroFrecuente.add(textField_categoria);
		textField_categoria.setColumns(10);
	
		
		int result = JOptionPane.showConfirmDialog(null, panel_altaForm, "Alta Cliente",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			System.out.println("Procesando alta cliente");
		}else {
			System.out.println("Cancelado");
		}
	}
	
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}
