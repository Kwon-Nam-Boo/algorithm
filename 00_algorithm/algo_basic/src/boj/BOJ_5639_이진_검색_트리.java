package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진_검색_트리 {

	private static Node root;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String s="";
		
		while((s=br.readLine())!=null && s.length() != 0) {
			 addNode(Integer.parseInt(s));
		}
		postOrder(root);
		System.out.println(sb);
	}
	public static void postOrder(Node d) {
		if(d!=null) {
			postOrder(d.l);
			postOrder(d.r);
			sb.append(d.v).append("\n");
		}
	}
	
	public static void addNode(int v){
		Node newNode = new Node(v);
		if(root == null) {
			root = newNode;
			return;
		}
		Node currNode = root;		// 현재 노드 위치(시작은 루트) 
		while(true) {
			if(newNode.v < currNode.v) {	// 기준 보다 작다면 왼쪽
				if(currNode.l == null) {						// 기준 노드의 자식이 없다면
					currNode.l = newNode;
					return;
				}else {
					currNode = currNode.l;
				}
			}else {
				if(currNode.r == null) {						// 기준 노드의 자식이 없다면
					currNode.r = newNode;
					return;
				}else {
					currNode = currNode.r;
				}
			}
			
		}
	}
	
	public static class Node{
		int v;
		Node l,r;
		public Node(int v) {
			this.v = v;
		}
		@Override
		public String toString() {
			return "[" + v + 
					","+ (l == null? "n":l.v) + 
					"," + (r == null? "n":r.v) + "]";
		}
	}
}
