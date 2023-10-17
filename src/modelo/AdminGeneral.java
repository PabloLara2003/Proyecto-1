package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminGeneral implements Usuario{
	private String nombre;
	private String usuario;
	private String contrasena;
	private List<AdminLocal> administradores = new ArrayList<>(); 
	private List<Sede> sedes = new ArrayList<>();
	private List<Categoria> categorias= new ArrayList<>();
	

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
	
	public List<Categoria> getCategorias(){
		return categorias;
	}
	
	public List<Sede> getSedes(){
		return sedes;
	}
	
	public void registrarVehiculo(boolean disponibilidad, String placa, Categoria categoria, String marca, String modelo, String color,
			String tipoTransmision, int cantidadPuertas, String tipoCombustible, Date fechaDisponibilidad, Sede sede) 
	{
		Vehiculo nuevoVehiculo = new Vehiculo(disponibilidad, placa, categoria, marca, modelo, color, tipoTransmision, cantidadPuertas, tipoCombustible,
		fechaDisponibilidad);
		sede.agregarVehiculos(nuevoVehiculo);
		
		
	}
	
	public void registrarAdminLocal(String usuario, String contrasena, String nombre) {
		AdminLocal nuevoAdmin= new AdminLocal(usuario,contrasena,nombre);
		administradores.add(nuevoAdmin);
	}
	
	public void registrarCategoria(String idCategoria, int tarifaPorDia, int valorExtra) {
		Categoria nuevaCategoria= new Categoria(idCategoria,tarifaPorDia,valorExtra);
		categorias.add(nuevaCategoria);
		
	}
	
}
