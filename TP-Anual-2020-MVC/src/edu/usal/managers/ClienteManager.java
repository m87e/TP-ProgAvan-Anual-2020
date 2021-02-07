package edu.usal.managers;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.ClienteFactory;
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

public class ClienteManager {

	private ClienteDAO clienteDAODatabase = ClienteFactory.GetImplementation("database");
	private PasaporteDAO pasaporteDAODatabase = PasaporteFactory.GetImplementation("database");
	private TelefonoDAO telefonoDAODatabase = TelefonoFactory.GetImplementation("database");
	private PasajeroFrecuenteDAO pasajeroFrecuenteDAODatabase = PasajeroFrecuenteFactory.GetImplementation("database");
	private DirCompletaDAO dirCompletaDAODatabase = DirCompletaFactory.GetImplementation("database");

	public void AltaCliente(Cliente cliente, Pasaporte pasaporte, Telefono telefono, DireccionCompleta direccion,
			PasajeroFrecuente pasFrec) throws ParseException {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.dirCompletaDAODatabase.AgregarDirCompleta(direccion, con);
			System.out.println("Direccion agregada - Operacion completada");
			cliente.setDireccionCompleta(direccion);

			this.pasaporteDAODatabase.AgregarPasaporte(pasaporte, con);
			System.out.println("Pasaporte agregado - Operacion completada");
			cliente.setPasaporte(pasaporte);

			this.telefonoDAODatabase.AgregarTelefono(telefono, con);
			System.out.println("Telefono agregado - Operacion completada");
			cliente.setTelefono(telefono);

			this.pasajeroFrecuenteDAODatabase.AgregarPasajeroFrecuente(pasFrec, con);
			System.out.println("Pasajero frecuente agregado - Operacion completada");
			cliente.setPasajeroFrecuente(pasFrec);

			this.clienteDAODatabase.AgregarCliente(cliente, con);
			con.commit();
			System.out.println("Cliente agregado - Operacion completada");

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

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void ModificacionCliente(Cliente cliente, Pasaporte pasaporte, Telefono telefono,
			DireccionCompleta direccion, PasajeroFrecuente pasFrec) throws ParseException {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.dirCompletaDAODatabase.ModificarDirCompleta(direccion, con);
			System.out.println("Direccion modificada - Operacion completada");
			cliente.setDireccionCompleta(direccion);

			this.pasaporteDAODatabase.ModificarPasaporte(pasaporte, con);
			System.out.println("Pasaporte actualizado - Operacion completada");
			cliente.setPasaporte(pasaporte);

			this.telefonoDAODatabase.ModificarTelefono(telefono, con);
			System.out.println("Telefono actualizado - Operacion completada");
			cliente.setTelefono(telefono);

			this.pasajeroFrecuenteDAODatabase.ModificarPasajeroFrecuente(pasFrec, con);
			System.out.println("Pasajero frecuente actualizado - Operacion completada");
			cliente.setPasajeroFrecuente(pasFrec);

			this.clienteDAODatabase.ModificarCliente(cliente, con);
			con.commit();
			System.out.println("Cliente actualizado - Operacion completada");

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

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public void BajaCliente(Cliente cli) {
		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);
			
			
			this.clienteDAODatabase.EliminarCliente(cli, con);
			con.commit();
			
			
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
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	 public List<Cliente> MostrarClientes() {

		List<Cliente> listadoClientes = null;
		try {
			listadoClientes = clienteDAODatabase.GetAll();
			/*
			for (int i = 0; i < listadoClientes.size(); i++) {
				//Dirreccion
				int idDir = listadoClientes.get(i).getDireccionCompleta().getId();
				DireccionCompleta dirAux = ObtenerDirCompleta(idDir);
				listadoClientes.get(i).getDireccionCompleta().setAltura(dirAux.getAltura());
				listadoClientes.get(i).getDireccionCompleta().setCalle(dirAux.getCalle());
				listadoClientes.get(i).getDireccionCompleta().setCiudad(dirAux.getCiudad());
				listadoClientes.get(i).getDireccionCompleta().setCodigoPostal(dirAux.getCodigoPostal());
				listadoClientes.get(i).getDireccionCompleta().setPais(dirAux.getPais());
				listadoClientes.get(i).getDireccionCompleta().setProvincia(dirAux.getProvincia());
				
				//Telefono
				int idTel = listadoClientes.get(i).getTelefono().getId();
				Telefono telAux = ObtenerTelefono(idTel);
				listadoClientes.get(i).getTelefono().setNumCelular(telAux.getNumCelular());
				listadoClientes.get(i).getTelefono().setNumLaboral(telAux.getNumLaboral());
				listadoClientes.get(i).getTelefono().setNumPersonal(telAux.getNumPersonal());
				
				//Pasaporte
				int idPas = listadoClientes.get(i).getPasaporte().getId();
				Pasaporte pasAux = ObtenerPasaporte(idPas);
				listadoClientes.get(i).getPasaporte().setAutoridadEmision(pasAux.getAutoridadEmision());
				listadoClientes.get(i).getPasaporte().setFechaEmision(pasAux.getFechaEmision());
				listadoClientes.get(i).getPasaporte().setFechaVencimiento(pasAux.getFechaVencimiento());
				listadoClientes.get(i).getPasaporte().setNumeroPasaporte(pasAux.getNumeroPasaporte());
				listadoClientes.get(i).getPasaporte().setPais(pasAux.getPais());
				
				//PasajeroFrecuente
				int idPasFre = listadoClientes.get(i).getPasajeroFrecuente().getId();
				PasajeroFrecuente pasFreAux = ObtenerPasFrecuente(idPasFre);
				listadoClientes.get(i).getPasajeroFrecuente().setAerolinea(pasFreAux.getAerolinea());
				listadoClientes.get(i).getPasajeroFrecuente().setAerolinea(pasFreAux.getAerolinea());
				listadoClientes.get(i).getPasajeroFrecuente().setCategoria(pasFreAux.getCategoria());
				listadoClientes.get(i).getPasajeroFrecuente().setNumeroPF(pasFreAux.getNumeroPF());
			}
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listadoClientes;
	} 

	public Cliente ObtenerCliente(String dni) {
		Cliente cli = new Cliente();

		try {
			cli = this.clienteDAODatabase.ObtenerClientePorDNI(dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cli;
	}

	public DireccionCompleta ObtenerDirCompleta(int id) {
		DireccionCompleta dir = new DireccionCompleta();

		try {
			dir = this.dirCompletaDAODatabase.ObtenerDirCompletaPorID(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dir;
	}

	public Telefono ObtenerTelefono(int id) {
		Telefono tel = new Telefono();

		try {
			tel = this.telefonoDAODatabase.ObtenerTelefonoPorID(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tel;
	}

	public Pasaporte ObtenerPasaporte(int id) {
		Pasaporte pas = new Pasaporte();

		try {
			pas = this.pasaporteDAODatabase.ObtenerPasaportePorID(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pas;
	}

	public PasajeroFrecuente ObtenerPasFrecuente(int id) {
		PasajeroFrecuente pasFre = new PasajeroFrecuente();
		try {
			pasFre = this.pasajeroFrecuenteDAODatabase.ObtenerPasajeroFrecuentePorID(id);
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasFre;
	}
	
	public List<Cliente> MostrarClientesCompleto() {
		
		List<Cliente> listadoClientes = null;
	
			listadoClientes = clienteDAODatabase.GetAllComplete();
			
			for (int i = 0; i < listadoClientes.size(); i++) {
			
			System.out.println(listadoClientes.get(i).getNombre());
			System.out.println(listadoClientes.get(i).getDireccionCompleta().getAltura());
			}

		return listadoClientes;
	}
}
