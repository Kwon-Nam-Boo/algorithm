package algo_ad.day1;

import java.util.Arrays;

public class PermutationTest {
	private static char[] chars ={'A','B','C','D'};
	
	
	public static void main(String[] args) {
		//chars에서 3개의 원소를 구하는 순열을 구해보자
		//makePermutationIter();
		
		// 방문 체크를 이용해서 순열 구하기
		//makePermutationVisited(3, new char[3], new boolean[chars.length]);
		
		//swap을 이용해서 순열 구하기
		//makePermutationSwap(3, 0);
		
		//next_permutation을 이용한 순열
		makePermutationNP();
	}
	private static void makePermutationNP() {
		do {
			System.out.println(Arrays.toString(chars));
		}while(nextPermutation());
	}
	
	
	
	private static boolean nextPermutation() {
		// step 1 i 찾기
		int i;
		for (i = chars.length-2; i >=0 ; i--) {
			if(chars[i]<chars[i+1]) {
				break;
			}
		}
		// 맨 마지막 경우는 위에 만족하는 i가 없다!
		if(i<0) {
			return false;
		}
		// step 2: j찾기
		int j;
		for (j = chars.length-1;j>=0;j--) {
			if(chars[i] < chars[j]) {
				break;
			}
		}
		// step 3: swap
		swap(i,j);
		// step 4: reverse
		for (int a = i+1, b = chars.length-1; a < b; a++,b--) {
			swap(a,b);
		}
		return true;
	}
	
	
	/*	 
	 * @param r: 뽑을 요소의  개수
	 * @param depth: 깊이
	 */
	private static void makePermutationSwap(int r, int depth) {
		if(r == depth) {
			System.out.println("swap: " + Arrays.toString(Arrays.copyOfRange(chars, 0, r)));
		}
		else {
			for (int i = depth; i < chars.length; i++) {
				swap(depth,i);
				makePermutationSwap(r, depth+1);
				swap(depth,i);
			}
			
		}
	}
	private static void swap(int a, int b) {
		char tmp = chars[a];
		chars[a] = chars[b];
		chars[b] = tmp;
	}
	
	/*	 
	 * @param r: 뽑아야 할 개수
	 * @param temp: 뽑은 녀석들이 저장되는 배열
	 * @param visited: d요소들의 선택  상태
	 * 
	 */
	private static void makePermutationVisited(int r, char[] temp, boolean[] visited) {
		// base case
		if(r == 0) {
			System.out.println("visited: " + Arrays.toString(temp));
		}
		// inductive case
		else {
			for (int i = 0; i < chars.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					temp[r-1] = chars[i];
					makePermutationVisited(r-1, temp, visited);
					visited[i] = false;
				}
			}
		}
	}
	
	private static void makePermutationIter() {
		for (int i = 0; i < chars.length; i++) {
			for(int j=0;j< chars.length;j++) {
				if(i==j) {			// 순열은 중복 되지 않는다.
					continue;
				}
				for (int k = 0; k < chars.length; k++) {
					if(i== k || j ==k) {			// 순열은 중복 되지 않는다.
						continue;
					}
					System.out.printf("반복문: %c %c %c %n",chars[i],chars[j],chars[k]);
				}
			}
		}
	}
}
