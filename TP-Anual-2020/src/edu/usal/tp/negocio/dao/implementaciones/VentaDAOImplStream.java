package edu.usal.tp.negocio.dao.implementaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.interfaces.IVentaDAO;
import edu.usal.tp.negocio.dao.util.PropertiesUtil;

public class VentaDAOImplStream implements IVentaDAO {

	private File file;
	private FileOutputStream fOut;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private List<Venta> lista;

	@Override
	public void AgregarVenta(Venta venta) throws IOException {
		// TODO Auto-generated method stub

		this.lista.add(venta);
		file = new File(PropertiesUtil.obtenerPathVentasStream());
		file.delete();

		fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVentasStream()));
		oos = new ObjectOutputStream(fOut);
		oos.writeObject(lista);
		oos.close();

		System.out.println("Stream -> Venta agregada correctamente");

	}

	@Override
	public void ModificarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub

		List<Venta> listado = GetAll();
		int aux = 0;

		for (Venta v : listado) {
			if (v.getId() == venta.getId()) {

				v.setAeroID(venta.getAeroID());
				v.setCli(venta.getCli());
				v.setFechaHoraVenta(venta.getFechaHoraVenta());
				v.setFormaPago(venta.getFormaPago());
				v.setVueID(venta.getVueID());
				aux++;
			}
		}

		if (aux > 0) {

			this.lista.clear();
			this.lista = listado.stream().collect(Collectors.toList());

			file = new File(PropertiesUtil.obtenerPathVentasStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVentasStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Venta actualizada correctamente");
		} else {
			System.out.println("Stream -> No se encontraron ventas con el Id: " + venta.getId());

		}

	}

	@Override
	public void EliminarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub

		int oriSize = lista.size();

		lista.removeIf(x -> x.getId() == venta.getId());

		if (lista.size() < oriSize) {

			file = new File(PropertiesUtil.obtenerPathVentasStream());
			file.delete();

			fOut = new FileOutputStream(new File(PropertiesUtil.obtenerPathVentasStream()));
			oos = new ObjectOutputStream(fOut);
			oos.writeObject(lista);
			oos.close();

			System.out.println("Stream -> Venta eliminada correctamente");
		} else {
			System.out.println("Stream -> No se encontraron ventas con el Id: " + venta.getId());
		}

	}

	@Override
	public List<Venta> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub
		fis = new FileInputStream(PropertiesUtil.obtenerPathVentasStream());
		ois = new ObjectInputStream(fis);
		try {
			lista = (List<Venta>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();

		System.out.println("Ventas leidas del archivo: " + lista.size());

		return lista;
	}

}
