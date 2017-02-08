package mlp;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class ReadFromFile {
	Scanner scn;
	private void openFile(String s) {
		try{
			scn= new Scanner(new File(s));
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Файл не найден!");
		}
	}
	private void readFile() {
		
	}
	private void out(){
		
	}
}
