package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class AeropuertosDAOImplDatabase implements AeropuertoDAO {

	final String SELECT_ALL = "SELECT * FROM Aeropuertos ORDER BY aeropuerto_id";
	final String SELECT_BY_ID = "SELECT * FROM Aeropuertos WHERE aeropuerto_id=?";

	@Override
	public void AgregarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarAeropuerto(Aeropuerto aeropuerto) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Aeropuerto ObtenerAeropuertoPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT_BY_ID");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Aeropuerto a = new Aeropuerto();

			if (rs.next()) {

				a.setId(rs.getInt("aeropuerto_id"));
				a.setCodigo(rs.getString("aeropuerto_codigo"));
				a.setCiudad(rs.getString("aeropuerto_ciudad"));
				a.setProvinciaID(rs.getInt("aeropuerto_provinciaID"));
				a.setPaisID(rs.getInt("aeropuerto_paisID"));

				return a;
			}

			System.out.println("Aeropuerto encontrado - Operacion completada");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexión a la DB ha sido cerrada.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public List<Aeropuerto> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Aeropuerto> listado = new ArrayList<Aeropuerto>();
		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT_ALL";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Aeropuerto a = new Aeropuerto();
				a.setId(rs.getInt("aeropuerto_id"));
				a.setCodigo(rs.getString("aeropuerto_codigo"));
				a.setCiudad(rs.getString("aeropuerto_ciudad"));
				a.setProvinciaID(rs.getInt("aeropuerto_provinciaID"));
				a.setPaisID(rs.getInt("aeropuerto_paisID"));

				listado.add(a);
			}

			System.out.println("Aeropuertos encontrados: " + listado.size());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				rs.close();
				con.close();
				System.out.println("Conexion cerrada");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return listado;
	}

}
