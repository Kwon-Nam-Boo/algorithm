package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Toss_4 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String input = br.readLine();
		st = new StringTokenizer(input, " ");
		int len = st.countTokens();
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < len; i++) {
			String tmp = st.nextToken();
			if(list.contains(tmp)) {
				list.remove(tmp);
			}
			list.add(tmp);
			
			if(list.size() == 6) {
				list.remove(0);
			}
			for (int j = list.size()-1; j >=0 ; j--) {
				System.out.print(list.get(j) +" ");
			}
			System.out.println();
		}
		
		
		
	
	}
}
