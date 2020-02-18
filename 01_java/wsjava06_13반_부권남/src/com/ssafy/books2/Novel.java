package com.ssafy.books2;

public class Novel extends Book {
	String genre;
	
	public Novel(int isbn, String title, String author, String publisher, int price, String desc,String genre) {
		super(isbn, title, author, publisher, price, desc);
		this.genre = genre;
		// TODO Auto-generated constructor stub
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return super.toString()+ "genre=" + genre;
	}
	
	
}
