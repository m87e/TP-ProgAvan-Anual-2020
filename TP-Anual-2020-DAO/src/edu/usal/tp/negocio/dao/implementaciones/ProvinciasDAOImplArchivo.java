package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;

public class ProvinciasDAOImplArchivo implements ProvinciasDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarProvincia(Provincia provincia) throws IOException {

		archivo = new File("provincias.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveProvincia(provincia);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveProvincia(Provincia provincia) {
		return provincia.getId() + ";" + provincia.getNombre() + "\r\n";
	}

	@Override
	public void ModificarProvincia(Provincia provincia) throws IOException {
		// TODO Auto-generated method stub

		List<Provincia> listadoProvincias = GetAll();

		for (Provincia p : listadoProvincias) {

			if (p.getId() == (provincia.getId())) {
				p.setId(provincia.getId());
				p.setNombre(provincia.getNombre());
			}

			AgregarProvincia(p);

		}

	}

	@Override
	public void EliminarProvincia(Provincia provincia) throws IOException {

		List<Provincia> listadoProvincias = GetAll();

		listadoProvincias.removeIf(o -> o.getId() == (provincia.getId()));

		for (Provincia p : listadoProvincias) {
			AgregarProvincia(p);
		}

	}

	@Override
	public List<Provincia> GetAll() throws IOException {

		// ajustarlo al config.propiertes
		archivo = new File(
				"C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//provincias.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Provincia> listadoProvincias = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoProvincias.add(Parse(linea));
		}

		return listadoProvincias;
	}

	private Provincia Parse(String linea) {

		String[] atributos = linea.split(";");

		Provincia provincia = new Provincia();
		provincia.setId(Integer.valueOf(atributos[0]));
		provincia.setNombre(atributos[1]);

		return provincia;
	}

	@Override
	public Provincia ObtenerProvinciaPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
