package application;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersonalController {
	private static BufferedImage image;
	private ImageView imageViewPhoto;
 	@FXML
	private TableView<Person> tablePerson;
 	@FXML 
 	private TableColumn columSecondName;
 	@FXML 
 	private TableColumn columFirstName;
 	@FXML 
 	private TableColumn columMiddelName;
 	@FXML 
 	private TableColumn columDataBirthday;
	@FXML 
	private TextField txfSecondName;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtMiddelName;
	@FXML
	private DatePicker dataBithday;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnChange;
	@FXML
	private Button btnDelete;
	@FXML
	public void initialize(){
		imageViewPhoto.setImage(image);
	}
	@FXML
	public void eventbtnAdd(){
		Main.persons.add(new Person (txfSecondName.getText(),txtFirstName.getText(),txtMiddelName.getText()));
		
	}
	public void eventbtnDelete(){
		//Main.persons.remove(null);
	}
	public void eventbtnChange(){
		//Main.persons.remove(null);
	}
	public void setImage(URL url){
		try {
			image=ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}
	
}
