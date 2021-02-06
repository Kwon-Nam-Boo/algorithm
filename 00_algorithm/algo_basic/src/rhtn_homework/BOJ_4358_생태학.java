package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4358_생태학 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		
		int[] trees = new int[10001];
		int idx = 0;
		int cnt = 0;
		while(true) {
           
			String tree = br.readLine();
			if(tree == null || tree.length() == 0) {
				break;
			}
			else {
				cnt++;
				if(!hm.containsKey(tree)) {
					hm.put(tree, idx++);
				}
				trees[hm.get(tree)]++;
			}
		}
		
		Object[] keys = hm.keySet().toArray();
		Arrays.sort(keys);
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i] +" "+ String.format("%.4f", (double) trees[hm.get(keys[i])] *100/ cnt));
		}
		

	}

}
