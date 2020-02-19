package algo_ad.day1;

import java.math.BigDecimal;

public class ChangeNotation {

	public static void main(String[] args) {
		int num =149;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
		int numbit = 0b10010101;
		System.out.println(numbit);
		System.out.println(Integer.toString(numbit, 10));
		System.out.println(Integer.toString(numbit, 8));
		System.out.println(Integer.toString(numbit, 16));
		
		double d1 =2.0;
		double d2 =1.1;
		System.out.println(d1-d2);
		
		BigDecimal bd1 = new BigDecimal(d1+"");
		BigDecimal bd2 = new BigDecimal(d2+"");
		System.out.println(bd1.subtract(bd2));
	}

}
