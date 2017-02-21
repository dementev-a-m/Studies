package application;

import java.util.Date;

import javafx.scene.image.Image;

public class Person {
	private String lastName;
	private String  firstName;
	private String middelName;
	private Date dataBithday;
	private Image photo;
	public Person() {
		
	}
	public Person(String lastName,String  firstName,String middelName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
		System.out.println(lastName + "  "+ firstName + "  "+middelName);
	}
	public Person(String lastName,String  firstName,String middelName,Date dataBithday){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
		this.dataBithday = dataBithday;
	}
	public Person(String lastName,String  firstName,String middelName,Date dataBithday,Image photo){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
		this.dataBithday = dataBithday;
		this.photo = photo;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddelName() {
		return middelName;
	}
	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}
	public Date getDataBithday() {
		return dataBithday;
	}
	public void setDataBithday(Date dataBithday) {
		this.dataBithday = dataBithday;
	}
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
}
