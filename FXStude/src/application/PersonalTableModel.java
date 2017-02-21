package application;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PersonalTableModel implements TableModel {
	private ArrayList<TableModelListener> listener;
	public PersonalTableModel() {
		listener= new ArrayList<TableModelListener>();
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		listener.add(arg0);
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int index) {
		switch (index) {
		case 0:
			return  "Фамилия";
		case 1:
			return "Имя";
		case 2:
			return "Отчество";	
		case 3:
			return "Дата рождения";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return listener.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return Main.persons.get(row).getLastName();
		case 1:
			return Main.persons.get(row).getFirstName();	
		case 2:
			return Main.persons.get(row).getMiddelName();
		case 3:
			return Main.persons.get(row).getDataBithday();
		}
		return "";
	}


	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		listener.remove(arg0);

	}

	@Override
	public void setValueAt(Object obj, int row, int col) {
		switch (col) {
		case 0:
			Main.persons.get(row).setLastName((String) obj);
		case 1:
			Main.persons.get(row).setFirstName((String) obj);	
		case 2:
			Main.persons.get(row).setMiddelName((String) obj);
		//case 3:
			//Main.personals.get(row).setDataBithday((Date) obj);
		}
	}

}
