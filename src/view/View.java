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


public class View {

	private String[] s = { "", "article", "book", "letter", "report", "new" };
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
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
						dm.readArticle();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "book") {
					try {
						dm.readBook();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "letter") {
					try {
						dm.readLetter();
					} catch (Exception e1) {
						// TODO auto-generated in each block
						e1.printStackTrace();
					}
					textArea.setText(dm.dataMap.toString());

				}
				if (msg == "report") {
					try {
						dm.readReport();
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
		mntmNew.addActionListener(new SaveAsActionListener(textArea));

		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.addActionListener(new SaveAsActionListener(textArea));
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new SaveActionListener(textArea));
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new OpenAsActionListener(textArea));
		btnOpen.setBounds(306, 209, 105, 25);
		frame.getContentPane().add(btnOpen);
		
		mnFile.add(mntmSave);
		mnFile.add(mntmSaveAs);

	}
}
