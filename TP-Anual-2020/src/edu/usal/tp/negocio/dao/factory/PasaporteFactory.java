package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PasaporteDAOImpArchivo;
import edu.usal.tp.negocio.dao.interfaces.IPasaporteDAO;

public class PasaporteFactory {
	public static IPasaporteDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new PasaporteDAOImpArchivo();
		}
		
		return null;
		
	}
}
