package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROG_문자열압축 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "aabbaccc";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = s.length();
     
        // 자를 조각의 크기
        for (int i = 1; i <= s.length()/2; i++) {
        	// 전체 길이, 압축 숫자, 기준 문자열
        	int ans = 0;
        	int cnt = 1;
        	String stand = s.substring(0,i);
        	
			for (int j = i; j < s.length(); j+=i) {
				// 찌꺼기가 남는 경우
				if(j+i > s.length()) {
					ans+=(s.length()-j);
					break;
				}
				// 현재 문자열
				String tmp = s.substring(j, j+i);
				
				// 만약 앞뒤가 같다면
				if(tmp.equals(stand)) {
					cnt++;
				}else {
					ans = Compression(cnt,ans,i);
					stand = tmp;
					cnt = 1;
				}
			}
			ans = Compression(cnt,ans,i);
			answer = Math.min(ans, answer);
		}
        
        return answer;
    }
	
	public static int Compression(int cnt , int ans , int i){
		if(cnt == 1) {
			return ans+=i;
		}else if(cnt<10){
			return ans+=(i+1);
		}else if(cnt<100) {
			return ans+=(i+2);
		}else if(cnt<1000) {
			return ans+=(i+3);
		}else return ans+=(i+4);
	}
}
