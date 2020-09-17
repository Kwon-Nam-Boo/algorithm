package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17825_주사위_윷놀이 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] dice, horse;
	private static int[] result;
	private static Pair[] game;
	private static boolean[] visited;
	private static int ans, point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 해당 idx의 주사위 번호
		dice = new int[10];
		// 해당 idx에 옮길 말 번호
		result = new int[10];
		// 1~4 까지 말의 현재 위치
		horse = new int[5];
		
		// 말판의 모든 경우의 수 ..?
		game = new Pair[76];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dice.length; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		// 겉으로 도는건 다음수가 2큰수이고, 실제 숫자도 idx랑 같다
		for (int i = 0; i < 42; i+=2) {
			game[i] = new Pair(i+2, i);
		}
		//10 ,20, 30 에 대한 양갈래 처리 (+30는 내부숫자와 윳놀이 외부숫자의 중복되는것을 구분하기 위해)
		game[10].color = 1;
		game[10].shortcut = 13+30;
		game[20].color = 1;
		game[20].shortcut = 22+30;
		game[30].color = 1;
		game[30].shortcut = 28+30;
		
		// 내부 숫자에 대한  경로 처리  (+30는 내부숫자와 윳놀이 외부숫자의 중복되는것을 구분하기 위해)
		game[13+30] = new Pair(16+30, 13);
		game[16+30] = new Pair(19+30, 16);
		game[19+30] = new Pair(25+30, 19);
		game[25+30] = new Pair(30+30, 25);
		game[22+30] = new Pair(24+30, 22);
		game[24+30] = new Pair(25+30, 24);
		game[28+30] = new Pair(27+30, 28);
		game[27+30] = new Pair(26+30, 27);
		game[26+30] = new Pair(25+30, 26);
		game[30+30] = new Pair(35+30, 30);
		game[35+30] = new Pair(40, 35);
		game[42] = new Pair(42, 0);
		ans =0;
		nPr(0);
		System.out.println(ans);
	}
	
	public static void nPr(int r) {
		if(r == 10) {
			// 말 위치, 방문 초기화
			horse = new int[5];
			visited = new boolean[76];
			
			ans = Math.max(ans,move());
			return;
		}
		for (int i = 0; i < 4; i++) {
			result[r] = i;
			nPr(r+1);
		}
	}
	// 모두 이동 시키고 점수를 합쳐서 보내준다
	private static int move() {
		point = 0;
		for (int i = 0; i < result.length; i++) {
			// 해당 말을 , 해당 주사위 만큼 이동시킨다
			// 겹치는 경우가 발생하면 에러난 경우로 간주! 아니면 이동시키고 포인트 얻어오기
			if(!moveOnePoint(result[i], dice[i])) return 0;
			point+=game[horse[result[i]]].realPoint;
		}
		//if(point == 200)System.out.println(Arrays.toString(result));
		if(point == 204)System.out.println(Arrays.toString(result));
		return point;
	}
	
	// 해당 주사위 만큼 옮기기(현재 말의 위치, 주사위 수)
	private static boolean moveOnePoint(int hr, int dc) {
		// 현재 위치
		int tmp = horse[hr];
		//System.out.println(tmp);
		
		for (int i = 0; i < dc; i++) {
			// 출발점이 10,20,30 이라면?
			if(i == 0 && game[tmp].color == 1) {
				tmp = game[tmp].shortcut;
			}else {
				tmp = game[tmp].next;
				// 만약 이미 도착했다면 스탑
				if(tmp == 42) {
					break;
				}
			}
			
		}
		
		// 만약 도착한게  경우가 아닌데, 방문처리한곳을 밟았다? 아웃!
		if(tmp !=42 && visited[tmp]) {
			return false;
		}else {
			// 이전 방문 처리 없애고 새롭게~
			visited[horse[hr]] = false;
			visited[tmp] = true;
			// 새로운 값으로 교체까지
			horse[hr] = tmp;
			return true;
		}
		
	}
	
	// 
	

	public static class Pair{
		// next: 다음수, realPoint: 현재위치의 진짜 idx(보통은 같으나 가운데 들어가는 숫자들 구분위해서)
		//  color: 0일때는 기본, 1일때 파랑, shortcut: 파랑일 때 다음수
		int next, realPoint, color=0, shortcut=-1;

		public Pair(int next, int realPoint) {
			super();
			this.next = next;
			this.realPoint = realPoint;
		}

		@Override
		public String toString() {
			return "Pair [next=" + next + ", realPoint=" + realPoint + ", color=" + color + ", shortcut=" + shortcut
					+ "]";
		}
		
	}
	
	
}
