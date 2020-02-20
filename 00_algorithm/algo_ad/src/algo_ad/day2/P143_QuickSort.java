package algo_ad.day2;

import java.util.Arrays;

public class P143_QuickSort {
	private static int[] src = {3,2,4,6,9,1,8,7,5};
	
	public static void main(String[] args) {
		sort(src,0,src.length-1);
		System.out.println(Arrays.toString(src));
	}
	
	public static void sort(int[] arr, int begin, int end) {
		if(begin < end) {
			// 정렬할 대상이 있다면 대상을 쪼개자!
			// s는 각 그룹의 경계값, 이미 정렬 완료된 위치
			int s = partition(arr, begin, end);
			sort(arr,begin,s-1);
			sort(arr,s+1,end);
		}
	}
	
	private static int partition(int[] arr, int begin, int end) {
		int left = begin;
		int right = end;
		int p =left;
		
		while(left<right) {
			while(arr[left] <=arr[p]) {
				if(left>=end) {
					break;						// 안전장치
				}
				left++;
			}
			while(arr[right]>=arr[p]) {
				if(right<=begin) {
					break;						// 안전장치
				}
				right--;
			}
			if(left<right) {
				swap(arr,left,right);
			}
		} // while{피벗}{작은 녀석들}{큰 녀석들}
		// 피벗을 작은녀석들과 큰녀석들 사이에 끼워두자
		swap(arr,p,right);
		return right;
	}
	private static void swap(int[] arr , int a , int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
