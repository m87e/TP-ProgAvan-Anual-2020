package edu.usal.tp.negocio.dao.implementaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;
import edu.usal.tp.negocio.dao.util.*;

public class ClientesDAOImplStream implements IClienteDAO {

	private File file;
	private FileOutputStream fOut;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private List<Cliente> lista;

	@Override
	public void AgregarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub

		this.lista.add(cliente);

		file = new File(PropertiesUtil.obtenerPathArchivoStream());
		file.delete();

		fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathArchivoStream()));
		oos = new ObjectOutputStream(fOut);
		oos.writeObject(lista);
		oos.close();

		System.out.println("Stream -> Cliente agregado correctamente");

	}

	@Override
	public void ModificarCliente(Cliente cliente) throws IOException, ParseException, ClassNotFoundException {
		// TODO Auto-generated method stub

		List<Cliente> listado = GetAll();
		int aux = 0;
		
		for(Cliente c: listado) {
			if(c.getId() == cliente.getId()) {
				c.setNombre(cliente.getNombre());
				c.setApellido(cliente.getApellido());
				c.setCuit(cliente.getCuit());
				c.setDni(cliente.getDni());
				c.setPas(cliente.getPas());
				c.setFechaNac(cliente.getFechaNac());
				c.setEmail(cliente.getEmail());
				c.setTel(cliente.getTel());
				c.setPasfre(cliente.getPasfre());
				c.setDir(cliente.getDir());
				aux++;
			}
		}
		
		if (aux > 0) {

			this.lista.clear();
			this.lista = listado.stream().collect(Collectors.toList());

			file = new File(PropertiesUtil.obtenerPathArchivoStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathArchivoStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Cliente actualizado correctamente");
		} else {
			System.out.println("Stream -> No se encontraron clientes con el Id: " + cliente.getId());

		}
		
	}

	@Override
	public void EliminarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub

		int id = cliente.getId();
		int oriSize = lista.size();

		lista.removeIf(x -> x.getId() == id);

		if (lista.size() < oriSize) {

			file = new File(PropertiesUtil.obtenerPathArchivoStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathArchivoStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Cliente eliminado correctamente");
		} else {
			System.out.println("Stream -> No se encontraron clientes con el Id: " + cliente.getId());
		}
	}

	@Override
	public List<Cliente> GetAll() throws IOException, ParseException, ClassNotFoundException {
		// TODO Auto-generated method stub

		fis = new FileInputStream(PropertiesUtil.obtenerPathArchivoStream());
		ois = new ObjectInputStream(fis);
		lista = (List<Cliente>) ois.readObject();
		ois.close();

		System.out.println("Clientes leidos del archivo: " + lista.size());

		return lista;

	}

}
