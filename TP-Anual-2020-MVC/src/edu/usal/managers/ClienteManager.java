package edu.usal.managers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.ClientesFactory;
import edu.usal.tp.negocio.dao.factory.DirCompletaFactory;
import edu.usal.tp.negocio.dao.factory.PasajeroFrecuenteFactory;
import edu.usal.tp.negocio.dao.factory.PasaporteFactory;
import edu.usal.tp.negocio.dao.factory.TelefonoFactory;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;
import edu.usal.tp.negocio.dao.interfaces.IDirCompletaDAO;
import edu.usal.tp.negocio.dao.interfaces.IPasajeroFrecuenteDAO;
import edu.usal.tp.negocio.dao.interfaces.IPasaporteDAO;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;
import edu.usal.views.console.ClienteView;

public class ClienteManager {

	private IClienteDAO clienteDAODatabase = ClientesFactory.GetImplementation("database");
	private IPasaporteDAO pasaporteDAODatabase = PasaporteFactory.GetImplementation("database");
	private ITelefonoDAO telefonoDAODatabase = TelefonoFactory.GetImplementation("database");
	private IPasajeroFrecuenteDAO pasajeroFrecuenteDAODatabase = PasajeroFrecuenteFactory.GetImplementation("database");
	private IDirCompletaDAO dirCompletaDAODatabase = DirCompletaFactory.GetImplementation("database");

	public void cargarCliente(Cliente c, Pasaporte p, Telefono tel, DirCompleta dir, PasajeroFrecuente pasFrec)
			throws IOException, ParseException {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.dirCompletaDAODatabase.AgregarDirCompleta(dir, con);
			System.out.println("Direccion agregada - Operacion completada");
			c.setDir(dir);

			this.pasaporteDAODatabase.AgregarPasaporte(p, con);
			System.out.println("Pasaporte agregado - Operacion completada");
			c.setPas(p);

			this.telefonoDAODatabase.AgregarTelefono(tel, con);
			System.out.println("Telefono agregado - Operacion completada");
			c.setTel(tel);

			this.pasajeroFrecuenteDAODatabase.AgregarPasajeroFrecuente(pasFrec, con);
			System.out.println("Pasajero frecuente agregado - Operacion completada");
			c.setPasfre(pasFrec);

			this.clienteDAODatabase.AgregarCliente(c, con);
			con.commit();
			System.out.println("Cliente agregado - Operacion completada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Transaction is being rolled back");
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
