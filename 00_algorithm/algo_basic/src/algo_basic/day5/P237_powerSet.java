package algo_basic.day5;

import java.util.Arrays;

public class P237_powerSet {
	
	private static int[] set = {1,2,3,4,5,6,7,8,9,10};
	private static boolean[] status = new boolean[set.length];
	private static int[] status2 = new int[set.length];
	private static boolean[] child = {true, false};
	private static int cnt = 0;
	
	public static void makePowerSet(int n, int r) {
		if(n == r) {
			for (int i = 0; i < status.length; i++) {
				if(status[i]) {
					System.out.print(set[i] + " ");
				}
			}
			System.out.println();
			return;
		}else {
			for (int i = 0; i < child.length; i++) {
				status[r] = child[i];
				makePowerSet(n, r+1);
			}
		}
	}
	
	public static void makePowerSetSum(int n, int r, int sum) {		// 일정 합의 부분집합 출력
		
		if(sum == 0) {								// 깊이가 같고 sum도 0이면 출력 --> 수정 길이가 적어도 sum이 0일떄만 출력하면 불필요하게 더 뒤질 필요가 없다
			for (int i = 0; i < status.length; i++) {
				if(status[i]) {
					System.out.print(set[i] + " ");
				}
			}
			System.out.println();
			return;
		}else if(n == r){										// 깊이가 같지만 sum이 0 이하라면
			return;
		}
		
		else {
			for (int i = 0; i < child.length; i++) {
					status[r] = child[i];
					//if(sum>0) {
						if(child[i] ==true) sum-=set[r];			// 부분집합의 값이 있다면 기준 sum값을 뺸다 
						if(sum >= 0) {								// sum이 0이하가 아니라면 다음 노드를 간다
						makePowerSetSum(n, r+1, sum);
						cnt++;
						}
						if(child[i] ==true) sum+=set[r];			// 다시 원상 복구 시킨다.
					//}
			}
		}
	}
	
	
	public static void makePermutation(int n, int r) {
		if(n == r) {
			for (int i = 0; i < set.length; i++) {
					System.out.print(set[i] + " ");
			}
			System.out.println();
			return;
		}else {
				for (int j = 0; j < set.length; j++) {
					status2[r] = set[j];
					makePermutation(n, r+1);
					status2[r] = 0;
				}
			}
		}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//makePowerSet(4,0);
		//makePowerSetSum(10,0,10);
		//System.out.println(cnt);
		makePermutation(10, 0);
	}
	
}
