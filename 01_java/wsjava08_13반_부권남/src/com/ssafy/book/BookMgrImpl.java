package com.ssafy.book;

import java.util.ArrayList;


class QuantityException extends Exception{
	String message;

	public QuantityException(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "QuantityException [message=" + message + "]";
	}

	
}
class ISBNNotFoundException extends Exception{
	String message;
	
	
	public ISBNNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ISBNNotFoundException [message=" + message + "]";
	}
	
	
	
}

public class BookMgrImpl implements IBookMgr{
	
	private static ArrayList<Book> bk;
	
	BookMgrImpl(){
		bk = new ArrayList<>();
	}
	
	@Override
	public void add(Book book) {
		bk.add(book);
	}

	@Override
	public ArrayList<Book> total() {
		return bk;
	}

	@Override
	public Book findByIsbn(String Isbn) {
		for(Book book : bk) {
			if(book==null) break;
			if(Isbn.equals(book.getIsbn())){
				return book;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Book> findByTitle(String title) {
		ArrayList<Book> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(title.equals(book.getTitle())){
				tmp.add(book);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Magazine> findMagazine() {
		ArrayList<Magazine> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(book instanceof Magazine){
				tmp.add((Magazine) book);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Magazine> findMagazine_year(int year) {
		ArrayList<Magazine> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(book instanceof Magazine && ((Magazine) book).getYear() == year){
				tmp.add((Magazine) book);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) {
		ArrayList<Book> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(publisher.equals(book.getPublisher())){
				tmp.add(book);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Novel> findNovel() {
		ArrayList<Novel> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(book instanceof Novel){
				tmp.add((Novel) book);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Book> findByPrice(int price) {
		ArrayList<Book> tmp = new ArrayList<>();
		for(Book book : bk) {
			if(book==null) break;
			if(price == book.getPrice()){
				tmp.add(book);
			}
		}
		return tmp;
	}

	@Override
	public int sum() {
		int sum =0;
		for(Book book: bk) {
			if(book==null) break;
			sum+=book.getPrice();
		}
		return sum;
	}

	@Override
	public double average() {
		int sum =0;
		for(Book book: bk) {
			if(book==null) break;
			sum+=book.getPrice();
		}
		return (double) sum / bk.size();
	}

}
