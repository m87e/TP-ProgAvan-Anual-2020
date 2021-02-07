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


public class Menu_view implements ActionListener{

	private JFrame frame;
	
	private JMenuBar menuBar;
	
	private JMenu mnHelp;
	private JMenuItem mntmSalir, mntmVersion;
	
	private JMenu mnCliente;
	private JMenuItem mntmCliente;
	private JMenuItem mntmAltaCliente;
	
	private JMenu mnVuelos;
	private JMenuItem mntmVuelo;
	private JMenuItem mntmAltaVuelo;

	private JMenu mnVentas;
	private JMenuItem mntmVenta;
	
	private JMenu mnAerolineas;
	private JMenuItem mntmAerolinea;
	private JMenuItem mntmAltaAerolinea;
	
	static JPanel panelPivot;
	private JPanel panelCliente , panelVenta , panelVuelo , panelAerolinea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_view window = new Menu_view();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
			mntmCliente = new JMenuItem("Gestion de clientes");
			mnCliente.add(mntmCliente);
			mntmCliente.addActionListener(this);
			
			mntmAltaCliente = new JMenuItem("Nuevo cliente");
			mnCliente.add(mntmAltaCliente);
			mntmAltaCliente.addActionListener(this);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
			mntmVenta = new JMenuItem("Gestion de ventas");
			mnVentas.add(mntmVenta);
			mntmVenta.addActionListener(this);
		
		
		mnVuelos = new JMenu("Vuelos");
		menuBar.add(mnVuelos);
		
			mntmVuelo = new JMenuItem("Gestion de vuelos");
			mnVuelos.add(mntmVuelo);
			
			mntmAltaVuelo = new JMenuItem("Nuevo vuelo");
			mnVuelos.add(mntmAltaVuelo);
			mntmVuelo.addActionListener(this);
		
		mnAerolineas = new JMenu("Aerolineas");
		menuBar.add(mnAerolineas);
		
			mntmAerolinea = new JMenuItem("Gestion de aerolineas");
			mnAerolineas.add(mntmAerolinea);
			mntmAerolinea.addActionListener(this);
			
			mntmAltaAerolinea = new JMenuItem("Nueva aerolinea");
			mnAerolineas.add(mntmAltaAerolinea);
		

		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmVersion = new JMenuItem("Version");
		mnHelp.add(mntmVersion);
		mntmVersion.addActionListener(this);
		
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnHelp.add(mntmSalir);
		
		frame.getContentPane().setLayout(null);
		
		panelPivot = new JPanel();
		panelPivot.setBounds(0,0,900,550);
		frame.getContentPane().add(panelPivot);
		panelPivot.setLayout(new CardLayout(0,0));
		
		
		panelCliente = new AerolineasView();
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
		if(e.getSource() == mntmSalir) {
			System.exit(0);
		}
		
		if(e.getSource() == mntmCliente) {
			panelCliente = new ClientesView();
			panelPivot.removeAll();
			panelPivot.add(panelCliente);
			panelPivot.setVisible(true);
			panelPivot.validate();
		}
		
		if(e.getSource() == mntmVenta) {
			panelVenta = new VentasABM_view();
			panelPivot.removeAll();
			panelPivot.add(panelVenta);
			panelPivot.setVisible(true);
			panelPivot.validate();	
		}
		
		if(e.getSource() == mntmVuelo) {
			panelVuelo = new VuelosABM_view();
			panelPivot.removeAll();
			panelPivot.add(panelVuelo);
			panelPivot.setVisible(true);
			panelPivot.validate();
		}
		if(e.getSource()== mntmAerolinea) {
			panelAerolinea = new AerolineasView();
			panelPivot.removeAll();
			panelPivot.add(panelAerolinea);
			panelPivot.setVisible(true);
			panelPivot.validate();
			
		}
		if(e.getSource()== mntmVersion) {
			JOptionPane.showMessageDialog(null, "Sistema de gestion de viajes V2.0");
		}
		if (e.getSource() == mntmSalir) {
			System.exit(0);
		}
		
	}
}
