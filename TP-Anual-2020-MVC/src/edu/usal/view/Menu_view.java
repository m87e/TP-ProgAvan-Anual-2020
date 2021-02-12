package edu.usal.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.usal.view_old.ClientesABM_view;
import javax.swing.SwingConstants;

public class Menu_view implements ActionListener {

	private JFrame frmSis;

	private JMenuBar menuBar;

	private JMenu mnHelp;
	private JMenuItem mntmSalir, mntmVersion;

	private JMenu mnCliente;
	private JMenuItem mntmCliente;

	private JMenu mnVuelos;
	private JMenuItem mntmVuelo;

	private JMenu mnVentas;
	private JMenuItem mntmVenta;

	private JMenu mnAerolineas;
	private JMenuItem mntmAerolinea;
	
	private JMenuItem mntmActualizar;

	static JPanel panelPivot;
	private JPanel panelCliente, panelVenta, panelVuelo, panelAerolinea;
	
	private Boolean cliente=false, venta=false, vuelo=false, aerolinea=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_view window = new Menu_view();
					window.frmSis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSis = new JFrame();
		frmSis.setTitle("Sistema de gestion de Vuelos");
		frmSis.setBounds(100, 100, 900, 700);
		frmSis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		frmSis.setJMenuBar(menuBar);

		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		mntmCliente = new JMenuItem("Gestion de clientes");
		mnCliente.add(mntmCliente);
		mntmCliente.addActionListener(this);

		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		mntmVenta = new JMenuItem("Gestion de ventas");
		mnVentas.add(mntmVenta);
		mntmVenta.addActionListener(this);

		mnVuelos = new JMenu("Vuelos");
		menuBar.add(mnVuelos);

		mntmVuelo = new JMenuItem("Gestion de vuelos");
		mnVuelos.add(mntmVuelo);
		mntmVuelo.addActionListener(this);

		mnAerolineas = new JMenu("Aerolineas");
		menuBar.add(mnAerolineas);

		mntmAerolinea = 
				new JMenuItem("Gestion de aerolineas");
		mnAerolineas.add(mntmAerolinea);
		mntmAerolinea.addActionListener(this);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmVersion = new JMenuItem("Version");
		mnHelp.add(mntmVersion);
		mntmVersion.addActionListener(this);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnHelp.add(mntmSalir);
		
		mntmActualizar = new JMenuItem("Actualizar");
		mntmActualizar.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmActualizar.addActionListener(this);
		menuBar.add(mntmActualizar);

		frmSis.getContentPane().setLayout(null);

		panelPivot = new JPanel();
		panelPivot.setBounds(0, 0, 900, 550);
		frmSis.getContentPane().add(panelPivot);
		panelPivot.setLayout(new CardLayout(0, 0));

		panelCliente = new ClientesView();
		panelPivot.add(panelCliente);
		panelPivot.setVisible(true);
		panelPivot.validate();

	}

	@SuppressWarnings("deprecation")
	public static void RecargarPanelCambiante(JPanel jp) {

		panelPivot.removeAll();

		try {
			panelPivot.add(jp.getClass().newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelPivot.setVisible(true);
		panelPivot.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mntmSalir) {
			System.exit(0);
		}

		if (e.getSource() == mntmCliente) {
			panelCliente = new ClientesView();
			panelPivot.removeAll();
			panelPivot.add(panelCliente);
			panelPivot.setVisible(true);
			panelPivot.validate();
			
			cliente=true; 
			venta=false; 
			vuelo=false;
			aerolinea=false;
		}

		if (e.getSource() == mntmVenta) {
			panelVenta = new VentasView();
			panelPivot.removeAll();
			panelPivot.add(panelVenta);
			panelPivot.setVisible(true);
			panelPivot.validate();
			
			cliente=false; 
			venta=true; 
			vuelo=false;
			aerolinea=false;
		}

		if (e.getSource() == mntmVuelo) {
			panelVuelo = new VuelosView();
			panelPivot.removeAll();
			panelPivot.add(panelVuelo);
			panelPivot.setVisible(true);
			panelPivot.validate();
			
			cliente=false; 
			venta=false; 
			vuelo=true;
			aerolinea=false;
		}
		if (e.getSource() == mntmAerolinea) {
			String usuario = JOptionPane.showInputDialog(null,"Usuario");
			String password = JOptionPane.showInputDialog(null,"Password");
			if (usuario.equals("admin") && password.equals("admin")) {
				panelAerolinea = new AerolineasView();
				panelPivot.removeAll();
				panelPivot.add(panelAerolinea);
				panelPivot.setVisible(true);
				panelPivot.validate();
				
				cliente=false; 
				venta=false; 
				vuelo=false;
				aerolinea=true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
				panelCliente = new ClientesView();
				panelPivot.removeAll();
				panelPivot.add(panelCliente);
				panelPivot.setVisible(true);
				panelPivot.validate();
				
				cliente=true; 
				venta=false; 
				vuelo=false;
				aerolinea=false;
			}
			


		}
		if (e.getSource() == mntmVersion) {
			JOptionPane.showMessageDialog(null, "Sistema de gestion de viajes V2.0");
		}
		if (e.getSource() == mntmSalir) {
			System.exit(0);
		}
		if (e.getSource() == mntmActualizar) {
			if(cliente) {
				panelCliente = new ClientesView();
				panelPivot.removeAll();
				panelPivot.add(panelCliente);
				panelPivot.setVisible(true);
				panelPivot.validate();
			}
			if(vuelo) {
				panelVuelo = new VuelosView();
				panelPivot.removeAll();
				panelPivot.add(panelVuelo);
				panelPivot.setVisible(true);
				panelPivot.validate();		
			}
			if(venta) {
				panelVenta = new VentasView();
				panelPivot.removeAll();
				panelPivot.add(panelVenta);
				panelPivot.setVisible(true);
				panelPivot.validate();
			}
			if(aerolinea) {
				panelAerolinea = new AerolineasView();
				panelPivot.removeAll();
				panelPivot.add(panelAerolinea);
				panelPivot.setVisible(true);
				panelPivot.validate();		
			}
				
				
		}

	}
}
