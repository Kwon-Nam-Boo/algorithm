package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7206_D5_숫자_게임 {
	
	private static HashMap<Integer, Integer> map;
	private static int N,x;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			
			map = new HashMap<>();
			
			if(N <10) {
				sb.append(0).append("\n");
				continue;
			}else {
				int ans = subSet(N);
				sb.append(ans).append("\n");
			}
			//System.out.println(game(1804,2));
			//System.out.println(map);
		}
		System.out.println(sb);
		//System.out.println(map);
	}
	
	
	public static int subSet(int x) {
		if(x < 10) {
			return 0;
		}
		int len = (int) (Math.log10(x));	// 길이보다 1작은 값 (쪼개야하는 부분의 길이)
		int maxCnt=0;
		for (int i = 1; i < (1<<len); i++) {
			List<Boolean> tmp = new LinkedList<>();
			for (int j = 0; j < len; j++) {
				if((i & 1<<j)>0) {
					tmp.add(true);
				}else {
					tmp.add(false);
				}
			}
			int ga = game2(x,tmp);
			
			int cnt = 0;
			if(!map.containsKey(ga)) {	// 저장해둔 값이 없다면?
				cnt = subSet(ga);		// 재귀를 진행하고 나온 cnt를 저장해둔다
				map.put(ga, cnt);
			}else {						// 저장해둔 값이 있다면?
				cnt = map.get(ga);		// 꺼내온다
			}
	
			maxCnt = Math.max(maxCnt,cnt);	//현재 위치에서 가장 큰 cnt를 찾는다
			
			
		}
		
		return maxCnt+1;	// 현재의 최고의 cnt를 리턴
	}

	private static int game2(int x, List<Boolean> list) {
		int len = list.size();
		int re = 1;
		int cut = 1;
		for (int i = len-1; i >=0; i--) {
			if(list.get(i)) {		// 만약 잘라야 하는 곳이라면
				re = re * (int) (x % Math.pow(10, cut));
				x = (int) (x / Math.pow(10, cut));
				cut=1;
			}else {		// 안자르면
				cut++;
			}
		}
		return x*re;
	}
}
