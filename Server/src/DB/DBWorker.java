package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
	private Connection con;
	private String url="jdbc:mysql://localhost/mysql";
	private String user = "root";
	private String password = "dementev4";
	public DBWorker(){
		try {			
			con= DriverManager.getConnection(url, user, password);			
			System.out.println("Соединение уставнолено");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Connection getCon() {
		return con;
	}
	
}
