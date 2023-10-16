package modelo;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Cliente {
	private String nombre;
	private String correo;
	private String celular;
	private Date fechaNacimiento;
	private String nacionalidad;
	private BufferedImage imagenDocumentoIdentidad;
	private Licencia licencia;
	private MedioDePago medioPago;
	
	public Cliente(String nombreCliente, String correoCliente, String celularCliente, Date fechaN, String nacionalidadCliente, BufferedImage imagenDocumento, Licencia lic, MedioDePago medio) {
		nombre = nombreCliente;
		correo = correoCliente;
		celular = celularCliente;
		fechaNacimiento = fechaN;
		nacionalidad = nacionalidadCliente;
		imagenDocumentoIdentidad = imagenDocumento;
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

	public String generarTexto() {
		String texto = getNombre() + "," + getCorreo() + "," + getCelular() + "," + getFechaNacimiento()
				+ "," + getNacionalidad() + "," + getImagenDocumentoIdentidad() + "," + licencia.generarTexto()
				+ "," + medioPago.generarTexto();
		return texto;
	}
}
