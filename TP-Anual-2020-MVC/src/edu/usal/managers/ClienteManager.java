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

			this.pasaporteDAODatabase.AgregarPasaporte(p, con);
			con.commit();
			c.setPas(p);

			this.telefonoDAODatabase.AgregarTelefono(tel, con);
			con.commit();
			c.setTel(tel);

			this.dirCompletaDAODatabase.AgregarDirCompleta(dir, con);
			con.commit();
			c.setDir(dir);

			this.pasajeroFrecuenteDAODatabase.AgregarPasajeroFrecuente(pasFrec, con);
			con.commit();
			c.setPasfre(pasFrec);

			this.clienteDAODatabase.AgregarCliente(c, con);
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Transaction is being rolled back");
			}
		}

	}

}
