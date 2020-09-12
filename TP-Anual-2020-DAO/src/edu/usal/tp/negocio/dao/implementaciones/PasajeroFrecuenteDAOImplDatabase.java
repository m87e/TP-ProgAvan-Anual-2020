package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.interfaces.IPasajeroFrecuenteDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class PasajeroFrecuenteDAOImplDatabase implements IPasajeroFrecuenteDAO {

	final String INSERT = "INSERT INTO PasajerosFrecuentes (pasajerofrecuente_alianza, pasajerofrecuente_aerolineaID, pasajerofrecuente_numeroPF, pasajerofrecuente_categoria) values (?,?,?,?)";

	@Override
	public void AgregarPasajeroFrecuente(PasajeroFrecuente pasFre, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, pasFre.getAlianza().toString());
			ps.setInt(2, pasFre.getAerolineaID());
			ps.setString(3, pasFre.getNumeroPF());
			ps.setString(4, pasFre.getCategoria());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				pasFre.setIdPasFre((int) rs.getLong(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				ps.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}

	@Override
	public void ModificarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement(
					"UPDATE PasajerosFrecuentes SET pasajerofrecuente_alianza=?, pasajerofrecuente_aerolineaID=?, pasajerofrecuente_numeroPF=?, pasajerofrecuente_categoria=? WHERE pasajerofrecuente_id=?");

			ps.setString(1, pasFre.getAlianza().toString());
			ps.setInt(2, pasFre.getAerolineaID());
			ps.setString(3, pasFre.getNumeroPF());
			ps.setString(4, pasFre.getCategoria());
			ps.setInt(5, pasFre.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Pasajero Frecuente actualizado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void EliminarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement("DELETE FROM PasajerosFrecuentes WHERE pasajerofrecuente_id=?");

			ps.setInt(1, pasFre.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Pasajero frecuente eliminado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public PasajeroFrecuente ObtenerPasajeroFrecuentePorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT * FROM PasajerosFrecuentes WHERE pasajerofrecuente_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			PasajeroFrecuente p = new PasajeroFrecuente();

			if (rs.next()) {

				p.setIdPasFre(rs.getInt("pasajerofrecuente_id"));
				p.setAlianza(Alianza.valueOf(rs.getString("pasajerofrecuente_alianza")));
				p.setAerolineaID(rs.getInt("pasajerofrecuente_aerolineaID"));
				p.setNumeroPF(rs.getString("pasajerofrecuente_numeroPF"));
				p.setCategoria(rs.getString("pasajerofrecuente_categoria"));

				return p;
			}
			System.out.println("Pasajero frecuente encontrado - Operacion completada");

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
	public List<PasajeroFrecuente> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<PasajeroFrecuente> listado = new ArrayList<PasajeroFrecuente>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM PasajerosFrecuentes ORDER BY pasajerofrecuente_id";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				PasajeroFrecuente p = new PasajeroFrecuente();
				p.setIdPasFre(rs.getInt("pasajerofrecuente_id"));
				p.setAlianza(Alianza.valueOf(rs.getString("pasajerofrecuente_alianza")));
				p.setAerolineaID(rs.getInt("pasajerofrecuente_aerolineaID"));
				p.setNumeroPF(rs.getString("pasajerofrecuente_numeroPF"));
				p.setCategoria(rs.getString("pasajerofrecuente_categoria"));

				listado.add(p);
			}
			System.out.println("pasajeros encontrados: " + listado.size());

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
			}
		}

		return listado;
	}

}
