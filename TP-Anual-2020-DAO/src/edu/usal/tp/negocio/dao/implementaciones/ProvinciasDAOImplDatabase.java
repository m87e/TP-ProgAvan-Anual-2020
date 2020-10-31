package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class ProvinciasDAOImplDatabase implements ProvinciasDAO {

	private String SELECT_BY_ID = "SELECT * FROM Provincias WHERE provincia_id=?";
	private String SELECT_ALL = "SELECT * FROM Provincias ORDER BY provincia_id";

	@Override
	public void AgregarProvincia(Provincia provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarProvincia(Provincia provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarProvincia(Provincia provincia) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Provincia ObtenerProvinciaPorID(int id) throws IOException {
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

				Provincia p = new Provincia();

				p.setId(rs.getInt("provincia_id"));
				p.setNombre(rs.getString("provincia_nombre"));

				System.out.println("Provincia encontrada - Operacion completada");

				return p;
			}

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
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return null;
	}

	@Override
	public List<Provincia> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Provincia> listado = new ArrayList<Provincia>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = SELECT_ALL;

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Provincia p = new Provincia();
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
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return listado;
	}

}
