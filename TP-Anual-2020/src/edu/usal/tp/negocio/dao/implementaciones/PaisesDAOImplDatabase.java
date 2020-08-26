package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class PaisesDAOImplDatabase implements IPaisesDAO {

	@Override
	public void AgregarPais(Paises pais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarPais(Paises oldPais, Paises newPais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarPais(Paises pais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Paises ObtenerPaisPorID(int id) throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT * FROM Paises WHERE pais_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Paises p = new Paises();

			if (rs.next()) {

				p.setId(rs.getInt("pais_id"));
				p.setNombre(rs.getString("pais_nombre"));

				return p;
			}
			System.out.println("Pais encontrado - Operacion completada");

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
	public List<Paises> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		List<Paises> listado = new ArrayList<Paises>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Paises ORDER BY pais_id";

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Paises p = new Paises();

				p.setId(rs.getInt("pais_id"));
				p.setNombre(rs.getString("pais_nombre"));
				listado.add(p);

			}
			System.out.println("Paises encontrados: " + listado.size());

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
