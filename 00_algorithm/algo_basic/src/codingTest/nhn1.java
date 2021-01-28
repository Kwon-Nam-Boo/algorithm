package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class nhn1 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] alpha = new int[26]; // 아스키 65~90
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int numOfAllPlayers = 17;
		int numOfQuickPlayers = 5;
		char[] namesOfQuickPlayers = {'B', 'D', 'I', 'M', 'P'};
		int numOfGames = 11;
		int[] numOfMovesPerGame = {3 ,-4 ,5 ,6 ,-7 ,-8 ,10 ,-12 ,-15 ,-20 ,23};
		solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);
	}
	
	public static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
		alpha[0]++;
		int start = 0;
		
		HashMap<Integer,Character> map = new HashMap<>();
		
		for (int i = 0; i < numOfAllPlayers; i++) {
			map.put(i-1, (char)('A'+i));
		}
		
		for (int i = 0; i < numOfGames; i++) {
			int x = numOfMovesPerGame[i];
			
			while(x <= -(numOfAllPlayers-1)) {
				x+=(numOfAllPlayers-1);
			}
			
			int tmp = (start+x+numOfAllPlayers-1) % (numOfAllPlayers-1);
			start= tmp;
			boolean fast = false;
			// 빠른녀석인 경우
			for (int j = 0; j < namesOfQuickPlayers.length; j++) {
				// 빠른 녀석이면
				if(map.get(start)  == namesOfQuickPlayers[j]) {
					//start = j;
					alpha[map.get(-1) - 65]++;
					fast = true;
					break;
				}
			}
			if(fast) continue;
			else {	// 빠르지 않으면
				char tmp2 = map.get(start);
				alpha[tmp2 - 65]++;
				map.put(start, map.get(-1));
				map.put(-1, tmp2);
			}
		}
		
		for (int i = 0; i < map.size()-1; i++) {
			System.out.println(map.get(i) + " " + alpha[map.get(i) - 65]);
		}
		System.out.println(map.get(-1) + " " + alpha[map.get(-1) - 65]);
	}
}
