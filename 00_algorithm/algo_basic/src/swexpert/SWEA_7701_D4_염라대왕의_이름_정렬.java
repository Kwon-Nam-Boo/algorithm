package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_7701_D4_염라대왕의_이름_정렬 {

	private static int N;
	private static TreeSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append("\n");
			N =Integer.parseInt(br.readLine());
			set = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Integer l1 = o1.length();
					Integer l2 = o2.length();
					if(l1 == l2) {
						return o1.compareTo(o2);
					}
					return l1.compareTo(l2);
				}
			});
			
			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
				sb.append(iter.next()).append("\n");
			}
		}
		System.out.println(sb);
	}


}
