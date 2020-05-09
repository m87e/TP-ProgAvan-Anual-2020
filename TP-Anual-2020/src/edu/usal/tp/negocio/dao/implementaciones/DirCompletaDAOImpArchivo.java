package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.interfaces.IDirCompletaDAO;

public class DirCompletaDAOImpArchivo implements IDirCompletaDAO{

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//DirCompleta.txt";
	
	@Override
	public void AgregarTelefono(DirCompleta dir) throws IOException {
		archivo = new File (path);

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

	private String SaveDirCompleta(DirCompleta dir) {
		return 		  dir.getID() + 
				";" + dir.getCalle() +
				";" + dir.getAltura() +
				";" + dir.getCiudad() +
				";" + dir.getCodigoPostal() +
				";" + dir.getPais().getId() +
				";" + dir.getProvincia().getId()+ 
				"\r\n";
	}

	@Override
	public void ModificarTelefono(DirCompleta dir) throws IOException {
		List<DirCompleta> listadoDirCompleta = GetAll();
		
		for (DirCompleta dC : listadoDirCompleta) {
			if (dC.getID() == dir.getID()) {
				dC.setID(dir.getID());
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
	public void EliminarTelefono(DirCompleta dir) throws IOException {
		List<DirCompleta> listadoDirCompleta = GetAll();
		
		listadoDirCompleta.removeIf(o -> o.getID() == dir.getID());
		
		for (DirCompleta dC : listadoDirCompleta) {
			AgregarTelefono(dC);
		}
		
	}

	@Override
	public List<DirCompleta> GetAll() throws IOException {
		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<DirCompleta> listadoDirCompleta = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoDirCompleta.add(ParsePasaporte(linea));
		}

		return listadoDirCompleta;
	}

	private DirCompleta ParsePasaporte(String linea) {
		String[] atributos = linea.split(";");
		
		DirCompleta dC = new DirCompleta();

		dC.setID(Integer.valueOf(atributos[0]));
		dC.setCalle(atributos[1]);
		dC.setAltura(atributos[2]);
		dC.setCiudad(atributos[3]);
		dC.setCodigoPostal(atributos[4]);
		dC.setPaisID(atributos[5]);
		dC.setProvinciaID(atributos[6]);
		
		return dC;
	}

}
