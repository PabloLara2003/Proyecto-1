package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class Cliente {
	private String nombre;
	private String correo;
	private String celular;
	private Date fechaNacimiento;
	private String nacionalidad;
	private BufferedImage imagenDocumentoIdentidad;
	private String rutaImagenDocumentoIdentidad;
	private Licencia licencia;
	private MedioDePago medioPago;
	
	public Cliente(String nombreCliente, String correoCliente, String celularCliente, Date fechaN, String nacionalidadCliente, String rutaImagenDocumento, Licencia lic, MedioDePago medio) throws IOException {
		nombre = nombreCliente;
		correo = correoCliente;
		celular = celularCliente;
		fechaNacimiento = fechaN;
		nacionalidad = nacionalidadCliente;
		rutaImagenDocumentoIdentidad = rutaImagenDocumento;
		imagenDocumentoIdentidad = ImageIO.read(new File(rutaImagenDocumentoIdentidad));
		licencia = lic;
		medioPago = medio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public BufferedImage getImagenDocumentoIdentidad() {
		return imagenDocumentoIdentidad;
	}

	public void setImagenDocumentoIdentidad(BufferedImage imagenDocumentoIdentidad) {
		this.imagenDocumentoIdentidad = imagenDocumentoIdentidad;
	}

	public String getRutaImagenDocumentoIdentidad() {
		return rutaImagenDocumentoIdentidad;
	}

	public void setRutaImagenDocumentoIdentidad(String rutaImagenDocumentoIdentidad) {
		this.rutaImagenDocumentoIdentidad = rutaImagenDocumentoIdentidad;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public MedioDePago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioDePago medioPago) {
		this.medioPago = medioPago;
	}
	
	public String generarTextoFechaNacimiento() {
		String texto = "";
		texto += fechaNacimiento.getYear() + "'" + fechaNacimiento.getMonth() + "'" + fechaNacimiento.getDate() + "'" + fechaNacimiento.getHours() + "'" + fechaNacimiento.getMinutes() + "'" + fechaNacimiento.getSeconds();
		return texto;
	}

	public String generarTexto() {
		String texto = getNombre() + "," + getCorreo() + "," + getCelular() + "," + getFechaNacimiento()
				+ "," + getNacionalidad() + "," + getRutaImagenDocumentoIdentidad() + "," + licencia.generarTexto()
				+ "," + medioPago.generarTexto();
		return texto;
	}
}
