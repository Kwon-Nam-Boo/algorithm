package algo_basic.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeGraphList {

	public static void MakeGraphList1() {
		int v = 7;
		String src = "1 2 1 3 1 6 1 7 6 4 6 5 5 4 7 5";
		
		List<Integer>[] graph = new List[v+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String[] splited = src.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			
			graph[a].add(b);
			//graph[b].add(a);	// 단방향
			
		}
		for (int i = 0; i < graph.length; i++) {
			System.out.println(i+" -> "+ graph[i]);
		}
		
		
	}	
	static class Pair{		// 관리해야할 정보가 두개 이상으로 늘어서 만들었다.
							// 배열로 안만든 이유? 데이터 형태가 다를 수도 , toString 으로 디버깅도 용이
		// 관리가 필요한 정보들을 변수로 선언해주자
		int b;
		int w;
		public Pair(int n, int w) {
			this.b = n;
			this.w = w;
		}
		@Override
		public String toString() {
			return "[b=" + b + ", w=" + w + "]";
		}
		
	}
	public static void MakeGraphList2() {
		int v = 7;
		String src = "1 2 2 1 3 4 1 6 1 1 7 3 6 4 6 6 5 1 5 4 2 7 5 4";
		
		List<Pair>[] graph = new List[v+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String[] splited = src.split(" ");
		
		for (int i = 0; i < splited.length; i+=3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			int w= Integer.parseInt(splited[i+2]);
			
			graph[a].add(new Pair(b,w));
			//graph[b].add(a);	// 단방향
			
		}
		for (int i = 0; i < graph.length; i++) {
			System.out.println(i+" -> "+ graph[i]);
		}
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeGraphList1();
		System.out.println();
		MakeGraphList2();
	}
}
