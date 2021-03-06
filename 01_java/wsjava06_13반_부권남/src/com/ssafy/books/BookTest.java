package com.ssafy.books;

import java.util.Arrays;

public class BookTest {
	int N =5;
	int index;
	private static Book[] bk;

	BookTest(){
		bk = new Book[N-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookTest bt = new BookTest();
		bt.addBook(new Book(1234,"정글북", "키플링", "아토북", 18000, "모험담"));
		bt.addBook(new Magazine(2323, "타임즈", "times", "타임즈쓰", 12000, "과학", 20, 2));
		bt.addBook(new Novel(1212,"룬의아이들","전민희","학산출판사",12000,"판타지","무협"));
		
		
		System.out.println(Arrays.toString(bt.getAllBooks()));
		System.out.println(Arrays.toString(bt.findByIsbn(1234)));
		System.out.println(Arrays.toString(bt.findByPrice(12000)));
		System.out.println(Arrays.toString(bt.findByTitle("정글북")));
		System.out.println(Arrays.toString(bt.findByPublisher("아토북")));
		
		System.out.println(bt.getSum());
		System.out.println(bt.getAverage());
		
	}
	public void addBook(Book book) {
		bk[index++]=book;
	}
	public void addBook(Magazine magazine) {
		bk[index++]=magazine;
	}
	public void addBook(Novel novel) {
		bk[index++]=novel;
	}
	public Book[] getAllBooks() {
		return bk;
	}
	
	public Book[] findByIsbn(int isbn) {
		Book[] tmp = new Book[N-1];  			//임시 배열
		int idx = 0;
		for(Book book : bk) {
			if(book==null) break;
			if(isbn == book.getIsbn()){
				tmp[idx] = book;
				idx++;
			}
		}
		return tmp;
	}
	public Book[] findByTitle(String title) {	// 동일한 제목 여러권도 생각해서 제작한다.
		Book[] tmp = new Book[N-1];  			//임시 배열
		int idx = 0;
		for(Book book: bk) {
			if(book==null) break;
			if(book.getTitle().equals(title)){
				tmp[idx] = book;
				idx++;
			}
		}
		return tmp;
	}
	public Book[] findByPublisher(String publisher) {
		Book[] tmp = new Book[N-1];  			//임시 배열
		int idx = 0;
		for(Book book: bk) {
			if(book==null) break;
			if(book.getPublisher().equals(publisher)){
				tmp[idx] = book;
				idx++;
			}
		}
		return tmp;
	}
	public Book[] findByPrice(int price) {
		Book[] tmp = new Book[N-1];  			//임시 배열
		int idx = 0;
		for(Book book: bk) {
			if(book==null) break;
			if(book.getPrice()== price){
				tmp[idx] = book;
				idx++;
			}
		}
		return tmp;
	}
	public int getSum(){
		int sum =0;
		
		for(Book book: bk) {
			if(book==null) break;
			sum+=book.getPrice();
		}
		return sum;
	}
	
	public double getAverage(){
		int sum =0;
		for(Book book: bk) {
			if(book==null) break;
			sum+=book.getPrice();
		}
		return (double) sum / bk.length;
	}
}	

