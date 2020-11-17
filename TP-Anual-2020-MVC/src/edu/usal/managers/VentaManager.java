package edu.usal.managers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.ClienteFactory;
import edu.usal.tp.negocio.dao.factory.VentaFactory;
import edu.usal.tp.negocio.dao.factory.VueloFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.tp.negocio.dao.interfaces.VentaDAO;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class VentaManager {

	private VentaDAO ventaDAODatabase = VentaFactory.GetImplementation("database");
	private ClienteDAO clienteDAODatabase = ClienteFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	private VueloDAO vueloDAODatabase = VueloFactory.GetImplementation("database");

	public void AltaVenta(Venta venta, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea, LocalDate fechaHoraVenta,
			String formaPago) {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			Cliente c = this.clienteDAODatabase.ObtenerClientePorDNI(cliente.getDni());
			venta.setCliente(c);

			Vuelo v = this.vueloDAODatabase.ObtenerVuelosPorNumero(vuelo.getNumVuelo());
			venta.setVuelo(v);

			Aerolinea a = this.aerolineaDAODatabase.ObtenerAerolineaPorID(aerolinea.getId());
			venta.setAerolinea(a);

			venta.setFechaHoraVenta(fechaHoraVenta);
			venta.setFormaPago(formaPago);

			this.ventaDAODatabase.AgregarVenta(venta, con);
			con.commit();
			System.out.println("Venta agregada - Operacion completada");

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos en la base de datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void ModificacionVenta(Venta venta) {
		Connection con = null;

		try {

			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			Cliente cliente = this.clienteDAODatabase.ObtenerClientePorDNI(venta.getCliente().getDni());
			venta.setCliente(cliente);

			Vuelo vuelo = this.vueloDAODatabase.ObtenerVuelosPorNumero(venta.getVuelo().getNumVuelo());
			venta.setVuelo(vuelo);

			Aerolinea aerolinea = this.aerolineaDAODatabase.ObtenerAerolineaPorID(venta.getAerolinea().getId());
			venta.setAerolinea(aerolinea);

			this.ventaDAODatabase.ModificarVenta(venta, con);
			con.commit();
			System.out.println("Venta agregada - Operacion completada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos en la base de datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al parsear los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void BajaVenta(Venta venta) {

		Connection con = null;

		try {

			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.ventaDAODatabase.EliminarVenta(venta, con);
			con.commit();

			System.out.println("Venta eliminada - Operacion completada");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos en la base de datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al parsear los datos en la base de datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
