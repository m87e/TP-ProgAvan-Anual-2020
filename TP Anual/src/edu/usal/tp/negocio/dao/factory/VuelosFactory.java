package edu.usal.tp.negocio.dao.factory;


import edu.usal.tp.negocio.dao.implementaciones.VueloDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IVuelosDAO;

public class VuelosFactory {
	public static IVuelosDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new VueloDAOImplArchivo();
		}
		
		return null;
		
	}
}
