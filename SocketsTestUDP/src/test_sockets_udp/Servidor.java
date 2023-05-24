package test_sockets_udp;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.IOException;
import java.net.DatagramPacket;

public class Servidor {

	public static void main(String[] args) {
		final int PORT = 5000;
		byte[] buffer = new byte[1024];
		
		try {
			System.out.println("Iniciando el Servidor UDP");
			DatagramSocket socketUDP = new DatagramSocket(PORT);
			
			while(true) {
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				System.out.println("A la espera de datos del cliente");
				socketUDP.receive(peticion);
				String mensaje = new String(peticion.getData());
				System.out.println(mensaje);
				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();
				
				mensaje = "Hola Mundo desde el Servidor";
				buffer = mensaje.getBytes();
				
				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
				System.out.println("Envio de datos al cliente");
				socketUDP.send(respuesta); 
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
