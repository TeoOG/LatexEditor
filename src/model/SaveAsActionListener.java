package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class SaveAsActionListener implements ActionListener {

	private JTextArea textArea;
	private File fileTex;

	public SaveAsActionListener(JTextArea textArea) {
		super();
		this.textArea = textArea;
	}

	@Override
	public void actionPerformed(ActionEvent even) {
		// open file chooser - default
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the file
			this.fileTex = fileChooser.getSelectedFile();

			String myString = this.textArea.getText();

			try {//print string to file
				PrintWriter out = new PrintWriter(this.fileTex);
				out.println(myString);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
