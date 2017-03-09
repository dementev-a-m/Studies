package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DBWorker {
	private static Connection con;
	private String url="jdbc:mysql://localhost/mysql";
	private String user = "root";
	private String password = "dementev4";
	
	DBWorker(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading success");
			
			try {
				con= DriverManager.getConnection(url, user, password);
				System.out.println("Соединение установлено.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			 try {
				con.close();
				System.out.println("Дисконект");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
