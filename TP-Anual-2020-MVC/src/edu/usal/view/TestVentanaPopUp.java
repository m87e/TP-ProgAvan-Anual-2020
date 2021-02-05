package edu.usal.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.events.AerolineaEvents;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class TestVentanaPopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nombre;
	private JTextField textField__alianza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TestVentanaPopUp dialog = new TestVentanaPopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TestVentanaPopUp() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 58, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblAlianza = new JLabel("Alianza");
		lblAlianza.setBounds(10, 127, 46, 14);
		contentPanel.add(lblAlianza);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(103, 55, 86, 20);
		contentPanel.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField__alianza = new JTextField();
		textField__alianza.setBounds(103, 124, 86, 20);
		contentPanel.add(textField__alianza);
		textField__alianza.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public TestVentanaPopUp(AerolineaEvents aerolineaEvents, boolean b) {
		b = false;
	}
	
	
}
