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

import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.interfaces.VentaDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class VentaDAOImplDatabase implements VentaDAO {

	@Override
	public void AgregarVenta(Venta venta) throws IOException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;
	

		try {

	
			ps = con.prepareStatement(
					"INSERT INTO Ventas (venta_fecha, venta_formaPago, venta_clienteID, venta_vueloID, venta_aerolineaID) values (?,?,?,?,?)");

			ps.setDate(1, (Date) venta.getFechaHoraVenta());
			ps.setString(2, venta.getFormaPago());
			ps.setInt(3, venta.getClienteID());
			ps.setInt(4, venta.getVueloID());
			ps.setInt(5, venta.getAerolineaID());
			ps.executeUpdate();


		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				
				ps.close();
				con.close();
				System.out.println("Venta agregada - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void ModificarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE Ventas SET venta_fecha=?, venta_formaPago=?, venta_clienteID=?, venta_vueloID=?, venta_aerolineaID?) WHERE venta_id=?");

			ps.setDate(1, (Date) venta.getFechaHoraVenta());
			ps.setString(2, venta.getFormaPago());
			ps.setInt(3, venta.getClienteID());
			ps.setInt(4, venta.getVueloID());
			ps.setInt(5, venta.getAerolineaID());
			ps.setInt(6, venta.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Venta actualizada - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void EliminarVenta(Venta venta) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Connection con = SQLDatabaseConnection.conectar();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM Ventas WHERE venta_id=?");
			ps.setInt(1, venta.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				System.out.println("Venta eliminada - Operacion completada");
				System.out.println("Conexion cerrada");

			} catch (Exception e2) {
				// TODO: handle exception
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

		String sql = "SELECT * FROM Ventas ORDER BY venta_id";

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Venta v = new Venta();

				v.setId(rs.getInt("venta_id"));
				v.setFechaHoraVenta(rs.getDate("venta_fecha"));
				v.setFormaPago(rs.getString("venta_formaPago"));
				v.setClienteID(rs.getInt("venta_clienteID"));
				v.setVueloID(rs.getInt("venta_vueloID"));
				v.setAerolineaID(rs.getInt("venta_aerolineaID"));

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
			}
		}

		return listado;
	}

}
