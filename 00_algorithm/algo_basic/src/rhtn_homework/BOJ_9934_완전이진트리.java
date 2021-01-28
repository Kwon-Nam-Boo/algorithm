package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.security.auth.login.CredentialException;

public class BOJ_9934_완전이진트리 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[] K;
	private static int[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		K = new int[(int) Math.pow(2, N)-1];
		
		for (int i = 0; i < K.length; i++) {
			K[i] = Integer.parseInt(st.nextToken());
		}
		
		// 답을 2차배열로 표현하기 위해서
		ans = new int[10][1024];
		
		// 트리를 생성하고 루트노드(중간값)을 세팅해준다
		Tree tree = new Tree();
		Node r = tree.createNode(null, null, K[K.length/2]);
		tree.setRoot(r);
		
		// 재귀로  K의 숫자들을 중위순회로 넣어준다
		tree.putNode(r,0,tree,0,K.length-1);
	
		// 2차배열 출력하기
		for (int i = 0; i < ans.length; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < ans[i].length; j++) {
				if(ans[i][j] == 0) break;
				 sb.append(ans[i][j]).append(" ");
			}
			if(sb.length() == 0) break;
			System.out.println(sb);
		}
	}
	

	public static class Tree{
		private Node root;

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
		
		public Node createNode(Node l, Node r, int data) {
			Node node = new Node();
			node.left = l;
			node.right = l;
			node.data = data;
			
			return node;
		}
		
		public void putNode(Node root, int d , Tree tree , int start, int end) {
			int middle = (start + end) /2;
			// 종료 조건
			if(N == d)
				return;

			// 중위 순회
			Node lr = tree.createNode(null, null, K[(start + middle-1)/2]);
			putNode(lr, d + 1, tree, start , middle-1);
			if(start!=end)
				root.left = lr;
			insert(root.data, d);
			Node rr = tree.createNode(null, null, K[(end + middle+1)/2]);
			putNode(rr, d + 1, tree , middle+1, end);
			if(start!=end)
				root.right = rr;
		}
		
		// 해당 값을 맞는 2차배열에 저장한다
		private void insert(int data, int d) {
			for (int i = 0; i < ans[d].length; i++) {
				if(ans[d][i]== 0) {
					ans[d][i] = data;
					break;
				}
			}
		}

	}
	
	public static class Node {
		int data;
		Node left;
		Node right;
		@Override
		
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}
	
}
