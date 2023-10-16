package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.AdminGeneral;

public class Aplicacion {
	AdminGeneral adminGeneral= new AdminGeneral("Admin1", "Administrador2023", "123456");
	
	
	public void ejecutarAplicacion() 
	{
		boolean continuar= true;
		while(continuar)
		{
			System.out.println("Bienvendio a la aplicacion, por favor seleccione el numero que indique su tipo de usuario:\n");
			mostrarUsuarios();
			int opcionSeleccionada = Integer.parseInt(input(""));
			if(opcionSeleccionada== 1)
				ejecutarCliente();
			else if(opcionSeleccionada==2)
				ejecutarEmpleado();
			else if(opcionSeleccionada==3)
				ejecutarAdminLocal();
			else if(opcionSeleccionada==4)
				ejecutarAdminGeneral();
			else if(opcionSeleccionada==5)
			{
				System.out.println("Cerrando la aplicacion");
				continuar= false;
			}
		}
	}
	
	
	public void mostrarUsuarios()
	{
		System.out.println("1. Cliente");
		System.out.println("2. Empleado");
		System.out.println("3. Administrador Local");
		System.out.println("4. Administrador general");
		System.out.println("5. Salir de la aplicacion");
	}
	public void mostrarMenuAdminGeneral(){
		System.out.println("1. Registrar vehiculo");
		System.out.println("2. Eliminar vehiculo");
		System.out.println("3. Registrar empleado");
		System.out.println("4. Registrar Administrador local");
		System.out.println("5. Registrar sedes");
		System.out.println("6. Salir al menu principal\n");
		
	}
	
	public void ejecutarCliente(){}
	public void ejecutarEmpleado(){}
	
	public void ejecutarAdminLocal(){
		boolean continuar = true;
		while(continuar) 
		{
			String usuario= input("Ingrese su nombre de usuario");	
			String contrasena= input("Ingrese su contraseña");
			//if(usuario==usuarioAdmin && contrasena==contrasenaAdmin){
		
			//}
		}
	}
	
	public void ejecutarAdminGeneral(){
		boolean continuar= true;
		while(continuar) 
		{
			String usuario= input("Ingrese su nombre de usuario");	
			String contrasena= input("Ingrese su contraseña");
			if(usuario.equals(adminGeneral.getUsuario()) && contrasena.equals(adminGeneral.getContrasena())){
				mostrarMenuAdminGeneral();
				int opcionSeleccionada = Integer.parseInt(input("Ingrese el numero de la opcion deseada\n"));
				
				if(opcionSeleccionada==1)
					ejecutarRegistrarVehiculo();
				else if(opcionSeleccionada==2)
					ejecutarEliminarVehiculo();
				else if(opcionSeleccionada==3)
					ejecutarRegistrarEmpleado();
				else if(opcionSeleccionada==4)
					ejecutarRegistrarAdminLocal();
				else if(opcionSeleccionada==5)
					ejecutarRegistrarSede();
				else if(opcionSeleccionada==6) 
				{
					System.out.println("Cerrando la aplicacion");
					continuar= false;
				}
			}
			else {
				System.out.println("Contraseña o usuario incorrecto");
				continuar=false;
				}
		}
	}
	
	public void ejecutarRegistrarVehiculo(){}
	public void ejecutarEliminarVehiculo(){}
	public void ejecutarRegistrarEmpleado(){}
	public void ejecutarRegistrarAdminLocal()
	{
		String usuario= input("Ingrese el usuario del nuevo usuario");
		String contrasena= input("Ingrese la contrasena del nuevo usuario");
		String nombre= input("Ingrese el nombre del nuevo usuario");
		adminGeneral.registrarAdminLocal(usuario, contrasena, nombre);
	}
	public void ejecutarRegistrarSede(){}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args)
	{
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion();
	}

}
 