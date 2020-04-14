package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리_순회 {
	
	private static int N;
	private static Node root;
	private static Node[] tree;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char p = st.nextToken().charAt(0);			// 부모 node;
			char cl = st.nextToken().charAt(0);			// 부모 node;
			char cr = st.nextToken().charAt(0);			// 부모 node;
			
			Node pNode = getNode(p);
			Node clNode = getNode(cl);
			Node crNode = getNode(cr);
			pNode.l =clNode;
			pNode.r =crNode;
			
		}
		//System.out.println(Arrays.toString(tree));
		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
		
	}
	private static void preOrder(Node d){
		if(d!=null) {
			System.out.print(d.v);
			preOrder(d.l);
			preOrder(d.r);
		}
	}
	private static void inOrder(Node d){
		if(d!=null)  {
			inOrder(d.l);
			System.out.print(d.v);
			inOrder(d.r);
		}
	}
	private static void postOrder(Node d){
		if(d!=null) {
			postOrder(d.l);
			postOrder(d.r);
			System.out.print(d.v);
		}
	}
	
	public static Node getNode(char c) {
		if(c == '.') {
			return null;
		}
		
		if(tree[c-65]== null) {		//아직 tree배멸이 null이면
			tree[c-65] = new Node(c);
		}
		return tree[c-65];
	}
	
	public static class Node{
		char v;
		Node l,r;

		public Node(char v) {
			super();
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(l == null ? "n":l.v).append(",")
			.append(r == null ? "n":r.v).append(")");
			
			return sb.toString();
		}
	}
}
