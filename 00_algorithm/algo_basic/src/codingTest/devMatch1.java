package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class devMatch1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String P ="AM 12:01:00";
		int N = 0;
		System.out.println(solution(P, N));
	}
	
	public static String solution(String p, int n) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(p);
        
        String AP = st.nextToken();
        st = new StringTokenizer(st.nextToken(), ":");
        int time = Integer.parseInt(st.nextToken());
        int t = time*3600;
        t += Integer.parseInt(st.nextToken())*60;
        t += Integer.parseInt(st.nextToken());
        t+=n;
        if(AP.equals("PM") && time < 12) t+=12*3600;
        if(AP.equals("AM") && time == 12) t-=12*3600;
        
        //System.out.println(t);
        if((t/3600)%24 < 10) answer = answer +"0" +Integer.toString((t/3600)%24) + ":";
        else answer = answer +Integer.toString((t/3600)%24) + ":";
        t%=3600;
        if((t/60) < 10) answer = answer + "0" + Integer.toString(t/60) + ":";
        else answer = answer + Integer.toString(t/60) + ":";
        t%=60;
        if(t < 10) answer = answer + "0" + Integer.toString(t);
        else answer = answer + Integer.toString(t);
    
        //System.out.println(t+":" + m +":"+ s);
        
    
        return answer;
    }
}
