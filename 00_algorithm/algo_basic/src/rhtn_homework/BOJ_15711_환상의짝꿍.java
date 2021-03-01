package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class BOJ_15711_환상의짝꿍 {

	private static int T;
	private static boolean[] arr;
	private static List<Integer> prime;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		// 2^6+1 ( 기준의 루트값만 조사하면 되니깐)
		// 2000001 전 까지의 소수를 구하여 소수로만 리스트화
		arr = new boolean[2000001];
		arr[1] = true;
		prime = new ArrayList<>();
		for (int i = 2; i < arr.length; i++) {
			if(arr[i]) continue;
			else {
				prime.add(i);
				for (int j = i+i; j < arr.length; j+=i) {
					arr[j] = true;
				}
			}
		}
	
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			long sum = a+b;
			if(sum < 4) {
				sb.append("NO" +"\n");
				continue;
			}
			if(sum %2 == 0) {
				sb.append("YES" +"\n");
				continue;
			}
			// 2(소수)와 sum-2로 나눠본다면 sum-2가 소수이면 되는 문제인 것이다 
			sum-=2;
			if(checkPrime(sum)) {
				sb.append("YES" +"\n");
			}else {
				sb.append("NO" +"\n");
			}
		}
		
		System.out.println(sb);
	}
	
	// 루트 N 까지만 소수인지 조사해보면 된다(이미 가능한 소수들 리스트화 해둠)
	private static boolean checkPrime(Long l) {
		
		// 리스트화 된 소수로 해당 수가 소수인지 나눠보는 것
		for (int i = 0; i < prime.size(); i++) {
			if(l <= prime.get(i)) break;
			if(l % prime.get(i) == 0) return false; 
		}
		return true;
		
	}
}
