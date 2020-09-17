package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//25명 중 7명을 뽑으면서 이다솜파의 학생이 4명이상인 경우만 서로 연결되어있는 지 탐색
public class June_1941_소문난_칠공주 {
	static char[][] map;//원래 입력 데이터(학생별 파가 표시됨. 'S', 'Y')
	static boolean[] visited = new boolean[25]; //학생들 별로 칠공주 후보에 포함되었는지 체크해 볼 배열	
	
	//4방 접근 인덱스 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	static int result = 0;	//결과값 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));	
	 
        map = new char[5][5];
	 
	    for (int i = 0; i < 5; i++) {
	        map[i] = br.readLine().toCharArray();
	    }
	    
		
		//모든 정점에서 다솜파를 만들 수 있는지 검사하기
		for(int num = 0 ; num < 25; num++) {
			dfs(num, 1, 0);//시작학생번호, 칠공주 후보 구성인원수, 다솜파인원수
		}		
		
		System.out.println(result);
	}
	
	//dfs():현재까지 다솜파인원이 som명이고 칠공주 구성 후보 인원이 cnt명일 때 
	//num번호의 학생을 칠공주파 후보로 넣었을 때의 결과를 알아보는 메소드
	//num: 현재 선택된 학생 번호, cnt:칠공주 선택 인원수, som : 이다솜파 인원수
	static void dfs(int num, int cnt, int som) {
		visited[num] = true;//num번 학생은 방문처리.칠공주파 후보로 선택됨		
		
		//num 값으로 2차원 배열안의 행,열 값 계산하기
		if(map[num / 5][num % 5] =='S') {//다솜파 학생이면
			som += 1;//다솜파인원수 증가
		}
				
		if(cnt == 7) {//7명이 선택되었으면
			if(som >= 4) {//다솜파가 4명 이상이면
				if(solve(num/5, num%5)) {//전체가 연결되어 있나 체크해서 연결되어 있다면
					result += 1;//칠공주 구성하는 경우의 수 1 증가
				}
			}
			
			//7명이 선택 되었는데 다솜파가 4명 미만이면
			visited[num] = false;//num번 학생은 칠공주파에서 제외
			return;
		}
		
		//아직 7명이 구성되지 않았으면 다음 학생을 선택해서 다시 체크해봄
		for(int next = num + 1 ; next < 25; next++) {
			if(!visited[next]) {//아직 칠공주파 후보로 선택되지 않았다면
				dfs(next, cnt + 1, som);//그 학생부터 다시 dfs
			}
		}

		//백트래킹
		visited[num] = false;
	}
	
	private static boolean solve(int y, int x) {
		boolean[][] v1 = new boolean[5][5];
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x,y));
		
		v1[y][x] = true;
		int vCnt = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			//4방 탐색
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				//경계 범위 벗어나면 무시
				if(nx < 0 || nx >=5 || ny < 0 || ny >= 5) {
					continue;
				}
				
				//이미 방문한 정점은 무시
				if(v1[ny][nx]) {
					continue;
				}
				
				//선택된 인원이 아니면 무시
				if(!visited[ny*5 + nx]) {
					continue;
				}
				
				//새로운 방문체크 해주고 큐에 삽입
				v1[ny][nx] = true;
				q.offer(new Point(nx, ny));
				//연결된 카운트 갯수 추가
				vCnt++;
			}
		}
		return vCnt == 7 ? true : false;
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static String src = "YYYYY\r\n" + 
			"SYSYS\r\n" + 
			"YYYYY\r\n" + 
			"YSYYS\r\n" + 
			"YYYYY";
}
