package algo_basic.day7;

public class BinarySearchTree {
	private static Node root;
	
	// v에 해당하는 노드를 추가하고 결과를 반환한다.
	public static boolean addNode(int v) {		// 삽입 연산
		Node newNode = new Node(v);
		// 아직 root가 없다면 이놈이 root
		if(root == null) {
			root =newNode;
			return true;
		}
		
		Node current = root;
		while(true) {	// 검색에 실패 할 때까지 돌려본다.
			// 이진 검색 트리는 동일한 값이 있을 수 없다. 오류!
			if(current.v ==v) {
				return false;
			}else if(current.v > v) { // 현재 노드가 더 커서 왼쪽으로 감
				// 왼쪽으로 가려고 하는데
				if(current.l == null) {
					newNode.p = current;
					current.l = newNode;
					return true;
				}else {
					current = current.l;
				}
			}else {
				// 오른쪽으로 가려고 하는데
				if(current.r == null) {
					newNode.p = current;
					current.r = newNode;
					return true;
				}else {
					current = current.r;
				}
			}
		}
	}
	
	public static Node search(int v) {
		// root가 없다면
		if(root == null) {
			return null;
		}
		// root 부터 탐색 시작
		Node current = root;
		
		while(true) {
			if(current.v == v) {
				return current;
			}else if ( current.v >v) {
				current = current.l;
			}else {
				current = current.r;
			}
		}
		
	}
	// v에 해당하는 노드를 지우고 그 결과를 반환한다.
	public static boolean deleteNode(int v) {
		Node target = search(v);
		if(target == null) {
			return false;
		}else if(target.l == null && target.r == null) { // 자식이 없을 경우
			// 부모로 부터 target을 지워준다.
			if(target.p.l == target) {
				target.p.l =null;
			}else {
				target.p.r =null;
			}
		}else if(target.l == null || target.r == null){ // 자식이 하나 있을 경우 
			Node child = target.l ==null ? target.r : target.l;
			
			if(target.p.l == target) {
				target.p.l = child;
				child.p =target.p;
			}else {
				target.p.r =child;
				child.p =target.p;
			}
		}else { // 두명의 자식이  있는 경우
			// 왼쪽의 sub tree에서 가장 큰놈 즉 오른쪽 자식이 null인 놈 찾기
			Node max = target.l;
			while(max.r !=null) {
				max =max.r;
			}
			int newV = max.v;
			deleteNode(max.v); // 이녀석 삭제는 이미 구현
			target.v = newV; // 값 바꿔주기
		}
		return true;
	}
	
	
	static class Node{
		int v;
		Node l,r,p;

		public Node(int v) {
			super();
			this.v = v;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(p==null ? "n":p.v).append(",")
			.append(l==null ? "n":l.v).append(",")
			.append(r==null ? "n":r.v).append(")");
			
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		
		int[] nums = {9,4,3,6,12,15,13,17};
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("삽입 연산:%d %b%n", nums[i], addNode(nums[i]));
		}
		System.out.printf("%d노드: %s%n",15,search(15));
		System.out.printf("%d노드: %s%n",9,search(9));
		System.out.printf("%d노드 삭제 %b: %s%n",13,deleteNode(13),search(15));
	}
}
