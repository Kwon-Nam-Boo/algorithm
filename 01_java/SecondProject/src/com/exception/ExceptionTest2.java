package com.exception;

public class ExceptionTest2 {
	public void first(int num) throws Exception {
		second(num);
	}
	public void second(int num) throws Exception {
		third(num);
	}
	public void third(int num) throws Exception {
		if(num > 0) {
			System.out.println(++num);
		}else {
			//1
			throw new Exception();
			//2
			/*Exception e = new Exception();		같은 표현
			throw e;*/
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*try {
			new ExceptionTest2().first(-1);
		}catch (Exception e) {
			System.out.println("양수를 입력해 주세요 ㅜㅜㅜ");
		}*/
		
	}

}
