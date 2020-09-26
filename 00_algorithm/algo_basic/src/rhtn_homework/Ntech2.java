package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ntech2 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 1;
		System.out.println(solution(N));
		
	}
	
	public static int solution(int N) {
        int[] hand = new int[N+1];
   
        hand[0] = 1;
        hand[1] = 1;

        for(int i = 2; i<=N; i++) {
            hand[i] = hand[i-1] + hand[i-2];
        }
        return hand[N];
    }
}
