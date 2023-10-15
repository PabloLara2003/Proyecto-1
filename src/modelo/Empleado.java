package modelo;

public class Empleado implements Usuario{
	private String nombre;
    private String usuario;
    private String contrasena;
    
	
	

	public Empleado(String nombre, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	@Override
	public String getUsuario() {
		return usuario;
	}
	@Override
	public String getContrasena() {
		return contrasena;
	}
    
    
    
   

}
