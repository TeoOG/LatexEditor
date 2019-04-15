package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class OpenAsActionListener implements ActionListener {

	private JTextArea textArea;
	private File fileTex;

	public OpenAsActionListener(JTextArea textArea) {
		super();
		this.textArea = textArea;
	}

	@Override
	public void actionPerformed(ActionEvent even) {
		
		// open file chooser - default
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			///get the file
		    this.fileTex = fileChooser.getSelectedFile();
						
			//create a scanner for the file
			Scanner input;
			try {
				BufferedReader in = new BufferedReader(new FileReader(this.fileTex));
			    String str;
			    while ((str = in.readLine()) != null) {
			    	this.textArea.append(str);
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
	}

}
