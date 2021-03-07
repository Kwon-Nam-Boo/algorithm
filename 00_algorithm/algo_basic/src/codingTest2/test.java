package codingTest2;

import java.util.Arrays;
import java.util.HashMap;

public class test {
	
	public static void main(String[] args){
		int[][] matrix = {{4,2,9},{1,3,5},{6,8,7}};
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
		}
		
		return ans;
	}
	
}
