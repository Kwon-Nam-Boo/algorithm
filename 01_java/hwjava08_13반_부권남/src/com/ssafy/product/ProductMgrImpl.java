package com.ssafy.product;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	
	private static ArrayList<Product> pd;
	
	ProductMgrImpl() {
		pd = new ArrayList<>();
	}

	@Override
	public void addProduct(Product product) {
		pd.add(product);
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pd;
	}

	@Override
	public Product findById(int id) {
		for(Product pro : pd) {
			if(pro==null) break;
			if(id == pro.getId()){
				return pro;
			}
		}
		return null;
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
	public ArrayList<Refrigerator> findBy400L() {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro instanceof Refrigerator && ((Refrigerator) pro).getRefSize() >= 400){
				tmp.add((Refrigerator) pro);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<TV> findBy50inch() {
		ArrayList<TV> tmp = new ArrayList<>();
		for(Product pro : pd) {
			if(pro==null) break;
			if(pro instanceof TV && ((TV) pro).getTvSize() >=50){
				tmp.add((TV) pro);
			}
		}
		return tmp;
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
	

}
