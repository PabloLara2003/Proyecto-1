package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private ArrayList <Conductor> conductores = new ArrayList<Conductor>();
	private Vehiculo vehiculo;
	private Seguro seguro;
	private MedioDePago medioDePago;
	
	public Reserva(int id, Cliente pCliente, Conductor conductor, Vehiculo carro, Seguro pSeguro, MedioDePago medioPago) {
		idReserva = id;
		cliente = pCliente;
		conductores.add(conductor);
		vehiculo = carro;
		seguro = pSeguro;
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
	
	public void agregarConductor(Conductor conductor) {
		conductores.add(conductor);
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Seguro getSegruo() {
		return seguro;
	}

	public void setSegruo(Seguro pSegruo) {
		seguro = pSegruo;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioPago) {
		medioDePago = medioPago;
	}
	
	private String generarTexto() {
		String texto = getIdReserva() + ":" + cliente.generarTexto();
		for (int i = 0 ;i < conductores.size(); i++) {
			texto += conductores.get(i).generarTexto() + ":";
		}
		texto += "InfoVehiculo" + ":" + seguro.generarTexto() + ":" + medioDePago.generarTexto();
		return texto;
	}
	
	public void guardarReserva(File archivo, boolean creado) throws IOException {
		String texto = "";
		if (creado) {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null) {
				texto += linea + ";";
				linea = br.readLine();
			}
			br.close();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
		texto += generarTexto();
		String[] reservas = texto.split(";");
		for (int i = 0; i < reservas.length; i++) {
			bw.write(reservas[i]);
			bw.newLine();
		}
		bw.close();
	}
}
