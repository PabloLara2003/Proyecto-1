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
	
	public String getMedio() {
		return medio;
	}
	
	public void setMedio(String medio) {
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

	public String generarTexto() {
		String texto = getMedio() + "'" + getNumero() + "'" + getFechaVencimiento() + "'"
				+ getCVV();
		return texto;
	}
}
