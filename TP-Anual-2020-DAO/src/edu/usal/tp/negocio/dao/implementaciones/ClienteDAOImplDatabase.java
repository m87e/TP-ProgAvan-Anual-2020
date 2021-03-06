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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class ClienteDAOImplDatabase implements ClienteDAO {

	final String INSERT = "INSERT INTO Clientes (cliente_nombre, cliente_apellido, cliente_dni, cliente_cuit, cliente_fechaNac, cliente_email, cliente_dirCompletaID, cliente_telID, cliente_pasaporteID, cliente_pasFreID) values (?,?,?,?,?,?,?,?,?,?)";
	final String UPDATE = "UPDATE Clientes SET cliente_nombre=?, cliente_apellido=?, cliente_dni=?, cliente_cuit=?, cliente_fechaNac=?, cliente_email=?, cliente_dirCompletaID=?, cliente_telID=?, cliente_pasaporteID=?, cliente_pasFreID=? WHERE cliente_id=?";
	final String DELETE = "DELETE FROM Clientes WHERE cliente_id=?";
	final String SELECT_BY_DNI = "SELECT * FROM [TPAnual].[dbo].[Clientes] WHERE cliente_dni=?";
	final String SELECT_ALL = "SELECT * FROM [TPAnual].[dbo].[Clientes] ORDER BY cliente_id";
	final String SELECT_ALL_COMPLETE = "SELECT * FROM [TPAnual].[dbo].[Clientes] INNER JOIN Direcciones ON Clientes.cliente_dirCompletaID = Direcciones.direccion_id	INNER JOIN Paises ON direccion_paisID = Paises.pais_id	INNER JOIN Provincias ON direccion_provinciaID = Provincias.provincia_id INNER JOIN Telefonos ON Clientes.cliente_telID = Telefonos.telefono_id INNER JOIN Pasaportes ON Clientes.cliente_pasaporteID = Pasaportes.pasaporte_id INNER JOIN Paises AS paisPasa ON Pasaportes.pasaporte_paisID = paisPasa.pais_id INNER JOIN PasajerosFrecuentes ON Clientes.cliente_pasFreID = PasajerosFrecuentes.pasajerofrecuente_id INNER JOIN Aerolineas ON PasajerosFrecuentes.pasajerofrecuente_id = Aerolineas.aerolinea_id";
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
			ps.setInt(7, cliente.getDireccionCompleta().getId());
			ps.setInt(8, cliente.getTelefono().getId());
			ps.setInt(9, cliente.getPasaporte().getId());
			ps.setInt(10, cliente.getPasajeroFrecuente().getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al cargar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Cliente agregado - Operacion completada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void ModificarCliente(Cliente cliente, Connection con) throws IOException, ParseException {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(UPDATE);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getCuit());
			ps.setDate(5, java.sql.Date.valueOf(cliente.getFechaNac()));
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getDireccionCompleta().getId());
			ps.setInt(8, cliente.getTelefono().getId());
			ps.setInt(9, cliente.getPasaporte().getId());
			ps.setInt(10, cliente.getPasajeroFrecuente().getId());
			ps.setInt(11, cliente.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error al actualizar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Cliente actualizado - Operacion completada");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

	}

	@Override
	public void EliminarCliente(Cliente cliente, Connection con) throws IOException, ParseException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(DELETE);
			ps.setInt(1, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurrio un error al eliminar el dato en la base de datos");

		} finally {
			try {
				ps.close();
				System.out.println("Cliente eliminado - Operacion completada");

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Ocurrio un error al cerrar la base de datos");

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

		String sql = SELECT_ALL;

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
				c.setDireccionCompleta(dir);

				tel.setId(rs.getInt("cliente_telID"));
				c.setTelefono(tel);

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
				System.out.println("Ocurrio un error al cerrar la base de datos");

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

			ps = con.prepareStatement(SELECT_BY_DNI);
			ps.setString(1, dni);
			System.out.println(ps);
			rs = ps.executeQuery();
			System.out.println(rs);

			if (rs.next()) {
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
				c.setDireccionCompleta(dir);

				tel.setId(rs.getInt("cliente_telID"));
				c.setTelefono(tel);

				pas.setId(rs.getInt("cliente_pasaporteID"));
				c.setPasaporte(pas);

				pasFre.setId(rs.getInt("cliente_pasFreID"));
				c.setPasajeroFrecuente(pasFre);

				System.out.println("Cliente encontrado - Operacion completada");

				return c;
			}

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
				System.out.println("Ocurrio un error al cerrar la base de datos");

			}
		}

		return null;

	}

	@Override
	public List<Cliente> GetAllComplete() {
		// TODO Auto-generated method stub
				Connection con = null;
				List<Cliente> listado = new ArrayList<Cliente>();

				Statement stm = null;
				ResultSet rs = null;

				String sql = SELECT_ALL_COMPLETE;

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
						Pais pais = new Pais();
						Provincia provincia = new Provincia ();
						Aerolinea a = new Aerolinea();
						
						System.out.println("query ejecutada... iniciando carga de datos...");
						System.out.println(sql);
						System.out.println(rs.getInt("cliente_id"));
						
						c.setId(rs.getInt("cliente_id"));
						c.setNombre(rs.getString("cliente_nombre"));
						c.setApellido(rs.getString("cliente_apellido"));
						c.setDni(rs.getString("cliente_dni"));
						c.setCuit(rs.getString("cliente_cuit"));
						c.setFechaNac(rs.getDate("cliente_fechaNac").toLocalDate());
						c.setEmail(rs.getString("cliente_email"));

						System.out.println(rs.getInt("cliente_dirCompletaID"));
						dir.setId(rs.getInt("cliente_dirCompletaID"));
						dir.setCalle(rs.getString("direccion_calle"));
						dir.setAltura(rs.getString("direccion_altura"));
						dir.setCiudad(rs.getString("direccion_ciudad"));
						System.out.println(rs.getString("direccion_ciudad"));
						System.out.println(rs.getInt("paisID"));
						pais.setId(rs.getInt("paisID"));
						pais.setNombre(rs.getString("pais_nombre"));
						dir.setPais(pais);
						provincia.setId(rs.getInt("provincia_id"));
						provincia.setNombre(rs.getString("provincia_nombre"));
						dir.setProvincia(provincia);
						dir.setCodigoPostal(rs.getString("direccion_codigoPostal"));
						c.setDireccionCompleta(dir);

						System.out.println(rs.getInt("cliente_telID"));
						tel.setId(rs.getInt("cliente_telID"));
						tel.setNumCelular(rs.getString("telefono_numCelular"));
						tel.setNumLaboral(rs.getString("telefono_numLaboral"));
						tel.setNumPersonal(rs.getString("telefono_numPersonal"));
						c.setTelefono(tel);

						System.out.println(rs.getInt("cliente_pasaporteID"));
						pas.setId(rs.getInt("cliente_pasaporteID"));
						pas.setNumeroPasaporte(rs.getString("pasaporte_numero"));
						pas.setAutoridadEmision(rs.getString("pasaporte_autEmision"));
						
						Date fechaEmisionDB = rs.getDate("pasaporte_fechaEmision");
						LocalDate fechaEmisionJava = fechaEmisionDB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						pas.setFechaEmision(fechaEmisionJava);
						
						Date fechaVencimientoDB = rs.getDate("pasaporte_fechaVencimiento");
						LocalDate fechaVencimientoJava = fechaVencimientoDB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						
						pas.setFechaVencimiento(fechaVencimientoJava);
						pais.setId(rs.getInt("pasaporte_paisID"));
						pais.setNombre("paisPas_id");
						pas.setPais(pais);
						c.setPasaporte(pas);

						pasFre.setId(rs.getInt("cliente_pasFreID"));
						pasFre.setAlianza(Alianza.valueOf((rs.getString("pasajerosfrecuente_alianza"))));
						pasFre.setNumeroPF(rs.getString("pasajerosfrecuente_numeroPF"));
						pasFre.setCategoria(rs.getString("pasajerosfrecuente_categoria"));
						a.setId(rs.getInt("aerolinea_id"));
						a.setNombre(rs.getString("aerolinea_nombre"));
						a.setAlianza(Alianza.valueOf(rs.getString("aerolinea_alianza")));
						pasFre.setAerolinea(a);
						c.setPasajeroFrecuente(pasFre);

						listado.add(c);
					}
					System.out.println("Clientes encontrados: " + listado.size());

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ocurrio un error al leer los datos de la base de datos!");

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
