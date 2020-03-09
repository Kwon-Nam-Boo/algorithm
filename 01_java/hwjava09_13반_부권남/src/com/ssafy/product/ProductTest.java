package com.ssafy.product;

import java.util.ArrayList;



public class ProductTest {

	public static void main(String[] args) throws Exception{
		ProductMgrImpl pmgr = new ProductMgrImpl();
		
		
		 try{																		
			pmgr.addProduct(new TV(5, "벽걸이", 300, 3,"LG", 100));				// 상품정보 저장
			pmgr.addProduct(new TV(6, "소형", 100, 1,"Samsung", 30));			
			pmgr.addProduct(new Refrigerator(7, "김치", 200, 4, 300));
			pmgr.addProduct(new Refrigerator(8, "대형", 500, 2, 350));
		}catch(DuplicateException d) {
			System.out.println(d);
		}
		
		ArrayList<Product> test = pmgr.getAllProducts();					// 전체 검색
		
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));							
		}
		System.out.println();
		
	
		try {
			System.out.println(pmgr.findById(1));								// ID 검색	
			System.out.println();
		}catch(CodeNotFoundException c){
			System.out.println(c);
		}
		
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
		
		
		
		try {
			test3 = pmgr.findBy400L();											// 400L 이상 냉장고만 검색
			for (int i = 0; i < test3.size(); i++) {
				System.out.println(test3.get(i));
			}
			System.out.println();
		}catch(ProductNotFoundException p) {
			System.out.println(p);
		}
		try {
			test2 = pmgr.findBy50inch();										// 50인치 tv만
			for (int i = 0; i < test2.size(); i++) {
				System.out.println(test2.get(i));
			}
			System.out.println();
		}catch(ProductNotFoundException p) {
			System.out.println(p);
		}
		
		
		
		pmgr.close();
	}

}
