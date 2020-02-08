package algo_basic.day1.io;

public class StringSplitTest {
	public static void main(String[] args) {
		split3();
	}
	public static void split1() {
		String src = "10,20,30";
		
		String[] splited = src.split(",");
		int sum = 0;
		for (int i = 0; i < splited.length; i++) {
			sum += Integer.parseInt(splited[i]);
			
		}
		System.out.println(sum);
	}
	public static void split2() {
		String src = "10.20.30";
		
		//String[] splited = src.split(".");	// 정규 표현식에서 .은 어떤 문자 하나를 나타냄 --> 예외 처리 필요
		String[] splited = src.split("\\.");

		int sum = 0;
		for (int i = 0; i < splited.length; i++) {
			sum += Integer.parseInt(splited[i]);
			
		}
		System.out.println(sum);
	}
	public static void split3() {
		// 이름과 총점을 출력하세요
		String src = "이름:홍길동,Java:100,HTML:80,Script:85";
		String[] splited = src.split(",|:");
		
		int sum =0;
		System.out.println(splited[1]);
		for (int i = 3; i < splited.length; i+=2) {
			sum += Integer.parseInt(splited[i]);
		}
		System.out.println(sum);
	
		

		
	}
}
