package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1719_별삼각형2 {
	public static void main(String[] args) throws IOException{

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int starType = Integer.parseInt(st.nextToken());
		

		if(N < 1 || N > 100 || N % 2==0) {
			System.out.println("INPUT ERROR!");
		}else {
			int mid = N/2 +1;
			switch(starType) {
				
				case 1:
					for (int r = 0; r < mid; r++) {
						for (int c = 0; c <= r; c++) {
							System.out.print("*");
						}
						System.out.println();
					}
					for (int r = mid-1; r > 0; r--) {
						for (int c = 0; c < r; c++) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
					
				case 2:
					for (int r = 0; r < mid; r++) {
						for (int c = (mid-1)-r; c > 0; c--) {
							System.out.print(" ");
						}
						for (int c = 0; c <= r; c++) {
							System.out.print("*");
						}
						System.out.println();
					}
					for (int r = 0; r < mid; r++) {
						for (int c = 0; c <=r ; c++) {
							System.out.print(" ");
						}
						for (int c = (mid-1)-r; c > 0; c--) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
					
				case 3:
					int x = 0;
					for (int r = 0; r < mid; r++) {
						for (int c = 0; c < x; c++) {
							System.out.print(" ");
						}
						for (int c = x; c < N-x; c++) {
							System.out.print("*");
						}
						System.out.println();
						x++;
					}
					x-=2;
					for (int r = 0; r < mid-1; r++) {
						for (int c = x; c > 0; c--) {
							System.out.print(" ");
						}
						for (int c = x; c < N-x; c++) {
							System.out.print("*");
						}
						System.out.println();
						x--;
					}
					break;
					
				case 4:
					int x1=0;
					for (int r = 0; r < mid; r++) {
						for (int c = 0; c < x1; c++) {
							System.out.print(" ");
						}
						for (int c = mid-r; c > 0; c--) {
							System.out.print("*");
						}
						System.out.println();
						x1++;
					}
					x1--;
					for (int r = 0; r < mid-1; r++) {
						for (int c = 0; c < x1; c++) {
							System.out.print(" ");
						}
						for (int c = 0; c <= r+1; c++) {
							System.out.print("*");
						}
						System.out.println();
						
					}
					break;
					
				default:
					System.out.println("INPUT ERROR!");
					break;
			}
		}
		
	
		
	}
}
