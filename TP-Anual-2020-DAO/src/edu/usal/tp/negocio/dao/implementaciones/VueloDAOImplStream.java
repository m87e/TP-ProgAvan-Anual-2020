package edu.usal.tp.negocio.dao.implementaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelos;
import edu.usal.tp.negocio.dao.interfaces.VuelosDAO;
import edu.usal.tp.negocio.dao.util.PropertiesUtil;

public class VueloDAOImplStream implements VuelosDAO {

	private File file;
	private FileOutputStream fOut;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private List<Vuelos> lista;

	@Override
	public void AgregarVuelo(Vuelos vuelos) throws IOException {
		// TODO Auto-generated method stub

		this.lista.add(vuelos);

		file = new File(PropertiesUtil.obtenerPathVuelosStream());
		file.delete();

		fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVuelosStream()));
		oos = new ObjectOutputStream(fOut);
		oos.writeObject(lista);
		oos.close();

		System.out.println("Stream -> Vuelo agregado correctamente");

	}

	@Override
	public void ModificarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Vuelos> listado = GetAll();
		int aux = 0;

		for (Vuelos v : listado) {

			if (v.getNumVuelo().equals(vuelos.getNumVuelo())) {

				v.setCantAsientos(vuelos.getCantAsientos());
				v.setAeropuertoLlegada(vuelos.getAeropuertoLlegadaID());
				v.setAeropuertoSalida(vuelos.getAeropuertoSalidaID());
				v.setFechaHoraLlegada(vuelos.getFechaHoraLlegada());
				v.setFechaHoraSalida(vuelos.getFechaHoraSalida());
				v.setTiempoVuelo(vuelos.getTiempoVuelo());

				aux++;
			}
		}

		if (aux > 0) {

			this.lista.clear();
			this.lista = listado.stream().collect(Collectors.toList());

			file = new File(PropertiesUtil.obtenerPathVuelosStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVuelosStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Vuelo actualizado correctamente");
		} else {
			System.out.println("Stream -> No se encontraron vuelos con el Id: " + vuelos.getNumVuelo());

		}

	}

	@Override
	public void EliminarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

		int oriSize = lista.size();

		lista.removeIf(x -> x.getNumVuelo() == vuelos.getNumVuelo());

		if (lista.size() < oriSize) {

			file = new File(PropertiesUtil.obtenerPathVuelosStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVuelosStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Vuelo eliminado correctamente");
		} else {
			System.out.println("Stream -> No se encontraron vuelos con el Id: " + vuelos.getNumVuelo());
		}

	}

	@Override
	public List<Vuelos> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub
		fis = new FileInputStream(PropertiesUtil.obtenerPathVuelosStream());
		ois = new ObjectInputStream(fis);
		try {
			lista = (List<Vuelos>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();

		System.out.println("Vuelos leidos del archivo: " + lista.size());

		return lista;
	}

	@Override
	public Vuelos ObtenerVueloPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelos ObtenerVuelosPorNumero(String numVuelo) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
