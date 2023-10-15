package modelo;

public class AdminGeneral implements Usuario{
	private String nombre;
	private String usuario;
	private String contrasena;
	

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
	

}
