package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.AdminGeneral;
import modelo.AdminLocal;
import modelo.Categoria;
import modelo.Empleado;
import modelo.Sede;


public class Aplicacion {
	AdminGeneral adminGeneral= new AdminGeneral("Admin1", "Administrador2023", "123456");
	
	
	public void ejecutarAplicacion() throws ParseException 
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
		System.out.println("3. Registrar Administrador local");
		System.out.println("4. Registrar sedes");
		System.out.println("5. Salir al menu principal\n");
		
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
	
	public void ejecutarAdminGeneral() throws ParseException{
		boolean continuar= true;
		while(continuar) 
		{
			String usuario= input("Ingrese su nombre de usuario");	
			String contrasena= input("Ingrese su contraseña");
			if(usuario.equals(adminGeneral.getUsuario()) && contrasena.equals(adminGeneral.getContrasena())){
				mostrarMenuAdminGeneral();
				int opcionSeleccionada = Integer.parseInt(input("Ingrese el numero de la opcion deseada\n"));
				
				if(opcionSeleccionada==1) {
					ejecutarRegistrarVehiculo();
					System.out.println("Recuerde que para registrar un vehiculo debe de tener una sede ya registrada donde asignarlo");
				}
				else if(opcionSeleccionada==2)
					ejecutarEliminarVehiculo();
				else if(opcionSeleccionada==3)
					ejecutarRegistrarAdminLocal();
				else if(opcionSeleccionada==4)
					ejecutarRegistrarSede();
				else if(opcionSeleccionada==5) 
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
	
	public void ejecutarRegistrarVehiculo() throws ParseException{
		boolean continuar= true;
		while(continuar) {
			System.out.println("Recuerde que para registrar un vehiculo debe de tener una sede ya registrada donde asignarlo");
			String respuesta= input("¿La categoria del auto ya ha sido registrada? (Y/N)");
			
			if(respuesta.equals("n")|| respuesta.equals("N")){
				System.out.println("por favor ingrese los datos de la categoria del auto\n");
				String id = input("Ingrese el id de la categoria");
				int tarifaDia = Integer.parseInt(input("Ingrese la tarifa diaria de la categoria"));
				int tarifaExtra = Integer.parseInt(input("Ingrese el valor extra en temporada alta"));
				adminGeneral.registrarCategoria(id, tarifaDia, tarifaExtra);
				System.out.println("La categoria de id "+ id + " se ha registrado\n");
			}
			else {}
			System.out.println("Ahora ingrese los datos del vehiculo ");
			String placa= input("Ingrese la placa del vehiculo");
			String categoriaString= input("Ingrese el ID de la categoria del vehiculo");
			Categoria categoriaObj = null;
			for(Categoria categoria : adminGeneral.getCategorias()) 
			{
				if( categoria.getIdCategoria().equals(categoriaString)) {
					categoriaObj = categoria;
					break;
				}
				else {
					System.out.println("el ID de la categoria no es el correcto.\n");
					continuar= false;
					
				}
			}
			String marca= input("Ingrese el nombre de la marca del vehiculo");
			String modelo= input("Ingrese el modelo del vehiculo");
			String color= input("Ingrese el color del vehiculo");
			String transmision= input("Ingrese el tipo de transmision del vehiculo");
			int puertas = Integer.parseInt(input("Ingrese el numero de puertas"));
			String combustible = input("Ingrese el tipo de combustible del vehiculo");
			String fechaDisponibilidad = ("Ingrese desde que fecha estara disponible el vehiculo en formato (dd/MM/yyyy)");
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = formato.parse(fechaDisponibilidad);
			String sedeString = input("Ingrese el nombre de la sede donde se almacenara el Vehiculo");
			Sede sedeObj= null;
			for(Sede sede : adminGeneral.getSedes()) 
			{
				if( sede.getNombreSede().equals(sedeString)) {
					sedeObj = sede;
					break;
				}
				else {
					System.out.println("el nombre de la sede no es el correcto o no existe.\n");
					continuar= false;
					
				}
			}
			adminGeneral.registrarVehiculo(true, placa, categoriaObj, marca, modelo, color, transmision, puertas, combustible, fecha, sedeObj);
			
		}
		
	}
	public void ejecutarEliminarVehiculo(){
		String placa= input("Ingrese la placa del vehiculo que desea eliminar");
		String sedeNombre = input("Ingrese el nombre de la sede donde se encuentra el vehiculo");
		Sede sedeObj= null;
		for(Sede sede : adminGeneral.getSedes()) 
		{
			if( sede.getNombreSede().equals(sedeNombre)) {
				sedeObj = sede;
				break;
			}
			else {
				System.out.println("el nombre de la sede no es el correcto o no existe.\n");
				
			}
		}
		adminGeneral.eliminarVehiculos(placa, sedeObj);
		System.out.println("El auto de placa "+ placa + " ha sido eliminado");
		
		
	}
		

	
	
	public void ejecutarRegistrarAdminLocal()
	{
		String usuario= input("Ingrese el usuario del nuevo usuario");
		String contrasena= input("Ingrese la contrasena del nuevo usuario");
		String nombre= input("Ingrese el nombre del nuevo usuario");
		adminGeneral.registrarAdminLocal(usuario, contrasena, nombre);
		System.out.println("El administrador local de nombre "+ nombre + " ha sido registrado");
	}
	public void ejecutarRegistrarSede(){
		String respuesta= input("¿Ya registro al Administrador local de la sede? (Y/N)\n");
		if(respuesta.equals("n")|| respuesta.equals("N")){
			ejecutarRegistrarAdminLocal();
		}
		else {}
		String nombre= input("Ingrese el nombre de la sede");
		String ubicacion= input("Ingrese la ubicacion de la sede");
		double horaI= Double.parseDouble(input("Ingrese la hora a la que abre la sede en horario 24h (hh.mm)"));
		double horaF= Double.parseDouble(input("Ingrese la hora a la que cierra la sede en horario 24h (hh.mm)"));
		ArrayList<Double> hora= new ArrayList<>();
		hora.add(horaI);
		hora.add(horaF);
		ArrayList<Empleado> empleados= new ArrayList<>();
		String adminLocalNombre= input("Ingrese el nombre del administrador local de la sede");
		AdminLocal adminLocal = null;
		for(AdminLocal admin : adminGeneral.getAdminLocal()) 
		{
			if( admin.getNombre().equals(adminLocalNombre)) {
				adminLocal = admin;
				break;
			}
			else {
				System.out.println("el nombre del administrador no es correcto o no existe.");
			}	
		}
		adminGeneral.registrarSede(nombre, ubicacion, hora, empleados, adminLocal);
		
	}
	
	
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
	
	
	public static void main(String[] args) throws ParseException
	{
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion();
	}

}
 