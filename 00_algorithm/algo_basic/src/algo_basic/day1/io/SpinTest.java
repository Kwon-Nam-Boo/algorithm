package algo_basic.day1.io;

public class SpinTest {
	
	public static int[] src = {7,4,2,0,0,6,0,7,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max =0;
		for (int i = 0; i < src.length; i++) {
			int cnt =0;
			for (int j = i+1; j < src.length; j++) {
				if(src[i] > src[j]) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
			
		}
		System.out.println(max);
	}
	
}
