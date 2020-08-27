package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PasajeroFrecuenteDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IPasajeroFrecuenteDAO;

public class PasajeroFrecuenteFactory {
	public static IPasajeroFrecuenteDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new PasajeroFrecuenteDAOImplArchivo();
		}
		
		return null;
		
	}
}
