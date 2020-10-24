package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class AerolineaDAOImplDatabase implements AerolineaDAO {

	final String INSERT = "INSERT INTO Aerolineas (aerolinea_nombre, aerolinea_alianza) values (?,?)";
	final String UPDATE = "UPDATE Aerolineas SET aerolinea_nombre=?,aerolinea_alianza=? WHERE aerolinea_id=?";
	final String DELETE = "DELETE FROM Aerolineas WHERE aerolinea_id=?";
	final String SELECT_ALL = "SELECT * FROM Aerolineas ORDER BY aerolinea_id";
	final String SELECT_BY_ID = "SELECT * FROM Aerolineas WHERE aerolinea_id=?";

	@Override
	public void AgregarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("INSERT");

			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().toString());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void ModificarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement("UPDATE");

			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().toString());
			ps.setInt(3, aerolinea.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void EliminarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement("DELETE");
			ps.setInt(1, aerolinea.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Aerolinea eliminada - Operacion completada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public List<Aerolinea> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Aerolinea> listado = new ArrayList<Aerolinea>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT_ALL";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Aerolinea a = new Aerolinea();
				a.setId(rs.getInt("aerolinea_id"));
				a.setNombre(rs.getString("aerolinea_nombre"));
				a.setAlianza(Alianza.valueOf(rs.getString("aerolinea_alianza")));

				listado.add(a);
			}

			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Aerolineas encontradas: " + listado.size());

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

	@Override
	public Aerolinea ObtenerAerolineaPorID(int aerolineaID) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT_BY_ID");
			ps.setInt(1, aerolineaID);
			rs = ps.executeQuery();

			Aerolinea a = new Aerolinea();
			if (rs.next()) {
				a.setId(rs.getInt("aerolinea_id"));
				a.setNombre(rs.getString("aerolinea_nombre"));
				a.setAlianza(Alianza.valueOf(rs.getString("aerolinea_alianza")));

				return a;
			}

			System.out.println("Aerolinea encontrada - Operacion completada");

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

}
