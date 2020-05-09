package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.ProvinciasDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;

public class ProvinciasFactory {
	 
	public static IProvinciasDAO GetImplementation (String source) {
		
		if (source.equals("Archivo")){
			return new ProvinciasDAOImplArchivo();
		}
		return null;
	}

}
