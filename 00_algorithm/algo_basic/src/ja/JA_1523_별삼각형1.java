package ja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class JA_1523_별삼각형1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int starType = Integer.parseInt(st.nextToken());
		
		if(N < 1 || N > 100) {
			System.out.println("INPUT ERROR!");
		}else {
			switch(starType) {
				case 1:
					for (int r = 0; r < N; r++) {
						for (int c = 0; c <= r; c++) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
				case 2:
					for (int r = N; r > 0; r--) {
						for (int c = r; c >0; c--) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
				case 3:
					for (int r = N; r > 0; r--) {
						for (int c = r-1; c >0; c--) {
							System.out.print(" ");
						}
						for (int c = 0; c < 2* (N-r) +1; c++) {
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
