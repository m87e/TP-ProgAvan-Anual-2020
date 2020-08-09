package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.AeropuertosDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IAeropuertoDAO;

public class AeropuertoFactory {
	public static IAeropuertoDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new AeropuertosDAOImplArchivo();
		}
		
		return null;
		
	}
}
