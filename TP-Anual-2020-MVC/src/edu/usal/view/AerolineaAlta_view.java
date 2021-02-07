package edu.usal.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import edu.usal.controllers.GUI.AerolineaAltaController_GUI;
import edu.usal.controllers.GUI.AerolineaController_GUI;
import edu.usal.events.AerolineaAltaEvents;
import edu.usal.events.AerolineaEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class AerolineaAlta_view extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JLabel lblNombre;
	private JLabel lblAlianza;
	private JButton btnCancel;
	private JButton btnSubmit;
	private JComboBox comboBox_alianza;

	public AerolineaAlta_view() {
		setTitle("Agregar Aerolinea");
		getContentPane().setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(46, 26, 106, 22);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(161, 28, 206, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(47, 56, 72, 14);
		getContentPane().add(lblAlianza);

		comboBox_alianza = new JComboBox();
		comboBox_alianza.setBounds(161, 54, 206, 21);
		getContentPane().add(comboBox_alianza);
		comboBox_alianza.addItem("Oneworld");
		comboBox_alianza.addItem("SkyTeam");
		comboBox_alianza.addItem("StarAlliance");
		

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(42, 106, 140, 23);
		getContentPane().add(btnCancel);
		getBtnCancel().addActionListener(new AerolineaAltaEvents(this));

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(190, 106, 189, 23);
		getContentPane().add(btnSubmit);
		getBtnSubmit().addActionListener(new AerolineaAltaEvents(this));
		
}

	// Getter & setters

	

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JComboBox getComboBoxAlianza() {
		return comboBox_alianza;
	}

	public void setComboBoxAlianza(JComboBox comboBox) {
		this.comboBox_alianza = comboBox;
	}
	
}
