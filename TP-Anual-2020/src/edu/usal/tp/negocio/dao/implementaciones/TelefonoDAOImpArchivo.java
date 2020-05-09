package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;

public class TelefonoDAOImpArchivo implements ITelefonoDAO{
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;
	String path = "C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//telefonos.txt";
 
	
	@Override
	public void AgregarTelefono(Telefono tel) throws IOException {
		
		archivo = new File (path);

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveTelefono(tel);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveTelefono(Telefono tel) {
		return  	  tel.getID()  +
				";" + tel.getNumPersonal() + 
				";" + tel.getNumLaboral()+
				";" + tel.getNumCelular() + 
				"\r\n";
	}

	@Override
	public void ModificarTelefono(Telefono tel) throws IOException {
		List<Telefono> listadoTelefono = GetAll();

		for (Telefono t : listadoTelefono) {

			if (t.getID()==(tel.getID())) {
				t.setID(tel.getID());
				t.setNumCelular(tel.getNumCelular());
				t.setNumPersonal(tel.getNumPersonal());
				t.setNumLaboral(tel.getNumLaboral());
			}

			AgregarTelefono(t);

		}

	}

	@Override
	public void EliminarTelefono(Telefono tel) throws IOException {
		List<Telefono> listadoTelefono = GetAll();
		
		listadoTelefono.removeIf(o -> o.getID()==(tel.getID()));
		
		for (Telefono t : listadoTelefono) {
			AgregarTelefono(t);
		}

	}

	@Override
	public List<Telefono> GetAll() throws IOException {
		archivo = new File(path);
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Telefono> listadoTelefonos = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoTelefonos.add(Parse(linea));
		}

		return listadoTelefonos;
	}

	private Telefono Parse(String linea) {
		String[] atributos = linea.split(";");

		Telefono telefono = new Telefono();
		telefono.setID(Integer.valueOf(atributos[0]));
		telefono.setNumPersonal(atributos[1]);
		telefono.setNumLaboral(atributos[2]);
		telefono.setNumCelular(atributos[3]);
		
		return telefono;
	}
}
