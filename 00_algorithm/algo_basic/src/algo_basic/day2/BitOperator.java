package algo_basic.day2;

public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int status = 0;
		int student1 =1;
		
		// & 비트가 속해있냐 안속해있냐
		// | 포함시킬때
		
		// 현재 참여중입니까?
		System.out.println((status & student1) > 0 ?"참석중": "불참");
		
		//참석 처리
		status = status | student1;
		//현재 참석 중입니까?
		System.out.println((status & student1) > 0 ? "참석중": "불참" );
		int student2 = 0b10;
		
		status = status| student2;
		System.out.println((status & student2) > 0 ? "참석중": "불참" );
		System.out.println(Integer.toBinaryString(status));
		
		int i =4;
		if((i & 1) == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
	}

}
