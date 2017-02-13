package Stude;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private ContactModel model;
	private JTable table;
	private JButton btnAdd;
	private JButton btnRemove;
	public MainFrame() {
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		model= new ContactModel();
		table = new JTable(model);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contact contact = new Contact();
				contact.setSecondName(JOptionPane.showInputDialog("¬ведите фамилию:"));
				contact.setFirstName(JOptionPane.showInputDialog( "¬ведите им€:"));
				contact.setMiddelName(JOptionPane.showInputDialog("¬ведите отчество:"));
				Main.contacts.add(contact);
				table.updateUI();
			}
		});
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1||Main.contacts.size()>0)
					Main.contacts.remove(table.getSelectedRow()); 
				table.updateUI();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(btnRemove))
					.addGap(206))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnRemove)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}
}
