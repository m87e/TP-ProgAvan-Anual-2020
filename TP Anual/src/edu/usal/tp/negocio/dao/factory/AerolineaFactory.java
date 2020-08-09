package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.AerolineaDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;

public class AerolineaFactory {
	public static IAerolineaDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new AerolineaDAOImplArchivo();
		}
		
		return null;
		
	}
}
