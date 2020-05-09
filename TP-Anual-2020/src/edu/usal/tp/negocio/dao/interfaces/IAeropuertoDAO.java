package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Aeropuerto;

public interface IAeropuertoDAO {

	void AgregarAeropuerto(Aeropuerto aeropuerto) throws IOException;

	void ModificarAeropuerto(Aeropuerto oldAeropuerto, Aeropuerto newAeropuerto) throws IOException;

	void EliminarAeropuerto(Aeropuerto aeropuerto) throws IOException;

	List<Aeropuerto> GetAll() throws IOException;

}
