package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;

public interface IAerolineaDAO {

	void AgregarAerolinea(Aerolinea aerolinea) throws IOException;

	void ModificarAerolinea(Aerolinea oldAerolinea, Aerolinea newAerolinea) throws IOException;

	void EliminarAerolinea(Aerolinea aerolinea) throws IOException;

	List<Aerolinea> GetAll() throws IOException;

}
