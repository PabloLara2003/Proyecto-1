package modelo;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Licencia {
	private int numero;
	private String paisExpedicion;
	private Date fechaVencimiento;
	private BufferedImage imagenLicencia;
	
	public Licencia(int numeroLic, String paisExp, Date fechaVen, BufferedImage imagenLic) {
		numero = numeroLic;
		paisExpedicion = paisExp;
		fechaVencimiento = fechaVen;
		imagenLicencia = imagenLic;
	}

	public int getNumeroLic() {
		return numero;
	}
	
	public void setNumeroLic(int numLic) {
		numero = numLic;
	}

	public String getPaisExp() {
		return paisExpedicion;
	}
	
	public void setPaisExpedicion(String paisExp) {
		paisExpedicion = paisExp;
	}

	public Date getFechaVen() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVen) {
		fechaVencimiento = fechaVen;
	}

	public BufferedImage getImagenLic() {
		return imagenLicencia;
	}
	
	public void setImagenLicencia(BufferedImage imagenLic) {
		imagenLicencia = imagenLic;
	}

	public String generarTexto() {
		String texto = getNumeroLic() + "'" + getPaisExp() + "'" + getFechaVen()
				+ "'" + getImagenLic();
		return texto;
	}
}
