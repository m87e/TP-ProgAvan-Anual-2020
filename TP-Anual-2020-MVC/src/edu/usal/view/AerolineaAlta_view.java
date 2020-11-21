package edu.usal.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import edu.usal.events.AerolineaEvents;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AerolineaAlta_view extends JFrame {
	private JTextField textNombre;
	private JTextField textAlianza;
	private JLabel lblNombre;
	private JLabel lblAlianza;
	private JButton btnCancel;
	private JButton btnSubmit;

	public AerolineaAlta_view() {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("161px"), ColumnSpec.decode("61px:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("61px"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("16px"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		lblNombre = new JLabel("Nombre");
		add(lblNombre, "1, 4, right, top");

		textNombre = new JTextField();
		add(textNombre, "2, 4, fill, default");
		textNombre.setColumns(10);

		lblAlianza = new JLabel("Alianza");
		add(lblAlianza, "1, 6, right, top");

		textAlianza = new JTextField();
		add(textAlianza, "2, 6, fill, default");
		textAlianza.setColumns(10);

		btnCancel = new JButton("Cancel");
		add(btnCancel, "1, 10");

		btnSubmit = new JButton("Submit");
		add(btnSubmit, "2, 10");
		getBtnSubmit().addActionListener(new AerolineaEvents(this));

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

}
