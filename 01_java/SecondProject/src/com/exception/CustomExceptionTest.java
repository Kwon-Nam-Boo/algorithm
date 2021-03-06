package com.exception;

class YourException extends Exception{
	String message;
	
	public YourException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "YourException [message=" + message + "]";
	}
	
	
}
class MyException extends Exception{
	String message;
	
	public MyException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyException [message=" + message + "]";
	}
	
	
}

public class CustomExceptionTest {
	
	public int work(int num1, int num2) throws YourException {
		if(num1>num2) {
			return num1;
		}else {
			throw new YourException("이게뭐람2!");
		}
	}
	
	public void check(int num) throws MyException {
		if(num>0) {
			System.out.println("result: "+ ++num);
		}else {
			throw new MyException("이게뭐람!");
		}
	}
	
	public static void main(String[] args) throws MyException {
		CustomExceptionTest c = new CustomExceptionTest();
		
		 try{
			 //c.check(-8);
			 c.work(11, 12);
		}catch(YourException e) {
			System.out.println(e);
		}
		
	}
}	
