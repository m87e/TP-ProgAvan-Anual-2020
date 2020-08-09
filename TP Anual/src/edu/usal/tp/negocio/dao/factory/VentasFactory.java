package edu.usal.tp.negocio.dao.factory;


import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IVentaDAO;

public class VentasFactory {
	public static IVentaDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new VentaDAOImplArchivo();
		}
		
		return null;
		
	}
}
