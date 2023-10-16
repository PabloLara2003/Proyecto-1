package modelo;

public class Conductor {
	Licencia licencia;
	
	public Conductor(Licencia lic) {
		licencia = lic;
	}
	
	public Licencia getLicencia() {
		return licencia;
	}
}
