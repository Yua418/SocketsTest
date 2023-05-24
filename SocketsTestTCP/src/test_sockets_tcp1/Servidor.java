package test_sockets_tcp1;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		final int PORT = 5050;
		ServerSocket server = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("The server is running");
			
			while(true) {
				sc = server.accept();
				System.out.println("Cliente Conectado");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				String text = in.readUTF();
				System.out.println(text);
				
				out.writeUTF("Hola SC");
				
				sc.close();
				System.out.println("Cliente Desconectado");
			}
			
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		};
		
	}

}
