package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class coupang4 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = {{"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"}};
		System.out.println(solution(depar, hub, dest, roads));
	}
	
	public static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = -1;
		HashMap<String,Integer> map = new HashMap<>();
		int cnt = 1;
		for (int i = 0; i < roads.length; i++) {
			if(!map.containsKey(roads[i][0])) {
				map.put(roads[i][0], cnt);
				cnt++;
			}
			if(!map.containsKey(roads[i][1])) {
				map.put(roads[i][1], cnt);
				cnt++;
			}
		}
		
		//System.out.println(map);
		
		List<Integer>[] list = new ArrayList[map.size()+1];
		List<Integer>[] rlist = new ArrayList[map.size()+1];
		List<Integer>[] rlist2 = new ArrayList[map.size()+1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
			rlist[i] = new ArrayList<>();
			rlist2[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < roads.length; i++) {
			list[map.get(roads[i][0])].add(map.get(roads[i][1]));
			rlist[map.get(roads[i][1])].add(map.get(roads[i][0]));
			rlist2[map.get(roads[i][1])].add(map.get(roads[i][0]));
		}
//		System.out.println(Arrays.toString(list));
//		System.out.println(Arrays.toString(rlist));
		
		answer = XtoY(map,rlist,map.get(depar),map.get(hub)) * XtoY(map,rlist2,map.get(hub),map.get(dest));
		return answer;
	}
	public static int XtoY(HashMap<String,Integer> map,List<Integer>[] rlist ,int x, int y){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		boolean[] visited = new boolean[map.size()+1];
		int[] count = new int[map.size()+1];
		count[x] = 1;
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for (int i = 1; i < rlist.length; i++) {
				if(rlist[i].contains(a)) {
					rlist[i].remove(Integer.valueOf(a));
					count[i]+=count[a];
				}
				if(rlist[i].isEmpty()) queue.add(i);
			}
	
			int flag = 0;
			for (int i = 1; i < rlist.length; i++) {
				if(!rlist[i].isEmpty()) {
					flag++;
					break;
				}
			}
			if(flag==0) break;
		}
		
		return count[y];
	}
}
