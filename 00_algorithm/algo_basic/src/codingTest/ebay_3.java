package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ebay_3 {

	private static StringBuilder sb = new StringBuilder();
	public static int[] result;
	public static boolean[] visited;
	public static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = 3;
		int[][] products = {{6, 5, 1},{11, 3, 2},{7, 10, 3}};
		
		solution(n, products);
	}
	public static long solution(int n, int[][] products) {
        long answer = 0;
        //visited = new boolean[products.length];
        result = new int[n];
        max = 0;
        int[] copy = new int[products.length];
        for (int i = 0; i < products.length; i++) {
			copy[i] = products[i][0];
		}
        nPrVisted(0, n, products,copy);
        
		System.out.println(max);
        return answer;
    }
	
	public static void nPrVisted(int r,int n, int[][] products, int[] copy) {
		if(r == n) {
			//System.out.println("visited:" + Arrays.toString(result));
			
			int sum = 0;
			
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < products.length; j++) {
					// 매대 에 있는경우
					if(result[i] == j) {
						// 개수가 넘어가면?
						if(products[j][2]*2 > products[j][0]) {
							sum+= (products[j][0] * products[j][1]);
							products[j][0] = 0;
						}else {
							sum+= (products[j][2]*2*products[j][1]);
							products[j][0]-=(products[j][2]*2);
						}
					}else {	// 매대에 없는 경우
						if(products[j][2] > products[j][0]) {
							sum+= (products[j][0] * products[j][1]);
							products[j][0] = 0;
						}else {
							sum+= (products[j][2]*products[j][1]);
							products[j][0]-=(products[j][2]);
						}
					}
				}
				
			}
			
			//System.out.println(sum);
			max = Math.max(max, sum);
			
			for (int i = 0; i < copy.length; i++) {
				products[i][0] = copy[i];
			}
			return;
		}
		for (int i = 0; i < products.length; i++) {
				result[r] = i;
				nPrVisted(r+1,n,products, copy);
		}
	}
}
