package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentManager implements Cloneable {

	public Map<String, String> dataMap = new HashMap<String, String>();

	public DocumentManager() {
	}

	public BufferedReader readTex(String filename) throws FileNotFoundException {
		FileReader myFr = new FileReader(filename);
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(myFr);
		
		return reader;
	}
	
	public void myRead() throws Exception {
		FileReader myFr = new FileReader("/home/teo/eclipse-workspace/LaTex/article-template.tex");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(myFr);

		String line = reader.readLine();
		String myString = new String();

		while (line != null) {
			line = reader.readLine();
			if (line == null)
				break;
			sb.append(line);
			sb.append("\n");
		}
		myFr.close();
		myString = sb.toString();

		dataMap.put("article", myString);
		// System.out.println(dataMap);

		Document doc = new Document();
		doc.clone();
		doc.setContents(myString);
		// System.out.println(doc.getContents());

		// Get date and time
		doc.setDate(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
		System.out.println(doc.getDate());

		try (PrintWriter w = new PrintWriter("output" + ".tex", "UTF-8");) {
			w.println(doc.getContents());
		}

	}

	public void myRead2() throws Exception {
		FileReader myFr = new FileReader("/home/teo/eclipse-workspace/LaTex/book-template.tex");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(myFr);

		String line = reader.readLine();
		String myString = new String();

		while (line != null) {
			line = reader.readLine();
			if (line == null)
				break;
			sb.append(line);
			sb.append("\n");
		}

		myString = sb.toString();

		dataMap.put("book", myString);
		System.out.println(dataMap);

	}

	public void myRead3() throws Exception {
		FileReader myFr = new FileReader("/home/teo/eclipse-workspace/LaTex/letter-template.tex");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(myFr);

		String line = reader.readLine();
		String myString = new String();

		while (line != null) {
			line = reader.readLine();
			if (line == null)
				break;
			sb.append(line);
			sb.append("\n");
		}

		myString = sb.toString();

		dataMap.put("letter", myString);
		System.out.println(dataMap);
	}

	public void myRead4() throws Exception {
		FileReader myFr = new FileReader("/home/teo/eclipse-workspace/LaTex/report-template.tex");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(myFr);

		String line = reader.readLine();
		String myString = new String();

		while (line != null) {
			line = reader.readLine();
			if (line == null)
				break;
			sb.append(line);
			sb.append("\n");
		}

		myString = sb.toString();

		dataMap.put("report", myString);
		System.out.println(dataMap);
	}

	public void SaveMe(String getFromText) {

		File f = new File("newSavedDoc.tex");
		if (f.exists()) {
			f.delete();
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("newSavedDoc.tex", true)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		pw.print("");
		pw.println(getFromText);
		pw.close();
	}

	public Document createDocument(String string) throws CloneNotSupportedException {

		// for ( String key : dataMap.keySet() ) {
		// key="article";
		// }
		// clone

		return null;
	}

}
