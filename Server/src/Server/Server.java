package Server;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Server implements Runnable{
		static private ServerSocket server;
		static private Socket connection;
		static private ObjectOutputStream output;
		static private ObjectInputStream input;
		//static private ArrayList<Person> persons = new ArrayList<Person>();
		public static void main(String[] args) {
				new Thread(new Server()).start();
		}
		@Override
		public void run() {
			try {
				server = new ServerSocket(5678,1000);
				while(true) {
					connection =  server.accept();
					System.out.println(connection.getInetAddress());
					output = new ObjectOutputStream(connection.getOutputStream());
					input = new ObjectInputStream(connection.getInputStream());
					output.writeObject(input.readObject());
				}	
				
			}
			catch(UnknownHostException e){}
			catch (IOException e){} 
			catch (HeadlessException e) {} 
			catch (ClassNotFoundException e) {}		
			finally {
				System.out.println("Сервер остановлен");
			}
		}	
		/*public static void NewPers(){
			try {
				output.flush();
				output.writeObject(new Person("Серввер","Присала"," хера"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/

}
