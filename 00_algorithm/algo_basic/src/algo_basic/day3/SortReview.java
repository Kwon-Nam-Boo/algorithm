package algo_basic.day3;

import java.util.Arrays;
import java.util.Comparator;

public class SortReview {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] src = {"dream","is","come","true"};
		Arrays.sort(src);
		System.out.println(Arrays.toString(src));
		
		Arrays.sort(src, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				if(len1.equals(len2)) {
					return o2.compareTo(o1);
				}
				return len1.compareTo(len2);
			}
			
		});
		
		//글자 오른차순 정렬
		System.out.println(Arrays.toString(src));
		
		// 길이가 같은경우는 내림차순 출력	
		
		int[][] arr = {{1,2,3},{7,8,9},{4,5,6}};
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				Integer sum1 =0;
				Integer sum2 =0;
				for (int i = 0; i < o1.length; i++) {
					sum1+=o1[i];
				}
				for (int i = 0; i < o1.length; i++) {
					sum2+=o2[i];
				}
				return sum2.compareTo(sum1);
			}
			
		});	
		for(int[] row:arr) {
			System.out.println(Arrays.toString(row));
		}
		
	}

}
