package mlp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JFrame{
	JButton start, clear, learing, inputeDate;
	JLabel out;
	EventHandler handler = new EventHandler();
	UserInterface(String s) {
	super(s);
		setLayout(new FlowLayout());
		start = new JButton("������");
		clear = new JButton("��������");
		learing = new JButton("��������");
		inputeDate = new JButton("����� ������");
		out = new JLabel("���������: ");
		add(start);
		add(clear);
		add(learing);
		add(out);
		learing.addActionListener(handler);
	}
	public class EventHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==learing)
			{
				
			}
		}
		
	}
}
