package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7988_D4_내전경기 {
	
	private static int M;
	private static HashMap<ID, ArrayList<ID>> graph;
	private static String result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			M = Integer.parseInt(br.readLine());
			graph = new HashMap<>();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				ID a = new ID(st.nextToken());
				ID b = new ID(st.nextToken());
				if(!graph.containsKey(a)) {	
					graph.put(a,new ArrayList<>());		// 새 키값일 경우에는? 키를 추가해줘야지
					graph.get(a).add(b);
				}else {								
					graph.get(a).add(b);			// 기존에 존재하는 키값이면? 값만 넣어준다
				}
				if(!graph.containsKey(b)) {			// 양 방향
					graph.put(b,new ArrayList<>());
					graph.get(b).add(a);
				}else {
					graph.get(b).add(a);
				}
			}
			//System.out.println(graph);
			
			Set<ID> set = new HashSet<>();
			set = graph.keySet();
			
			/*ID c = new ID("Alex");
			c.color = 1;
			set.add(c);
			set.add(new ID("Alex"));
			System.out.println(set);*/
			result ="Yes";
			Iterator<ID> it = set.iterator();
			while(it.hasNext()) {
				//System.out.println("a");
				ID i = it.next();
				if(i.color == 0) {
					if(!bfs(i)) {
						result = "No";
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
	public static class ID{
		String name;
		int color;
		
		public ID(String name) {
			this.name = name;
			this.color = 0;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ID other = (ID) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ID [name=" + name + ", color=" + color + "]";
		}	
		
		
	}
	
	public static boolean bfs(ID i) {
		Queue<ID> queue = new LinkedList<>();
		i.color = 1;
		queue.offer(i);
		while(!queue.isEmpty()) {
			ID tmp = queue.poll();
			ArrayList<ID> map = graph.get(tmp);
			for (ID id : map) {
				if(id.color == 0) {
					id.color = -tmp.color;
					queue.offer(id);
				}else
				{
					if(id.color == tmp.color) {			// 같은 색깔이 나오면 오류이다
						return false;
					}
				}
			}
		}
		return true;
		
	}

}
