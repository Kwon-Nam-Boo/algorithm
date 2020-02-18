package com.ssafy.book;

public class Novel extends Book {
	String genre;
	
	public Novel(String isbn, String title,int price,int quantity, String genre) {
		super(isbn, title, price, quantity);
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
