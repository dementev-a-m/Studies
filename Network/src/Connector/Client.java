package Connector;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable{
	static private Socket connection;
	static private ObjectOutputStream output;
	static private ObjectInputStream input;
	String UserName;
	final JTextArea history;
	final JButton send;
	final JTextField message;
	public static void main(String[] args) {
		new Thread(new Client("Massager")).start();;
	}
	public Client(String name) {
		super(name);
		setLayout( new FlowLayout());
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);		
		message= new JTextField(10);
		send= new JButton("Send");
		history = new JTextArea(495, 350);
		send.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==send) {
					sendData(UserName+": " +message.getText());
				}				
			}
		});
		add(message);
		add(send);
		add(history);
		history.setLineWrap(true);
		history.append("Test");
		
		
	}
	@Override
	public void run() {
		try {
			while(true) {
				connection = new Socket(InetAddress.getByName("127.0.0.1"),5678);
				output = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());
				message.setText((String)input.readObject()+"\n");
			}
			
		}
		catch(UnknownHostException e){}
		catch (IOException e){
			
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void sendData(Object obj) {
		try{
			output.flush();
			output.writeObject(obj);
		}
		catch (NullPointerException e) {}
		catch(IOException e) {
			
		}
	}
}
