package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class KAKAO_크레인_인형뽑기 {

	private static StringBuilder sb = new StringBuilder();
	private static Stack<Integer> stack = new Stack<>();
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
		
	}
	
	
    public static int solution(int[][] board, int[] moves) {
        ans = 0;
        int[][] tmp = {};
        
        for (int i = 0; i < moves.length; i++) {
			tmp = pick(board, moves[i]-1);
		}
        
        return ans;
    }
	
    public static int[][] pick(int[][] board , int move) {
    	
    	
    	for (int i = 0; i < board.length; i++) {
			if(board[i][move]==0) continue;
			else {
				if(!stack.isEmpty() && stack.peek() == board[i][move]) {
					stack.pop();
					ans+=2;
				}else
					stack.add(board[i][move]);
				
				board[i][move]=0;
				break;
			}
		}
		return board;
    	
    }
	
}
