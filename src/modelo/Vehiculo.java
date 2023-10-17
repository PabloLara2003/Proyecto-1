package modelo;

import java.util.Date;

public class Vehiculo {
	private boolean disponibilidad;
	private String placa;
	private Categoria categoria;
	private String marca;
	private String modelo;
	private String color;
	private String tipoTransmision;
	private int cantidadPuertas;
	private String tipoCombustible;
	private Date fechaDisponibilidad;
	
	
	 public Vehiculo(boolean disponibilidad, String placa, Categoria categoria, String marca, String modelo, String color,
			String tipoTransmision, int cantidadPuertas, String tipoCombustible, Date fechaDisponibilidad) {
		super();
		this.disponibilidad = disponibilidad;
		this.placa = placa;
		this.categoria = categoria;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.cantidadPuertas = cantidadPuertas;
		this.tipoCombustible = tipoCombustible;
		this.fechaDisponibilidad = fechaDisponibilidad;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipoTransmision() {
		return tipoTransmision;
	}
	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}
	public int getCantidadPuertas() {
		return cantidadPuertas;
	}
	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}
	public String getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	public Date getFechaDisponibilidad() {
		return fechaDisponibilidad;
	}
	public void setFechaDisponibilidad(Date fechaDisponibilidad) {
		this.fechaDisponibilidad = fechaDisponibilidad;
	}

}
