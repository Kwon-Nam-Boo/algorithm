package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ntech4 {

	private static StringBuilder sb = new StringBuilder();
	private static Node[] tree;
	private static Node[] tree2;
	private static char[] pattern2;
	private static char[] pattern;
	private static int n = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] t1 = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[][] t2 = {{1,2},{-1,-1},{-1,-1}};
		System.out.println(solution(t1, t2));;
		
	}
	public static int solution(int[][] t1, int[][] t2) {
        int answer = 0;
        
        tree = new Node[t1.length];
        tree2 = new Node[t2.length];
        
        for (int i = 0; i < t2.length; i++) {
        	Node pNode = getNode(i, tree2);
			Node clNode = getNode(t2[i][0],tree2);
			Node crNode = getNode(t2[i][1],tree2);
			pNode.l =clNode;
			pNode.r =crNode;
		}
        
        pattern2 = new char[t2.length-1];
        preOrder(tree2[0],pattern2);
        
//      System.out.println(Arrays.toString(pattern));
        for (int i = 0; i < t1.length; i++) {
        	Node pNode = getNode(i, tree);
			Node clNode = getNode(t1[i][0],tree);
			Node crNode = getNode(t1[i][1],tree);
			pNode.l =clNode;
			pNode.r =crNode;
		}
        
        for (int i = 0; i < t1.length; i++) {
        	n = 0;
        	pattern = new char[t1.length-1];
        	preOrder(tree[i],pattern);
        	
        	if(pattern[t2.length-1] != '\u0000') continue; 
        	
        	int flag = 0;
        	
        	for (int j = 0; j < t2.length-1; j++) {
				if(pattern[j] != pattern2[j]) {
					flag = 1;
					break;
				}
			}
        	if(flag==0) answer++;
		}
        return answer;
    }
	
	// 전위 순회
	private static void preOrder(Node d,char[] pattern){
		if(d!=null) {
			preOrder(d.l,pattern);
			if(d.l != null) {
				pattern[n] = 'l';
				n++;
			}
			preOrder(d.r,pattern);
			if(d.r != null){
				pattern[n] = 'r';
				n++;
			}
		}
	}
	
	public static Node getNode(int c, Node[] tree) {
		if(c == -1) {
			return null;
		}
		
		if(tree[c]== null) {		//아직 tree배멸이 null이면
			tree[c] = new Node(c);
		}
		return tree[c];
	}
	
	public static class Node{
		int v;
		Node l,r;

		public Node(int v) {
			super();
			this.v = v;
		}
	}
}
