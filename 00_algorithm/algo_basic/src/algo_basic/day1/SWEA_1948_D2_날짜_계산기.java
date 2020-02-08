package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1948_D2_날짜_계산기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int TC = sc.nextInt();
		for (int i = 1; i <=TC; i++) {
			sb.append("#").append(i).append(" ");
			int startM =sc.nextInt();
			int startD =sc.nextInt();
			int endM =sc.nextInt();
			int endD =sc.nextInt();
			
			int sum =0;
			
			if(startM == endM ) {
				sum =endD;
			}else {
				sum += (Date(startM) - startD+1);
				sum += endD;
				for (int j = startM+1; j <=endM-1; j++) {
					sum+=Date(j);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	public static int Date(int month) {
		int day;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					day =31;
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					day =30;
					break;
				
			default:
					day=28;
					break;
		}
		return day;
	}

}
