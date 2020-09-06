package edu.usal.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class menuPrincipalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipalView frame = new menuPrincipalView();
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
	public menuPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Version");
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE AEROLINEAS");
		lblNewLabel.setBounds(0, 63, 604, 54);
		lblNewLabel.setForeground(new Color(51, 51, 102));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VENTA");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnNewButton.setBounds(21, 214, 180, 81);
		contentPane.add(btnNewButton);
		
		JButton btnVuelo = new JButton("VUELO");
		btnVuelo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnVuelo.setBounds(211, 214, 180, 81);
		contentPane.add(btnVuelo);
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnCliente.setBounds(401, 214, 180, 81);
		contentPane.add(btnCliente);
	}
}
