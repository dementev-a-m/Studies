package model;

import java.time.LocalDate;

import javafx.scene.image.Image;

public class Person {
	private int id;
	private String lastName;
	private String  firstName;
	private String middelName;
	private LocalDate dataBithday;
	private String email;
	private String phone;
	private String sex;
	private Image photo;
	public Person() {
		
	}
	public Person(String lastName,String  firstName,String middelName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
	}
	public Person(String lastName,String  firstName,String middelName,LocalDate dataBithday){
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
		this.dataBithday = dataBithday;
	}
	public Person(String lastName,String  firstName,String middelName,LocalDate dataBithday,Image photo){
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
	public LocalDate getDataBithday() {
		return dataBithday;
	}
	public void setDataBithday(LocalDate dataBithday) {
		this.dataBithday = dataBithday;
	}
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
