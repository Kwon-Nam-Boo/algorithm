package com.ssafy.book;

import java.util.ArrayList;

public interface IBookMgr {
		//1. 도서 추가
		void add(Book book);
		//2. 전체 데이터 검색
		ArrayList<Book> total();
		
		//3. Isbn으로 정보를 검색
		Book findByIsbn(String Isbn);
		
		//4. Title로 정보를 검색
		ArrayList<Book> findByTitle(String title);
		
		//5. Magazine만 검색
		ArrayList<Magazine> findMagazine();
		
		//6. Magazine중 올해 잡지만 검색
		ArrayList<Magazine> findMagazine_year(int year);
		
		//7. 출판사로 검색
		ArrayList<Book> findByPublisher(String publisher);
		
		//8. Novel만 검색
		ArrayList<Novel> findNovel();
		
		//9. 가격으로 검색
		ArrayList<Book> findByPrice(int price);
		
		//10. 저장된 모든 금액 합계
		int sum();
		
		//저장된 모든 금액 평균
		double average();
}
