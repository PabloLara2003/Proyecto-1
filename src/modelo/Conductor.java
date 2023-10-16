package modelo;

public class Conductor {
	Licencia licencia;
	
	public Conductor(Licencia lic) {
		licencia = lic;
	}
	
	public Licencia getLicencia() {
		return licencia;
	}
	
	public void setLicencia(Licencia lic) {
		licencia = lic;
	}

	public String generarTexto() {
		String texto = licencia.generarTexto();
		return texto;
	}
}
