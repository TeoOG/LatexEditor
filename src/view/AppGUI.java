package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.DocumentManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppGUI {

	private String[] s= {"article","book","letter","report","new"}; 
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
				JComboBox cb = (JComboBox)e.getSource();
				String msg = (String)cb.getSelectedItem(); 
				DocumentManager dm = new DocumentManager();
				if(msg=="article") {
					try {
						dm.myRead();
						}
					 catch (Exception e1) {
						//TODO auto-generated in each block 
						e1.printStackTrace();			
					}
					textArea.setText(dm.dataMap.toString());
				   	
				}
				if(msg=="book") {
					try {
						dm.myRead2();
						}
					 catch (Exception e1) {
						//TODO auto-generated in each block 
						e1.printStackTrace();			
					}
					textArea.setText(dm.dataMap.toString());
				   	
				}if(msg=="letter") {
					try {
						dm.myRead3();
						}
					 catch (Exception e1) {
						//TODO auto-generated in each block 
						e1.printStackTrace();			
					}
					textArea.setText(dm.dataMap.toString());
				   	
				}if(msg=="report") {
					try {
						dm.myRead4();
						}
					 catch (Exception e1) {
						//TODO auto-generated in each block 
						e1.printStackTrace();			
					}
					textArea.setText(dm.dataMap.toString());
				   	
				}if(msg=="new") {
					
					
					textArea.setText("".toString());
				   	
				}
			}
		});
		comboBox.setBounds(36, 221, 151, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentManager of = new DocumentManager();
				//copy contents of the GUI into a string
				String getFromText = textArea.getText();
			    textArea.selectAll();
			    
			    //save 
			    try {
			    	of.SaveMe(getFromText);
				} catch (Exception e1) {
					//TODO auto-generated in each block 
					e1.printStackTrace();			
				}	    
			}
		});
		btnSave.setBounds(225, 221, 114, 25);
		frame.getContentPane().add(btnSave);
		
	}
}
