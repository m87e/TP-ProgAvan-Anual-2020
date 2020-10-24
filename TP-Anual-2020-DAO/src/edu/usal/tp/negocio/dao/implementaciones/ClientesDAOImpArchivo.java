package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;

public class ClientesDAOImpArchivo implements ClienteDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//cliente.txt";

	@Override
	public void AgregarCliente(Cliente cliente, Connection con) throws IOException {
		archivo = new File(path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveCliente(cliente);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveCliente(Cliente cliente) {
		return cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getDni() + ";"
				+ cliente.getTelefono().getId() + ";" + cliente.getCuit() + ";" + cliente.getEmail() + ";"
				+ cliente.getDir().getId() + ";" + cliente.getFechaNac() + ";"
				+ cliente.getPasaporte().getNumeroPasaporte() + ";" + cliente.getPasajeroFrecuente().getNumeroPF()
				+ "\r\n";

	}

	@Override
	public void ModificarCliente(Cliente cliente) throws IOException, ParseException {
		List<Cliente> listadoCliente = GetAll();

		for (Cliente c : listadoCliente) {

			if (c.getId() == (cliente.getId())) {
				c.setId(cliente.getId());
				c.setApellido(cliente.getApellido());
				c.setNombre(cliente.getNombre());
				c.setDni(cliente.getDni());
				c.setTelID(cliente.getTelefono().getId());
				c.setCuit(cliente.getCuit());
				c.setEmail(cliente.getEmail());
				c.setDirID(cliente.getDir().getId());
				c.setFechaNac(cliente.getFechaNac());
				c.setPasID(cliente.getPasaporte().getIdPasaporte());
				c.setPasfreID(cliente.getPasajeroFrecuente().getId());
			}

			AgregarCliente(c, null);

		}

	}

	@Override
	public void EliminarCliente(Cliente cliente) throws IOException, ParseException {

		List<Cliente> listadoClientes = GetAll();

		listadoClientes.removeIf(o -> o.getId() == cliente.getId());

		for (Cliente c : listadoClientes) {

			AgregarCliente(c, null);

		}

	}

	@Override
	public List<Cliente> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub

		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Cliente> listadoClientes = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoClientes.add(ParseCliente(linea));
		}

		return listadoClientes;
	}

	private Cliente ParseCliente(String linea) throws ParseException {
		// TODO Auto-generated method stub

		String[] atributos = linea.split(";");

		Cliente c = new Cliente();

		c.setId(Integer.valueOf(atributos[0]));
		c.setApellido(atributos[1]);
		c.setNombre(atributos[2]);
		c.setDni(atributos[3]);
		c.setTelID(Integer.valueOf(atributos[4]));
		c.setCuit(atributos[5]);
		c.setEmail(atributos[6]);
		c.setDirID(Integer.valueOf(atributos[7]));
		c.setFechaNac(LocalDate.parse((atributos[8]).toString()));
		c.setPasID(Integer.valueOf(atributos[9]));
		c.setPasfreID(Integer.valueOf(atributos[10]));

		return c;
	}

	@Override
	public Cliente ObtenerClientePorDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
