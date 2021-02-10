package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class VueloDAOImplDatabase implements VueloDAO {

	final String INSERT = "INSERT INTO Vuelos (vuelo_numero,vuelo_cantAsientos,vuelo_fechaHoraSalida,vuelo_fechaHoraLlegada,vuelo_aerolineaID,vuelo_aeropuertoSalidaID,vuelo_aeropuertoLlegadaID) values (?,?,?,?,?,?,?) ";
	final String UPDATE = "UPDATE Vuelos SET vuelo_numero = ?,vuelo_cantAsientos = ?,vuelo_fechaHoraSalida=?,vuelo_fechaHoraLlegada=?,vuelo_aerolineaID=?,vuelo_aeropuertoSalidaID=?,vuelo_aeropuertoLlegadaID=? WHERE vuelo_id=?";
	final String DELETE = "DELETE FROM Vuelos WHERE vuelo_id=?";
	final String SELECT_BY_ID = "SELECT * FROM Vuelos WHERE vuelo_id=?";
	final String SELECT_BY_NUMVUELO = "SELECT * FROM Vuelos WHERE vuelo_numero=?";
	final String SELECT_ALL = "SELECT * FROM Vuelos ORDER BY vuelo_id";
	final String SELECT_LAST = "SELECT TOP 1 * FROM Vuelos ORDER BY vuelo_id DESC";

	/*
	 * 
	 * vuelo_numero VARCHAR(255), vuelo_cantAsientos INT, vuelo_fechaHoraSalida
	 * DATETIME, vuelo_fechaHoraLlegada DATETIME, vuelo_aerolineaID INT FOREIGN KEY
	 * REFERENCESAerolineas (aerolinea_id), vuelo_aeropuertoSalidaID INT FOREIGN KEY
	 * REFERENCES Aeropuertos (aeropuerto_id), vuelo_aeropuertoLlegadaID INT FOREIGN
	 * KEY REFERENCES Aeropuertos (aeropuerto_id)
	 * 
	 * 
	 */

	@Override
	public void AgregarVuelo(Vuelo vuelo, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(INSERT);

			ps.setString(1, vuelo.getNumVuelo());
			ps.setInt(2, vuelo.getCantAsientos());
			ps.setDate(3, java.sql.Date.valueOf(vuelo.getFechaHoraSalida()));
			ps.setDate(4, java.sql.Date.valueOf(vuelo.getFechaHoraLlegada()));
			ps.setInt(5, vuelo.getAerolinea().getId());
			ps.setInt(6, vuelo.getAeropuertoSalida().getId());
			ps.setInt(7, vuelo.getAeropuertoLlegada().getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar el dato en la base de datos");

		} finally {
			try {
				ps.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void ModificarVuelo(Vuelo vuelo, Connection con) throws IOException, ParseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(UPDATE);

			ps.setString(1, vuelo.getNumVuelo());
			ps.setInt(2, vuelo.getCantAsientos());
			ps.setDate(3, java.sql.Date.valueOf(vuelo.getFechaHoraSalida()));
			ps.setDate(4, java.sql.Date.valueOf(vuelo.getFechaHoraLlegada()));
			ps.setInt(5, vuelo.getAerolinea().getId());
			ps.setInt(6, vuelo.getAeropuertoSalida().getId());
			ps.setInt(7, vuelo.getAeropuertoLlegada().getId());
			ps.setInt(8, vuelo.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar el dato en la base de datos");

		} finally {
			try {
				ps.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void EliminarVuelo(Vuelo vuelo, Connection con) throws IOException, ParseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(DELETE);
			ps.setInt(1, vuelo.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al eliminar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Vuelo eliminado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}
	}

	@Override
	public List<Vuelo> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub

		Connection con = SQLDatabaseConnection.conectar();
		List<Vuelo> listado = new ArrayList<Vuelo>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = SELECT_ALL;

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Vuelo vuelo = new Vuelo();
				Aerolinea aerolinea = new Aerolinea();
				Aeropuerto aeropuertoSalida = new Aeropuerto();
				Aeropuerto aeropuertoLlegada = new Aeropuerto();

				vuelo.setId(rs.getInt("vuelo_id"));
				vuelo.setNumVuelo(rs.getString("vuelo_numero"));
				vuelo.setCantAsientos(rs.getInt("vuelo_cantAsientos"));
				vuelo.setFechaHoraSalida(rs.getDate("vuelo_fechaHoraSalida").toLocalDate());
				vuelo.setFechaHoraLlegada(rs.getDate("vuelo_fechaHoraLlegada").toLocalDate());
				aerolinea.setId(rs.getInt("vuelo_aerolineaID"));
				vuelo.setAerolinea(aerolinea);
				aeropuertoSalida.setId(rs.getInt("vuelo_aeropuertoSalidaID"));
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				aeropuertoLlegada.setId(rs.getInt("vuelo_aeropuertoLlegadaID"));
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);

				listado.add(vuelo);
			}

			System.out.println("Vuelos encontrados: " + listado.size());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				stm.close();
				rs.close();
				con.close();
				System.out.println("Conexion cerrada");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return listado;
	}

	@Override
	public Vuelo ObtenerVueloPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {

				Vuelo vuelo = new Vuelo();
				Aerolinea aerolinea = new Aerolinea();
				Aeropuerto aeropuertoSalida = new Aeropuerto();
				Aeropuerto aeropuertoLlegada = new Aeropuerto();

				vuelo.setId(rs.getInt("vuelo_id"));
				vuelo.setNumVuelo(rs.getString("vuelo_numero"));
				vuelo.setCantAsientos(rs.getInt("vuelo_cantAsientos"));
				vuelo.setFechaHoraSalida(rs.getDate("vuelo_fechaHoraSalida").toLocalDate());
				vuelo.setFechaHoraLlegada(rs.getDate("vuelo_fechaHoraLlegada").toLocalDate());
				aerolinea.setId(rs.getInt("vuelo_aerolineaID"));
				vuelo.setAerolinea(aerolinea);
				aeropuertoSalida.setId(rs.getInt("vuelo_aeropuertoSalidaID"));
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				aeropuertoLlegada.setId(rs.getInt("vuelo_aeropuertoLlegadaID"));
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);

				System.out.println("Vuelo encontrado - Operacion completada");

				return vuelo;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al leer los datos de la base de datos");

		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexion a la DB ha sido cerrada.");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return null;
	}

	@Override
	public Vuelo ObtenerVuelosPorNumero(String numVuelo) throws IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement(SELECT_BY_NUMVUELO);
			ps.setString(1, numVuelo);
			rs = ps.executeQuery();

			if (rs.next()) {

				Vuelo vuelo = new Vuelo();
				Aerolinea aerolinea = new Aerolinea();
				Aeropuerto aeropuertoSalida = new Aeropuerto();
				Aeropuerto aeropuertoLlegada = new Aeropuerto();

				vuelo.setId(rs.getInt("vuelo_id"));
				vuelo.setNumVuelo(rs.getString("vuelo_numero"));
				vuelo.setCantAsientos(rs.getInt("vuelo_cantAsientos"));
				vuelo.setFechaHoraSalida(rs.getDate("vuelo_fechaHoraSalida").toLocalDate());
				vuelo.setFechaHoraLlegada(rs.getDate("vuelo_fechaHoraLlegada").toLocalDate());
				aerolinea.setId(rs.getInt("vuelo_aerolineaID"));
				vuelo.setAerolinea(aerolinea);
				aeropuertoSalida.setId(rs.getInt("vuelo_aeropuertoSalidaID"));
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				aeropuertoLlegada.setId(rs.getInt("vuelo_aeropuertoLlegadaID"));
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);

				System.out.println("Vuelo encontrado - Operacion completada");

				return vuelo;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al leer los datos de la base de datos");

		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexion a la DB ha sido cerrada.");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return null;

	}

	@Override
	public Vuelo ObtenerUltimoVuelo() throws IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement(SELECT_LAST);
			rs = ps.executeQuery();

			if (rs.next()) {

				Vuelo vuelo = new Vuelo();
				Aerolinea aerolinea = new Aerolinea();
				Aeropuerto aeropuertoSalida = new Aeropuerto();
				Aeropuerto aeropuertoLlegada = new Aeropuerto();

				vuelo.setId(rs.getInt("vuelo_id"));
				vuelo.setNumVuelo(rs.getString("vuelo_numero"));
				vuelo.setCantAsientos(rs.getInt("vuelo_cantAsientos"));
				vuelo.setFechaHoraSalida(rs.getDate("vuelo_fechaHoraSalida").toLocalDate());
				vuelo.setFechaHoraLlegada(rs.getDate("vuelo_fechaHoraLlegada").toLocalDate());
				aerolinea.setId(rs.getInt("vuelo_aerolineaID"));
				vuelo.setAerolinea(aerolinea);
				aeropuertoSalida.setId(rs.getInt("vuelo_aeropuertoSalidaID"));
				vuelo.setAeropuertoSalida(aeropuertoSalida);
				aeropuertoLlegada.setId(rs.getInt("vuelo_aeropuertoLlegadaID"));
				vuelo.setAeropuertoLlegada(aeropuertoLlegada);

				System.out.println("Vuelo encontrado - Operacion completada");

				return vuelo;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al leer los datos de la base de datos");

		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexion a la DB ha sido cerrada.");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return null;
	}

}
