package com.ssafy.book;

public class Magazine extends Book {
	private int year;
	private int month;

	public Magazine(String isbn, String title, String author, String publisher, int price,int year,int month) {
		super(isbn, title, author, publisher, price);
		this.year = year;
		this.month = month;
		// TODO Auto-generated constructor stub
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + "year=" + year + ", month=" + month;
	}
	
	
}
