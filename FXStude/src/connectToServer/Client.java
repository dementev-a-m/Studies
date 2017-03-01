package connectToServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import application.Main;
import model.Person;

public class Client implements Runnable{
	private static Socket connection;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private String hostname;
	private int port;
	public Client(String hostname,int port) {
		this.hostname=hostname;
		this.port=port;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				connection = new Socket(InetAddress.getByName(hostname), port);
				output = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());
				input.readObject();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}	
	
	}
	public static void sendData(Object obj) {
		try {
			output.flush();	
			output.writeObject(obj);				
		}
		catch (NullPointerException e) {}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
