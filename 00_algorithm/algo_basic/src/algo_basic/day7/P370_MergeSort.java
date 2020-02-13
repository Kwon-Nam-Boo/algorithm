package algo_basic.day7;

import java.util.Arrays;

public class P370_MergeSort {
	public static void main(String[] args) {
		int arr[] = {69,10,30,2,16,8,31,22};
		//arr을 병합 정렬하고 결과를 출력하시오
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	// 재귀의 변수들은 상태를 나타낸다!
	public static void mergeSort(int arr[], int startI, int endI) {
		// base case
		if(startI == endI) {
			return;
		}
		//recur case
		int midI = (startI + endI) / 2;
		mergeSort(arr, startI, midI);
		mergeSort(arr, midI+1, endI);
		// 쪼개기 완료. 이제 정렬 및 합치기 과정
		merge(arr,startI,midI,endI);
	}
	public static void merge(int[] arr, int si, int mi, int ei) {
		int[] tmp = new int[arr.length];
		// 왼쪽 배열의 기점
		int li = si;
		//오른쪽 배열의  기점
		int ri =mi +1;
		//임시 배열의 기점
		int ti =si;
		//양쪽 배열에 모두 값이 있다면 - 한놈씩 나와서 경합
		while(li <=mi && ri <=ei) {
			if(arr[li] < arr[ri]) {
				tmp[ti++] =arr[li++];
			}else {
				tmp[ti++] =arr[ri++];
			}
		}
		// 어느  한쪽에만 선수가 남은 상황
		while(li<=mi){
			tmp[ti++]= arr[li++];
		}
		while(ri<=ei) {
			tmp[ti++]= arr[ri++];
		}
		for (int i = si; i <=ei; i++) {
			arr[i] =tmp[i];
		}
	}
}
