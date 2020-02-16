package A_0345636;

import java.util.Arrays;

/* 0345636_부권남
 * 이진트리를 구성하고 삽입,삭제,검색을 구현합니다.
 * 
 * 
 */
public class Review_0213_A_1 {
	
	private static Node root;						// 최상위 부모
	
	public static class Node{						// 노드 생성
		int v;
		Node l,r;									// 왼쪽, 오른쪽
		Node p;										// delete를 위해 부모 노드 정보 추가
		
		public Node(int v) {
			super();
			this.v = v;
		}

		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(p == null ? "n" :p.v).append(",")
			.append(l == null ? "n" :l.v).append(",")
			.append(r == null ? "n" :r.v).append(")");
			
			return sb.toString();
		}
	
	}
	
	public static void addNode(int v) {			// 노드를 트리에 추가합니다
		Node newNode = new Node(v);
		
		if(root ==null) {						// 아직 만들어진 최상위 루트가 없으면 생성
			root = newNode;
			return;
		}
		
		Node current = root;					// 처음부터 시작
		while(true) {							// 계속 탐색을 돌린다
			if(current.v ==v) {					// 만약 이진트리에서 같은 값이 나왔다? --> error
				System.out.printf("error: same num  %d is in ",v);
				return;
			}else if(current.v > v) {			// 현재 노드보다 작은수라면  왼쪽으로 가므로 왼쪽 노드를 확인할 필요가 있다. 
				if(current.l ==null) {			// 근데 왼쪽이 비어있다면? 그자리는 내꺼
					newNode.p =current;			// 추가할 노드에 부모노드 정보를 넣어준다.
					current.l = newNode;		// 그 노드를 자식노드로 넣어준다
					return;
				}else {							// 안비었다면?
					current =current.l;			// 다음 탐색을 위해 현재 노드를 왼쪽로 옮겨준다
				}
			}else {
				if(current.r ==null) {			// 오른쪽도 같은 과정
					newNode.p =current;	
					current.r =newNode;
					return;
				}else {
					current = current.r;
				}
			}
		}
	}
	
	public static Node search(int v) {			// 트리 탐색
		if(root == null) {
			return new Node(-1);				// 그냥 없는거라면 -1
		}
		
		Node current = root;
		while(true) {
			if(current.v == v) {
				return current;
			}else if(current.v > v) {
				if(current.l == null) {			// 없다면 -1
					return new Node(-1);
				}else {
					current= current.l;			// 있으면 해당 노드 return;
				}
			}else {
				if(current.r == null) {
					return new Node(-1);
				}else {
					current= current.r;
				}
			}
		}
		
	}
	
	public static boolean deleteNode(int v) {				// 해당 노드를 삭제 -- 자식이 없고, 있고(자식 수)에 따라 다르다.
		Node tar = search(v);								// 해당 노드 확인
		if(tar.v == -1) {
			System.out.print("Node is not exsist ");		// 없으면 끝!
			return false;
		}
		else if(tar.l == null && tar.r == null) {			// 자식이 둘다 없으면
			if(tar.p.l == tar) {							// 부모에서 해당 노드를 찾아 지운다.
				tar.p.l =null;
			}
			else{
				tar.p.r =null;
			}
		}else if(tar.l == null || tar.r == null) {			// 자식이 하나만 있다면
			Node child = tar.l == null ? tar.r : tar.l;		// 해당 자식과 부모를 이어주면 끝
			if(tar.p.l == tar) {							
				tar.p.l = child;
				child.p =tar.p;
			}
			else{
				tar.p.r = child;
				child.p =tar.p;
			}
		}else {												// 자식이 둘 다 있다면
			Node maxC = tar.l;
			while(maxC.r != null) {							// 왼쪽 자식중 가장 오른쪽 ( 현재값보다 작지만 제일 큰 값을 찾는다)
				maxC= maxC.r; 
			}
			int changev = maxC.v;							// 해당 값을 삭제할 노드로 바꿔주고 
			deleteNode(maxC.v);								// 바꿔준 노드를 없앤다.
			tar.v = changev;
		}
		return true;
	
	}
	public static void preOrder(Node start) {				// 전위 순회
		if(start!=null) {
			System.out.print(start.v + " ");
			preOrder(start.l);
			preOrder(start.r);
		}
	}
	public static void inOrder(Node start) {				// 중위 순회
		if(start!=null) {
			inOrder(start.l);
			System.out.print(start.v + " ");
			inOrder(start.r);
		}
	}
	
	public static void postOrder(Node start) {				// 후위 순회
		if(start!=null) {
			postOrder(start.l);
			postOrder(start.r);
			System.out.print(start.v + " ");
		}
	}
	

	public static void main(String[] args) {
		int[] nums = {9,4,3,6,12,15,13,17,12};
		
		for (int i = 0; i < nums.length; i++) {
			addNode(nums[i]);
			System.out.printf("삽입 연산:%d %n", nums[i]);		// 12가 두번 나온다 : error 확인 가능
		}
		
		System.out.println();
		System.out.printf("%d노드: %s%n",9,search(9));
		System.out.printf("%d노드: %s%n",4,search(4));
		System.out.printf("%d노드: %s%n",3,search(3));
		System.out.printf("%d노드: %s%n",6,search(6));
		System.out.printf("%d노드: %s%n",12,search(12));
		System.out.printf("%d노드: %s%n",15,search(15));
		System.out.printf("%d노드: %s%n",13,search(13));
		System.out.printf("%d노드: %s%n",17,search(17));
		System.out.printf("%d노드: %s%n",8,search(8));		// search 안됨 -1
		System.out.println();
		
		System.out.print("전위: ");
		preOrder(root);
		System.out.println();
		System.out.print("중위: ");
		inOrder(root);
		System.out.println();
		System.out.print("후위: ");
		postOrder(root);
		System.out.println();
		
		System.out.println();
		System.out.printf("%d노드 삭제 %b%n",5, deleteNode(5));		// 어
		System.out.printf("%d노드 삭제 %b%n",4, deleteNode(4));		// 자식이 두 개인 경우 삭제
		System.out.printf("%d노드 삭제 %b%n",12, deleteNode(12));	// 자식이 한개인 경우 삭제
		System.out.println();
		
		System.out.printf("%d노드: %s%n",9,search(9));			
		System.out.printf("%d노드: %s%n",4,search(4));
		System.out.printf("%d노드: %s%n",3,search(3));			// 4가 삭제되어 3이 대체 되었다
		System.out.printf("%d노드: %s%n",6,search(6));
		System.out.printf("%d노드: %s%n",12,search(12));
		System.out.printf("%d노드: %s%n",15,search(15));			// 12의 자식인 15가 12의 부모와 이어진다
		System.out.printf("%d노드: %s%n",13,search(13));
		System.out.printf("%d노드: %s%n",17,search(17));
		System.out.println();
		
		
		
	}

}
