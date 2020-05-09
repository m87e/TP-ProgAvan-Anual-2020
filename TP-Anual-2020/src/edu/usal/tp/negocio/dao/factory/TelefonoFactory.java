package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.TelefonoDAOImpArchivo;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;

public class TelefonoFactory {
public static ITelefonoDAO GetImplementation (String source) {
		
		if (source.equals("Archivo")){
			return new TelefonoDAOImpArchivo();
		}
		return null;
	}
}
