package boj;

class member{
	String name;
	int id;
	
	public member(){}
	
	public member(String name){
		this.name =name;
	}
	
	public member(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void go() {
		System.out.println("go");
	}
	public void go(int b, String x) {
		System.out.println("go");
	}
	
	public void go(int a) {
		System.out.println("go");
	}
	
	
}

public class test {
	public static void main(String[] args) {
		member m = new member("aa");
		System.out.println(m.name);
		System.out.println(m.id);
		
	}
}
