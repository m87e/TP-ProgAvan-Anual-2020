package edu.usal.managers;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.ClientesFactory;
import edu.usal.tp.negocio.dao.factory.DirCompletaFactory;
import edu.usal.tp.negocio.dao.factory.PasajeroFrecuenteFactory;
import edu.usal.tp.negocio.dao.factory.PasaporteFactory;
import edu.usal.tp.negocio.dao.factory.TelefonoFactory;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.tp.negocio.dao.interfaces.DirCompletaDAO;
import edu.usal.tp.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.tp.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.tp.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;
import edu.usal.views.console.ClienteView;

public class ClienteManager {

	private ClienteDAO clienteDAODatabase = ClientesFactory.GetImplementation("database");
	private PasaporteDAO pasaporteDAODatabase = PasaporteFactory.GetImplementation("database");
	private TelefonoDAO telefonoDAODatabase = TelefonoFactory.GetImplementation("database");
	private PasajeroFrecuenteDAO pasajeroFrecuenteDAODatabase = PasajeroFrecuenteFactory.GetImplementation("database");
	private DirCompletaDAO dirCompletaDAODatabase = DirCompletaFactory.GetImplementation("database");

	public void cargarCliente(Cliente c, Pasaporte p, Telefono tel, DireccionCompleta dir, PasajeroFrecuente pasFrec)
			throws IOException, ParseException {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.dirCompletaDAODatabase.AgregarDirCompleta(dir, con);
			System.out.println("Direccion agregada - Operacion completada");
			c.setDireccionCompleta(dir);

			this.pasaporteDAODatabase.AgregarPasaporte(p, con);
			System.out.println("Pasaporte agregado - Operacion completada");
			c.setPasaporte(p);

			this.telefonoDAODatabase.AgregarTelefono(tel, con);
			System.out.println("Telefono agregado - Operacion completada");
			c.setTelefono(tel);

			this.pasajeroFrecuenteDAODatabase.AgregarPasajeroFrecuente(pasFrec, con);
			System.out.println("Pasajero frecuente agregado - Operacion completada");
			c.setPasajeroFrecuente(pasFrec);

			this.clienteDAODatabase.AgregarCliente(c, con);
			con.commit();
			System.out.println("Cliente agregado - Operacion completada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar los datos en la base de datos");
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
