package edu.usal.tp.negocio.dao.implementaciones;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;

public class PaisesDAOImplArchivo implements IPaisesDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarPais(Paises pais) throws IOException {

		archivo = new File("/Users/juan/Desktop/paises.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SavePais(pais);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SavePais(Paises pais) {
		return 		  pais.getId() + 
				";" + pais.getNombre() + 
				"\r\n";

	}

	@Override
	public void ModificarPais(Paises oldPais, Paises newPais) throws IOException {

		List<Paises> listadoPaises = GetAll();

		for (Paises p : listadoPaises) {

			if (p.getId().equals(oldPais.getId())) {
				p.setId(newPais.getId());
				p.setNombre(newPais.getNombre());
			}

			AgregarPais(p);

		}

	}

	@Override
	public void EliminarPais(Paises pais) throws IOException {

		List<Paises> listadoPaises = GetAll();

		listadoPaises.removeIf(o -> o.getId().equals(pais.getId()));

		for (Paises p : listadoPaises) {

			AgregarPais(p);

		}

	}

	@Override
	public List<Paises> GetAll() throws IOException {

		archivo = new File("/Users/juan/Desktop/paises.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Paises> listadoPaises = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoPaises.add(ParsePais(linea));
		}

		return listadoPaises;

	}

	private Paises ParsePais(String linea) {

		String[] atributos = linea.split(";");

		Paises pais = new Paises();
		pais.setId(atributos[0]);
		pais.setNombre(atributos[1]);

		return pais;

	}

}
