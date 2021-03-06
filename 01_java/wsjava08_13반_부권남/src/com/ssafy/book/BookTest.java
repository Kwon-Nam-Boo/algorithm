package com.ssafy.book;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		BookMgrImpl bmgr = new BookMgrImpl();
		bmgr.add(new Book("12", "삼국지", "나관중", "은행나무", 20000));
		bmgr.add(new Magazine("13", "타임즈", "뉴욕", "설즈버그", 15000, 2020, 2));		//도서 추가
		bmgr.add(new Novel("14", "모모", "미하일 엔더", "청림", 13000, "아동"));
		bmgr.add(new Magazine("17", "디스커버리", "베어그릴스", "디스커버리", 15000, 2019, 1));		
		
		ArrayList<Book> test = bmgr.total();
		for (int i = 0; i < test.size(); i++) {										//전체 데이터 검색
			System.out.println(test.get(i));
		}
		System.out.println();
		
		System.out.println(bmgr.findByIsbn("13"));									//Isbn으로 정보를 검색
		System.out.println();
		
		test = bmgr.findByTitle("삼국지");											//Title로 정보를 검색
		for (int i = 0; i < test.size(); i++) {											
			System.out.println(test.get(i));
		}
		System.out.println();
		
		ArrayList<Magazine> test2 = bmgr.findMagazine();							//Magazine만 검색			
		for (int i = 0; i < test2.size(); i++) {											
			System.out.println(test2.get(i));
		}
		System.out.println();
		
		
		test2 = bmgr.findMagazine_year(2020);										//Magazine중 올해 잡지만 검색
		for (int i = 0; i < test2.size(); i++) {											
			System.out.println(test2.get(i));
		}
		System.out.println();
		
		test =bmgr.findByPublisher("은행나무");
		for (int i = 0; i < test.size(); i++) {											
			System.out.println(test.get(i));
		}
		System.out.println();
		
		ArrayList<Novel> test3 = bmgr.findNovel();
		for (int i = 0; i < test3.size(); i++) {											
			System.out.println(test3.get(i));
		}
		System.out.println();
		
		System.out.println(bmgr.sum());
		System.out.println();
		System.out.println(bmgr.average());
		
	}
	

}
