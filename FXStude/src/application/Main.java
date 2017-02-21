package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private AnchorPane pane;
	public static ArrayList<Person> persons=new ArrayList<Person>();
	
	public void start(Stage stage) {	
			this.stage=stage;
			try {
				pane=FXMLLoader.load(Main.class.getResource("MainWindows.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
		
	}	
	public static void main(String[] args) {
		launch(args);
	}

}
