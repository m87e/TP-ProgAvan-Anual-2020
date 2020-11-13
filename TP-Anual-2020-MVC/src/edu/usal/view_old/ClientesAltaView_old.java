package edu.usal.view_old;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClientesAltaView_old extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesAltaView_old frame = new ClientesAltaView_old();
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
	public ClientesAltaView_old() {
		setTitle("Nuevo cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(5, 543, 922, 17);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(910, 5, 17, 538);
		contentPane.add(scrollBar_1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel.setBounds(25, 71, 478, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_1.setBounds(25, 96, 478, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(81, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_2.setBounds(192, 71, 311, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 68, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cuit");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_3.setBounds(192, 96, 311, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 93, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(248, 93, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Pasaporte");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_4.setBounds(25, 306, 478, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 303, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_5.setBounds(25, 121, 478, 20);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(144, 121, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_6.setBounds(248, 124, 255, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(290, 121, 205, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Calle");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_7.setBounds(25, 187, 478, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(81, 184, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(81, 184, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ciudad");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_8.setBounds(25, 218, 478, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Altura");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_9.setBounds(192, 187, 311, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(248, 184, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Codigo Postal");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_10.setBounds(192, 218, 311, 17);
		contentPane.add(lblNewLabel_10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(275, 215, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Pais");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_11.setBounds(25, 243, 478, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setBounds(81, 215, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Pais");
		comboBox.setBounds(164, 240, 17, 20);
		contentPane.add(comboBox);
		
		textField_12 = new JTextField();
		textField_12.setBounds(81, 240, 86, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(275, 246, 86, 20);
		contentPane.add(textField_13);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Pais");
		comboBox_1.setBounds(358, 246, 17, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("Provincia");
		lblNewLabel_11_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_11_1.setBounds(192, 243, 311, 14);
		contentPane.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_12 = new JLabel("Telefono personal");
		lblNewLabel_12.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_12.setBounds(410, 186, 104, 17);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("Telefono celular");
		lblNewLabel_12_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_12_1.setBounds(410, 217, 93, 17);
		contentPane.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Telefono laboral");
		lblNewLabel_12_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_12_2.setBounds(410, 248, 93, 17);
		contentPane.add(lblNewLabel_12_2);
		
		textField_14 = new JTextField();
		textField_14.setBounds(513, 184, 86, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(513, 215, 86, 20);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(513, 246, 86, 20);
		contentPane.add(textField_16);
		
		JLabel lblNewLabel_11_2 = new JLabel("Pais");
		lblNewLabel_11_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_11_2.setBounds(25, 334, 478, 14);
		contentPane.add(lblNewLabel_11_2);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(91, 334, 86, 20);
		contentPane.add(textField_17);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Pais");
		comboBox_2.setBounds(174, 334, 17, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_13 = new JLabel("Autoridad de emision");
		lblNewLabel_13.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_13.setBounds(25, 359, 478, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Fecha de emision");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_14.setBounds(25, 384, 478, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Fecha de vencimiento");
		lblNewLabel_15.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblNewLabel_15.setBounds(25, 409, 478, 14);
		contentPane.add(lblNewLabel_15);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(144, 356, 86, 20);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(144, 381, 86, 20);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(144, 406, 86, 20);
		contentPane.add(textField_20);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(473, 456, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setBounds(301, 456, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblClienteAlta = new JLabel("CLIENTE: Alta");
		lblClienteAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteAlta.setForeground(new Color(51, 51, 102));
		lblClienteAlta.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
		lblClienteAlta.setBounds(5, 5, 604, 54);
		contentPane.add(lblClienteAlta);
	}
}
