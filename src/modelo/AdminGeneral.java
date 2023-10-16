package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdminGeneral implements Usuario{
	private String nombre;
	private String usuario;
	private String contrasena;
	private List<AdminLocal> administradores = new ArrayList<>(); 
	

	public AdminGeneral(String nombre, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}


	public String getUsuario() {
	
		return usuario;
	}

	public String getContrasena() {
		
		return contrasena;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void registrarVehiculo() {}
	
	public void registrarAdminLocal(String usuario, String contrasena, String nombre) {
		AdminLocal nuevoAdmin= new AdminLocal(usuario,contrasena,nombre);
		administradores.add(nuevoAdmin);
	}
}
