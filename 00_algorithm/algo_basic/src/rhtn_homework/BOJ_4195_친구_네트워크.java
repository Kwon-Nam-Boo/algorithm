package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195_친구_네트워크 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] parent, rank;	// parnet: idx의 부모 idx rank: 자식+ 자기자신의 수(개수)
	private static HashMap<String, Integer> hm;// 해당 친구, 레벨
	private static int F, MAX_FRIEND;	// F:친구관계	MAX: 친구 최대 길이(F의 2배 정도)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			hm = new HashMap<>();
			F = Integer.parseInt(br.readLine());
			MAX_FRIEND = 2*F +1;			// 관계*2는 친구수의 최대일 것이다
			parent = new int[MAX_FRIEND];
			rank = new int[MAX_FRIEND];
			Arrays.fill(rank, 1);
			
			int cnt = 1;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				
				String a = st.nextToken();
				if(!hm.containsKey(a)) {	// 키에 해당하는게 없다면 추가
					hm.put(a, cnt);
					parent[cnt] =cnt;
					cnt++;
				}
				String b = st.nextToken();
				if(!hm.containsKey(b)) {	// 키에 해당하는게 없다면 추가
					hm.put(b, cnt);
					parent[cnt] =cnt;
					cnt++;
				}
				
				// a,b 의 부모를 찾는다(하는김에 갱신도 ..)
				int pa = findSet(hm.get(a));
				int pb = findSet(hm.get(b));
				
				
				if(pa == pb) {		// 만약 부모가 같다면 ..? 개수는 부모의 그대로
					sb.append(rank[pa]).append("\n");	
				}else {				// 부모가 다르면 ..? union하고 개수 세기
					sb.append(union(hm.get(a), hm.get(b))).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	public static int findSet(int x) {		// 보모찾기 & 부모값 갱신을 동시에
		if(x == parent[x]) return x;
		else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	public static int union(int x, int y) {
		int sx = findSet(x);
		int sy = findSet(y);
		
		if(rank[sx] > rank[sy]) {	// 짧은 놈을 긴쪽에 붙여주면 좀더 효율적이다
			parent[sy] = sx;		// sy의 부모를 sx로 지정
			rank[sx]+=rank[sy];		// 더 높은 부모를가진 sx에 sy개수만 큼 증가
			return rank[sx];
		}else {						// 반대로
			parent[sx] = sy;
			rank[sy]+=rank[sx];
			return rank[sy];
		}
	}
	
}
