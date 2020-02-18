package com.ssafy.book;

public class Novel extends Book {
	String genre;
	
	public Novel(String isbn, String title, String author, String publisher, int price,String genre) {
		super(isbn, title, author, publisher, price);
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
