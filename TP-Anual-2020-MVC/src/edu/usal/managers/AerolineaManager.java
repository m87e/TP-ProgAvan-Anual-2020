package edu.usal.managers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class AerolineaManager {

	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");

	public void AltaAerolinea(Aerolinea aerolinea) {

		Connection con = null;

		try {

			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.aerolineaDAODatabase.AgregarAerolinea(aerolinea, con);

			con.commit();
			System.out.println("Aerolinea agregada - Operacion completada");

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

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void ModificacionAerolinea(Aerolinea aerolinea) {

		Connection con = null;

		try {

			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.aerolineaDAODatabase.ModificarAerolinea(aerolinea, con);

			con.commit();
			System.out.println("Aerolinea modificada - Operacion completada");

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

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void BajaAerolinea(Aerolinea aerolinea) {
		Connection con = null;

		try {

			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.aerolineaDAODatabase.EliminarAerolinea(aerolinea, con);

			con.commit();
			System.out.println("Aerolinea eliminada - Operacion completada");

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

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public List<Aerolinea> MostrarLineasAereas() {

		List<Aerolinea> listadoAerolinea = null;

		try {
			System.out.println("Generando listado de aerolineas...");
			System.out.println("procesando... ");
			listadoAerolinea = aerolineaDAODatabase.GetAll();
			System.out.println("finalizado");
		} catch (IOException e) {
			System.out.println("No se pudo obtener listado de las lineas aereas");
		}
		return listadoAerolinea;
	}

	public Aerolinea BuscarAerolineaID(int id) {
		Aerolinea a = new Aerolinea();
		try {
			a = aerolineaDAODatabase.ObtenerAerolineaPorID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontraron aerolineas con ese ID");
		}

		return a;

	}

}
