package model;

import java.util.ArrayList;

import javax.swing.event.ListDataListener;

public class ListModel<E> implements javax.swing.ListModel<E> {
	public ArrayList<E> data;
	public ListModel() {
		data =new ArrayList<E>();
	}
	
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	
	
	public void removeElement(int index) {
		data.remove(index);
	}
	public void removeElement(E obj) {
		data.remove(obj);
	}
	public void addElement(E obj) {
		data.add(obj);
		System.out.println(data.toString());
	}
}
