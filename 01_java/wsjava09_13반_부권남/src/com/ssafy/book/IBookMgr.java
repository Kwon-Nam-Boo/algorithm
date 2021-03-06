package com.ssafy.book;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IBookMgr {
		//1. 도서 추가
		void add(Book book);
		//2. 전체 데이터 검색
		ArrayList<Book> search();
		//3. 도서가 구매되어 재고 수량을 빼준다
		void sell(String isbn, int quantity) throws Exception;
		//4. 도서가 구매되어 재고 수령울 더한다.
		void buy(String isbn, int quantity) throws Exception;
		//5.재고 도서들의 수량* 금액을 하여 총 재고 금액을 구하여 리턴
		int getTotalAmount();
		//
		void open() throws Exception;
		//
		void close() throws Exception;
		
}
