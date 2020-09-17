package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class line_3 {

	private static StringBuilder sb = new StringBuilder();
	private static int min,ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n  = 73425;
		System.out.println(Arrays.toString(solution(n)));
	}
	public static int[] solution(int n) {
        int[] answer = {};
        String num = Integer.toString(n);
        min= Integer.MAX_VALUE;
        ans = 0;
//        System.out.println(num.substring(0, 2));
//        System.out.println(num.substring(2, num.length()));
        cut(num, 0);
        answer = new int[2];
        answer[0] = min;
        answer[1] = ans;
        return answer;
    }
	
	public static void cut(String num, int cnt) {
		// 자를수 있는 구간 수
		int point = num.length()-1;
		//System.out.println(point);
		
		if(point == 0) {
			if(min > cnt) {
				min = cnt;
				ans = Integer.parseInt(num);
			}
			return;
		}
		
		for (int i = 1; i <= point; i++) {
			String a = num.substring(0, i);
			String b = num.substring(i, num.length());
			if(a.charAt(0) == '0' || b.charAt(0)=='0') continue;
			
			int tmp = Integer.parseInt(a) +  Integer.parseInt(b);
			String tmp2 = Integer.toString(tmp);
			
			cut(tmp2 ,cnt+1);
		}
	}
}
