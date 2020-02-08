package com.object;

class Book{
	int num;
	String title;
	
	public Book(int num, String title) {
		this.num = num;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [num=" + num + ", title=" + title + "]";
	}
	
	// equals 함수와 hashCode를 재정의
	@Override
	public int hashCode() {
		return 999;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Book) {
			Book b = (Book)obj;		// 형 맞춰주기 위해 형변환
			if(num== b.num && title.equals(b.title)){
				return true;
			}
		
		}
		return false;
	}
	
	
}

public class HashEqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book bk1 = new Book(111, "hello java");
		Book bk2 = new Book(111, "hello java");
		
		System.out.println(bk1 == bk2);		// 주소값이니깐 false
		System.out.println(bk1.equals(bk2));  // String에서는 equals를 오버라이딩 해서 값비교로 해두었다. 사실은  여기의 equals 은 주소값비교
		
		
		System.out.println(bk1.hashCode());		// 객체를 구분하는 코드 값
		System.out.println(bk2.hashCode());
		
		// equals 함수와 hashCode를 재정의 할거 것이다.
		
	}

}
