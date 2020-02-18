package algo_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class sdsd {	
	private static int[] area;
	private static int num;
	private static List<Integer>[] adj;
	private static boolean[] visited;
	private static int compo;
	private static int[] sum;
	private static int temp;
	private static int result = Integer.MAX_VALUE;
	private static boolean[] finished;
	private static int cnt;
	private static boolean connect;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());		
		area = new int[num+1];
		sum = new int[2];
		adj = new List[num+1];
		visited = new boolean[num+1];
		finished = new boolean[num+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= num; i++)
			area[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= num; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			adj[i] = new ArrayList<>();
			while(st.hasMoreTokens())
				adj[i].add(Integer.parseInt(st.nextToken()));
		}
		for(int r = 1; r < num; ++r)
			Comb(0,1,r);
		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}
	private static void Comb(int idx, int before, int r) {
		if(idx == r)
		{
			for(int i = 1; i <= num; ++i)
				if(visited[i])
					System.out.print(i + " ");
			System.out.println();
			cnt = 0; sum[0] = 0; sum[1] = 0; connect = false;
			for(int i = 0; i <= num; ++i)
				finished[i] = false;
			for(int i = 1; i <= num; ++i)
			{
				System.out.print(" "+(visited[i] ? "1" : "0"));
	
				//System.out.print("f : " + (finished[i] ? "1" : "0"));
			}
			System.out.println();
			for(int i = 1; i <= num; ++i)
				if(visited[i])
				{
					if(isConnect(i,r))
						connect = true;
					if(connect)
						sum[0] += area[i];
					else
						return;
				}
			for(int i = 0; i <= num; ++i)
				finished[i] = visited[i];
			compo = 0;
			for(int i = 1; i <= num; ++i)
				if(!finished[i])
				{
					compo++;
					if(compo > 1)
						return;
					DFS(i);				
				}
			System.out.println("sum[0] : " + sum[0] + " sum[1] : " + sum[1] + " result : " + result);
			temp = Math.abs(sum[0] - sum[1]);
			result = result > temp ? temp : result;
			return;
		}
		for(int i = before; i <= num; ++i)
		{
			visited[i] = true;
			Comb(idx+1,++before,r);
			visited[i] = false;
		}
	}
	private static void DFS(int curr) {
		finished[curr] = true;
		sum[1] += area[curr]; 
		for(int next : adj[curr])
			if(!finished[next])
				DFS(next);
	}
	private static boolean isConnect(int curr, int r) {
		finished[curr] = true;
		if(visited[curr])
			cnt++;
		if(cnt == r)
			return true;
		for(int next : adj[curr])
			if(!finished[next])
				return isConnect(next,r);
		return false;
	}
}