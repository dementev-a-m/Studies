package application;
	
import java.io.IOException;
import connectToServer.Client;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Person;


public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private AnchorPane pane;
	private static Thread connectToServer;
	public static String host="127.0.0.1";
	public static int port=5678;
	public static ObservableList<Person> persons = FXCollections.observableArrayList();
	public static int id;
	public void start(Stage stage) {	
			this.stage=stage;
			try {
				pane=FXMLLoader.load(getClass().getResource("views/MainWindows.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();	
	}	
	public static void main(String[] args) {
		//connectToServer= new Thread( new Client(host,port));
		//connectToServer.start();
		launch(args);
		
	}
	@Override
	public void stop(){
		//connectToServer.interrupt();  
	}

}
