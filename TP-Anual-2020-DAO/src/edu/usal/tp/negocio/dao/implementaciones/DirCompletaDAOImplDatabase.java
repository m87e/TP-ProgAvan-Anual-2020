package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.interfaces.DirCompletaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class DirCompletaDAOImplDatabase implements DirCompletaDAO {

	final String INSERT = "INSERT INTO Direcciones (direccion_calle, direccion_altura, direccion_ciudad, direccion_paisID, direccion_provinciaID, direccion_codigoPostal) values (?,?,?,?,?,?)";
	final String UPDATE = "UPDATE Direcciones direccion_calle=?, direccion_altura=?, direccion_ciudad=?, direccion_paisID=?, direccion_provinciaID=?, direccion_codigoPostal=? WHERE direccion_id=?";
	final String DELETE = "DELETE FROM Direcciones WHERE direccion_id=?";
	final String SELECT_BY_ID = "SELECT * FROM Direcciones WHERE direccion_id=?";

	@Override
	public void AgregarDirCompleta(DireccionCompleta dir, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dir.getCalle());
			ps.setString(2, dir.getAltura());
			ps.setString(3, dir.getCiudad());
			ps.setInt(4, dir.getPais().getId());
			ps.setInt(5, dir.getProvincia().getId());
			ps.setString(6, dir.getCodigoPostal());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				dir.setId((int) rs.getLong(1));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				System.out.println("Direccion agregada - Operacion completada");

			} catch (Exception e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void ModificarDirCompleta(DireccionCompleta dir, Connection con) throws IOException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(UPDATE);
			ps.setString(1, dir.getCalle());
			ps.setString(2, dir.getAltura());
			ps.setString(3, dir.getCiudad());
			ps.setInt(4, dir.getPais().getId());
			ps.setInt(5, dir.getProvincia().getId());
			ps.setString(6, dir.getCodigoPostal());
			ps.setInt(7, dir.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al actualizar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Direccion agregada - Operacion completada");

			} catch (Exception e) {
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void EliminarDirCompleta(DireccionCompleta dir, Connection con) throws IOException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, dir.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al eliminar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Direccion eliminada - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}
	}

	@Override
	public DireccionCompleta ObtenerDirCompletaPorID(int id) throws IOException {
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

				DireccionCompleta dir = new DireccionCompleta();
				Pais pais = new Pais();
				Provincia prov = new Provincia();

				dir.setId(rs.getInt("direccion_id"));
				dir.setCalle(rs.getString("direccion_calle"));
				dir.setAltura(rs.getString("direccion_altura"));
				dir.setCiudad(rs.getString("direccion_ciudad"));
				pais.setId(rs.getInt("direccion_paisID"));
				dir.setPais(pais);
				prov.setId(rs.getInt("direccion_provinciaID"));
				dir.setProvincia(prov);
				dir.setCodigoPostal(rs.getString("direccion_codigoPostal"));

				System.out.println("Direccion encontrada - Operacion completada");

				return dir;
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
	public List<DireccionCompleta> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
