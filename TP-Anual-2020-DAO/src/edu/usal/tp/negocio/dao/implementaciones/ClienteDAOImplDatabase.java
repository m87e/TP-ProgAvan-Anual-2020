package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class ClienteDAOImplDatabase implements ClienteDAO {

	final String INSERT = "INSERT INTO Clientes (cliente_nombre, cliente_apellido, cliente_dni, cliente_cuit, cliente_fechaNac, cliente_email, cliente_dirCompletaID, cliente_telID, cliente_pasaporteID, cliente_pasFreID) values (?,?,?,?,?,?,?,?,?,?)";
	final String UPDATE = "UPDATE Clientes SET cliente_nombre=?, cliente_apellido=?, cliente_dni=?, cliente_cuit=?, cliente_fechaNac=?, cliente_email=?, cliente_dirCompletaID=?, cliente_telID=?, cliente_pasaporteID=?, cliente_pasFreID=? WHERE cliente_id=?";
	final String DELETE = "DELETE FROM Clientes WHERE cliente_id=?";
	final String GETONE = "SELECT * FROM Clientes WHERE cliente_dni=?";
	final String GETALL = "SELECT * FROM Clientes ORDER BY cliente_id";

	@Override
	public void AgregarCliente(Cliente cliente, Connection con) throws IOException, ParseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(INSERT);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNac()));
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getDir().getId());
			ps.setInt(8, cliente.getTelefono().getId());
			ps.setInt(9, cliente.getPasaporte().getIdPasaporte());
			ps.setInt(10, cliente.getPasajeroFrecuente().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar el dato en la base de datos");

		} finally {
			try {
				ps.close();

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
			ps = con.prepareStatement(UPDATE);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNac()));
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getDir().getId());
			ps.setInt(8, cliente.getTelefono().getId());
			ps.setInt(9, cliente.getPasaporte().getIdPasaporte());
			ps.setInt(10, cliente.getPasajeroFrecuente().getId());
			ps.setInt(11, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al actualizar el dato en la base de datos");

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
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al eliminar el dato en la base de datos");

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

		String sql = GETALL;

		try {
			con = SQLDatabaseConnection.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {

				Cliente c = new Cliente();
				DireccionCompleta dir = new DireccionCompleta();
				Telefono tel = new Telefono();
				Pasaporte pas = new Pasaporte();
				PasajeroFrecuente pasFre = new PasajeroFrecuente();

				c.setId(rs.getInt("cliente_id"));
				c.setNombre(rs.getString("cliente_nombre"));
				c.setApellido(rs.getString("cliente_apellido"));
				c.setDni(rs.getString("cliente_dni"));
				c.setCuit(rs.getString("cliente_cuit"));
				c.setFechaNac(rs.getDate("cliente_fechaNac").toLocalDate());
				c.setEmail(rs.getString("cliente_email"));

				dir.setId(rs.getInt("cliente_dirCompletaID"));
				c.setDir(dir);

				tel.setId(rs.getInt("cliente_telID"));
				c.setTel(tel);

				pas.setId(rs.getInt("cliente_pasaporteID"));
				c.setPasaporte(pas);

				pasFre.setId(rs.getInt("cliente_pasFreID"));
				c.setPasajeroFrecuente(pasFre);

				listado.add(c);
			}
			System.out.println("Clientes encontrados: " + listado.size());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al leer los datos de la base de datos");

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

			ps = con.prepareStatement(GETONE);
			ps.setString(1, dni);
			rs = ps.executeQuery();

			Cliente c = new Cliente();
			DireccionCompleta dir = new DireccionCompleta();
			Telefono tel = new Telefono();
			Pasaporte pas = new Pasaporte();
			PasajeroFrecuente pasFre = new PasajeroFrecuente();

			if (rs.next()) {

				c.setId(rs.getInt("cliente_id"));
				c.setNombre(rs.getString("cliente_nombre"));
				c.setApellido(rs.getString("cliente_apellido"));
				c.setDni(rs.getString("cliente_dni"));
				c.setCuit(rs.getString("cliente_cuit"));
				c.setFechaNac(rs.getDate("cliente_fechaNac").toLocalDate());
				c.setEmail(rs.getString("cliente_email"));

				dir.setId(rs.getInt("cliente_dirCompletaID"));
				c.setDir(dir);

				tel.setId(rs.getInt("cliente_telID"));
				c.setTel(tel);

				pas.setId(rs.getInt("cliente_pasaporteID"));
				c.setPasaporte(pas);

				pasFre.setId(rs.getInt("cliente_pasFreID"));
				c.setPasajeroFrecuente(pasFre);

				return c;
			}

			System.out.println("Cliente encontrado - Operacion completada");

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
				e.printStackTrace();
			}
		}

		return null;

	}

}
