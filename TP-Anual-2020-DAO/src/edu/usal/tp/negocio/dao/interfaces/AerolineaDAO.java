package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;

public interface AerolineaDAO {

	void AgregarAerolinea(Aerolinea aerolinea, Connection con) throws IOException;

	void ModificarAerolinea(Aerolinea aerolinea, Connection con) throws IOException;

	void EliminarAerolinea(Aerolinea aerolinea, Connection con) throws IOException;

	Aerolinea ObtenerAerolineaPorID(int aerolineaID) throws SQLException;

	List<Aerolinea> GetAll() throws IOException;

}
