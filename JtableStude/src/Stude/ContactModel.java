package Stude;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ContactModel implements TableModel {

	private ArrayList<TableModelListener> listener;
	public ContactModel(){
		listener = new ArrayList<TableModelListener>();
		
	}
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int index) {
		
		switch (index) {
		case 0:
			return  "SecondName";
		case 1:
			return "FirstName";
		case 2:
			return "MiddelName";			
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return Main.contacts.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object returnContact=null;
		switch (col) {
		case 0:
			returnContact=Main.contacts.get(row).getFirstName();
			break;
		case 1:
			returnContact=Main.contacts.get(row).getFirstName();
			break;
		
		case 2:
			returnContact=Main.contacts.get(row).getMiddelName();
			break;
		}
		return returnContact;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object obj, int row, int col) {
		switch (col) {
		case 0:
			Main.contacts.get(row).setSecondName((String) obj);
			break;
		case 1:
			Main.contacts.get(row).setFirstName((String) obj);
			break;
		
		case 2:
			Main.contacts.get(row).setMiddelName((String) obj);
			break;
		}
	}

}
