package algo_basic.day2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	
	public static void sort0(){
		String[] strs = {"Now","Hello", "Java", "World"};
		Arrays.sort(strs);									// 알파벳 정렬 (정렬 가능한 것만 정렬하는 sort)
		System.out.println(Arrays.toString(strs));
	}
	
	public static void sort1() {
		Hero[] heros = {
			new Hero(100,"Hulk"),
			new Hero(80,"SpiderMan"),
			new Hero(90,"IronMan"),
		};
		Arrays.sort(heros);
		System.out.println(Arrays.toString(heros));
	}
	
	static class Hero implements Comparable<Hero>{
		Integer power;		// Integer는 비교 가는해짐
		String name;
		
		@Override
		public String toString() {
			return "Hero [power=" + power + ", name=" + name + "]";
		}

		public Hero(int power, String name) {
			super();
			this.power = power;
			this.name = name;
		}

		@Override
		public int compareTo(Hero o) {
			// TODO Auto-generated method stub
			
			/*if(this.power >o.power){
				return 1;
			}else if(this.power == o.power) {
				return 0;
			}else {
				return 1;
			}*/
			
			return this.power.compareTo(o.power);
			//return this.name.compareTo(o.name);
		}
	}
		static class Hero2{
			Integer power;		// Integer는 비교 가는해짐
			String name;
			
			@Override
			public String toString() {
				return "Hero [power=" + power + ", name=" + name + "]";
			}

			public Hero2(int power, String name) {
				super();
				this.power = power;
				this.name = name;
			}

		}
		public static void sort2() {
			Hero2[] heros = {
				new Hero2(100,"Hulk"),
				new Hero2(80,"SpiderMan"),
				new Hero2(90,"IronMan"),
			};
			Arrays.sort(heros, new Comparator<Hero2>() {		// 어노니머스 이너 클래스 (익명의 내부 클래스) 방식
				@Override
				public int compare(Hero2 o1, Hero2 o2) {
					
					return o1.name.compareTo(o2.name);
				}
			});
			System.out.println(Arrays.toString(heros));
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sort0();
		//sort1();
		sort2();
		
		}

}

