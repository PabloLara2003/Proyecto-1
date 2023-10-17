package modelo;

import java.util.ArrayList;
//ee
//
public class Sede {
	private String nombreSede;
	private String ubicacion;
	private ArrayList<Double> horarioAtencion;
	private ArrayList<Empleado> empleados;
	private AdminLocal adminLocal;
	private ArrayList<Vehiculo> vehiculos; 
	
	public Sede(String nombreSede, String ubicacion, ArrayList<Double> horarioAtencion, ArrayList<Empleado> empleados,
			AdminLocal adminLocal) {
		super();
		this.nombreSede = nombreSede;
		this.ubicacion = ubicacion;
		this.horarioAtencion = horarioAtencion;
		this.empleados = empleados;
		this.adminLocal = adminLocal;
		
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public ArrayList<Double> getHorarioAtencion() {
		return horarioAtencion;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public AdminLocal getAdminLocal() {
		return adminLocal;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public void agregarVehiculos(Vehiculo vehiculo) 
	{
		vehiculos.add(vehiculo);
	}
	public void eliminarVehiculo(Vehiculo vehiculo) 
	{
		vehiculos.remove(vehiculo);
	}

}
