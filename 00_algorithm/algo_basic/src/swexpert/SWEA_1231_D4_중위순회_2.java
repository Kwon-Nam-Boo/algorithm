package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_1231_D4_중위순회_2 {
	
	private static Node[] tree = null;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			tree = new Node[N+1];
			
			for (int j = 1; j <= N; j++) {
				int child1= 0;
				int child2 =0;
				st = new StringTokenizer(br.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				char word = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					child1 = Integer.parseInt(st.nextToken());
				}
				if(st.hasMoreTokens()) {
					child2 =Integer.parseInt(st.nextToken());
				}
				
				Node pNode =getNode(parent);
				pNode.w = word;
				
				if(child2!=0) {
					Node cNode1 =getNode(child1);
					Node cNode2 =getNode(child2);
					pNode.l =cNode1;
					pNode.r = cNode2;
				}else if(child1!=0 && child2==0) {
					Node cNode1 =getNode(child1);
					pNode.l = cNode1;
				}
			}
			inOrder(tree[1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void inOrder(Node node) {
		if(node!=null) {
			inOrder(node.l);
			sb.append(node.w);
			inOrder(node.r);
		}	
	}
	
	static class Node{
		int v;
		char w;
		Node l,r;

		public Node(int v) {
			super();
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(w).append(",")
			.append(l==null ? "n":l.v).append(",")
			.append(r==null ? "n":r.v).append(")");
			
			return sb.toString();
		}
	}
	private static Node getNode(int v) {
		if( tree[v] ==null) {
			tree[v] = new Node(v);
		}
		return tree[v];
	}
	

}
