package thrd;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;

public class frsThrd implements Runnable {
	int time;
	String name;
	Random random = new Random();
	frsThrd(String name)
	{
		this.name=name;
		time=random.nextInt(999);  
	}
	@Override
	public void run() {
		System.out.printf("����� %s ���� %d ������",name,time);
		try {
			Thread.sleep(time);
		}
		catch(Exception e){
			System.out.printf("����� %s ��������� � ���������� %d ������",name,time);
			
		}
	}


}
