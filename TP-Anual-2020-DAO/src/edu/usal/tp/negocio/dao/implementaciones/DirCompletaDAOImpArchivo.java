package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.interfaces.DirCompletaDAO;

public class DirCompletaDAOImpArchivo implements DirCompletaDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//DirCompleta.txt";

	@Override
	public void AgregarDirCompleta(DireccionCompleta dir, Connection con) throws IOException {
		archivo = new File(path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveDirCompleta(dir);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveDirCompleta(DireccionCompleta dir) {
		return dir.getId() + ";" + dir.getCalle() + ";" + dir.getAltura() + ";" + dir.getCiudad() + ";"
				+ dir.getCodigoPostal() + ";" + dir.getPais().getId() + ";" + dir.getProvincia().getId() + "\r\n";
	}

	@Override
	public void ModificarDirCompleta(DireccionCompleta dir) throws IOException {
		List<DireccionCompleta> listadoDirCompleta = GetAll();

		for (DireccionCompleta dC : listadoDirCompleta) {
			if (dC.getId() == dir.getId()) {
				dC.setId(dir.getId());
				dC.setCalle(dir.getCalle());
				dC.setAltura(dir.getAltura());
				dC.setCiudad(dir.getCiudad());
				dC.setCodigoPostal(dir.getCodigoPostal());
				dC.setPaisID(dir.getPais().getId());
				dC.setProvinciaID(dir.getProvincia().getId());
			}
		}

	}

	@Override
	public void EliminarDirCompleta(DireccionCompleta dir) throws IOException {
		List<DireccionCompleta> listadoDirCompleta = GetAll();

		listadoDirCompleta.removeIf(o -> o.getId() == dir.getId());

		for (DireccionCompleta dC : listadoDirCompleta) {
			AgregarDirCompleta(dC, null);
		}

	}

	@Override
	public List<DireccionCompleta> GetAll() throws IOException {
		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<DireccionCompleta> listadoDirCompleta = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoDirCompleta.add(ParsePasaporte(linea));
		}

		return listadoDirCompleta;
	}

	private DireccionCompleta ParsePasaporte(String linea) {
		String[] atributos = linea.split(";");

		DireccionCompleta dC = new DireccionCompleta();

		dC.setId(Integer.valueOf(atributos[0]));
		dC.setCalle(atributos[1]);
		dC.setAltura(atributos[2]);
		dC.setCiudad(atributos[3]);
		dC.setCodigoPostal(atributos[4]);
		dC.setPaisID(Integer.valueOf(atributos[5]));
		dC.setProvinciaID(Integer.valueOf(atributos[6]));

		return dC;
	}

	@Override
	public DireccionCompleta ObtenerDirCompletaPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
