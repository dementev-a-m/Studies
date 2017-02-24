package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PersonController {
	@FXML 
	private TextField txfLastName;
	@FXML
	private TextField txfFirstName;
	@FXML
	private TextField txfMiddelName;
	@FXML
	private DatePicker dataBithday;
	@FXML
	private void initialize(){
		txfLastName.setText(Main.persons.get(Main.id).getLastName());
		txfFirstName.setText(Main.persons.get(Main.id).getFirstName());
		txfMiddelName.setText(Main.persons.get(Main.id).getMiddelName());
		dataBithday.setValue(Main.persons.get(Main.id).getDataBithday());
		
	}
}
