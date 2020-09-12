package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class TelefonoDAOImplDatabase implements ITelefonoDAO {

	final String INSERT = "INSERT INTO Telefonos (telefono_numPersonal, telefono_numCelular, telefono_numLaboral) values (?,?,?)";

	@Override
	public void AgregarTelefono(Telefono tel, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tel.getNumPersonal());
			ps.setString(2, tel.getNumCelular());
			ps.setString(3, tel.getNumLaboral());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				tel.setID((int) rs.getLong(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void ModificarTelefono(Telefono tel) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement(
					"UPDATE Telefonos SET telefono_numPersonal=?, telefono_numCelular=?, telefono_numLaboral=? WHERE telefono_id=?");

			ps.setString(1, tel.getNumPersonal());
			ps.setString(2, tel.getNumCelular());
			ps.setString(3, tel.getNumLaboral());
			ps.setInt(4, tel.getId());

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
	public void EliminarTelefono(Telefono tel) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement("DELETE FROM Telefonos WHERE telefono_id=?");
			ps.setInt(1, tel.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Telefono eliminado - Operacion completada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public Telefono ObtenerTelefonoPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT * FROM Telefonos WHERE telefono_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Telefono t = new Telefono();

			if (rs.next()) {
				t.setID(rs.getInt("telefono_id"));
				t.setNumPersonal(rs.getNString("telefono_numPersonal"));
				t.setNumCelular(rs.getString("telefono_numCelular"));
				t.setNumLaboral(rs.getString("telefono_numLaboral"));

				return t;

			}
			System.out.println("Telefono encontrado - Operacion completada");

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
	public List<Telefono> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Telefono> listado = new ArrayList<Telefono>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Telefono ORDER BY telefono_id";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Telefono t = new Telefono();
				t.setID(rs.getInt("telefono_id"));
				t.setNumPersonal(rs.getNString("telefono_numPersonal"));
				t.setNumCelular(rs.getString("telefono_numCelular"));
				t.setNumLaboral(rs.getString("telefono_numLaboral"));

				listado.add(t);

			}
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Telefonos encontrados: " + listado.size());

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
