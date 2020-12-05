package edu.usal.view;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Menu_view implements ActionListener{

	private JFrame frame;
	
	private JMenuBar menuBar;
	
	private JMenu mnHelp;
	private JMenuItem mntmSalir, mntmVersion;
	
	private JMenu mnCliente;
	private JMenuItem mntmABMCliente;
	private JMenuItem mntmCliente;
	
	private JMenu mnVuelos;
	private JMenuItem mntmABMVuelos;

	private JMenu mnVentas;
	private JMenuItem mntmABMVenta;
	
	static JPanel panelPivot;
	private JPanel panelCliente , panelVenta , panelVuelo;

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
		
		mntmABMCliente = new JMenuItem("Gestion cliente");
		mnCliente.add(mntmABMCliente);
		mntmABMCliente.addActionListener(this);
		
		mntmCliente = new JMenuItem("Listado cliente");
		mnCliente.add(mntmCliente);
		mntmCliente.addActionListener(this);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmABMVenta = new JMenuItem("Gestion venta");
		mnVentas.add(mntmABMVenta);
		mntmABMVenta.addActionListener(this);
		
		
		mnVuelos = new JMenu("Vuelos");
		menuBar.add(mnVuelos);
		
		mntmABMVuelos = new JMenuItem("Gestion vuelo");
		mnVuelos.add(mntmABMVuelos);
		mntmABMVuelos.addActionListener(this);
		

		
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
		
		
		panelCliente = new ClientesView();
		panelPivot.add(panelCliente);
		panelPivot.setVisible(true);
		panelPivot.validate();
		
		
	}

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
		
		if(e.getSource() == mntmABMCliente) {
			panelCliente = new ClientesABM_view();
			panelPivot.removeAll();
			panelPivot.add(panelCliente);
			panelPivot.setVisible(true);
			panelPivot.validate();
		}
		
		if(e.getSource() == mntmCliente) {
			panelCliente = new ClientesView();
			panelPivot.removeAll();
			panelPivot.add(panelCliente);
			panelPivot.setVisible(true);
			panelPivot.validate();
		}
		
		
		if(e.getSource() == mntmABMVenta) {
			panelVenta = new VentasABM_view();
			panelPivot.removeAll();
			panelPivot.add(panelVenta);
			panelPivot.setVisible(true);
			panelPivot.validate();	
		}
		
		if(e.getSource() == mntmABMVuelos) {
			panelVuelo = new VuelosABM_view();
			panelPivot.removeAll();
			panelPivot.add(panelVuelo);
			panelPivot.setVisible(true);
			panelPivot.validate();
		}
		
	}

}
