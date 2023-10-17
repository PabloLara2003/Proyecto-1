package modelo;

import java.util.Date;

public class MedioDePago {
	private String medio;
	private String numero;
	private Date fechaVencimiento;
	private String CVV;
	
	public MedioDePago(String medioPago, String num, Date fechaVen, String cvv) {
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public String generarTexto() {
		String texto = getMedio() + "'" + getNumero() + "'" + getFechaVencimiento() + "'"
				+ getCVV();
		return texto;
	}
}
