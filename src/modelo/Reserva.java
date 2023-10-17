package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private ArrayList <Conductor> conductores = new ArrayList<Conductor>();
	private Categoria tipoDeVehiculo;
	private Seguro seguro;
	private MedioDePago medioDePago;
	private Date fechaInicio;
	private boolean enCurso;
	
	public Reserva(int id, Cliente pCliente, Conductor conductor, Categoria tipoVehiculo, Seguro pSeguro, MedioDePago medioPago, Date fechaIni) {
		idReserva = id;
		cliente = pCliente;
		conductores.add(conductor);
		setTipoDeVehiculo(tipoVehiculo);
		seguro = pSeguro;
		medioDePago = medioPago;
		setFechaInicio(fechaIni);
		setEnCurso(false);
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

	public Categoria getTipoDeVehiculo() {
		return tipoDeVehiculo;
	}

	public void setTipoDeVehiculo(Categoria tipoDeVehiculo) {
		this.tipoDeVehiculo = tipoDeVehiculo;
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
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	public void comprobarInicio(Date fechaActual) {
		setEnCurso(compararFechas(fechaInicio, fechaActual));
	}
	
	private boolean compararFechas(Date fecha1, Date fecha2){
		if ((fecha1.getDate() == fecha2.getDate()) && (fecha1.getMonth() == fecha2.getMonth()) 
				&& (fecha1.getYear() == fecha2.getYear())) {
			return true;
		} else {
			return false;
		}
	}

	private String generarTexto() {
		String texto = getIdReserva() + ":" + cliente.generarTexto();
		for (int i = 0; i < conductores.size(); i++) {
			texto += conductores.get(i).generarTexto() + ",";
		}
		texto = texto.substring(0, texto.length() - 1);
		texto += ":" + "InfoVehiculo" + ":" + seguro.generarTexto() + ":" + medioDePago.generarTexto();
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
