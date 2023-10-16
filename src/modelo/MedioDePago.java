package modelo;

import java.util.Date;

public class MedioDePago {
	private String medio;
	private int numero;
	private Date fechaVencimiento;
	private int CVV;
	
	public MedioDePago(String medioPago, int num, Date fechaVen, int cvv) {
		medio = medioPago;
		if (medio != "efectivo") {
			numero = num;
			fechaVencimiento = fechaVen;
			CVV = cvv;
		}
	}
	
	public String getmedio() {
		return medio;
	}
	
	public void setmedio(String medio) {
		this.medio = medio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}
}
