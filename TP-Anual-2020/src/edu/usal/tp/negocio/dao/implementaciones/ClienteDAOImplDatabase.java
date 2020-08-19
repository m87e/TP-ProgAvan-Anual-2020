package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class ClienteDAOImplDatabase implements IClienteDAO {

	@Override
	public void AgregarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub

		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;
		Statement stm = null;

		try {

			String sql = "SET IDENTITY_INSERT Clientes ON";
			stm = con.createStatement();
			stm.execute(sql);

			ps = con.prepareStatement(
					"INSERT INTO Clientes (cliente_id, cliente_nombre, cliente_apellido, cliente_dni, cliente_cuit, cliente_fechaNac, cliente_email, cliente_dirCompletaID, cliente_telID, cliente_pasaporteID, cliente_pasFreID) values (?,?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellido());
			ps.setString(4, cliente.getDni());
			ps.setString(5, cliente.getCuit());
			ps.setDate(6, (Date) cliente.getFechaNac());
			ps.setString(7, cliente.getEmail());
			ps.setInt(8, cliente.getDir().getId());
			ps.setInt(9, cliente.getTel().getId());
			ps.setInt(10, cliente.getPas().getIdPasaporte());
			ps.setInt(11, cliente.getPasfre().getId());
			ps.executeUpdate();

			String sql1 = "SET IDENTITY_INSERT Clientes OFF";
			stm.execute(sql1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				ps.close();
				con.close();
				System.out.println("Cliente agregado - Operacion completada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void ModificarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM Clientes WHERE cliente_id=?");
			ps.setInt(1, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Cliente eliminado - Operacion completada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public List<Cliente> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		List<Cliente> listado = new ArrayList<Cliente>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Clientes ORDER BY cliente_id";

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Cliente c = new Cliente();

				c.setIdCliente(rs.getInt("cliente_id"));
				c.setNombre(rs.getString("cliente_nombre"));
				c.setApellido(rs.getString("cliente_apellido"));
				c.setDni(rs.getString("cliente_dni"));
				c.setCuit(rs.getString("cliente_cuit"));
				c.setFechaNac(rs.getDate("cliente_fechaNac"));
				c.setEmail(rs.getString("cliente_email"));
				c.setDirID(rs.getInt("cliente_dirCompletaID"));
				c.setTelID(rs.getInt("cliente_telID"));
				c.setPasID(rs.getInt("cliente_pasaporteID"));
				c.setPasfreID(rs.getInt("cliente_pasFreID"));

				listado.add(c);
			}
			System.out.println("Clientes encontrados: " + listado.size());

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