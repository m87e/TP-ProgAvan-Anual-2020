package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.AeropuertosDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.AeropuertosDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.AeropuertoDAO;

public class AeropuertoFactory {
	public static AeropuertoDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new AeropuertosDAOImplArchivo();
		}
		if (source.equals("database")) {
			return new AeropuertosDAOImplDatabase();
		}

		return null;

	}
}
