package edu.usal.tp.negocio.dao.implementaciones;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;

public class AerolineaDAOImplArchivo implements IAerolineaDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarAerolinea(Aerolinea aerolinea) throws IOException {

		archivo = new File("/Users/juan/Desktop/aerolineas.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveAerolinea(aerolinea);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveAerolinea(Aerolinea aerolinea) {
		return 	 	  aerolinea.getId() + 
				";" + aerolinea.getNombre() + 
				";" + aerolinea.getAlianza() + 
				"\r\n";
	}

	@Override
	public void ModificarAerolinea(Aerolinea oldAerolinea, Aerolinea newAerolinea) throws IOException {

		List<Aerolinea> listadoAerolineas = GetAll();

		for (Aerolinea a : listadoAerolineas) {

			if (a.getId().equals(oldAerolinea.getId())) {
				a.setId(newAerolinea.getId());
				a.setNombre(newAerolinea.getNombre());
				a.setAlianza(newAerolinea.getAlianza());
			}

			AgregarAerolinea(a);
		}
	}

	@Override
	public void EliminarAerolinea(Aerolinea aerolinea) throws IOException {

		List<Aerolinea> listadoAerolineas = GetAll();

		listadoAerolineas.removeIf(o -> o.getId().equals(aerolinea.getId()));

		for (Aerolinea a : listadoAerolineas) {

			AgregarAerolinea(a);
		}

	}

	@Override
	public List<Aerolinea> GetAll() throws IOException {

		archivo = new File("/Users/juan/Desktop/aerolineas.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;

		List<Aerolinea> listadoAerolineas = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoAerolineas.add(parseAerolinea(linea));
		}

		return null;

	}

	private Aerolinea parseAerolinea(String linea) {

		String[] atributos = linea.split(";");

		Aerolinea aerolinea = new Aerolinea();
		aerolinea.setId(atributos[0]);
		aerolinea.setNombre(atributos[1]);
		aerolinea.setAlianza(atributos[2]);

		return aerolinea;
	}

}
