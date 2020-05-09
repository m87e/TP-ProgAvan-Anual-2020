package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Vuelos;
import edu.usal.tp.negocio.dao.interfaces.IVuelosDAO;

public class VueloDAOImplArchivo implements IVuelosDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	String path = "/Users/juan/Desktop/vuelos.txt"; 
	@Override
	public void AgregarVuelo(Vuelos vuelos) throws IOException {
		// TODO Auto-generated method stub
		archivo = new File(path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveVuelos(vuelos);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveVuelos(Vuelos vuelos) {
		
		return 		  vuelos.getNumVuelo() + 
				";" + vuelos.getAeropuertoSalida().getIdAeropuerto() + 
				";" + vuelos.getAeropuertoLlegada().getIdAeropuerto() + 
				";" + vuelos.getFechaHoraSalida().toString() + 
				";"	+ vuelos.getFechaHoraLlegada().toString() + 
				";" + vuelos.getTiempoVuelo() + 
				"\r\n";
	}

	@Override
	public void ModificarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Vuelos> listadoVuelos = GetAll();

		for (Vuelos v : listadoVuelos) {

			if (v.getNumVuelo().equals(vuelos.getNumVuelo())) {

				v.setNumVuelo(vuelos.getNumVuelo());
				v.setAeropuertoSalida(vuelos.getAeropuertoSalida());
				v.setAeropuertoLlegada(vuelos.getAeropuertoLlegada());
				v.setFechaHoraSalida(vuelos.getFechaHoraSalida());
				v.setFechaHoraLlegada(vuelos.getFechaHoraLlegada());
				v.setTiempoVuelo(vuelos.getTiempoVuelo());

			}

			AgregarVuelo(v);

		}

	}

	@Override
	public void EliminarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Vuelos> listadoVuelos = GetAll();

		listadoVuelos.removeIf(o -> o.getNumVuelo().equals(vuelos.getNumVuelo()));

		for (Vuelos v : listadoVuelos) {
			AgregarVuelo(v);
		}

	}

	@Override
	public List<Vuelos> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub

		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Vuelos> listadoVuelos = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoVuelos.add(ParseVuelo(linea));
		}

		return listadoVuelos;
	}

	private Vuelos ParseVuelo(String linea) throws ParseException {
		// TODO Auto-generated method stub

		String[] atributos = linea.split(";");

		Vuelos vuelo = new Vuelos();
		vuelo.setNumVuelo(atributos[0]);
		vuelo.setAeropuertoSalida(atributos[1]);
		vuelo.setAeropuertoLlegada(atributos[2]);
		vuelo.setFechaHoraSalida(new SimpleDateFormat("dd/MM/yyyy").parse(atributos[3]));
		vuelo.setFechaHoraLlegada(new SimpleDateFormat("dd/MM/yyyy").parse(atributos[4]));
		vuelo.setTiempoVuelo(atributos[5]);

		return vuelo;
	}

}
