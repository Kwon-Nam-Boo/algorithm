package com.ssafy.product;

import java.util.ArrayList;

public interface IProductMgr {
	void addProduct(Product product) throws DuplicateException;			// 상품정보 저장
	ArrayList<Product> getAllProducts();								// 전체 검색
	Product findById(int id) throws CodeNotFoundException;				// ID 검색
	ArrayList<Product> findByName(String name);							// 이름 검색
	ArrayList<TV> searchForTv();										// tv만 검색
	ArrayList<Refrigerator> searchForRefrigerator();					// 냉장고만 검색
	ArrayList<Refrigerator> findBy400L() throws ProductNotFoundException;// 400L 이상 냉장고만 검색
	ArrayList<TV> findBy50inch() throws ProductNotFoundException;		// 50인치 tv만
	void changePrice(int id, int price);								// 가격 바꾸기
	void deleteProduct(int id);											// 제품 삭제
	void CheckPrice();													// 재고 상품 금액 총합
	void open() throws Exception;
	void close() throws Exception;
	
}
