package modelo;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Licencia {
	private int numero;
	private String paisExpedicion;
	private Date fechaExpedicion;
	private BufferedImage imagenLicencia;
	
	public Licencia(int numeroLic, String paisExp, Date fechaExp, BufferedImage imagenLic) {
		numero = numeroLic;
		paisExpedicion = paisExp;
		fechaExpedicion = fechaExp;
		imagenLicencia = imagenLic;
	}

	public int getNumeroLic() {
		return numero;
	}

	public String getPaisExp() {
		return paisExpedicion;
	}

	public Date getFechaExp() {
		return fechaExpedicion;
	}

	public BufferedImage getImagenLic() {
		return imagenLicencia;
	}
}
