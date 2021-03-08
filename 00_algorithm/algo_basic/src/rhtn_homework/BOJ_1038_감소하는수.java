package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1038_감소하는수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 횟수카운팅, 정답
		int cnt = 0;
		long ans = 0;
		
		// 9876543210 보다 큰수는 없다 (당연히 9보다큰 한자리수가 없기떄문에)
		// 9876543210 1022번째 이므로 이보다 크면 -1
		
		if(N > 1022) {
			System.out.println(-1);
			return;
		}
		
		while(true) {
			//  감소수인가 아닌가, 답의 임시객체, 어떤 자릿수 위치, 이전 자릿수의 값
			boolean isDown = true;
			long tmp = ans;
			long jump = 1;
			long before = -1;
			
			while(tmp!=0){
				// 현재 자릿수의 값이 이전 자릿수의 값보다 크다면(만족)
				if(tmp%10 <= before) {
					isDown = false;
				}
				// 최적의 건너뛰기 jump 위치를 찾기 위해 
				// 1. 우선 감소하는수의 조건을 틀린적이 있고, 2.상위 자릿수에서 감소조건을 만족하면
				// 만족하기 직전까지는 다 바꿔줘도 된다는 의미
				if(!isDown && tmp%10 > before){
					break;
				}
				// 점프는 자릿수 증가 , 이전값과 현재값(임시) 갱신
				jump*=10;
				before = tmp%10;
				tmp/=10;
			}
			
			if(isDown) {
				// 해당값이 문제없이 감소하는 값이였다면, N위치인지 확인해보고
				// 아니면  cnt 증가  ans 증가시켜주면 된다
				if(N == cnt++) {
					System.out.println(ans);
					break;
				}else ans++;
			}else {
				jump/=10;
				ans+=jump;
				// 뒤에 자릿수 제거
				ans = ans/jump*jump;
			}
		}
	}

}
