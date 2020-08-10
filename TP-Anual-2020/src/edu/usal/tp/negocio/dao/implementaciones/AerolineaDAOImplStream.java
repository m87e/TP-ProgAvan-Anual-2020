package edu.usal.tp.negocio.dao.implementaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;
import edu.usal.tp.negocio.dao.util.PropertiesUtil;

public class AerolineaDAOImplStream implements IAerolineaDAO {

	private File file;
	private FileOutputStream fOut;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private List<Aerolinea> lista;

	@Override
	public void AgregarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		this.lista.add(aerolinea);

		file = new File(PropertiesUtil.obtenerPathAerolineasStream());
		file.delete();

		fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
		oos = new ObjectOutputStream(fOut);
		oos.writeObject(lista);
		oos.close();

		System.out.println("Stream -> Aerolinea agregada correctamente");

	}

	@Override
	public void ModificarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		int aux = 0;
		List<Aerolinea> listado = GetAll();

		for (Aerolinea a : listado) {
			if (a.getId().equals(aerolinea.getId())) {

				a.setNombre(aerolinea.getNombre());
				a.setAlianza(aerolinea.getAlianza());
				a.setVuelos(aerolinea.getVuelos());
				aux++;
			}
		}

		if (aux > 0) {

			this.lista.clear();
			this.lista = listado.stream().collect(Collectors.toList());

			file = new File(PropertiesUtil.obtenerPathAerolineasStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Aerolinea actualizada correctamente");
		} else {
			System.out.println("Stream -> No se encontraron aerolineas con el Id: " + aerolinea.getId());

		}
	}

	@Override
	public void EliminarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		int oriSize = lista.size();

		lista.removeIf(x -> x.getId() == aerolinea.getId());

		if (lista.size() < oriSize) {

			file = new File(PropertiesUtil.obtenerPathAerolineasStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Aerolinea eliminada correctamente");
		} else {
			System.out.println("Stream -> No se encontraron aerolineas con el Id: " + aerolinea.getId());
		}

	}

	@Override
	public List<Aerolinea> GetAll() throws IOException {
		// TODO Auto-generated method stub
		fis = new FileInputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ois = new ObjectInputStream(fis);
		try {
			lista = (List<Aerolinea>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();

		System.out.println("Aerolineas leidas del archivo: " + lista.size());

		return lista;
	}

}
