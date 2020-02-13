package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1229_D3_암호문2{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> al = new ArrayList<>();			// ArrayList 생성
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				al.add(Integer.parseInt(st.nextToken()));		// 암호문 정보 추가
			}
			
			int M = Integer.parseInt(br.readLine());			// 명령어 
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				
				String tp = st.nextToken();						// 명령에 따른 실행
				
				if(tp.equals("I")) {							// input 명령 이라면
					int start = Integer.parseInt(st.nextToken());		
					int c = Integer.parseInt(st.nextToken());
					for (int k = 0; k < c; k++) {
						al.add(start+k,Integer.parseInt(st.nextToken()));	// start부터 c개의 암호 삽입
					}
				}
				if(tp.equals("D")) {
					int start = Integer.parseInt(st.nextToken());			// Delete명령이면 
					int c = Integer.parseInt(st.nextToken());
					for (int k = 0; k < c; k++) {		
						al.remove(start);									// 해당 명령 삭제
					}
				}
				
			}
			for (int j = 0; j < 10; j++) {
				sb.append(al.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

