package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class PersonalController {
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
	private LocalDate localDateBithday;
	@FXML
	private void initialize(){		 
			setImage("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTZuwBMpLdnMhRjAhdE6fn6_K1r7F0upUmmpo31Uc_1H31AZoFm2_DcENc");
			Main.persons.add(new Person("Дементьев","Антон","Михал",null));
			initializeTablePersonal();		
	}
	@FXML
	private void eventbtnAdd(){
		if(txfSecondName.getText()!="" && txtFirstName.getText()!="" && txtMiddelName.getText()!="" &&getDate()!=null)
			Main.persons.add(new Person (txfSecondName.getText(),txtFirstName.getText(),txtMiddelName.getText(),getDate()));
	}
	@FXML
	private void eventbtnDelete(){
		int index=tablePerson.getSelectionModel().getSelectedIndex();
		if(index==-1)return;
		Main.persons.remove(index);
	}
	@FXML
	private void eventbtnChange(){
		int index=tablePerson.getSelectionModel().getSelectedIndex();
		if(index==-1)return;
		if(txfSecondName.getText()!="" && txtFirstName.getText()!="" && txtMiddelName.getText()!="" &&getDate()!=null) {
			Main.persons.get(index).setLastName(txfSecondName.getText());
			Main.persons.get(index).setFirstName(txtFirstName.getText());
			Main.persons.get(index).setMiddelName(txtMiddelName.getText());
			Main.persons.get(index).setDataBithday(getDate());	
			tablePerson.refresh();		
		}	
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
		txfSecondName.setText(Main.persons.get(index).getLastName());
		txtFirstName.setText(Main.persons.get(index).getFirstName());
		txtMiddelName.setText(Main.persons.get(index).getMiddelName());
		dataBithday.setValue(Main.persons.get(index).getDataBithday());
		} else {
			txfSecondName.setText("");
			txtFirstName.setText("");
			txtMiddelName.setText("");
			dataBithday.setValue(null);
		}
	}
}
