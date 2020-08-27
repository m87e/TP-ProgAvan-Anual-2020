package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Venta;

public interface IVentaDAO {

	void AgregarVenta(Venta venta) throws IOException;

	void ModificarVenta(Venta venta) throws IOException, ParseException;

	void EliminarVenta(Venta venta) throws IOException, ParseException;

	List<Venta> GetAll() throws IOException, ParseException;

}
