package eday4;

import java.util.Arrays;

/*	LIS 최장 증가 수열
	O[NlogN]
	8 다음에 2가 올경우 그냥 버리지 않고, LIS 를 구성할 수 있는 위치에 저장해둔다 
*/
public class LIS_2 {

	public static void main(String[] args) {
		int[] a = {8,2,4,3,6,11,7,10,14,5};
		int[] C = new int[a.length];	// LIS로 사용 가능한 숫자를 저장, index를 저장
		int[] path = new int[a.length];	// 경로를 저장할 배열 역추적할 index를 저장
		
		
		int size = 0;	// LIS 개수 관리할 변수
		
		path[size] = -1;
		C[size++] = 0;	// 첫번째 숫자의 index 바로 반영
		
		for (int i = 1; i < a.length; i++) {
			// C배열의 마지막 숫자와 수열값을 비교
			if(a[C[size-1]]< a[i]) {
				path[i] = C[size-1];
				C[size++] = i;	//맨뒤에 붙임
			}else {		// LIS 마지막 숫자보다 크지않으면 LIS의 값을 업데이트 (이진탐색)
				int temp = binarySearch0(a,C,0,size,a[i]);	// 삽입할 위치를 음수로 .. 
				if(temp < 0) temp = -temp-1;
				path[i] = path[C[temp]];	// 덮어쓸 위치의 index를 내껄로 복사
				C[temp] = i;		// 수열의 값을 LIS 에 삽입할 위치에 덮어쓰기
				
			}
			
		}
		//System.out.println(Arrays.toString(C));
		System.out.println("LIS 개수 : "+ size);
		String result ="";
		for (int i = C[size-1];i!=-1;i = path[i]) {
			result = a[i] + " " + result;
		}
		System.out.println("LIS 수열:" + result);
	} // end of main

	private static int binarySearch0(int[] a,int[]C, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[C[mid]];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

} // end of class
