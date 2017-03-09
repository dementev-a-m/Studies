package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Person;

public class PersonDB {
	private Statement statement;
	private DBWorker worker;
	public PersonDB() {
		worker = new DBWorker();
		try {
			statement = worker.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void query(String query) {
		try {	
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("Id"));
				person.setLastName(resultSet.getString("LastName"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setMiddelName(resultSet.getString("MiddelName"));
				person.setDataBithday(resultSet.getDate("Bithday").toLocalDate());
				person.setSex(resultSet.getString("Sex"));
				person.setEmail(resultSet.getString("Email"));
				person.setPhone(resultSet.getString("Phone"));
				person.setStatus(resultSet.getString("Status"));
				
			}
				
		}
		catch(SQLException e) {
		}
	}
	
	protected void finalize(){
		 try {
			statement.close();
			worker.getCon().close();
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
	}
}

