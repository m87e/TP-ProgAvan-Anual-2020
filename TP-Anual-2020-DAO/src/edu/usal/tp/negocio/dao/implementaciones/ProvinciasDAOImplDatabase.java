package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class ProvinciasDAOImplDatabase implements ProvinciasDAO {

	@Override
	public void AgregarProvincia(Provincias provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarProvincia(Provincias provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarProvincia(Provincias provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Provincias ObtenerProvinciaPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT * FROM Provincias WHERE provincia_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Provincias p = new Provincias();
			if (rs.next()) {

				p.setId(rs.getInt("provincia_id"));
				p.setNombre(rs.getString("provincia_nombre"));

				return p;
			}
			System.out.println("Provincia encontrada - Operacion completada");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("Conexion cerrada");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return null;
	}

	@Override
	public List<Provincias> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Provincias> listado = new ArrayList<Provincias>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Provincias ORDER BY provincia_id";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Provincias p = new Provincias();
				p.setId(rs.getInt("provincia_id"));
				p.setNombre(rs.getString("provincia_nombre"));
				listado.add(p);

			}
			System.out.println("Provincias encontradas: " + listado.size());

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
