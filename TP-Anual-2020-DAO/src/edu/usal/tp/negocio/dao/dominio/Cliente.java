package edu.usal.tp.negocio.dao.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private Pasaporte pasaporte;
	private String cuit;
	private LocalDate fechaNac;
	private String email;
	private Telefono telefono;
	private PasajeroFrecuente pasajeroFrecuente;
	private DireccionCompleta direccionCompleta;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public PasajeroFrecuente getPasajeroFrecuente() {
		return pasajeroFrecuente;
	}

	public void setPasajeroFrecuente(PasajeroFrecuente pasfre) {
		this.pasajeroFrecuente = pasfre;
	}

	public DireccionCompleta getDireccionCompleta() {
		return direccionCompleta;
	}

	public void setDireccionCompleta(DireccionCompleta dir) {
		this.direccionCompleta = dir;
	}

	// Constructors

	public Cliente() {

		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nombre, String apellido, String dni, Pasaporte pasaporte, String cuit,
			LocalDate fechaNac, String email, Telefono telefono, PasajeroFrecuente pasajeroFrecuente,
			DireccionCompleta direccionCompleta) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pasaporte = pasaporte;
		this.cuit = cuit;
		this.fechaNac = fechaNac;
		this.email = email;
		this.telefono = telefono;
		this.pasajeroFrecuente = pasajeroFrecuente;
		this.direccionCompleta = direccionCompleta;
	}

}
