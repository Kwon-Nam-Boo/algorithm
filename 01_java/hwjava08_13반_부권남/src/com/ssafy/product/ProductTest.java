package com.ssafy.product;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl pmgr = new ProductMgrImpl();
		
		pmgr.addProduct(new TV(1, "벽걸이", 300, 3,"LG", 100));				// 상품정보 저장
		pmgr.addProduct(new TV(2, "소형", 100, 1,"Samsung", 30));			
		pmgr.addProduct(new Refrigerator(3, "김치", 200, 4, 300));
		pmgr.addProduct(new Refrigerator(4, "대형", 500, 2, 500));
		
		ArrayList<Product> test = pmgr.getAllProducts();					// 전체 검색
		
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));							
		}
		System.out.println();
		
		System.out.println(pmgr.findById(1));								// ID 검색	
		System.out.println();
		
		 test = pmgr.findByName("소형");										// 이름 검색
		 for (int i = 0; i < test.size(); i++) {
				System.out.println(test.get(i));
		}
		System.out.println();
		 
		ArrayList<TV> test2 = pmgr.searchForTv();							// tv만 검색
		for (int i = 0; i < test2.size(); i++) {
			System.out.println(test2.get(i));
		}
		System.out.println();
		
		ArrayList<Refrigerator> test3 = pmgr.searchForRefrigerator();		// 냉장고만 검색
		for (int i = 0; i < test3.size(); i++) {
			System.out.println(test3.get(i));
		}
		System.out.println();
		
		test3 = pmgr.findBy400L();											// 400L 이상 냉장고만 검색
		for (int i = 0; i < test3.size(); i++) {
			System.out.println(test3.get(i));
		}
		System.out.println();
		
		test2 = pmgr.findBy50inch();										// 50인치 tv만
		for (int i = 0; i < test2.size(); i++) {
			System.out.println(test2.get(i));
		}
		System.out.println();
		
		pmgr.changePrice(1, 400);											// 가격 바꾸기
		System.out.println(pmgr.findById(1));	
		System.out.println();
		
		pmgr.deleteProduct(3);												// 제품 삭제
		test = pmgr.getAllProducts();								
		
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
		
		pmgr.CheckPrice();													// 재고 상품 금액 총합
		 
	}

}
