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
import java.util.Date;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelos;
import edu.usal.tp.negocio.dao.interfaces.IVentaDAO;

public class VentaDAOImplArchivo implements IVentaDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarVenta(Venta venta) throws IOException {
		// TODO Auto-generated method stub

		archivo = new File("/Users/juan/Desktop/ventas.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveVenta(venta);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();
	}

	private String SaveVenta(Venta venta) {
		return 		  venta.getId() + 
				";" + venta.getCliID() + 
				";" + venta.getVueID() + 
				";" + venta.getAeroID() + 
				";"	+ venta.getFechaHoraVenta().toString() + 
				";" + venta.getFormaPago() + 
				"\r\n";
	}

	@Override
	public void ModificarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Venta> listadoVentas = GetAll();

		for (Venta v : listadoVentas) {
			if (v.getId() == venta.getId()) {

				v.setId(venta.getId());
				v.setCli(venta.getCli());
				v.setVue(venta.getVue());
				v.setAero(venta.getAero());
				v.setFechaHoraVenta(venta.getFechaHoraVenta());
				v.setFormaPago(venta.getFormaPago());

			}
			AgregarVenta(v);
		}

	}

	@Override
	public void EliminarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Venta> listadoVentas = GetAll();

		listadoVentas.removeIf(o -> o.getId() == venta.getId());

		for (Venta v : listadoVentas) {

			AgregarVenta(v);

		}

	}

	@Override
	public List<Venta> GetAll() throws IOException, ParseException {

		archivo = new File("/Users/juan/Desktop/ventas.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Venta> listadoVenta = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoVenta.add(ParseVenta(linea));
		}

		return listadoVenta;
	}

	private Venta ParseVenta(String linea) throws ParseException {
		// TODO Auto-generated method stub

		String[] atributos = linea.split(";");
		Venta venta = new Venta();
		venta.setId(Integer.valueOf(atributos[0]));
		venta.setCliID(Integer.valueOf(atributos[1]));
		venta.setVueID(atributos[2]);
		venta.setAeroID(atributos[3]);
		venta.setFechaHoraVenta(new SimpleDateFormat("dd/MM/yyyy").parse(atributos[4]));
		venta.setFormaPago(atributos[5]);

		return venta;
	}

}
