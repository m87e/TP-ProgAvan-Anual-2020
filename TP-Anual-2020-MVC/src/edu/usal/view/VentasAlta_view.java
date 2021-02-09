package edu.usal.view;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import java.awt.BorderLayout;

public class VentasAlta_view extends JFrame implements ActionListener{
	
	public VentasAlta_view() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setBounds(0, 0, 706, 48);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 706, 408);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_cargaDatos = new JPanel();
		panel.add(panel_cargaDatos);
		
		JPanel panel_botones = new JPanel();
		panel.add(panel_botones);
		panel_botones.setLayout(null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
