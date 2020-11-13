package edu.usal.view_old;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class ClientePantallaView_old extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	
	//Comment
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePantallaView_old frame = new ClientePantallaView_old();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientePantallaView_old() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(new Color(51, 51, 102));
		lblCliente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
		lblCliente.setBounds(0, 24, 604, 54);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 119, 42, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasaporte = new JLabel("PASAPORTE");
		lblPasaporte.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lblPasaporte.setBounds(20, 159, 97, 21);
		contentPane.add(lblPasaporte);
		
		textField = new JTextField();
		textField.setBounds(112, 119, 115, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 159, 115, 21);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnNewButton.setBounds(237, 130, 149, 37);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 201, 552, 2);
		contentPane.add(separator);
		
		JButton btnCrearUnNuevo = new JButton("Crear un nuevo Cliente");
		btnCrearUnNuevo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnCrearUnNuevo.setBounds(212, 239, 202, 54);
		contentPane.add(btnCrearUnNuevo);
	}

}
