package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class SaveActionListener implements ActionListener {

	private JTextArea textArea;
	private File filenName;

	public SaveActionListener(JTextArea textArea, File filenName) {
		super();
		this.textArea = textArea;
		this.filenName = filenName;
	}

	@Override
	public void actionPerformed(ActionEvent even) {
		// open file chooser - default
		JFileChooser fileChooser = new JFileChooser();
		if ( this.filenName==null && fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the file
			this.filenName = fileChooser.getSelectedFile();	
		}
		
		String myString = this.textArea.getText();

		try {
			PrintWriter out = new PrintWriter(this.filenName);
			out.println(myString);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
