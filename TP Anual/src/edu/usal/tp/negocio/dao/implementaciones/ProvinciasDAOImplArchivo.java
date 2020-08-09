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

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;

public class ProvinciasDAOImplArchivo implements IProvinciasDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarProvincia(Provincias provincia) throws IOException {

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

	private String SaveProvincia(Provincias provincia) {
		return 		  provincia.getId() + 
				";" + provincia.getNombre() + 
				"\r\n";
	}

	@Override
	public void ModificarProvincia(Provincias oldProvincia, Provincias newPovincia) throws IOException {
		// TODO Auto-generated method stub

		List<Provincias> listadoProvincias = GetAll();

		for (Provincias p : listadoProvincias) {

			if (p.getId().equals(oldProvincia.getId())) {
				p.setId(newPovincia.getId());
				p.setNombre(newPovincia.getNombre());
			}

			AgregarProvincia(p);

		}

	}

	@Override
	public void EliminarProvincia(Provincias provincia) throws IOException {

		List<Provincias> listadoProvincias = GetAll();

		listadoProvincias.removeIf(o -> o.getId().equals(provincia.getId()));

		for (Provincias p : listadoProvincias) {
			AgregarProvincia(p);
		}

	}

	@Override
	public List<Provincias> GetAll() throws IOException {

		// ajustarlo al config.propiertes
		archivo = new File(
				"C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//provincias.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Provincias> listadoProvincias = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoProvincias.add(Parse(linea));
		}

		return listadoProvincias;
	}

	private Provincias Parse(String linea) {

		String[] atributos = linea.split(";");

		Provincias provincia = new Provincias();
		provincia.setId(atributos[0]);
		provincia.setNombre(atributos[1]);

		return provincia;
	}

}
