package algo_basic.day5;

import java.util.Arrays;

public class MakeGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v =6;
		String src ="1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";
		
		int[][] graph = new int[v+1][v+1];
		
		String[] splited = src.split(" ");
		
		int count =1;
		System.out.println(splited.length);
		for (int i = 0; i < splited.length; i+=3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			int w = Integer.parseInt(splited[i+2]);
			
			graph[a][b] = w;
			//graph[b][a] = 1; 단방향은 하나가 필요없으면 된다
			
			
		}
		for (int[] row :graph) {
			System.out.println(Arrays.toString(row));
		}
		
		
	}

}
