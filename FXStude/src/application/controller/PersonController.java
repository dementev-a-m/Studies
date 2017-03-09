package application.controller;


import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class PersonController {
	public static Stage stage;
	public static boolean clickAdd;
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
		if(!clickAdd)
			getData(Main.id);
	}
	@FXML
	private void eventSave(){
		if(clickAdd) {
			addData();
		} else {
			setData(Main.id);
		}
		stage.close();
	}
	@FXML
	private void eventCancel() {
		if(clickAdd)
			Main.persons.remove(Main.id);
		stage.close();
	}
	private void setData(int index){
		Main.persons.get(index).setLastName(txfLastName.getText());
		Main.persons.get(index).setFirstName(txfFirstName.getText());
		Main.persons.get(index).setMiddelName(txfMiddelName.getText());
		Main.persons.get(index).setDataBithday(dataBithday.getValue());
		Main.persons.get(index).setSex((String)cmbSex.getValue());
		Main.persons.get(index).setPhone(txfPhone.getText());
		Main.persons.get(index).setEmail(txfEmail.getText());
	}
	private void addData(){
		Person person= new Person();
		person.setLastName(txfLastName.getText());
		person.setFirstName(txfFirstName.getText());
		person.setMiddelName(txfMiddelName.getText());
		person.setDataBithday(dataBithday.getValue());
		person.setSex((String)cmbSex.getValue());
		person.setPhone(txfPhone.getText());
		person.setEmail(txfEmail.getText());
		Main.persons.add(person);
	}
	private void getData(int index) {
		txfLastName.setText(Main.persons.get(index).getLastName());
		txfFirstName.setText(Main.persons.get(index).getFirstName());
		txfMiddelName.setText(Main.persons.get(index).getMiddelName());
		dataBithday.setValue(Main.persons.get(index).getDataBithday());
		cmbSex.setValue(Main.persons.get(index).getSex());
		txfPhone.setText(Main.persons.get(index).getPhone());
		txfEmail.setText(Main.persons.get(index).getEmail());
	}
}
