package algo_basic.day1;

import java.util.Scanner;

public class SWEA_5603_D3_건초더미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
         
		 int TC = sc.nextInt();
         
		 for (int i = 1; i <= TC; i++) {
            sb.append("#").append(i).append(" ");
            int N = sc.nextInt();
            int[] arr = new int[N];
            
            int sum =0;
            for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum+=arr[j];
				
			}
            int average =sum/N;
    
            int result =0;
            for (int j = 0; j < arr.length; j++) {
				if(average >= arr[j])
					result+= (average-arr[j]);
			}
            sb.append(result).append("\n");
        }
	    System.out.println(sb); 
	}

}
