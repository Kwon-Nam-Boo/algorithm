package algo_basic.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InsertionSort {
	public static void main(String[] args) {
		
		Random rand = new Random();
		//int randNum;
		
		int[] data = new int[1000];
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(1000);
			list.add(rand.nextInt(1000));
		}
		
		insertionSort(data);
		System.out.println(Arrays.toString(data));
		//insertionSortList(list);
		System.out.println(list);
		
		
		for (int i = 0; i < data.length-1; i++) {
			if(data[i] < data[i+1]) {
				System.out.println("E");
			}

		}
	}
	
	public static void insertionSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if(data[j] > data[j-1]) {
					int tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
				}else {
					break;
				}
			}
		}
		
	}
	
	/*public static void insertionSortList(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			int stand = list.get(i);
			for (int j = i; j > 0; j--) {
				if(list.get(j) < stand) {
					list.remove(i);
					list.add(j+1,stand);
				}
			}
		}
	}*/
	
}
