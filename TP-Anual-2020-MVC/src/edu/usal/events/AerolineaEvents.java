package edu.usal.events;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.view.AerolineaAlta_view;

public class AerolineaEvents implements ActionListener {

	private AerolineaAlta_view view;

	public AerolineaEvents(AerolineaAlta_view view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == this.view.getBtnSubmit()) {

			String alianza = this.view.getTextAlianza().getText();
			Aerolinea aerolinea = new Aerolinea();
			aerolinea.setNombre(this.view.getTextNombre().getText());

			aerolinea.setAlianza(Alianza.valueOf(alianza));

			this.view.setAerolinea(aerolinea);

		}

		if (arg0.getSource() == this.view.getBtnCancel()) {

			// retorno a la pagina anterior
		}
	}

}
