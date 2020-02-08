package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1175_주사위_던지기2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		DicePermutaion(N,0,new int[N],M);
		
	}
	public static void DicePermutaion(int r, int d,int[] tmp, int count) {
		if(d == r && count == 0) {
			for (int i = 0; i < r; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}else if(d == r ){
			return;
		}
		for (int i = 0; i <6 ; i++) {
				tmp[d] = i+1;
				count-=(i+1);
				DicePermutaion(r, d+1,tmp,count);
				count+=(i+1);
			}
	}
			
			
		
}

