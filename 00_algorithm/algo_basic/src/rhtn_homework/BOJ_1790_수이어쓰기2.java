package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790_수이어쓰기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		long tmp = K;
		long digit =1;
		long lastNum = 0;
		long reduceNum = 9;
		
		while(tmp > (reduceNum*digit)) {
			tmp -= (reduceNum*digit);
			lastNum+=reduceNum;
			digit++;
			reduceNum*=10;
		}
		long selNum = (lastNum+1) + ((tmp-1)/digit);
		//System.out.println(selNum);
		
		if(selNum > N) {
			System.out.println(-1);
		}else {
			long index = (tmp-1)% digit;
			String ans = Long.toString(selNum);
			System.out.println(ans.charAt((int)index));			
		}
	}

}
