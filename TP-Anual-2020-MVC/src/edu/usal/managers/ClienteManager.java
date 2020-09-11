package edu.usal.managers;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DirCompleta;
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
import edu.usal.views.console.ClienteView;

public class ClienteManager {

	private IClienteDAO clienteDAODatabase = ClientesFactory.GetImplementation("database");
	private IPasaporteDAO pasaporteDAODatabase = PasaporteFactory.GetImplementation("database");
	private ITelefonoDAO telefonoDAODatabase = TelefonoFactory.GetImplementation("database");
	private IPasajeroFrecuenteDAO pasajeroFrecuenteDAODatabase = PasajeroFrecuenteFactory.GetImplementation("database");
	private IDirCompletaDAO dirCompletaDAODatabase = DirCompletaFactory.GetImplementation("database");
	private ClienteView view;

	public void cargarCliente() throws IOException, ParseException {

		Cliente c = this.view.cargarCliente();

		// String numeroPasaporte = this.view.obtenerPasaporte();
		String numeroPasaporte = null;
		Pasaporte p = this.pasaporteDAODatabase.ObtenerPasaportePorNumero(numeroPasaporte);
		c.setPas(p);

		int id = this.view.obtenerTelefono();
		Telefono tel = this.telefonoDAODatabase.ObtenerTelefonoPorID(id);
		c.setTel(tel);

		int idDir = this.view.obtenerDir();
		DirCompleta dir = this.dirCompletaDAODatabase.ObtenerDirCompletaPorID(idDir);

		// AGREGAR LO DEL COMMIT
		this.clienteDAODatabase.AgregarCliente(c);

	}

}
