package edu.usal.views.console;

import java.time.LocalDate;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.util.IOGeneral;

public class ClienteView {

	public int mostrarMenu() {
		System.out.println("1 - Alta cliente");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}

	public Cliente cargarCliente() {

		Cliente c = new Cliente();

		LocalDate d = LocalDate.now();

		c.setNombre(IOGeneral.leerLinea("Ingrese nombre: "));
		c.setApellido(IOGeneral.leerLinea("Ingrese apellido: "));
		c.setDni(IOGeneral.leerLinea("Ingrese dni: "));
		c.setCuit(IOGeneral.leerLinea("Ingrese cuit: "));
		c.setEmail(IOGeneral.leerLinea("Ingrese email: "));
		c.setFechaNac(d);
		return c;

	}

	public Pasaporte cargarPasaporte() {

		// Pasaporte pas = new Pasaporte(1, "AAA333444", p, "Consulado", d, d);

		Pasaporte pas = new Pasaporte();
		Pais p = new Pais(1, "Argentina");
		LocalDate d = LocalDate.now();
		pas.setNumeroPasaporte(IOGeneral.leerLinea("ingrese numero de pasaporte"));
		pas.setPais(p);
		pas.setAutoridadEmision(IOGeneral.leerLinea("ingrese autoridad de emision"));
		pas.setFechaEmision(d);
		pas.setFechaVencimiento(d);
		return pas;

	}

	public Telefono cargarTelefono() {

		// Telefono t = new Telefono(1, "23456", "23415", "23452");

		Telefono t = new Telefono();
		t.setNumCelular((IOGeneral.leerLinea("ingrese numero de celular")));
		t.setNumLaboral((IOGeneral.leerLinea("ingrese numero laboral")));
		t.setNumPersonal((IOGeneral.leerLinea("ingrese numero personal")));
		return t;

	}

	public DireccionCompleta cargarDirCompleta() {

		// DirCompleta dir = new DirCompleta(1, "Test", "3500", "BA", p, prov, "1424");
		Pais p = new Pais(1, "Argentina");
		Provincia prov = new Provincia(1, "Buenos");

		DireccionCompleta dir = new DireccionCompleta();
		dir.setCalle((IOGeneral.leerLinea("ingrese nombre calle")));
		dir.setAltura((IOGeneral.leerLinea("ingrese altura de la calle")));
		dir.setCiudad((IOGeneral.leerLinea("ingrese nombre ciudad")));
		dir.setPais(p);
		dir.setProvincia(prov);
		dir.setCodigoPostal((IOGeneral.leerLinea("ingrese codigo postal")));
		return dir;
	}

	public PasajeroFrecuente cargarPasFrecuente() {

		// PasajeroFrecuente pasFrec = new PasajeroFrecuente(1, Alianza.StarAlliance,
		// aerolinea, "UA88", "Silver");

		PasajeroFrecuente pas = new PasajeroFrecuente();
		Aerolinea aerolinea = new Aerolinea(1, "United Airlines", Alianza.StarAlliance);

		pas.setAlianza(Alianza.StarAlliance);
		pas.setAerolinea(aerolinea);
		pas.setNumeroPF((IOGeneral.leerLinea("ingrese numero pasajero frecuente")));
		pas.setCategoria((IOGeneral.leerLinea("ingrese nombre categoria")));

		return pas;
	}

}
