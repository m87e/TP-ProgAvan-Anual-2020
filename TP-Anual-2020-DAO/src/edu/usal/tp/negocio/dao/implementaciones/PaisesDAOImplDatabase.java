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
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class PaisesDAOImplDatabase implements PaisesDAO {

	final String SELECT_BY_ID = "SELECT * FROM Paises WHERE pais_id=?";
	final String SELECT_ALL = "SELECT * FROM Paises ORDER BY pais_id";

	@Override
	public void AgregarPais(Pais pais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarPais(Pais oldPais, Pais newPais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarPais(Pais pais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pais ObtenerPaisPorID(int id) throws IOException {
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

				Pais p = new Pais();
				p.setId(rs.getInt("pais_id"));
				p.setNombre(rs.getString("pais_nombre"));

				System.out.println("Pais encontrado - Operacion completada");

				return p;
			}

		} catch (SQLException e) {
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
	public List<Pais> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Pais> listado = new ArrayList<Pais>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = SELECT_ALL;

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Pais p = new Pais();

				p.setId(rs.getInt("pais_id"));
				p.setNombre(rs.getString("pais_nombre"));
				listado.add(p);

			}
			System.out.println("Paises encontrados: " + listado.size());

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

}
