package com.ssafy.book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	BookMgrImpl() throws Exception{
		bk = new ArrayList<>();
		open();
	}

	@Override
	public void add(Book book) {
		bk.add(book);
	}

	@Override
	public ArrayList<Book> search() {
		return bk;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		for(Book book : bk) {
			if(isbn.equals(book.getIsbn())){
				int current =book.getQuantity()-1;
				if(current>= 0) {
					book.setQuantity(current);
					return;
				}else if(current < 0) {
					throw new QuantityException("재고가 없는데 어떻게 팝니까!");
				}
				
			}
		}
		throw new ISBNNotFoundException("없는데 어떻게 찾습니까!");
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for(Book book : bk) {
			if(isbn.equals(book.getIsbn())){
				int current =book.getQuantity()-1;
					book.setQuantity(current);
					return;
			}
		}
		throw new ISBNNotFoundException("없는데 어떻게 찾습니까!");
	}

	@Override
	public int getTotalAmount() {
		int sum =0;
		for(Book book: bk) {
			if(book==null) break;
			sum+=book.getPrice()*book.getQuantity();
		}
		return sum;
	}

	@Override
	public void open() throws Exception {
		File file = new File("Book.dat");
		if(file.exists()) {
			FileInputStream fis = new FileInputStream("Book.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			fis.close();
			ois.close();
			
		}	
	}

	@Override
	public void close() throws Exception{
		FileOutputStream fos = new FileOutputStream("Book.dat");		//node Stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);		//process Stream
		oos.writeObject(bk);									// 객체를 write한다
		
		fos.close();
		oos.close();
		
	}
	
	
	
	

}
