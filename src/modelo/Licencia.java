package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class Licencia {
	private String numero;
	private String paisExpedicion;
	private Date fechaVencimiento;
	private BufferedImage imagenLicencia;
	private String rutaImagenLicencia;
	
	public Licencia(String numeroLic, String paisExp, Date fechaVen, String rutaImagenLic) throws IOException {
		numero = numeroLic;
		paisExpedicion = paisExp;
		fechaVencimiento = fechaVen;
		rutaImagenLicencia = rutaImagenLic;
		imagenLicencia = ImageIO.read(new File(rutaImagenLicencia));
	}

	public String getNumeroLic() {
		return numero;
	}
	
	public void setNumeroLic(String numLic) {
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

	public String getRutaImagenLicencia() {
		return rutaImagenLicencia;
	}

	public void setRutaImagenLicencia(String rutaImagenLicencia) {
		this.rutaImagenLicencia = rutaImagenLicencia;
	}
	
	public String generarTextoFechaVencimiento() {
		String texto = "";
		texto += fechaVencimiento.getYear() + "." + fechaVencimiento.getMonth() + "." + fechaVencimiento.getDate() + "." + fechaVencimiento.getHours() + "." + fechaVencimiento.getMinutes() + "." + fechaVencimiento.getSeconds();
		return texto;
	}
	
	public String generarTexto() {
		String texto = getNumeroLic() + "'" + getPaisExp() + "'" + generarTextoFechaVencimiento()
				+ "'" + getRutaImagenLicencia();
		return texto;
	}
}
