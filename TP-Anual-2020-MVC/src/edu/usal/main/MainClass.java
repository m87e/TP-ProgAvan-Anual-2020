package edu.usal.main;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.controllers.ClienteController;
import edu.usal.managers.ClienteManager;
import edu.usal.views.console.ClienteView;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		ClienteView vista = new ClienteView();
		ClienteController controlador = new ClienteController(vista);
		controlador.mostrarMenu();

	}

}
