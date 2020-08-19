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
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class AerolineaDAOImplDatabase implements IAerolineaDAO {

	@Override
	public void AgregarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;
		Statement stm = null;

		try {

			String sql = "SET IDENTITY_INSERT Aerolineas ON";
			stm = con.createStatement();
			stm.execute(sql);

			ps = con.prepareStatement(
					"INSERT INTO Aerolineas (aerolinea_id, aerolinea_nombre, aerolinea_alianza) values (?,?,?)");
			ps.setInt(1, aerolinea.getId());
			ps.setString(2, aerolinea.getNombre());
			ps.setString(3, aerolinea.getAlianza().toString());
			ps.executeUpdate();

			String sql1 = "SET IDENTITY_INSERT Aerolineas OFF";
			stm.execute(sql1);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				stm.close();
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

	}

	@Override
	public void EliminarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Aerolinea> GetAll() throws IOException {
		// TODO Auto-generated method stub

		Connection con = SQLDatabaseConnection.conectar();
		List<Aerolinea> listado = new ArrayList<Aerolinea>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Aerolineas ORDER BY aerolinea_id";

		try {
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

}
