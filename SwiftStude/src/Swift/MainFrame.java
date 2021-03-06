package Swift;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
	private JTextField txfUrl;
	private JTabbedPane tabbedPane;
	private JLabel lblUrl;
	private JPanel pnlDownload;
	private JButton btnDownload;
	private JButton btnSave;
	private JComboBox cmbFormat;
	private JLabel label;
	private GroupLayout gl_pnlDownload;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpenFile;
	private JMenu mnOption;
	private JMenuItem mntmExit;
	private JScrollPane scrlpnlReview;
	private JPanel panel;
	private JLabel Image;
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pnlDownload= new JPanel();
		tabbedPane.addTab("\u0421\u043A\u0430\u0447\u0430\u0442\u044C", pnlDownload);
		
		lblUrl = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 URL \u043A\u0430\u0440\u0442\u0438\u043D\u043A\u0435:");
		
		txfUrl = new JTextField();
		txfUrl.setHorizontalAlignment(SwingConstants.LEFT);
		txfUrl.setColumns(10);
		
		btnDownload = new JButton("\u0421\u043A\u0430\u0447\u0430\u0442\u044C");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Main.setImage(new URL(txfUrl.getText()));
					Image.setIcon(new ImageIcon(Main.getImage()));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnSave = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser saveFile=new JFileChooser();
				int reply = saveFile.showSaveDialog(null);
				if(reply == JFileChooser.APPROVE_OPTION) {
					Main.saveImage(saveFile.getSelectedFile(),(String)cmbFormat.getSelectedItem());
				}
			}
		});
		
		cmbFormat = new JComboBox();
		cmbFormat.addItem("jpg");
		cmbFormat.addItem("png");
		
		label = new JLabel("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u043E\u0440\u043C\u0430\u0442:");
		gl_pnlDownload = new GroupLayout(pnlDownload);
		gl_pnlDownload.setHorizontalGroup(
			gl_pnlDownload.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDownload.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlDownload.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUrl)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlDownload.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDownload.createSequentialGroup()
							.addComponent(txfUrl, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDownload))
						.addGroup(Alignment.TRAILING, gl_pnlDownload.createSequentialGroup()
							.addComponent(cmbFormat, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
							.addComponent(btnSave)))
					.addContainerGap())
		);
		gl_pnlDownload.setVerticalGroup(
			gl_pnlDownload.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDownload.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlDownload.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblUrl)
						.addGroup(gl_pnlDownload.createSequentialGroup()
							.addGap(3)
							.addComponent(txfUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnDownload))
					.addGap(18)
					.addGroup(gl_pnlDownload.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbFormat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(316))
		);
		pnlDownload.setLayout(gl_pnlDownload);
		
		scrlpnlReview = new JScrollPane();
		tabbedPane.addTab("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440", scrlpnlReview);
		tabbedPane.setMnemonicAt(1, 1);
		tabbedPane.setDisplayedMnemonicIndexAt(1, 1);
		
		panel = new JPanel();
		scrlpnlReview.setViewportView(panel);
		
		Image = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(Image)
					.addContainerGap(519, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(Image)
					.addContainerGap(379, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane)
		);
		getContentPane().setLayout(groupLayout);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				int reply = chooser.showOpenDialog(null);
				if(reply==JFileChooser.APPROVE_OPTION) {
					Main.setImage(chooser.getSelectedFile());
					Image.setIcon(new ImageIcon(Main.getImage()));
				}
			}
		});
		mnFile.add(mntmOpenFile);
		
		mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		mnOption.add(mntmExit);
		setVisible(true);
	}
}
