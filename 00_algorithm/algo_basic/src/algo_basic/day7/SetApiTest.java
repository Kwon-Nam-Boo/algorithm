package algo_basic.day7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetApiTest {

	public static void main(String[] args) {
		useSet(new HashSet<>());
		useSet(new LinkedHashSet<>());
		useSet(new TreeSet<>());			// 자동으로 sort

	}
	public static void useSet(Set<String> set) {
		set.add("My");
		set.addAll(Arrays.asList("My","Dream","Come","True"));
		
		// Hashset은 중복 x, 순서 x
		// LinkedHashSet 은 중복 x, 넣은 순서로 출력
		//Treeset 은 중복 x , 정렬된 순서로 출력
		
		System.out.println(set.getClass().getName() + " : "+set);
		
		
		for(String str:set) {
			System.out.println("for:" + str);
		}
		
		
		
		System.out.println(set.size()+ " : "+ set.contains("Hello") + " : " + set.isEmpty() + " : " + set.remove("Hello"));
		Object [] arr = set.toArray();
		
		if(set instanceof TreeSet) {
			TreeSet<String> tset = (TreeSet) set;
			System.out.println("test보다 앞에 있는 녀석들" + tset.headSet("Test"));
			System.out.println("test보다 뒤에 있는 녀석들" + tset.tailSet("Test"));
			System.out.println(tset.subSet("Done","test"));
			
			System.out.println(tset.first() + " : " + tset.pollFirst());
			System.out.println(tset);
		}
	}
}
