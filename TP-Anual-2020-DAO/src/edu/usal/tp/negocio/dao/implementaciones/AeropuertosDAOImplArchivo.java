package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.interfaces.AeropuertoDAO;

public class AeropuertosDAOImplArchivo implements AeropuertoDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

		archivo = new File("/Users/juan/Desktop/aeropuertos.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveAeropuerto(aeropuerto);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveAeropuerto(Aeropuerto aeropuerto) {
		// TODO Auto-generated method stub
		return aeropuerto.getId() + ";" + aeropuerto.getCiudad() + "\r\n";
	}

	@Override
	public void ModificarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

		List<Aeropuerto> listadoAeropuertos = GetAll();

		for (Aeropuerto a : listadoAeropuertos) {

			if (a.getId() == (aeropuerto.getId())) {

				a.setId(aeropuerto.getId());
				a.setCiudad(aeropuerto.getCiudad());

			}
			AgregarAeropuerto(a);

		}

	}

	@Override
	public void EliminarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

		List<Aeropuerto> listadoAeropuertos = GetAll();

		listadoAeropuertos.removeIf(o -> o.getId() == (aeropuerto.getId()));

		for (Aeropuerto a : listadoAeropuertos) {

			AgregarAeropuerto(a);

		}

	}

	@Override
	public List<Aeropuerto> GetAll() throws IOException {
		// TODO Auto-generated method stub

		archivo = new File(
				"C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//aeropuertos.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Aeropuerto> listadoAeropuertos = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoAeropuertos.add(Parse(linea));
		}

		return listadoAeropuertos;
	}

	private Aeropuerto Parse(String linea) {
		// TODO Auto-generated method stub

		String[] atributos = linea.split(";");

		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.setId(Integer.valueOf(atributos[0]));
		aeropuerto.setCiudad(atributos[1]);

		return aeropuerto;
	}

	@Override
	public Aeropuerto ObtenerAeropuertoPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
