package Server;

import java.util.PriorityQueue;
import java.util.Queue;

import model.Person;

public class Main {
	private static Thread server;
	public static Queue<Person> person = new PriorityQueue<Person>(); 
	public static void main(String[] args) {
		server=new Thread(new Server());
		server.start();
	}
	public void stop(){
		server.interrupt();  
	}

}
