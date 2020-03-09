package com.ssafy.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class DuplicateException extends Exception{			// 이미 존재하는 상품일경우 
	String message;

	public DuplicateException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "DuplicateException [message=" + message + "]";
	}	
}
class CodeNotFoundException extends Exception{		// 상품번호가 존재 하지 않는다
	String message;

	public CodeNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CodeNotFoundException [message=" + message + "]";
	}
	
}
class ProductNotFoundException extends Exception{	// 상품이 존재하지 않을 경우 
	String message;
	
	public ProductNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProductNotFoundException [message=" + message + "]";
	}
	
}


public class ProductMgrImpl implements IProductMgr{
	
	private static ArrayList<Product> pd;
	
	ProductMgrImpl() throws Exception {
		pd = new ArrayList<>();
		open();
	}

	@Override
	public void addProduct(Product product) throws DuplicateException{
		if(pd.isEmpty()) {
			pd.add(product);
		}else {
			for (int i = 0; i < pd.size(); i++) {
				if(product.getId() == pd.get(i).getId()) {
					throw new DuplicateException("아니! 이미 있는데 어떡해요!");
				}
			}
			pd.add(product);
		}
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pd;
	}

	@Override
	public Product findById(int id) throws CodeNotFoundException{
		for(Product pro : pd) {
			if(pro==null) {
				throw new CodeNotFoundException("없다니깐요 ..");
			}
			if(id == pro.getId()){
				return pro;
			}
		}
		throw new CodeNotFoundException("없다니깐요 ..");
	}

	@Override
	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro.getName().contains(name)){
				tmp.add(pro);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<TV> searchForTv() {
		ArrayList<TV> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro instanceof TV){
				tmp.add((TV) pro);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> searchForRefrigerator() {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro instanceof Refrigerator){
				tmp.add((Refrigerator) pro);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> findBy400L() throws ProductNotFoundException{
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro instanceof Refrigerator && ((Refrigerator) pro).getRefSize() >= 400){
				tmp.add((Refrigerator) pro);
			}
		}
		if(tmp.isEmpty()) {
			throw new ProductNotFoundException("상품이 없어요 ..");
		}else {
			return tmp;
		}
		
	}

	@Override
	public ArrayList<TV> findBy50inch() throws ProductNotFoundException{
		ArrayList<TV> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro instanceof TV && ((TV) pro).getTvSize() >=50){
				tmp.add((TV) pro);
			}
		}
		if(tmp.isEmpty()) {
			throw new ProductNotFoundException("상품이 없어요 ..");
		}else {
			return tmp;
		}
	}

	@Override
	public void changePrice(int id, int price) {
		for(Product pro : pd) {
			if(pro==null) break;
			if(id == pro.getId()){
				pro.setPrice(price);
				return;
			}
		}
		return;
	}

	@Override
	public void deleteProduct(int id) {
		
		int count = 0;
		for (int i = 0; i < pd.size(); i++) {
			if(pd.get(i).getId()== id){
				count++;
				pd.remove(i);
				System.out.println("Delete Complete!!");
			}
		}
		if(count==0) System.out.println("No product!");
		
	}

	@Override
	public void CheckPrice() {
		int sum =0;
		for (Product pro : pd) {
			sum+=pro.getPrice()*pro.getNum();
		}
		System.out.println("Price is "+ sum);
		System.out.println();
		
	}

	@Override
	public void open() throws Exception {
		File file = new File("product.dat");
		if(file.exists()) {
			FileInputStream fis = new FileInputStream("product.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//bk =(ArrayList<Book>) ois.readObject();
			pd = (ArrayList<Product>) ois.readObject();
			fis.close();
			ois.close();
		}
		
	}

	@Override
	public void close() throws Exception {
		FileOutputStream fos = new FileOutputStream("product.dat");		//node Stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);		//process Stream
		oos.writeObject(pd);									// 객체를 write한다
		fos.close();
		oos.close();
		
	}
	
	
	

}
