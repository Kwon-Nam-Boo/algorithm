package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1071_약수와_배수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		int sum1 = 0,sum2 = 0;
		for (int i = 0; i < N; i++) {
			if(M >= arr[i] && M % arr[i] ==0) sum1+=arr[i];
			if(M <= arr[i] && arr[i] % M ==0) sum2+=arr[i];
		}
		System.out.println(sum1);
		System.out.println(sum2);
		
	}

}
