package servidor;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorOperaciones {
	public static int PUERTO = 1234;

	private static double procesarOperacion(double n1, double n2, char op) {
		switch (op) {
		case '+': return n1 + n2;
		case '-': return n1 - n2;
		case '*': return n1 * n2;
		case '/': return n1 / n2;
		default: 
			return 0;
		}
	};

	public static void main(String[] args) throws Exception {
		ServerSocket listener = new ServerSocket(PUERTO);
		System.out.println("Servidor corriendo en el puerto " + PUERTO);
		
		while(true) {
			Socket client = listener.accept();
			System.out.println(String.format("Cliente conectado, IP: %s", client.getInetAddress().toString()));
			
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			DataInputStream dataInputStream = new DataInputStream(in);
			
			double num1 = dataInputStream.readDouble();
			double num2 = dataInputStream.readDouble();
			char op = dataInputStream.readChar();
			
			if(op == 'x') break;
			
			double resultado = procesarOperacion(num1, num2, op) ;
			System.out.println(String.format("Mensaje Recibido %f %c %f", num1, op, num2));
			
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeDouble(resultado);
			client.close();
		}
		listener.close();
	}
}
