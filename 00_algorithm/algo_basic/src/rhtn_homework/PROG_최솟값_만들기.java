package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PROG_최솟값_만들기 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] A = {1,2};
		int[] B = {3,4};
		System.out.println(solution(A, B));
	}
	
	 public static int solution(int []A, int []B)
    {
		int ans = 0;
        Arrays.sort(A);
        Arrays.sort(B);
      
        for (int i = 0, j = A.length-1; i < A.length; i++, j--) {
			ans+=(A[i]*B[j]);
		}

        return ans;
    }
	
}
