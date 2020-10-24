package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Aeropuerto;

public interface AeropuertoDAO {

	void AgregarAeropuerto(Aeropuerto aeropuerto) throws IOException;

	void ModificarAeropuerto(Aeropuerto aeropuerto) throws IOException;

	void EliminarAeropuerto(Aeropuerto aeropuerto) throws IOException;

	Aeropuerto ObtenerAeropuertoPorID(int id) throws IOException, SQLException;

	List<Aeropuerto> GetAll() throws IOException;

}
