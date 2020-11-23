package edu.usal.view;

import javax.swing.JPanel;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import javax.swing.JButton;

public class AerolineasABM_View extends JPanel {

	private JButton btnAlta;

	public AerolineasABM_View() {

		btnAlta = new JButton("Alta");
		add(btnAlta);
	}

	public Aerolinea CargarAerolinea() {

		// Abro AerolineaAlta_view
		return null;

	}
}
