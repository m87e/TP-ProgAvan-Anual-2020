package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Cliente;

public interface IClienteDAO {

	void AgregarCliente(Cliente cliente) throws IOException, ParseException;

	void ModificarCliente(Cliente cliente) throws IOException, ParseException;

	void EliminarCliente(Cliente cliente) throws IOException , ParseException;

	List<Cliente> GetAll() throws IOException ,ParseException;

}
