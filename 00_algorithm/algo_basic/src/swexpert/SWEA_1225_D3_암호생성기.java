package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1225_D3_암호생성기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> al = new ArrayList<>();
			//List<Integer> al = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			int c = 1;
			while(true) {
				al.add(al.get(0)-c);	// 카운트 만큼 감소후 add 해준다
				al.remove(0);			// 그후 처음 값을 제거 한다.
				if(al.get(7) <= 0) {	// 감소한 수가 0보다 작은경우
					al.set(7,0);		// 0으로 바꿔준후
					break;				//종료한다
				}
				c++;
				if(c>5) c = 1;			// 한사이클이 돌아갓으면 c를 1롤 초기화해준다.
			}
			for (int j = 0; j < al.size(); j++) {
				sb.append(al.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
