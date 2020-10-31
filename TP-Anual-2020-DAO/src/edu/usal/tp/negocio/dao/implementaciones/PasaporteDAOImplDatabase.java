package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class PasaporteDAOImplDatabase implements PasaporteDAO {

	final String INSERT = "INSERT INTO Pasaportes (pasaporte_numero, pasaporte_autEmision, pasaporte_fechaEmision, pasaporte_fechaVencimiento, pasaporte_paisID) values (?,?,?,?,?)";
	final String UPDATE = "UPDATE INTO Pasaportes pasaporte_numero=?, pasaporte_autEmision=?, pasaporte_fechaEmision=?, pasaporte_fechaVencimiento=?, pasaporte_paisID=? WHERE pasaporte_id=? ";
	final String DELETE = "DELETE FROM Pasaportes WHERE pasaporte_id=?";
	final String SELECT_BY_NUMBER = "SELECT * FROM Pasaportes WHERE pasaporte_numero=?";
	final String SELECT_ALL = "SELECT * FROM Pasaportes ORDER BY pasaporte_id";

	@Override
	public void AgregarPasaporte(Pasaporte pasaporte, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, pasaporte.getNumeroPasaporte());
			ps.setString(2, pasaporte.getAutoridadEmision());
			ps.setDate(3, java.sql.Date.valueOf(pasaporte.getFechaVencimiento()));
			ps.setDate(4, java.sql.Date.valueOf(pasaporte.getFechaVencimiento()));
			ps.setInt(5, pasaporte.getPais().getId());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				pasaporte.setId((int) rs.getLong(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}

	@Override
	public void ModificarPasaporte(Pasaporte pasaporte) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement(UPDATE);

			ps.setString(1, pasaporte.getNumeroPasaporte());
			ps.setString(2, pasaporte.getAutoridadEmision());
			ps.setDate(3, java.sql.Date.valueOf(pasaporte.getFechaVencimiento()));
			ps.setDate(4, java.sql.Date.valueOf(pasaporte.getFechaVencimiento()));
			ps.setInt(5, pasaporte.getPais().getId());
			ps.setInt(6, pasaporte.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Pasaporte modificado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void EliminarPasaporte(Pasaporte pasaporte) throws IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, pasaporte.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Pasaporte eliminado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public List<Pasaporte> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Pasaporte> listado = new ArrayList<Pasaporte>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = SELECT_ALL;

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Pasaporte p = new Pasaporte();
				Pais pais = new Pais();

				p.setId(rs.getInt("pasaporte_id"));
				p.setNumeroPasaporte(rs.getString("pasaporte_numero"));
				p.setAutoridadEmision(rs.getString("pasaporte_autEmision"));
				p.setFechaEmision(rs.getDate("pasaporte_fechaEmision").toLocalDate());
				p.setFechaVencimiento(rs.getDate("pasaporte_fechaVencimiento").toLocalDate());
				pais.setId(rs.getInt("pasaporte_paisID"));
				p.setPais(pais);

				listado.add(p);
			}
			System.out.println("Pasaportes encontrados: " + listado.size());

		} catch (SQLException e) {
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
	public Pasaporte ObtenerPasaportePorNumero(String numeroPasaporte) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement(SELECT_BY_NUMBER);
			ps.setString(1, numeroPasaporte);
			rs = ps.executeQuery();

			if (rs.next()) {

				Pasaporte p = new Pasaporte();
				Pais pais = new Pais();

				p.setId(rs.getInt("pasaporte_id"));
				p.setNumeroPasaporte(rs.getString("pasaporte_numero"));
				p.setAutoridadEmision(rs.getString("pasaporte_autEmision"));
				p.setFechaEmision(rs.getDate("pasaporte_fechaEmision").toLocalDate());
				p.setFechaVencimiento(rs.getDate("pasaporte_fechaVencimiento").toLocalDate());
				pais.setId(rs.getInt("pasaporte_paisID"));
				p.setPais(pais);

				return p;
			}

			System.out.println("Pasaporte encontrado - Operacion completada");

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexion a la DB ha sido cerrada.");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}

		}

		return null;
	}

}
