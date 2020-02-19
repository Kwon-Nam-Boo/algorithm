package algo_ad.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapscakTest {
	
	//static int [][] goods = {{25,10},{10,9},{10,5}};
	//static int [][] goods = {{25,10},{10,9},{10,5}};
	static int [][] goods = {{5,50},{10,60},{20,140}};
	private static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) {
		// 위 조건을 0-1 Knapsack문제를 처리하시오
		//subSet(0,0);
		int weight = 30;
		int max =0;
		for (int i = 0; i < (1<<goods.length); i++) {
			List<Good> subset = new ArrayList<>();
			int sumw =0;
			int sump =0;
			for (int j = 0; j < goods.length; j++) {
				if((i& (1<<j))>0) {
					if(sumw + goods[j][0] >weight) {
						break;
					}else {
						Good good = new Good(goods[j][0], goods[j][1]);
							subset.add(good);
							sumw += good.w;
							sump += good.p;
					}
				}
			}
			System.out.println(subset);
			max =Math.max(max, sump);
		}
		System.out.println(max);
	}
	public static class Good {
		int w, p;
		
		public Good(int w, int p) {
			this.w = w;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Good [w=" + w + ", p=" + p + "]";
		}
		
	}
	
	/*public static void subSet(int r , int k) {
		int sum =0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i)[0];
			if(sum>)
		}
		System.out.println();
		if(r == goods.length) {
			return;
		}
		for (int i = k; i < goods.length; i++) {
			list.add(goods[i]);
			subSet(r+1,i+1);
			list.remove(list.size()-1);
			
		}
	}*/
}
