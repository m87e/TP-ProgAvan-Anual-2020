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

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.interfaces.IPasaporteDAO;

public class PasaporteDAOImpArchivo implements IPasaporteDAO{

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//Pasaporte.txt";
	
	@Override
	public void AgregarPasarporte(Pasaporte pas) throws IOException {
		archivo = new File (path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SavePasaporte(pas);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();
		
	}

	private String SavePasaporte(Pasaporte pas) {
		return		  pas.getNumeroPasaporte() + 
				";" + pas.getAutoridadEmision() + 
				";" + pas.getFechaEmision() + 
				";" + pas.getFechaVencimiento()+
				";" + pas.getPais().getId()	+ 
				"\r\n";
	}

	@Override
	public void ModificarPasarporte(Pasaporte pas) throws IOException {
		List<Pasaporte> listadoPasaporte = GetAll();
		
		for (Pasaporte p : listadoPasaporte) {
			if (p.getNumeroPasaporte() == pas.getNumeroPasaporte()) {
				p.setNumeroPasaporte(pas.getNumeroPasaporte());
				p.setAutoridadEmision(pas.getAutoridadEmision());
				p.setFechaEmision(pas.getFechaEmision());
				p.setFechaVencimiento(pas.getFechaVencimiento());
				p.setPaisID(pas.getPais().getId());
			}
		}
		
	}

	@Override
	public void EliminarPasarporte(Pasaporte pas) throws IOException {
		List<Pasaporte> listadoPasaporte = GetAll();
		
		listadoPasaporte.removeIf(o -> o.getNumeroPasaporte() == pas.getNumeroPasaporte());
		
		for (Pasaporte p : listadoPasaporte) {
			AgregarPasarporte(p);
		}
		
	}

	@Override
	public List<Pasaporte> GetAll() throws IOException {

		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Pasaporte> listadoPasaportes = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoPasaportes.add(ParsePasaporte(linea));
		}

		return listadoPasaportes;
	}

	private Pasaporte ParsePasaporte(String linea) {
		String[] atributos = linea.split(";");
		
		Pasaporte p = new Pasaporte();
		p.setNumeroPasaporte(atributos[0]);
		p.setAutoridadEmision(atributos[1]);
		p.setFechaEmision(Date.valueOf(atributos[2]));
		p.setFechaVencimiento(Date.valueOf(atributos[3]));
		p.setPaisID(atributos[4]);
		
		return p;
	}

}
