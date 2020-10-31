package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Venta;

public interface VentaDAO {

	void AgregarVenta(Venta venta, Connection con) throws IOException;

	void ModificarVenta(Venta venta, Connection con) throws IOException, ParseException;

	void EliminarVenta(Venta venta, Connection con) throws IOException, ParseException;

	Venta ObtenerVentaPorID(int id) throws IOException;

	List<Venta> GetAll() throws IOException, ParseException;

}
