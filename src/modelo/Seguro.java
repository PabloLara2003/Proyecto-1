package modelo;

import java.util.Date;

public class Seguro {
	private String poliza;
	private String cobertura;
	private Date fechaInicio;
	private Date vencimiento;
	private String compañía;
	
	public Seguro(String pol, String cober, Date inicio, Date fechaVencimiento, String comp) {
		poliza = pol;
		cobertura = cober;
		fechaInicio = inicio;
		vencimiento = fechaVencimiento;
		compañía = comp;
	}
	
	public String getPoliza() {
		return poliza;
	}
	
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getCompañía() {
		return compañía;
	}

	public void setCompañía(String compañía) {
		this.compañía = compañía;
	}

	public String generarTexto() {
		String texto = getPoliza() + "," + getCobertura() + "," + getFechaInicio() + ","
				+ getVencimiento() + "," + getCompañía();
		return texto;
	}
}