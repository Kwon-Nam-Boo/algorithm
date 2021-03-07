package codingTest2;

import java.util.Arrays;
import java.util.HashMap;

public class test2 {
	
	public static void main(String[] args){
		int[][] matrix = {{1,19,20,8,25},{21,4,3,17,24},{12,5,6,16,15},{11,18,10,9,23},{7,13,14,22,2}};
		System.out.println(solution(matrix));
	}
	
	public static int solution(int[][] matrix){
		int[] rMap, cMap;
		int N = matrix.length;
		rMap = new int[N];
		cMap = new int[N];
		
		for (int i = 0; i < N; i++) {
			int[] tmp = new int[N];
			int[] tmp2 = new int[N];
			
			for (int j = 0; j < N; j++) {
				tmp[j] = matrix[i][j];
				tmp2[j] = matrix[j][i];
			}
			Arrays.sort(tmp);
			Arrays.sort(tmp2);
			
			rMap[i] = tmp[N/2];
			cMap[i] = tmp2[N/2];
		}
		Arrays.sort(rMap);
		Arrays.sort(cMap);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(Arrays.binarySearch(cMap, rMap[i]) >=0) ans++;
			System.out.println(Arrays.binarySearch(cMap, rMap[i]));
		}
		
		return ans;
	}
	
}
