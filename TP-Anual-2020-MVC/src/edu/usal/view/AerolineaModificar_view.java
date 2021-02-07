package edu.usal.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import edu.usal.controllers.GUI.AerolineaController_GUI;
import edu.usal.events.AerolineaAltaEvents;
import edu.usal.events.AerolineaEvents;
import edu.usal.events.AerolineaModificarEvents;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AerolineaModificar_view extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textAlianza;
	private JLabel lblNombre;
	private JLabel lblAlianza;
	private JButton btnCancel;
	private JButton btnSubmit;
	private JTextField textID;

	public AerolineaModificar_view(Aerolinea a) {
		setTitle("Modifcar Aerolinea");
		getContentPane().setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 45, 106, 14);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(161, 42, 206, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.setText(a.getNombre());
		
		lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(32, 70, 106, 14);
		getContentPane().add(lblAlianza);

		textAlianza = new JTextField();
		textAlianza.setBounds(161, 68, 206, 20);
		getContentPane().add(textAlianza);
		textAlianza.setColumns(10);
		String alianza = a.getAlianza().toString();
		textAlianza.setText(alianza);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(0, 105, 161, 23);
		getContentPane().add(btnCancel);
		getBtnCancel().addActionListener(new AerolineaModificarEvents(this));

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(161, 105, 206, 23);
		getContentPane().add(btnSubmit);
		
		textID = new JTextField();
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setBounds(159, 11, 86, 20);
		getContentPane().add(textID);
		textID.setColumns(10);
		getBtnSubmit().addActionListener(new AerolineaModificarEvents(this));
		textID.setText(String.valueOf((a.getId())));
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(32, 11, 122, 23);
		getContentPane().add(lbl_id);
		
	}

	// Getter & setters

	

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextAlianza() {
		return textAlianza;
	}

	public void setTextAlianza(JTextField textAlianza) {
		this.textAlianza = textAlianza;
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

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}
}
