package model;

public class Main {
public static MainFrame frame;
	public static void main(String[] args) {
		frame=new MainFrame();
		for(int i=0;i<10;i++)
			frame.addElement("Hello world!");

	}

}
