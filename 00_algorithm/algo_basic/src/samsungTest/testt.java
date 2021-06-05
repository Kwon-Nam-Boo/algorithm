package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class testt {
	
	private static Map<String, Node> nodeMap = new HashMap<String, Node>();
	
	private static class Node {
		
		private String data = null;
		private String left = null;
		private String right = null;
		
		public Node(String data, String left, String right) {
			this.data = data;
			this.left = this.checkData(left);
			this.right = this.checkData(right);
		}
		
		public String checkData(String data) {
			if (data.equals(".")){
				return null;
			} else {
				return data;
			}
		}
		
		public String toString() {
			return "data: " + data + " left: " + left + " right: " + right;
		}
	}
	
//	private static class Node2{
//		
//		private int N = 0, M = 0;
//
//		public Node2(int n, int m) {
//			super();
//			N = n;
//			M = m;
//		}
//		
//		
//		
//	}
//	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		Node[] nn = new Node[7];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String data = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
	
			nn[i] = new Node(data, left, right);
			
			System.out.println(Arrays.toString(nn));
		}
		
//		/System.out.println(Arrays.toString(nn));
	}
	
	

}