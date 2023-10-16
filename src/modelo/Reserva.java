package modelo;

import java.util.ArrayList;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private ArrayList <Conductor> conductores;
	private Vehiculo vehiculo;
	private Seguro segruo;
	private MedioDePago medioDePago;
	
	public Reserva(int id, Cliente pCliente, Conductor conductor, Vehiculo carro, Seguro pSeguro, MedioDePago medioPago) {
		idReserva = id;
		cliente = pCliente;
		conductores.add(conductor);
		vehiculo = carro;
		segruo = pSeguro;
		medioDePago = medioPago;
	}
	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList <Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(ArrayList <Conductor> conductores) {
		this.conductores = conductores;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Seguro getSegruo() {
		return segruo;
	}

	public void setSegruo(Seguro pSegruo) {
		segruo = pSegruo;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioPago) {
		medioDePago = medioPago;
	}

	public void agregarConductor(Conductor conductor) {
		conductores.add(conductor);
	}
}
