package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.DocumentManager;
import model.OpenAsActionListener;
import model.SaveActionListener;
import model.SaveAsActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class AppGUI {

	private String[] s = { "", "article", "book", "letter", "report", "new" };
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI window = new AppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 12, 383, 185);
		frame.getContentPane().add(scrollPane);

		DocumentManager dm = new DocumentManager();
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JComboBox comboBox = new JComboBox(s);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String msg = (String) cb.getSelectedItem();
				DocumentManager dm = new DocumentManager();
				if (msg == "article") {
					try {
						dm.myRead();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "book") {
					try {
						dm.myRead2();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "letter") {
					try {
						dm.myRead3();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "report") {
					try {
						dm.myRead4();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "new") {

					textArea.setText("".toString());

				}
			}
		});
		comboBox.setBounds(26, 209, 151, 24);
		frame.getContentPane().add(comboBox);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new SaveActionListener(textArea));
		btnSave.setBounds(189, 209, 105, 25);
		frame.getContentPane().add(btnSave);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		JMenuItem mntmSave = new JMenuItem("Save as...");
		mntmSave.addActionListener(new SaveAsActionListener(textArea));
		
		JMenuItem mntmSave_1 = new JMenuItem("Save");
		mntmSave_1.addActionListener(new SaveActionListener(textArea));
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new OpenAsActionListener(textArea));
		btnOpen.setBounds(306, 209, 105, 25);
		frame.getContentPane().add(btnOpen);
		
		mnFile.add(mntmSave_1);
		mnFile.add(mntmSave);

	}
}
