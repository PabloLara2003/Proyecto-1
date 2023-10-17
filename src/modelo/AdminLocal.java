package modelo;

public class AdminLocal implements Usuario{
	private String usuario;
	private String contrasena; 
	private String nombre;

	public AdminLocal(String usuario, String contrasena, String nombre) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
	}

	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}


}
