package modelo;

public class AdminLocal implements Usuario{
	private String usuario;
	private String contrasena; 
	private String nombre;

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

}
