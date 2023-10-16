package modelo;

import java.util.ArrayList;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	ArrayList <Conductor> conductores;
	Vehiculo vehiculo;
	
	public void agregarConductor(Conductor conductor) {
		conductores.add(conductor);
	}
}
