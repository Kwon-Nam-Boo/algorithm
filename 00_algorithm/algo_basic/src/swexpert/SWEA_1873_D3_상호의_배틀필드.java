package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1873_D3_상호의_배틀필드 {
	
	private static String[][] field;
	private static String[] moves;
	private static String operator ="^v<>";
	private static int tX;
	private static int tY;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			field = new String[N][M];
			tX =0;						//시작점
			tY =0;
			for (int r = 0; r < N; r++) {						
				field[r] = br.readLine().split("");				// 값을 넣어주면서
				for (int c = 0; c < M; c++) {
					if(operator.indexOf(field[r][c])>=0){		
						tX = r;									// 시작점 확인하기
						tY = c;
					}
				}
			}
			
			int move = Integer.parseInt(br.readLine());
			moves = br.readLine().split("");					// 명령을 저장
			for (int j = 0; j < moves.length; j++) {
				play(moves[j]);									// 명령을 실행한다.
			
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sb.append(field[r][c]);
					
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void play(String word) {
		switch(word){
			case "U":												// 상 하 좌 우
				if(isIn(tX-1,tY) && field[tX-1][tY].equals(".")) {	// 만약 범위 안에 있는 평지라면
					field[tX-1][tY] ="^";
					field[tX][tY] =".";
					tX--;											// 전차를 방향으로 옮긴다
				}else {
					field[tX][tY] ="^";								// 만약 갈수가 없다면 전차의 방향만 바꿔준다
				}
				break;
			case "D":
				if(isIn(tX+1,tY) && field[tX+1][tY].equals(".")) {
					field[tX+1][tY] ="v";
					field[tX][tY] =".";
					tX++;
				}else {
					field[tX][tY] ="v";
				}
				break;
			case "L":
				if(isIn(tX,tY-1) && field[tX][tY-1].equals(".")) {
					field[tX][tY-1] ="<";
					field[tX][tY] =".";
					tY--;
				}else {
					field[tX][tY] ="<";
				}
				break;
			case "R":
				if(isIn(tX,tY+1) && field[tX][tY+1].equals(".")) {
					field[tX][tY+1] =">";
					field[tX][tY] =".";
					tY++;
				}
				else {
					field[tX][tY] =">";
				}
				break;
			case "S":
				int dir = operator.indexOf(field[tX][tY]);			// 전차 방향 확인
				int a = tX;
				int b = tY;
				if(dir==0) {										// 상 하 좌 우
					a--;
					while(isIn(a,b)) {								// 배열을 벗어나기 전까지 반복
						if(field[a][b].equals("*")) {				// 벽돌은 부수고 평지로 바꾼다.
							field[a][b] =".";
							break;
						}else if(field[a][b].equals("#")) {			// 강철은 그냥 끝난다.
							break;
						}
						a--;
					}
				}
				else if(dir==1) {
					a++;
					while(isIn(a,b)) {
						if(field[a][b].equals("*")) {
							field[a][b] =".";
							break;
						}else if(field[a][b].equals("#")) {
							break;
						}
						a++;
					}
					
				}
				else if(dir==2) {
					b--;
					while(isIn(a,b)) {
						if(field[a][b].equals("*")) {
							field[a][b] =".";
							break;
						}else if(field[a][b].equals("#")) {
							break;
						}
						b--;
					}
					
				}
				else {
					b++;
					while(isIn(a,b)) {
						if(field[a][b].equals("*")) {
							field[a][b] =".";
							break;
						}else if(field[a][b].equals("#")) {
							break;
						}
						b++;
					}
					
				}
				break;
		}
	}
	public static boolean isIn(int r, int c) {							
		return r>=0 && c>=0 && r < field.length && c< field[0].length;
	}
}
