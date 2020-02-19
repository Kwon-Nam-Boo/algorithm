package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1240_D3_단순_2진_암호코드 {
	
	
	private static List<Integer> crypto = new ArrayList<>(Arrays.asList(13,25,19,61,35,49,47,59,55,11));	// 이진 암호를 10진수로 표현
	//private static int[] crypto ={13,25,19,61,35,49,47,59,55,11};
	private static int[] ans;
	private static String[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
			
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());	//해당 행
			int c = Integer.parseInt(st.nextToken());	//해당 열
			
			if(c < 56) {								// 암호문이 56보다 작다면
				sb.append(0).append("\n");
				continue;								// 오류이므로 0을 주고 넘긴다
			}
			
			arr = new String[r];						// 배열 생성
			for (int j = 0; j < r; j++) {
					arr[j] = br.readLine();
			}
			
			int flag2 = 0;
			
			for (int a = 0; a < r; a++) {				// 배열을 뒤진다
				if(flag2==1) break;
				String line = arr[a];
				for (int j = 0; j < c-56; j++) {		// 첫수부터 c-56한 곳만 뒤져본다
					ans = new int[8];
					int count = 0;
					for (int k = j; k < 56+j; k+=7) {		// 7단어씩 끊어서 해당 7자리 이진수가 crypto에 존재하는 수인지 확인한다.
						String tmp = line.substring(k, k+7);
						
						/*int ab = Integer.valueOf(tmp,2);
						int f =0;
						for (int l = 0; l < crypto.length; l++) {
							if(ab == crypto[l]) {
								ans[count] = l;					//배열로 풀면 빠르긴하더라
								f=1;
								break;
							}
						}
						if(f==0) {
							ans[count] = -1;
						}*/
				
						ans[count] = crypto.indexOf(Integer.valueOf(tmp,2));
						count++;
					}
					int flag =1;
					for (int k = 0; k < ans.length; k++) {							
						if(ans[k]== -1) {											// -1이 존재하는, 즉 쓰레기 값이면
							flag=0;													//  더이상 하지않고 다음 수를 찾아본다
							break;
						}
					}
					if(flag==1) {													// 만약 -1이 없는  즉, 암호문이라면
						flag2 =1;													// ans를 찾았으므로 전체를 종료한다.
						break;
					}

				}
			}
			
			int odd = 0;															// 홀 짝 암호 계산
			int even = 0;
			for (int j = 0; j < 7; j++) {
				if(j%2==0) odd+=ans[j];
				else even+=ans[j];
			}
			if(((odd*3)+even+ans[7])%10 ==0) {
				sb.append(odd+even+ans[7]).append("\n");
			}else {
				sb.append(0).append("\n");
			}
			
		}
		System.out.println(sb);
		
	
	}

}



	
	