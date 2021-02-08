package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_6588_골드바흐의추측 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[1000001];
		List<Integer> prime = new ArrayList<>();
		
		for (int i = 2; i < 1000001; i++) {
			// 배수 한적이 없으면
			if(!arr[i]) {
				prime.add(i);
				for (int j = i; j < 1000001; j+=i) {
					if(j == i) continue;
					if(j%i ==0) arr[j] = true;
				}
			}
		}
		arr[1] = true;

		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N ==0) break;
			for (int i = 0; i < prime.size(); i++) {
				int tmp = N - prime.get(i);
				if(tmp <= 0) {
					System.out.println("Goldbach's conjecture is wrong.");
				}else {
					if(!arr[tmp]) {
						System.out.println(N + " = " + prime.get(i) + " + " + tmp);
						break;
					}
				}
			}
		}
	}
}
