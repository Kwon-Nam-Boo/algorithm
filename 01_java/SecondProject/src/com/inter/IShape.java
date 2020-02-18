package com.inter;

// 클래스 내부에 100% 추상 메소드만 있음ㄴ
public interface IShape {
	
	//인터페이스 안의 추상메소드 -->  public, static이 자동으로 붙어 있다.
	public abstract double getArea();
	// default 아님! public and static and abstract
	double getCircum();
	

}
