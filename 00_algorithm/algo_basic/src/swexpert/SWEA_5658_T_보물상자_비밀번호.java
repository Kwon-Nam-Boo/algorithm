package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5658_T_보물상자_비밀번호 {

	private static int n;
	private static int k;
	private static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			String pass = br.readLine();
			list = new ArrayList<>();
			
			for (int i = 0; i < n/4; i++) {
				
				for (int j = 0; j < n; j+=(n/4)) {
					list.add(Integer.parseInt(pass.substring(j, j+(n/4)),16));
				}
				pass=(pass.charAt(n-1))+pass;
			}
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			
			
			int cnt=1;
			int ans = 0;
			for (int i = 1; i < list.size(); i++) {
				if(!list.get(i).equals(list.get(i-1))) {
					cnt++;
					if(cnt == k) {
						ans = i;
						break;
					}
				}
			}
			sb.append(list.get(ans)).append("\n");
			
		}
		System.out.println(sb);
		
	}

}
