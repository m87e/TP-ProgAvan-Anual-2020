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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;

public class VentasABM_view extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public VentasABM_view() {
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 40));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 17, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 24, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 730, SpringLayout.WEST, this);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 75, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 11, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -268, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, panel);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnAlta = new JButton("Alta");
		panel.add(btnAlta);
		
		JButton btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 23, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 206, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 5, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Venta #");
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_2.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente");
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("DNI de Cliente");
		panel_2.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Linea");
		panel_2.add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		panel_2.add(dateChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Vuelo");
		panel_2.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_12 = new JLabel("Pasajero Frecuente");
		panel_2.add(lblNewLabel_12);
		
		textField_8 = new JTextField();
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Cuit Cliente");
		panel_3.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("Precio pasaje");
		panel_3.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_8 = new JLabel("Forma de pago");
		panel_3.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_9 = new JLabel("Recargo aplicado");
		panel_3.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_3.add(textField_7);
		
		JLabel lblNewLabel_10 = new JLabel("Precio final");
		panel_3.add(lblNewLabel_10);
		
		JList list_1 = new JList();
		panel_3.add(list_1);
		
		JLabel lblNewLabel_11 = new JLabel("Fecha y hora de venta");
		panel_3.add(lblNewLabel_11);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		panel_3.add(dateChooser_1);
		
		JPanel panel_7 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_7, 26, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_7, -138, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_7, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel);
		add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Guardar");
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_7.add(btnNewButton_1);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
