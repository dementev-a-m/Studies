package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private AnchorPane pane;
	public static ObservableList<Person> persons = FXCollections.observableArrayList();
	
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
