package edu.usal.managers;
//private iVuelosDAO vueloDAODatabase =

import java.io.IOException;

// VuelosFactory.GetImplementation("database");

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.AeropuertoFactory;
import edu.usal.tp.negocio.dao.factory.VueloFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class VueloManager {

	private VueloDAO vueloDAODatabase = VueloFactory.GetImplementation("database");
	private AeropuertoDAO aeropuertoDAODatabase = AeropuertoFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");

	public void AltaVuelo(Vuelo vuelo) {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			System.out.println(vuelo.getAeropuertoSalida().getId());
			Aeropuerto salida = this.aeropuertoDAODatabase.ObtenerAeropuertoPorID(vuelo.getAeropuertoSalida().getId());
			vuelo.setAeropuertoSalida(salida);

			Aeropuerto llegada = this.aeropuertoDAODatabase
					.ObtenerAeropuertoPorID(vuelo.getAeropuertoLlegada().getId());
			vuelo.setAeropuertoLlegada(llegada);

			Aerolinea aero = this.aerolineaDAODatabase.ObtenerAerolineaPorID(vuelo.getAerolinea().getId());
			vuelo.setAerolinea(aero);

			vuelo.setNumVuelo(GenerarNumVuelo(aero.getNombre()));

			this.vueloDAODatabase.AgregarVuelo(vuelo, con);

			con.commit();
			System.out.println("Vuelo agregado - Operacion completada");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Ocurrio un error al cargar los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void ModificacionVuelo(Vuelo vuelo) {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			Aeropuerto salida = this.aeropuertoDAODatabase.ObtenerAeropuertoPorID(vuelo.getAeropuertoSalida().getId());
			System.out.println("### Manager - AEP Salida: "+salida.getCodigo());
			vuelo.setAeropuertoSalida(salida);

			Aeropuerto llegada = this.aeropuertoDAODatabase
					.ObtenerAeropuertoPorID(vuelo.getAeropuertoLlegada().getId());
			System.out.println("### Manager - AEP llegada: "+llegada.getCodigo());

			vuelo.setAeropuertoLlegada(llegada);

			Aerolinea aero = this.aerolineaDAODatabase.ObtenerAerolineaPorID(vuelo.getAerolinea().getId());
			vuelo.setAerolinea(aero);

			this.vueloDAODatabase.ModificarVuelo(vuelo, con);

			con.commit();
			System.out.println("Vuelo modificado - Operacion completada");

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("Ocurrio un error al cargar los datos");
			if (con != null) {
				SQLDatabaseConnection.rollback(con);
				System.err.print("Se realizo un rollback de la transaccion");
			}
		} catch (SQLException e) {
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

	public void BajaVuelo(Vuelo vuelo) {

		Connection con = null;

		try {
			con = SQLDatabaseConnection.conectar();
			con.setAutoCommit(false);

			this.vueloDAODatabase.EliminarVuelo(vuelo, con);

			con.commit();
			System.out.println("Vuelo eliminado - Operacion completada");
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

	public List<Vuelo> MostrarVuelos() {

		List<Vuelo> listadoVuelos = null;
		try {
			System.out.println("Generando listado de vuelos...");
			System.out.println("procesando... ");
			listadoVuelos = vueloDAODatabase.GetAll();
			System.out.println("finalizado");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo obtener listado de los vuelos");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo obtener listado de los vuelos");
		}

		return listadoVuelos;
	}

	public Vuelo BuscarVueloID(int id) {
		Vuelo vuelo = new Vuelo();

		try {
			vuelo = vueloDAODatabase.ObtenerVueloPorID(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontraron vuelos con ese ID");
		}

		return vuelo;
	}

	public String GenerarNumVuelo(String nombreAerolinea) {

		String numVueloGenerado = null;
		String aerolineaSplit;

		int numeroVuelo = 0;
		Vuelo vuelo = new Vuelo();

		try {
			vuelo = vueloDAODatabase.ObtenerUltimoVuelo();

			if (vuelo != null) {

				String[] arrayNumero = vuelo.getNumVuelo().trim().split("-");
				System.out.println(arrayNumero.length);
				if (arrayNumero.length > 1) {
					System.out.println("### inside if");
					numeroVuelo = Integer.parseInt(arrayNumero[1]) + 1;
					System.out.println(numeroVuelo);
				}

				String[] array = nombreAerolinea.trim().split(" ");
				System.out.println(array.length);
				if (array.length > 1) {
					System.out.println("### inside if");
					aerolineaSplit = (Character.toString(array[0].charAt(0)) + Character.toString(array[1].charAt(0)))
							.toUpperCase();
					System.out.println(aerolineaSplit);

				} else {

					System.out.println("### inside else");
					aerolineaSplit = (Character.toString(array[0].charAt(0)) + Character.toString(array[0].charAt(1)))
							.toUpperCase();
					System.out.println(aerolineaSplit);
				}

				numVueloGenerado = aerolineaSplit + "-" + String.valueOf(numeroVuelo);

			} else {

				numeroVuelo = 1111;

				String[] array = nombreAerolinea.trim().split(" ");
				System.out.println(array.length);
				if (array.length > 1) {
					System.out.println("### inside if");
					aerolineaSplit = (Character.toString(array[0].charAt(0)) + Character.toString(array[1].charAt(0)))
							.toUpperCase();
					System.out.println(aerolineaSplit);

				} else {

					System.out.println("### inside else");
					aerolineaSplit = (Character.toString(array[0].charAt(0)) + Character.toString(array[0].charAt(1)))
							.toUpperCase();
					System.out.println(aerolineaSplit);
				}

				numVueloGenerado = aerolineaSplit + "-" + String.valueOf(numeroVuelo);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al buscar los datos");
		}

		return numVueloGenerado;

	}
}