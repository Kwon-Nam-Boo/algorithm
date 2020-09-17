package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_1013_Contact {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 풀어 보려고 했는데 결국 패턴 매치 사용...
		for (int i = 0; i < N; i++) {
			Pattern pat = Pattern.compile("((100+1+)|(01))+");
			Matcher mat = pat.matcher(br.readLine());
			if(!mat.matches()) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
	}
}
