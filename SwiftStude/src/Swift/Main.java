package Swift;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Main {
	private static BufferedImage image;
	private static MainFrame windows;
	public static void main(String[] args) {
		windows=new MainFrame();

	}
	public static void setImage(URL urlImage){
		try {
			image=ImageIO.read(urlImage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setImage(File file){
		try {
			image=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void saveImage(File file, String format)
	{
		try {
			System.out.println("Вызываемся");
			ImageIO.write( getImage(), format, file);
			System.out.println("Вызывались Епта");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getImage() {
		return image;
	}
	public static void setImage(BufferedImage image) {
		Main.image = image;
	}

}
