package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AlquilerVehiculos {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public void crearReserva(){
		reservas.add(new Reserva(0, null, null, null, null, null, null));
		try {
			boolean creado = true;
			File archivo = new File("data/DatosReservas.txt");
			if (!archivo.exists()) {
				archivo.createNewFile();
				creado = false;
	        }
			reservas.get(reservas.size() - 1).guardarReserva(archivo, creado);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void cargarReservas() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("data/DatosReservas.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			String[] partes = linea.split(":");
			int id = Integer.parseInt(partes[0]);
			String[] partesCliente = partes[1].split(",");
			String[] partesFechaNaci = partesCliente[3].split("'");
			Date fechaNaci = generarFecha(partesFechaNaci);
			String[] partesLicencia = partesCliente[6].split("'");
			String[] partesFechaVen = partesLicencia[2].split(".");
			Date fechaVenLic = generarFecha(partesFechaVen);
			Licencia licencia = new Licencia(partesLicencia[0], partesLicencia[1], fechaVenLic, partesLicencia[3]);
			String[] partesMedioPago = partesCliente[7].split("'");
			String[] partesFechaVenTar = partesMedioPago[2].split(".");
			Date fechaVenTar = generarFecha(partesFechaVenTar);
			MedioDePago medioPago = new MedioDePago(partesMedioPago[0], partesMedioPago[1], fechaVenTar, partesMedioPago[3]);
			Cliente cliente = new Cliente(partesCliente[0], partesCliente[1], partesCliente[2], fechaNaci, partesCliente[4], partesCliente[5], licencia, medioPago);
			String[] partesConductores = partes[2].split(",");
			ArrayList<Conductor> conductores = new ArrayList<Conductor>();
			for (int i = 0; i < partesConductores.length; i++) {
				String[] partesConductor = partesConductores[i].split("'");
				String[] partesFechaVenLic = partesConductor[2].split(".");
				Date fechaVen = generarFecha(partesFechaVenLic);
				Conductor conductor = new Conductor(new Licencia(partesConductor[0], partesConductor[1], fechaVen, partesConductor[3]));
				conductores.add(conductor);
			}
			String[] partesCategoria = partes[3].split(",");
			Categoria categoria = new Categoria(partesCategoria[0], Integer.parseInt(partesCategoria[1]), Integer.parseInt(partesCategoria[2]));
			String[] partesSeguro = partes[4].split(",");
			String[] partesFechaIniSegu = partesSeguro[2].split(".");
			String[] partesFechaVenSegu = partesSeguro[3].split(".");
			Date fechaIniSegu = generarFecha(partesFechaIniSegu);
			Date fechaVenSegu = generarFecha(partesFechaVenSegu);
			Seguro seguro = new Seguro(partesSeguro[0], partesSeguro[1], fechaIniSegu, fechaVenSegu, partesSeguro[4]);
			String[] partesFechaIni = partes[6].split(".");
			Date fechaIni = generarFecha(partesFechaIni);
			Reserva reserva = new Reserva(id, cliente, conductores.get(0), categoria, seguro, medioPago, fechaIni);
			for (int i = 1; i < partesConductores.length; i++) {
				reserva.agregarConductor(conductores.get(i));
			}
			reservas.add(reserva);
			linea = br.readLine();
		}
		br.close();
	}
	
	private Date generarFecha(String[] partesFecha){
		int ano = Integer.parseInt(partesFecha[0]);
		int mes = Integer.parseInt(partesFecha[1]);
		int dia = Integer.parseInt(partesFecha[2]);
		int hora = Integer.parseInt(partesFecha[3]);
		int minuto = Integer.parseInt(partesFecha[4]);
		int segundo = Integer.parseInt(partesFecha[5]);
		Date fecha = new Date(ano, mes, dia, hora, minuto, segundo);
		return fecha;
	}
}
