package codingTest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class eleven2 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] S = {"gr","sd","rg"};
		System.out.println(Arrays.toString(solution(S)));
		
	}
	public static int[] solution(String[] S) {
        int[] ans = new int[3];
        
        // 알파벳, 문자열의 위치, 담길 정보는 해당 문자열의 idx
        int[][] map = new int[26][2000];
        
        
        // 초기화
        for (int[] is : map) {
			Arrays.fill(is, -1);
		}
        // 플래그
        int flag = 0;
        
        for (int i = 0; i < S.length; i++) {
        	String s = S[i];
			for (int j = 0; j < s.length(); j++) {
				if(map[s.charAt(j)-'a'][j]<0)
				map[s.charAt(j)-'a'][j] = i;
				else {
					ans[0] = map[s.charAt(j)-'a'][j];
					ans[1] = i;
					ans[2] = j;
					flag = 1;
					break;
				}
			}
		}
        // 답이없다면 빈배열 출력
        if(flag == 0) return new int[0];
		return ans;
    }
}
