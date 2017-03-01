package application.controller;


import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

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
	private ComboBox cmbSex;
	@FXML
	private TextField txfPhone;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSave;
	@FXML
	private TextField txfEmail;
	@FXML
	private void initialize(){			
		System.out.println("Метод работает");
		System.out.println(Main.id);
		getData();
	}
	@FXML
	private void eventSave(){
		Main.persons.get(Main.id).setLastName(txfLastName.getText());
		Main.persons.get(Main.id).setFirstName(txfFirstName.getText());
		Main.persons.get(Main.id).setMiddelName(txfMiddelName.getText());
		Main.persons.get(Main.id).setDataBithday(dataBithday.getValue());
		Main.persons.get(Main.id).setSex((String)cmbSex.getValue());
		Main.persons.get(Main.id).setPhone(txfPhone.getText());
		Main.persons.get(Main.id).setEmail(txfEmail.getText());
	}
	private void eventCancel() {
		
	}
	private void setData(){
		Main.persons.get(Main.id).setLastName(txfLastName.getText());
		Main.persons.get(Main.id).setFirstName(txfFirstName.getText());
		Main.persons.get(Main.id).setMiddelName(txfMiddelName.getText());
		Main.persons.get(Main.id).setDataBithday(dataBithday.getValue());
		Main.persons.get(Main.id).setSex((String)cmbSex.getValue());
		Main.persons.get(Main.id).setPhone(txfPhone.getText());
		Main.persons.get(Main.id).setEmail(txfEmail.getText());
	}
	private void getData() {
		txfLastName.setText(Main.persons.get(Main.id).getLastName());
		txfFirstName.setText(Main.persons.get(Main.id).getFirstName());
		txfMiddelName.setText(Main.persons.get(Main.id).getMiddelName());
		dataBithday.setValue(Main.persons.get(Main.id).getDataBithday());
	}
}
