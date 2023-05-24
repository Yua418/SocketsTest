package test_sockets_udp;

import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) {
		final int PORT_SERVER = 5000;
		byte[] buffer = new byte[1024];
		
		try {
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			DatagramSocket socketUDP = new DatagramSocket();
			
			String mensaje = "Hola Mundo desde el Cliente";
			
			buffer = mensaje.getBytes();
			
			// Hacemos la pregunta
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PORT_SERVER);
			System.out.println("Envio del Datagrama");
			socketUDP.send(pregunta);
			
			// Recibimos la respuesta
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			System.out.println("Recibo respuesta");
			socketUDP.receive(peticion);
			mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			socketUDP.close();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
