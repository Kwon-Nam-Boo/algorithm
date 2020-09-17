package swexpert;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class SWEA_4366_D4_정식이의_은행업무 {

	private static char[] WrongTwo;
	private static char[] WrongThree;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
		WrongTwo = br.readLine().toCharArray();
		WrongThree = br.readLine().toCharArray();
		
		check();
	}
	System.out.println(sb);
}

	private static void check() {
		// 숫자 하나를 바꿔본다
		for (int i = 1; i < WrongTwo.length; i++) {
			// 잠시 숫자를 하나 바꾼다
			WrongTwo[i] = WrongTwo[i] =='1' ? '0':'1';
			
			// 배열을 문자열로 바꾸고
			String tmpString = String.valueOf(WrongTwo);
			
			// 2진수를 10진수로 표현한다
			long num = Integer.parseInt(tmpString, 2);
			
			// 10진수를 3진수로 전환 후 -> 주어진 3진수와 비교하기
			if(threeCheck(threeString(num))) {
				sb.append(num).append("\n");
			}
			// 원상복구
			WrongTwo[i] = WrongTwo[i] =='1' ? '0':'1';
			}
	
	}
	// 십진수 -> 삼진수
	public static String threeString(long num) {
		String tmp ="";
		while(num >= 3) {
			tmp =  Long.toString(num%3) + tmp;
			num/=3;
		}
		tmp = Long.toString(num) + tmp;
		return tmp;
	}

	// 주어진 삼진수가 1자리만 틀린지 아닌지
	public static boolean threeCheck(String threeTmp) {
		int cnt=0;
		
		if(threeTmp.length() !=WrongThree.length) return false;
		
		for (int j = 0; j < WrongThree.length; j++) {
			if(WrongThree[j] != threeTmp.charAt(j)) {
				cnt++;
			}
			if(cnt > 1) return false;
		}
		if(cnt == 0) {
			return false;
		}else {
			return true;
		}
	}

	/*public static long toDigit10(char[] chars, int digits) {
		long num =0;
		for (int i = 0, j = chars.length-1 ; i < chars.length; i++, j--) {
			num+=(chars[i]-'0') * (Math.pow(digits, j));
		}
		return num;
	}*/
}
	
	
