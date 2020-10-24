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

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.interfaces.VentaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class VentaDAOImplDatabase implements VentaDAO {

	final String INSERT = "INSERT INTO Ventas (venta_fecha, venta_formaPago, venta_clienteID, venta_vueloID, venta_aerolineaID) values (?,?,?,?,?)";
	final String UPDATE = "UPDATE Ventas SET venta_fecha=?, venta_formaPago=?, venta_clienteID=?, venta_vueloID=?, venta_aerolineaID?) WHERE venta_id=?";
	final String DELETE = "DELETE FROM Ventas WHERE venta_id=?";
	final String SELECT_ALL = "SELECT * FROM Ventas ORDER BY venta_id";

	@Override
	public void AgregarVenta(Venta venta) throws IOException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT);

			ps.setDate(1, (Date) venta.getFechaHoraVenta());
			ps.setString(2, venta.getFormaPago());
			ps.setInt(3, venta.getCliente().getId());
			ps.setInt(4, venta.getVuelo().getId());
			ps.setInt(5, venta.getAerolinea().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {

				ps.close();
				con.close();
				System.out.println("Venta agregada - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void ModificarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(UPDATE);

			ps.setDate(1, (Date) venta.getFechaHoraVenta());
			ps.setString(2, venta.getFormaPago());
			ps.setInt(3, venta.getCliente().getId());
			ps.setInt(4, venta.getVuelo().getId());
			ps.setInt(5, venta.getAerolinea().getId());
			ps.setInt(6, venta.getId());

			ps.executeUpdate();

			System.out.println("Venta actualizada - Operacion completada");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void EliminarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, venta.getId());
			ps.executeUpdate();
			System.out.println("Venta eliminada - Operacion completada");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Conexion cerrada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public List<Venta> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub

		Connection con = SQLDatabaseConnection.conectar();
		List<Venta> listado = new ArrayList<Venta>();

		Statement stm = null;
		ResultSet rs = null;

		String sql = SELECT_ALL;

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Venta venta = new Venta();
				Cliente cliente = new Cliente();
				Vuelo vuelo = new Vuelo();
				Aerolinea aerolinea = new Aerolinea();

				venta.setId(rs.getInt("venta_id"));
				venta.setFechaHoraVenta(rs.getDate("venta_fecha"));
				venta.setFormaPago(rs.getString("venta_formaPago"));
				cliente.setId(rs.getInt("venta_clienteID"));
				venta.setCliente(cliente);
				vuelo.setId(rs.getInt("venta_vueloID"));
				venta.setVuelo(vuelo);
				aerolinea.setId(rs.getInt("venta_aerolineaID"));
				venta.setAerolinea(aerolinea);

			}
			System.out.println("Ventas encontrados: " + listado.size());

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
