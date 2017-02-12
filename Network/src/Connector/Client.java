package Connector;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	String name;
	private JTextArea txtHistory;
	private Component btnSend;
	private JTextField txtMessage;
	public String userName;
	public Client(String name){
		super(name);
		userName=JOptionPane.showInputDialog("Введите имя:");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtMessage = new JTextField();
		txtMessage.setBounds(12, 318, 349, 22);
		getContentPane().add(txtMessage);
		txtMessage.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Client.sendData(userName+": " +txtMessage.getText());
				txtMessage.setText("");
			}
		});
		btnSend.setBounds(373, 317, 97, 25);
		getContentPane().add(btnSend);
		
		txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		txtHistory.setBounds(12, 13, 458, 292);
		getContentPane().add(txtHistory);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		new Thread(new Client("Чатик")).start();
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				connection = new Socket(InetAddress.getByName("127.0.0.1"),5678);
				output = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());
				txtHistory.append((String)input.readObject()+"\n");
				
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
	public static void sendData(Object obj) {
		try{
			output.flush();
			output.writeObject(obj);
		}
		catch (NullPointerException e) {}
		catch(IOException e) {
			
		}
	}
}
