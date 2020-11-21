package edu.usal.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usal.view.AerolineaAlta_view;

public class AerolineaEvents implements ActionListener {

	private AerolineaAlta_view view;

	public AerolineaEvents(AerolineaAlta_view view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == this.view.getBtnSubmit()) {

			String nombre = this.view.getTextNombre().getText();
			String alianza = this.view.getTextAlianza().getText();

			// llamo a aerolinea controller y vista

		}

		if (arg0.getSource() == this.view.getBtnCancel()) {

			// retorno a la pagina anterior
		}
	}

}
