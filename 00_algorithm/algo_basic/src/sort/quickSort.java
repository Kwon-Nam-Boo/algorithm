package sort;

import java.util.Arrays;

public class quickSort {

	public static void main(String[] args){
		int[] data = new int[]{ 4, 2, 8, 6, 0, 5, 1, 7, 3, 9 };
		quicksort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}
	
	private static void quicksort(int[] data, int pl, int pr) {
		
		if(pl!=pr) {
			int pivotIdx = partition(data, pl,pr);
			quicksort(data, pl, pivotIdx-1);
			quicksort(data, pivotIdx, pr);
		}
		
	}
	
	private static int partition(int[] data, int pl, int pr) {
		
		int pivot = data[pl];
		
		while(pl<=pr) {
			// 1. 왼쪽이 피벗보다 크거나 같을때 까지 왼쪽으로 pl++
			while(data[pl] < pivot) pl++;
			// 2. 오른쪽이 피벗보다 작거나 같을때까지 pr--
			while(data[pr] > pivot) pr--;
			// 3. pl, pr을 스왑하고 둘다 다음칸으로 전진한다
			if(pl<=pr) {
				int temp = data[pr];
				data[pr] = data[pl];
				data[pl] = temp;
				pl++;
				pr--;
			}
			System.out.println("교체 결과: " + Arrays.toString(data));
		}
		
		return pl;
	}

}
