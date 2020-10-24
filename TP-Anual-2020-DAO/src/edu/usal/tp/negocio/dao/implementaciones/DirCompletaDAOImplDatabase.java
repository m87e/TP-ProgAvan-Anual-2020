package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.interfaces.DirCompletaDAO;

public class DirCompletaDAOImplDatabase implements DirCompletaDAO {

	final String INSERT = "INSERT INTO Direcciones (direccion_calle, direccion_altura, direccion_ciudad, direccion_paisID, direccion_provinciaID, direccion_codigoPostal) values (?,?,?,?,?,?)";

	@Override
	public void AgregarDirCompleta(DirCompleta dir, Connection con) throws IOException {
		// TODO Auto-generated method stub

		// DirCompleta dir = new DirCompleta(1, "Test", "3500", "BA", p, prov, "1424");

		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dir.getCalle());
			ps.setString(2, dir.getAltura());
			ps.setString(3, dir.getCiudad());
			ps.setInt(4, dir.getPais().getId());
			ps.setInt(5, dir.getProvincia().getId());
			ps.setString(6, dir.getCodigoPostal());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				dir.setId((int) rs.getLong(1));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void ModificarDirCompleta(DirCompleta dir) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarDirCompleta(DirCompleta dir) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public DirCompleta ObtenerDirCompletaPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DirCompleta> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
