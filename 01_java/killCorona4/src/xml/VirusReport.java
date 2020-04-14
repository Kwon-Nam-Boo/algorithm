package xml;

public class VirusReport {
	private String author;
	private String about;
	private String date;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "VirusReport [author=" + author + ", about=" + about + ", date=" + date + "]";
	}
	

}
