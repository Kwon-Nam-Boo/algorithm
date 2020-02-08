package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2056_D1_연월일_달력 {
	private static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
	
		
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//s = new Scanner(src);
		int TC = s.nextInt();
		
		for (int i = 1;i <=TC; i++) {
			sb.append('#').append(i).append(" ");
			String ymd = s.next();
			String year = ymd.substring(0, 4);
			String mStr = ymd.substring(4, 6);
			int month = Integer.parseInt(ymd.substring(4, 6));
			String dStr = (ymd.substring(6, 8));
			int day = Integer.parseInt(ymd.substring(6, 8));
			
			if(month > 12 || month < 1 || day <=0 || day > days[month]) {
				sb.append("-1").append("\n");
			} else {
				sb.append(year).append("/").append(mStr).append("/").append(dStr).append("\n");
			}
			
		}
		
		System.out.println(sb);	
	}
	//private static src = 
	

}
