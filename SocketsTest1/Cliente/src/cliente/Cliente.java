package cliente;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	//TODO: The port comes Here
	public static String IP_SERVIDOR = "The Port is Here";
	public static int PUERTO = 1234;
	
	public static double operar(double num1, double num2, char op) throws Exception {
		Socket sock = new Socket(IP_SERVIDOR, PUERTO);
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		// Send "Data" to server
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeDouble(num1);
		dos.writeDouble(num2);
		dos.writeChar(op);
		
		// Read the answer
		DataInputStream dis = new DataInputStream(in);
		double respuesta = dis.readDouble();
		sock.close();
		
		return respuesta;
	};

	public static void main(String[] args) throws Exception {
		System.out.println("Respuesta Resibida: " + Cliente.operar(10, 49.1, '+'));
	}
}
