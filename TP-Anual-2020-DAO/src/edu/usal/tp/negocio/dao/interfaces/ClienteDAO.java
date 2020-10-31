package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Cliente;

public interface ClienteDAO {

	void AgregarCliente(Cliente cliente, Connection con) throws IOException, ParseException;

	void ModificarCliente(Cliente cliente, Connection con) throws IOException, ParseException;

	void EliminarCliente(Cliente cliente, Connection con) throws IOException, ParseException;

	Cliente ObtenerClientePorDNI(String dni) throws SQLException;

	List<Cliente> GetAll() throws IOException, ParseException;

}
