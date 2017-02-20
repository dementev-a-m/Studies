package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PersonalController {
	@FXML
	private TableView tablePerson;
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
		
	}
	@FXML
	public void eventbtnAdd(){
		txfSecondName.setText("Тест");
		
	}
}
