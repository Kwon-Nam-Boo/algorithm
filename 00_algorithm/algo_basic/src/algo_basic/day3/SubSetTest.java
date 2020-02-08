package algo_basic.day3;

import java.util.ArrayList;
import java.util.List;

public class SubSetTest {
	private static char[] arr = {'A','B','C'};
	public static void main(String[] args) {
		System.out.println("부분집합의 개수: " + (1<<arr.length));
		
		for (int i = 0; i < (1<<arr.length); i++) {
			//System.out.println(i +": " + Integer.toBinaryString(i));	//tobinaryString 이진수 string출력
			List<Character> subset = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if((i & (1<<j))>0) {
					// 해당 i비트를 해당하는 상황이다
					subset.add(arr[j]);
			}
			
		}
		System.out.println(subset);
		}

	}
}
