package algo_basic.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2Test {

	public static void main(String[] args) {			// 5개의 정수의 부분집합의 합이 0이되는 경우가 있는지 찾는  test
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i < (1<<arr.length); i++) {
			List<Integer> subset = new ArrayList<>();
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if((i & (1<<j)) > 0) {
						sum+=arr[j];
						subset.add(arr[j]);
				}
			}
			if(sum == 0) {
				System.out.println("when" + subset +" is  True!");
				break;
			}
		}
		
	}

}
