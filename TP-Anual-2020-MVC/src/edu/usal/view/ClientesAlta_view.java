package edu.usal.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.toedter.calendar.JDateChooser;

public class ClientesAlta_view {
	

	private static void display() {
		
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
		JTextField textField_alianza;
		JTextField textField_Pas_pais;
		JTextField textField_categoria;
		JTextField textField_autEmision;
		JDateChooser dateChooser_fechaNac, dateChooser_fechaVencimiento, dateChooser_fechaEmision;

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		
		//Panel Datos Personales
		JPanel panel_2 = new JPanel(new GridLayout(7,2,0,0));
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblDatosPersonales.setForeground(Color.BLUE);
		panel_2.add(lblDatosPersonales);
		
		JLabel dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_2.add(dosPuntos);
		
		JLabel varDPnombre = new JLabel("Nombre");
		panel_2.add(varDPnombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		panel_2.add(textField_nombre);

		JLabel varDPapellido = new JLabel("Apellido");
		panel_2.add(varDPapellido);

		textField_apellido = new JTextField();
		textField_apellido.setColumns(10);
		panel_2.add(textField_apellido);

		JLabel varDPDNI = new JLabel("DNI");
		panel_2.add(varDPDNI);

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);
		panel_2.add(textField_DNI);

		JLabel varDPCuit = new JLabel("CUIT");
		panel_2.add(varDPCuit);

		textField_cuit = new JTextField();
		panel_2.add(textField_cuit);
		textField_cuit.setColumns(10);

		JLabel varDPfechaNacimiento = new JLabel("Fecha de Nacimiento");
		panel_2.add(varDPfechaNacimiento);

		dateChooser_fechaNac = new JDateChooser();
		panel_2.add(dateChooser_fechaNac);

		JLabel varDPemail = new JLabel("Email");
		panel_2.add(varDPemail);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		panel_2.add(textField_email);
		
		//Panel Direccion
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblDireccion.setForeground(Color.BLUE);
		panel_3.add(lblDireccion);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_3.add(dosPuntos);

		
		JLabel varDcalle = new JLabel("Calle");
		panel_3.add(varDcalle);

		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		panel_3.add(textField_calle);

		JLabel varDaltura = new JLabel("Altura");
		panel_3.add(varDaltura);

		textField_altura = new JTextField();
		textField_altura.setColumns(10);
		panel_3.add(textField_altura);

		JLabel varDciudad = new JLabel("Ciudad");
		panel_3.add(varDciudad);

		textField_ciudad = new JTextField();
		textField_ciudad.setColumns(10);
		panel_3.add(textField_ciudad);

		JLabel varDcp = new JLabel("C.P.");
		panel_3.add(varDcp);

		textField_CP = new JTextField();
		textField_CP.setColumns(10);
		panel_3.add(textField_CP);

		JLabel varDpais = new JLabel("Pais");
		panel_3.add(varDpais);

		JList list_pais = new JList();
		panel_3.add(list_pais);

		JLabel varDprovincia = new JLabel("Provincia");
		panel_3.add(varDprovincia);

		JList list_provincia = new JList();
		panel_3.add(list_provincia);
		
		//Panel Telefono
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblTelefonos.setForeground(Color.BLUE);
		panel_4.add(lblTelefonos);

		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_4.add(dosPuntos);

		
		JLabel varTpersonal = new JLabel("Nro. Personal");
		panel_4.add(varTpersonal);

		textField_nroPersonal = new JTextField();
		textField_nroPersonal.setColumns(10);
		panel_4.add(textField_nroPersonal);

		JLabel varTcelular = new JLabel("Nro. Celular");
		panel_4.add(varTcelular);

		textField_nroCelular = new JTextField();
		textField_nroCelular.setColumns(10);
		panel_4.add(textField_nroCelular);

		JLabel varTlaboral = new JLabel("Nro. Laboral");
		panel_4.add(varTlaboral);

		textField_nroLaboral = new JTextField();
		textField_nroLaboral.setColumns(10);
		panel_4.add(textField_nroLaboral);
		
		//Panel Pasaporte
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblPasaporte.setForeground(Color.BLUE);
		panel_5.add(lblPasaporte);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_5.add(dosPuntos);


		JLabel varPnroPasaporte = new JLabel("Nro. Pasaporte");
		panel_5.add(varPnroPasaporte);

		textField_nroPasaporte = new JTextField();
		textField_nroPasaporte.setColumns(10);
		panel_5.add(textField_nroPasaporte);

		JLabel varPfechaVecimiento = new JLabel("Fecha vecimiento");
		panel_5.add(varPfechaVecimiento);

		dateChooser_fechaVencimiento = new JDateChooser();
		panel_5.add(dateChooser_fechaVencimiento);

		JLabel varPfechaEmision = new JLabel("Fecha de emision");
		panel_5.add(varPfechaEmision);

		dateChooser_fechaEmision = new JDateChooser();
		panel_5.add(dateChooser_fechaEmision);

		JLabel varPpais = new JLabel("Pais");
		panel_5.add(varPpais);

		textField_Pas_pais = new JTextField();
		panel_5.add(textField_Pas_pais);
		textField_Pas_pais.setColumns(10);

		JLabel varPautEmision = new JLabel("Aut. Emision");
		panel_5.add(varPautEmision);

		textField_autEmision = new JTextField();
		panel_5.add(textField_autEmision);
		textField_autEmision.setColumns(10);
		
		//Panel pasajero Frecuente
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		lblPasajeroFrecuente.setForeground(Color.BLUE);
		panel_6.add(lblPasajeroFrecuente);
		
		dosPuntos = new JLabel("");
		dosPuntos.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		panel_6.add(dosPuntos);
		
		JLabel varPFnumero = new JLabel("Numero");
		panel_6.add(varPFnumero);

		textField_numeroPasaFrec = new JTextField();
		panel_6.add(textField_numeroPasaFrec);
		textField_numeroPasaFrec.setColumns(10);

		JLabel varPFalianza = new JLabel("Alianza");
		panel_6.add(varPFalianza);

		textField_alianza = new JTextField();
		panel_6.add(textField_alianza);
		textField_alianza.setColumns(10);

		JLabel varPFcategoria = new JLabel("Categoria");
		panel_6.add(varPFcategoria);

		textField_categoria = new JTextField();
		panel_6.add(textField_categoria);
		textField_categoria.setColumns(10);
		
		//Agregando paneles
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		panel_1.add(panel_4);
		panel_1.add(panel_5);
		panel_1.add(panel_6);
		
		int result = JOptionPane.showConfirmDialog(null, panel_1, "Alta Cliente",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			System.out.println("Hola Mundo");
		}else {
			System.out.println("cancelado");
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
