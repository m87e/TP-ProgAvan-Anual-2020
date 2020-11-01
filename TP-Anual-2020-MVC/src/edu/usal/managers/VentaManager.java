package edu.usal.managers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

}
