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
	private Telefono tel;
	private PasajeroFrecuente pasajeroFrecuente;
	private DirCompleta dir;

	public int getId() {
		return id;
	}

	public void setIdCliente(int id) {
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

	public void setId(int id) {
		this.id = id;
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

	public Telefono getTel() {
		return tel;
	}

	public void setTel(Telefono tel) {
		this.tel = tel;
	}

	public void setTelID(int id) {
		this.tel.setId(id);
	}

	public PasajeroFrecuente getPasajeroFrecuente() {
		return pasajeroFrecuente;
	}

	public void setPasajeroFrecuente(PasajeroFrecuente pasfre) {
		this.pasajeroFrecuente = pasfre;
	}

	public DirCompleta getDir() {
		return dir;
	}

	public void setDir(DirCompleta dir) {
		this.dir = dir;
	}

	public void setTelefono(int ID, String numPersonal, String numCelular, String numLaboral) {
		this.tel.setId(ID);
		this.tel.setNumCelular(numCelular);
		this.tel.setNumLaboral(numLaboral);
	}

	public Cliente() {

		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nombre, String apellido, String dni, Pasaporte pas, String cuit, LocalDate fechaNac,
			String email, Telefono tel, PasajeroFrecuente pasfre, DirCompleta dir) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pasaporte = pas;
		this.cuit = cuit;
		this.fechaNac = fechaNac;
		this.email = email;
		this.tel = tel;
		this.pasajeroFrecuente = pasfre;
		this.dir = dir;
	}

	public void setDirID(int id) {
		this.dir.setId(id);

	}

	public void setPasID(int numeroPasaporte) {
		this.pasaporte.setId(numeroPasaporte);
	}

	public void setPasfreID(int numeroPF) {
		this.pasajeroFrecuente.setId(numeroPF);

	}

}
