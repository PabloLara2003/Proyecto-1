package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.AdminGeneral;
import modelo.AdminLocal;
import modelo.AlquilerVehiculos;
import modelo.Categoria;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Sede;


public class Aplicacion {
	AdminGeneral adminGeneral= new AdminGeneral("Admin1", "Administrador2023", "123456");
	AlquilerVehiculos alquiler = new AlquilerVehiculos();
	
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
	
	public void mostrarMenuCliente(){
		System.out.println("Bienvenido señor(a) cliente");
		System.out.println("1. Hacer reserva");
		System.out.println("1. Cancelar reserva");
		System.out.println("2. Salir al menu principal");
	}
	
	public void ejecutarCliente(){
		boolean continuar= true;
		while(continuar) 
		{
			mostrarMenuCliente();
			int opcionSeleccionada = Integer.parseInt(input("Elija una opción"));
			if (opcionSeleccionada == 1) {
				ejecutarCrearReserva();
			}else if (opcionSeleccionada == 2) {
				try {
					ejecutarCancelarReserva();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if (opcionSeleccionada == 3) {
				continuar = false;
			}else {
				System.out.println("Elija una opción valida\n");
			}
		}
	}
	
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
	
	public void ejecutarCrearReserva() {
		String nombreCliente = input("Escriba su nombre");
		String correoCliente = input("Escriba su correo");
		String celualrCliente = input("Escriba su celular");
		String fechaNacimiento = input("Escriba su fecha de nacimiento (formato: AAAA/MM/DD)");
		Date fechaNaci = new Date(Integer.parseInt(fechaNacimiento.substring(0, 4))-1900, Integer.parseInt(fechaNacimiento.substring(5, 7))-1, Integer.parseInt(fechaNacimiento.substring(8, 10)));
		String nacionalidad = input("Escriba su nacionalidad");
		String rutaDocumento = input("Escriba la ruta a la imagen de su documento de identidad");
		String numLicencia = input("Escriba el número de su licencia");
		String paisLic = input("Escriba el país en el cual fue expedida su licencia");
		String fechaVencimientoLic = input("Escriba su fecha de nacimiento (formato: AAAA/MM/DD)");
		Date fechaVenLic = new Date(Integer.parseInt(fechaVencimientoLic.substring(0, 4))-1900, Integer.parseInt(fechaVencimientoLic.substring(5, 7))-1, Integer.parseInt(fechaVencimientoLic.substring(8, 10)));
		String rutaLic = input("Escriba la ruta a la imagen de su licencia");
		String medioDePago = input("Escriba si va a pagar con 'Efectivo' o 'Tarjeta'");
		String num = "N/A";
		String fechaVencimientoTar = "0000/00/00";
		String CVV = "N/A";
		if (medioDePago == "Tarjeta") {
			num = input("Escriba el número de su tarjera");
			fechaVencimientoTar = input("Escriba su fecha de nacimiento (formato: AAAA/MM/DD)");
			Date fechaVenTar = new Date(Integer.parseInt(fechaVencimientoTar.substring(0, 4))-1900, Integer.parseInt(fechaVencimientoTar.substring(5, 7))-1, Integer.parseInt(fechaVencimientoTar.substring(8, 10)));
			CVV = input("Escriba el código de seguridad de su tarjete(CVV)");
		}
		String idCategoria = "N/A";
		int tarifa = 0;
		int valorExtra = 0;
		String reservar = input("¿Desea reservar un carro? (Y/N)");
		if (reservar == "Y") {
			idCategoria = input("Elija la categoría del carro que desea reservar");
		}
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
//		String celualrCliente = input("Escriba su celular");
		String fechaInicio = input("Escriba la fecha de inicio de la reserva:");
		Date fechaIni = new Date(Integer.parseInt(fechaInicio.substring(0, 4))-1900, Integer.parseInt(fechaInicio.substring(5, 7))-1, Integer.parseInt(fechaInicio.substring(8, 10)));
		try {
			alquiler.crearReserva(nombreCliente, correoCliente, nombreCliente, null, nombreCliente, nombreCliente, nombreCliente, nombreCliente, null, nombreCliente, nombreCliente, nombreCliente, null, nombreCliente, nombreCliente, 0, 0, nombreCliente, nombreCliente, null, null, nombreCliente, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ejecutarCancelarReserva() throws IOException {
		ArrayList<Reserva> reservas = alquiler.getReservas();
		System.out.println("Estas son las reservas guardadas en el sistema:\n");
		for (int ind = 0; ind < reservas.size(); ind++) {
			System.out.println(reservas.get(ind).getIdReserva() + ". " + reservas.get(ind).getTipoDeVehiculo().generarTexto() + " " + reservas.get(ind).getFechaInicio() + "\n");
		}
		int idReserva = Integer.parseInt(input("Digite el ID de la reserva que desea cancelar"));
		alquiler.cancelarReserva(idReserva);
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
	
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException
	{
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.alquiler.cargarReservas();
		aplicacion.ejecutarAplicacion();
	}

}
 