package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	private Object deserialData(String fileName)
	{	
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn); 
			retObject = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retObject; 
	}
	public Object deserData(String fileName, String path) {
		fileName = path+"/"+fileName+".ser";
		return deserialData(fileName);
	}
	public Object deserData(String fileName) {		
		return deserialData(fileName);
	}
	private void serialData(Object obj,String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void serData(Object obj,String fileName, String path, String extension) {
		fileName = path+"/"+fileName+"."+extension;
		serialData(obj,fileName);		
	}
	public void serData(Object obj,String fileName, String path) {
		fileName=path+"/"+fileName+".ser";
		serialData(obj,fileName);
		
	}
	public void serData(Object obj,String fileName) {
		serialData(obj,fileName);
	}
}
	