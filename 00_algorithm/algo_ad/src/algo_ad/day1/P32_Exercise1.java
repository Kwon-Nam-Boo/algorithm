package algo_ad.day1;

public class P32_Exercise1 {
	private static String[] src = {
			"00000010001101","0000000111100000011000000111100110000110000111100111100111111001100111"
	};
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < src.length; i++) {
			String str = src[i];
			
			sb.append("#").append(i+1).append(" - ");
			for (int j = 0; j < str.length(); j+=7) {
				sb.append(calc(str,j)).append(",");
			}
			sb.delete(sb.length()-1, sb.length()).append("\n");
		}
		System.out.println(sb);
		
		
	}
	private static int calc(String data, int from) {
		int sum =0;
		for (int i = from, shift = 6; i < from + 7; i++, shift--) {
			if(data.charAt(i) == '1') {
				sum+=(1<< shift);
			}
		}
		return sum;
	}	
}
