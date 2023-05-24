package test_sockets_tcp1;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	//TODO: Here comes the IP port
	public static void main(String[] args) {
		final String HOST = "Here comes the IP port";
		final int PORT = 5050;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			sc = new Socket(HOST, PORT);
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF("Client message");
			String message = in.readUTF();
			
			System.out.println(message);
			
			sc.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}