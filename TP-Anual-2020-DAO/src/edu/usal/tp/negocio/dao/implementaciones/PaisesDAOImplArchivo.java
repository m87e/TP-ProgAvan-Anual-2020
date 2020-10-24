package edu.usal.tp.negocio.dao.implementaciones;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;

public class PaisesDAOImplArchivo implements PaisesDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarPais(Pais pais) throws IOException {

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

	private String SavePais(Pais pais) {
		return pais.getId() + ";" + pais.getNombre() + "\r\n";

	}

	@Override
	public void ModificarPais(Pais oldPais, Pais newPais) throws IOException {

		List<Pais> listadoPaises = GetAll();

		for (Pais p : listadoPaises) {

			if (p.getId() == (oldPais.getId())) {
				p.setId(newPais.getId());
				p.setNombre(newPais.getNombre());
			}

			AgregarPais(p);

		}

	}

	@Override
	public void EliminarPais(Pais pais) throws IOException {

		List<Pais> listadoPaises = GetAll();

		listadoPaises.removeIf(o -> o.getId() == (pais.getId()));

		for (Pais p : listadoPaises) {

			AgregarPais(p);

		}

	}

	@Override
	public List<Pais> GetAll() throws IOException {

		archivo = new File("/Users/juan/Desktop/paises.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Pais> listadoPaises = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoPaises.add(ParsePais(linea));
		}

		return listadoPaises;

	}

	private Pais ParsePais(String linea) {

		String[] atributos = linea.split(";");

		Pais pais = new Pais();
		pais.setId(Integer.valueOf(atributos[0]));
		pais.setNombre(atributos[1]);

		return pais;

	}

	@Override
	public Pais ObtenerPaisPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
