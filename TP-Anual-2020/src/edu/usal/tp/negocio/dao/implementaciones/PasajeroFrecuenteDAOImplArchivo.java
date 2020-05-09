package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.IPasajeroFrecuenteDAO;

public class PasajeroFrecuenteDAOImplArchivo implements IPasajeroFrecuenteDAO {
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//PasajeroFrecuente.txt";
	
	@Override
	public void AgregarPasarporte(PasajeroFrecuente pasFre) throws IOException {
		archivo = new File (path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SavePasajeroFrecuente(pasFre);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();
	}

	private String SavePasajeroFrecuente(PasajeroFrecuente pasFre) {
		return 		  pasFre.getNumero() +
				";" + pasFre.getCategoria() + 
				";" + pasFre.getAlianza()+ 
				";" + pasFre.getAerolinea().getId()	+ 
				"\r\n";
	}

	@Override
	public void ModificarPasarporte(PasajeroFrecuente pasFre) throws IOException {
		List<PasajeroFrecuente> listadoPasajeroFrecuente = GetAll();

		for (PasajeroFrecuente pF : listadoPasajeroFrecuente) {

			if (pF.getNumero()==(pasFre.getNumero())) {
				pF.setNumero(pasFre.getNumero());
				pF.setCategoria(pasFre.getCategoria());
				pF.setCategoria(pasFre.getCategoria());
				pF.setAerolineaID(pasFre.getAerolinea().getId());
			}

			AgregarPasarporte(pF);

		}
		
	}
	@Override
	public void EliminarPasarporte(PasajeroFrecuente pasFre) throws IOException {
		List<PasajeroFrecuente> listadoPasajeroFrecuentes = GetAll();
		
		listadoPasajeroFrecuentes.removeIf(o -> o.getNumero() == pasFre.getNumero());
		
		for (PasajeroFrecuente pF : listadoPasajeroFrecuentes) {
			AgregarPasarporte(pF);
		}
		
	}
	@Override
	public List<PasajeroFrecuente> GetAll() throws IOException {
		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<PasajeroFrecuente> listadoPasajeroFrecuentes = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoPasajeroFrecuentes.add(ParsePasajeroFrecuente(linea));
		}

		return listadoPasajeroFrecuentes;
	}

	private PasajeroFrecuente ParsePasajeroFrecuente(String linea) {
		
		String[] atributos = linea.split(";");
		
		PasajeroFrecuente pF = new PasajeroFrecuente();

		pF.setNumero(atributos[0]);
		pF.setCategoria(atributos[1]);
		pF.setCategoria(atributos[2]);
		pF.setAerolineaID(atributos[3]);
		
		return pF;
	}
}
