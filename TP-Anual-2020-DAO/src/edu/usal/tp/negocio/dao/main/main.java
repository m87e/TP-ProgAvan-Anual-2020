package edu.usal.tp.negocio.dao.main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.ClientesFactory;
import edu.usal.tp.negocio.dao.factory.PaisesFactory;
import edu.usal.tp.negocio.dao.factory.ProvinciasFactory;
import edu.usal.tp.negocio.dao.factory.TelefonoFactory;
import edu.usal.tp.negocio.dao.implementaciones.AerolineaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;
import edu.usal.tp.negocio.dao.util.IOGeneral;
import edu.usal.tp.negocio.dao.util.SQLDatabaseConnection;

public class main {

	public static void main(String[] args) throws IOException, ParseException {

		DirCompleta dir = cargarDirCompleta();

		if(dir!=null) {
			System.out.println("test");
		}

	}

	static DirCompleta cargarDirCompleta() {

		// DirCompleta dir = new DirCompleta(1, "Test", "3500", "BA", p, prov, "1424");
		Paises p = new Paises(1, "Argentina");
		Provincias prov = new Provincias(1, "Buenos");

		DirCompleta dir = new DirCompleta();
		dir.setCalle((IOGeneral.leerLinea("ingrese nombre calle")));
		dir.setAltura((IOGeneral.leerLinea("ingrese altura de la calle")));
		dir.setCiudad((IOGeneral.leerLinea("ingrese nombre ciudad")));
		dir.setPais(p);
		dir.setProvincia(prov);
		dir.setCodigoPostal((IOGeneral.leerLinea("ingrese codigo postal")));
		return dir;
	}

	/*
	 * 
	 * Connection con = null;
	 * 
	 * try { con = SQLDatabaseConnection.conectar(); con.setAutoCommit(false); }
	 * catch (SQLException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); }
	 * 
	 * IClienteDAO impCliDAO = ClientesFactory.GetImplementation("database");
	 * 
	 * LocalDate d = LocalDate.now();
	 * 
	 * Cliente cli1 = new Cliente(); Telefono t = new Telefono(1, "23456", "23415",
	 * "23452"); Paises p = new Paises(1, "Argentina"); Provincias prov = new
	 * Provincias(1, "Buenos"); Pasaporte pas = new Pasaporte(1, "AAA333444", p,
	 * "Consulado", d, d); Aerolinea aerolinea = new Aerolinea(1, "United Airlines",
	 * Alianza.StarAlliance); PasajeroFrecuente pasFrec = new PasajeroFrecuente(1,
	 * Alianza.StarAlliance, aerolinea, "UA88", "Silver"); DirCompleta dir = new
	 * DirCompleta(1, "Test", "3500", "BA", p, prov, "1424");
	 * 
	 * cli1.setNombre("TestCommit"); cli1.setApellido("TestRollback");
	 * cli1.setDni("59494854"); cli1.setEmail("test@fake.com");
	 * cli1.setCuit("20-12346345345-1"); cli1.setFechaNac(d); cli1.setTel(t);
	 * cli1.setPas(pas); cli1.setPasfre(pasFrec); cli1.setDir(dir);
	 * 
	 * System.out.println("test clientes ");
	 * 
	 * try { impCliDAO.AgregarCliente(cli1, con);
	 * 
	 * con.commit(); } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); if (con != null) { SQLDatabaseConnection.rollback(con);
	 * System.err.print("Transaction is being rolled back"); } }
	 * 
	 * 
	 * IAerolineaDAO dao = AerolineaFactory.GetImplementation("database");
	 * 
	 * Aerolinea aerolinea = new Aerolinea(); aerolinea.setId(2);
	 * aerolinea.setNombre("United Airlines");
	 * aerolinea.setAlianza(Alianza.StarAlliance);
	 * 
	 * // dao.AgregarAerolinea(aerolinea); // dao.ModificarAerolinea(aerolinea); //
	 * dao.EliminarAerolinea(aerolinea);
	 * 
	 * List<Aerolinea> listado = dao.GetAll(); listado.stream().forEach((p) -> {
	 * System.out.println(p.getId()); System.out.println(p.getNombre()); });
	 * 
	 * /* System.out.println("Testing"); System.out.println("1- Provincias");
	 * System.out.println("2- Telefono"); System.out.println("3- Clientes");
	 * 
	 * int op = IOGeneral.leerInt("Opcion", "Error");
	 * 
	 * switch (op) { case 1: // Testing Provincias
	 * 
	 * Provincias provincia1 = new Provincias(); provincia1.setId("BAS");
	 * provincia1.setNombre("Buenos Aires");
	 * 
	 * IProvinciasDAO impProvDAO = ProvinciasFactory.GetImplementation("Archivo");
	 * 
	 * try { impProvDAO.AgregarProvincia(provincia1); provincia1.setId("TUC");
	 * provincia1.setNombre("Tucuman"); impProvDAO.AgregarProvincia(provincia1);
	 * 
	 * List<Provincias> listado = impProvDAO.GetAll();
	 * 
	 * for (Provincias prov : listado) { System.out.println(prov.getId() + " " +
	 * prov.getNombre()); }
	 * 
	 * } catch (Exception e) { System.out.println("El archivo no fue encontrado");
	 * e.printStackTrace(); } break;
	 * 
	 * case 2: // Testing Provincias Telefono tel = new Telefono();
	 * tel.setNumCelular("156797679"); tel.setNumLaboral("54544");
	 * tel.setNumPersonal("564613218");
	 * 
	 * ITelefonoDAO impTelDAO = TelefonoFactory.GetImplementation("Archivo");
	 * 
	 * try { impTelDAO.AgregarTelefono(tel); tel.setNumCelular("1123");
	 * tel.setNumLaboral("12314"); tel.setNumPersonal("123148");
	 * impTelDAO.AgregarTelefono(tel);
	 * 
	 * List<Telefono> listado = impTelDAO.GetAll();
	 * 
	 * for (Telefono tel1 : listado) { System.out.println(tel1.getNumCelular() + " "
	 * + tel1.getNumLaboral() + tel1.getNumPersonal()); }
	 * 
	 * } catch (Exception e) { System.out.println("El archivo no fue encontrado");
	 * e.printStackTrace(); }
	 * 
	 * break;
	 * 
	 * case 3: // Testing Clientes Cliente cli1 = new Cliente();
	 * cli1.setNombre("Pedro"); cli1.setApellido("Smith"); cli1.setDni("859494854");
	 * cli1.setEmail("afdf@rfgerfg.com");
	 * 
	 * IClienteDAO impCliDAO = ClientesFactory.GetImplementatios("Archivo");
	 * 
	 * try { impCliDAO.AgregarCliente(cli1); cli1.setNombre("Jonh");
	 * cli1.setApellido("Smith"); cli1.setDni("123445678");
	 * cli1.setCuit("12-12346345345-1"); cli1.setEmail("qwer@qwer.com");
	 * 
	 * Date d = new Date (); d.setDate(2); d.setMonth(10); d.setYear(1999);
	 * 
	 * cli1.setFechaNac(d); cli1.setTelID(1); cli1.setTelefono(1, "123456",
	 * "123415", "123452");
	 * 
	 * 
	 * } catch (Exception e) { System.out.println("El archivo no fue encontrado");
	 * e.printStackTrace(); }
	 * 
	 * break;
	 * 
	 * default: break; }
	 */
}
