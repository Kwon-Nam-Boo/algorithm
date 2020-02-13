package algo_basic.day7;

import java.util.Arrays;

public class P410_Exercise1_pre {
	
	private static int V =13;
	private static String src ="1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
	private static Node[] tree = null;
	//private static boolean[] visited = new boolean[V+1];
	
	
	private static void preOrder(Node d){
		if(d!=null) {
			System.out.print(d.v+ "-");
			preOrder(d.l);
			preOrder(d.r);
		}
	}
	
	private static void inOrder(Node d){
		if(d!=null) {
			inOrder(d.l);
			System.out.print(d.v+ "-");
			inOrder(d.r);
		}
	}
	
	private static void postOrder(Node d){
		if(d!=null) {
			postOrder(d.l);
			postOrder(d.r);
			System.out.print(d.v+ "-");
		}
	}
	
	
	private static void makeTree() {
		tree = new Node[V+1];
		String[] splited = src.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int parent = Integer.parseInt(splited[i]);
			int child = Integer.parseInt(splited[i+1]);
			//System.out.println(parent + " : " + child);
			
			Node pNode =getNode(parent);
			Node cNode =getNode(child);
			
			// 노드간의 관계는?
			if(pNode.l == null) {
				pNode.l = cNode;
			}else {
				pNode.r = cNode;
			}
			
		}
		System.out.println(Arrays.toString(tree));
	}
	
	private static Node getNode(int v) {
		if( tree[v] ==null) {
			tree[v] = new Node(v);
		}
		return tree[v];
	}
	
	static class Node{
		int v;
		Node l,r;

		public Node(int v) {
			super();
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(l==null ? "n":l.v).append(",")
			.append(r==null ? "n":r.v).append(")");
			
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		makeTree();
		preOrder(tree[1]);
		System.out.println();
		inOrder(tree[1]);
		System.out.println();
		postOrder(tree[1]);
	}

}
