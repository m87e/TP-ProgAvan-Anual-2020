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

		Connection con = null;
		PreparedStatement ps = null;
		

		try {

		
			ps = con.prepareStatement(
					"INSERT INTO Clientes (cliente_nombre, cliente_apellido, cliente_dni, cliente_cuit, cliente_fechaNac, cliente_email, cliente_dirCompletaID, cliente_telID, cliente_pasaporteID, cliente_pasFreID) values (?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, (Date) cliente.getFechaNac());
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getDir().getId()); // llamar a traves de manager (agregar lo del commit adentro del
													// manager), tiene que estar dentro del MVC
			ps.setInt(8, cliente.getTel().getId());
			ps.setInt(9, cliente.getPas().getIdPasaporte()); // llamar a traves de manager
			ps.setInt(10, cliente.getPasfre().getId());
			ps.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Cliente agregado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void ModificarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = SQLDatabaseConnection.conectar();
			ps = con.prepareStatement(
					"UPDATE Clientes SET cliente_nombre=?, cliente_apellido=?, cliente_dni=?, cliente_cuit=?, cliente_fechaNac=?, cliente_email=?, cliente_dirCompletaID=?, cliente_telID=?, cliente_pasaporteID=?, cliente_pasFreID=? WHERE cliente_id=?");

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, (Date) cliente.getFechaNac());
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getDir().getId());
			ps.setInt(8, cliente.getTel().getId());
			ps.setInt(9, cliente.getPas().getIdPasaporte());
			ps.setInt(10, cliente.getPasfre().getId());
			ps.setInt(11, cliente.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Cliente actualizado - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void EliminarCliente(Cliente cliente) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = SQLDatabaseConnection.conectar();
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
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public List<Cliente> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Cliente> listado = new ArrayList<Cliente>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Clientes ORDER BY cliente_id";

		try {
			con = SQLDatabaseConnection.conectar();
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

	@Override
	public Cliente ObtenerClientePorDNI(String dni) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = SQLDatabaseConnection.conectar();

			ps = con.prepareStatement("SELECT * FROM Clientes WHERE cliente_dni=?");
			ps.setString(1, dni);
			rs = ps.executeQuery();

			Cliente c = new Cliente();
			if (rs.next()) {

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

				return c;
			}

			System.out.println("Cliente encontrado - Operacion completada");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
				System.out.println("La conexion a la DB ha sido cerrada.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

}
