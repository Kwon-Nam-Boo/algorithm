package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class line_4 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] maze = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
		System.out.println(solution(maze));
	}
	
    public static int solution(int[][] maze) {
        int answer = 0;
        N = maze.length;
        // 시작하자마자 왼손을 대고 잇으니 방향은 오른쪽을 보고 있 을것
        int head = 1;
        int r = 0; 
        int c = 0;
        int cnt=0;
        
        while(true) {
        	//System.out.println(r +":" + c);
        	if(r == maze.length-1 && c == maze.length-1) break;
        	// 만약 갈수 없는 곳이거나, 벽이 있다면
        	int dr = r + dir[head][0];
			int dc = c + dir[head][1];
        	
        	// 현재 방향에서의 왼쪽 벽과, 왼쪽 대각선 벽의 좌표
        	int wr = r + dir[(head + 3) % 4][0];
			int wc = c + dir[(head + 3) % 4][1];
			
			int fwr = dr + dir[(head + 3) % 4][0];
			int fwc = dc + dir[(head + 3) % 4][1]; 
			
			
			if(isIn(dr,dc) && maze[dr][dc] == 0) {
				// 왼쪽이 벽이라면 이동, 현재 방향에서의 왼쪽과, 왼쪽 대각선 중 하나라도 차있다면 이동
				// || maze[fwr][fwc] == 1
	    		if(!isIn(wr,wc) || maze[wr][wc] == 1 || maze[fwr][fwc] == 1) {
	    			r = dr;
	    			c = dc;
	    			cnt++;
	    			continue;
	    		}
	    		else {	// 하나도 없다면 좌회전
	    			head = (head + 3) % 4;
	    			continue;
	    		}
			}
			// 는 우회전
			if(!isIn(wr,wc) || maze[wr][wc] == 1) {
				head = (head + 1) % 4;
    			continue;
    		}else if(maze[wr][wc] == 0){
    			head = (head + 3) % 4;
        		continue;
    		}
		
        }
    
        
        return cnt;
    }
    
    public static boolean isIn(int r , int c) {
    	return r>=0 && c>=0 && r < N && c< N;
    }
}
