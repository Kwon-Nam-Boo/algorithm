package invest;

import java.util.Arrays;
import java.util.Stack;

public class PlusMinus {
	
	private static int[] high = {7750, 8030, 8280, 8120, 8100};
	private static int[] low = {7670,7720,7850, 7880,7870};
	public static Stack<Integer> stack;
	
	public static void main(String args[]) {
		
		Arrays.sort(high);
		Arrays.sort(low);
		
		double hs = 0, ls = 0;
		for (int i = 0; i < high.length; i++) {
			hs += high[i];
		}
		for (int i = 0; i < low.length; i++) {
			ls += low[i];
		}
		double sell = hs/(low.length);
		double buy = ls/(low.length);
		
		System.out.println("추천 매수 금액: " + (int)buy);
		System.out.println("추천 매도 금액: "+ (int)sell );
		double per  = ((sell - buy) / buy *100);
		System.out.println("매매시 이율: "+ String.format("%.2f", per));
		stack.pop();
	}
	
}
