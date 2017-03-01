package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import javax.imageio.ImageIO;

import application.Main;
import connectToServer.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Person;

public class PersonsController {
	@FXML
	private ImageView imageViewPhoto;
	private File file = new File("rec/photo.jpg");
 	@FXML
	private TableView<Person> tablePerson;
 	@FXML 
 	private TableColumn<Person, String> columSecondName;
 	@FXML 
 	private TableColumn<Person,String> columFirstName;
 	@FXML 
 	private TableColumn<Person,String> columMiddelName;
 	@FXML 
 	private TableColumn<Person,LocalDate> columDataBirthday;
	@FXML 
	private TextField txfLastName;
	@FXML
	private TextField txfFirstName;
	@FXML
	private TextField txfMiddelName;
	@FXML
	private DatePicker dataBithday;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnChange;
	@FXML
	private Button btnDelete;
	private LocalDate localDateBithday;
	@FXML
	private void initialize(){		 
			setImage("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTZuwBMpLdnMhRjAhdE6fn6_K1r7F0upUmmpo31Uc_1H31AZoFm2_DcENc");
			initializeTablePersonal();		
	}
	@FXML
	private void eventbtnAdd(){
		//Stage stage = new Stage();
		//newWindows(stage);
		if(txfLastName.getText()!="" && txfFirstName.getText()!="" && txfMiddelName.getText()!="" &&getDate()!=null)
			Main.persons.add(new Person (txfLastName.getText(),txfFirstName.getText(),txfMiddelName.getText(),getDate()));
			//Client.sendData(txfLastName.getText());
	}
	@FXML
	private void eventbtnDelete(){
		int index=tablePerson.getSelectionModel().getSelectedIndex();
		if(index==-1)return;
		Main.persons.remove(index);
		getSelectedRowTableView();
	}
	@FXML
	private void eventbtnChange(){
		int index = tablePerson.getSelectionModel().getSelectedIndex();
		if(index==-1) return;
		Main.id=index;
		Stage stage = new Stage();
		newWindows(stage);
		/*Main.id=tablePerson.getSelectionModel().getSelectedIndex();
		if(index==-1)return;
		if(txfSecondName.getText()!="" && txtFirstName.getText()!="" && txtMiddelName.getText()!="" &&getDate()!=null) {
			Main.persons.get(index).setLastName(txfSecondName.getText());
			Main.persons.get(index).setFirstName(txtFirstName.getText());
			Main.persons.get(index).setMiddelName(txtMiddelName.getText());
			Main.persons.get(index).setDataBithday(getDate());	
			tablePerson.refresh();		
		}	*/
	}
	private LocalDate getDate() {
		localDateBithday=dataBithday.getValue();
		return localDateBithday;
	}
	private void initializeTablePersonal(){
		columSecondName.setCellValueFactory(new PropertyValueFactory<Person,String>("LastName"));
		columFirstName.setCellValueFactory(new PropertyValueFactory<Person,String>("FirstName"));
		columMiddelName.setCellValueFactory(new PropertyValueFactory<Person,String>("MiddelName"));
		columDataBirthday.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("dataBithday"));
		tablePerson.setItems(Main.persons);
	}
	private void setImage(String url) {
		try {
			ImageIO.write(ImageIO.read(new URL(url)),"jpg", file);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	@FXML
	private void getSelectedRowTableView() {
		int index=tablePerson.getSelectionModel().getSelectedIndex();
		if(index!=-1){
			txfLastName.setText(Main.persons.get(index).getLastName());
			txfFirstName.setText(Main.persons.get(index).getFirstName());
			txfMiddelName.setText(Main.persons.get(index).getMiddelName());
			dataBithday.setValue(Main.persons.get(index).getDataBithday());
		} else {
			txfLastName.setText("");
			txfFirstName.setText("");
			txfMiddelName.setText("");
			dataBithday.setValue(null);
		}
	}
	 private void newWindows(Stage stage) {
			try {				
		        Parent root = FXMLLoader.load(getClass().getResource("../views/Person.fxml"));
		        Scene scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
}
