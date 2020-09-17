package rhtn_homework;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.*;

/**
 * 알고리즘 :
 *
 */
public class test1 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Character> koosaga = br.readLine().chars().mapToObj(e -> (char)e).collect(Collectors.toList());
		List<Character> cubelover = br.readLine().chars().mapToObj(e -> (char)e).collect(Collectors.toList());
		int n = koosaga.size();
		char[] result = new char[n];
		
		// 구사과 사전순 
		Collections.sort(koosaga);
		// 큐브러버 역사전순
		Collections.sort(cubelover, Collections.reverseOrder());

		// 구사과는 홀수 일 때는 큐브러버보다 1글자 더 받아와야함 
		int ks = 0, ke = (n + 1) / 2 - 1;
		int cs = 0, ce = (n / 2) - 1;

		// 한 글자인 경우 예외 처리 
		if (ke <= 0) ke = 0;
		if (ce <= 0) ce = 0;

		// 결과를 저장할 배열의 포인터 
		int head = 0, tail = n - 1;

//		System.out.println(koosaga.toString());
//		System.out.println(cubelover.toString());
//		
		for (int i = 0; i < n; i++) {
			// 구사과 턴  
			if(i % 2 == 0) {
				// 구사과의 첫글자가 큐브러버보다 작을 경우 그냥 앞에 넣음 
				if(koosaga.get(ks) < cubelover.get(cs)) 
					result[head++] = koosaga.get(ks++);
				// 그렇지 않을 경우 구사과의 값들은 모두 큐브러버보다 크기 때문에 가장 큰 값을 넣어서 뒤를 고정시킨다.  
				else
					result[tail--] = koosaga.get(ke--);
			} 
			// 큐브러버 턴 
			else {
				// 큐브러버의 첫글자가 구사과보다 클 경우 그냥 앞에 넣는다.
				if(koosaga.get(ks) < cubelover.get(cs)) 
					result[head++] = cubelover.get(cs++);
				// 그렇지 않을경우 큐브러버의 값들은 모두 구사과 보다 작기 때문에 가장 작은 값을 뒤에 넣어서 고정시킨다. 
				else
					result[tail--] = cubelover.get(ce--);
			}
		}

		System.out.println(String.copyValueOf(result));

	}

}