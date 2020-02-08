package algo_basic.day2;

import java.util.Arrays;

public class Search {
	static int[] test = {32,41,6,8,10,41,53,46,21,89,57};
	static int[] test2 = new int[test.length];
	public static void main(String[] args) {
		
		System.out.println(sequentialNoSort(test,21));		// 찾고자하는 것이 있을경우
		System.out.println(sequentialNoSort(test,22));		// 찾고자하는 것이 없을 경우
	
	
		System.out.println(sequentialSort(test,21));		// 찾고자하는 것이 있을경우 (정렬)
		System.out.println(sequentialSort(test,22));		// 찾고자하는 것이 없을경우 (정렬)
		
		System.arraycopy(test, 0, test2, 0, test.length);	// 배열복사
		System.out.println(Arrays.toString(test2));
		
		Arrays.sort(test2);
		System.out.println(binarySearch(test2, 8));			// 이진 탐색(정렬일때만)
		
		
	}
	public static int sequentialNoSort(int[] a, int key) {
		int i = 0;
		while(i<a.length && a[i]!=key) {
			i++;
		}
		if(i< a.length) return i;
		else return -1;
	}
	
	public static int sequentialSort(int[] a, int key) {
		int i = 0;
		while(a[i]<key) {
			i++;
		}
		if(a[i] == key) return i;
		else return -1;
	}
	
	public static int binarySearch(int[] a, int key) {
		int start = 0; int end = a.length-1;
		while(start<=end) {
			int middle = (start + end)/2;
			if(a[middle] == key) return middle;
			else if(a[middle]> key) end = middle -1;
			else start = middle +1;
		}
		return -1;
	}
	
}
