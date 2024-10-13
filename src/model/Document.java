package model;

public class Document implements Cloneable {

	private String author;
	private String date;
	private double versionID;
	private String contents;
	
	//not sure if this is right
	public Document(String author,String date,double versionID,String contents) {
		 this.author=author;
		 this.date=date;
		 this.versionID=versionID;
	     this.contents=contents;		
	}
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getVersionID() {
		return versionID;
	}

	public void setVersionID(double versionID) {
		this.versionID = versionID;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Document doc =(Document)super.clone();
		doc.author=this.author;
		doc.date=this.date;
		doc.versionID=this.versionID;
		doc.contents=this.contents;
		
		return doc;
	}	
	
}
