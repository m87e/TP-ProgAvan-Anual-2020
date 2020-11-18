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
import edu.usal.tp.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class TelefonoDAOImplDatabase implements TelefonoDAO {

	final String INSERT = "INSERT INTO Telefonos (telefono_numPersonal, telefono_numCelular, telefono_numLaboral) values (?,?,?)";
	final String UPDATE = "UPDATE Telefonos SET telefono_numPersonal=?, telefono_numCelular=?, telefono_numLaboral=? WHERE telefono_id=?";
	final String DELETE = "DELETE FROM Telefonos WHERE telefono_id=?";
	final String SELECT_BY_ID = "SELECT * FROM Telefonos WHERE telefono_id=?";
	final String SELECT_ALL = "SELECT * FROM Telefono ORDER BY telefono_id";

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
				tel.setId((int) rs.getLong(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				System.out.println("Telefono agregado - Operacion completada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}
	}

	@Override
	public void ModificarTelefono(Telefono tel, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(UPDATE);

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
				System.out.println("Telefono actualizado - Operacion completada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void EliminarTelefono(Telefono tel, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, tel.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				System.out.println("Telefono eliminado - Operacion completada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public Telefono ObtenerTelefonoPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		System.out.println("ID tel: "+id);
		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {

				Telefono t = new Telefono();

				t.setId(rs.getInt("telefono_id"));
				t.setNumPersonal(rs.getNString("telefono_numPersonal"));
				t.setNumCelular(rs.getString("telefono_numCelular"));
				t.setNumLaboral(rs.getString("telefono_numLaboral"));

				System.out.println("Telefono encontrado - Operacion completada");

				return t;

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexión a la DB ha sido cerrada.");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

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

		String sql = SELECT_ALL;

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Telefono t = new Telefono();

				t.setId(rs.getInt("telefono_id"));
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
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return listado;
	}

}
