package A_0345636;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 *  Set은 중복 되지 않게 데이터 저장
 *  Hashset은 중복 x, 순서 x
 *  LinkedHashSet 은 중복 x, 넣은 순서로 출력
 *  Treeset 은 중복 x , 정렬된 순서로 출력
 * 
 *  map은 key, value의 페어로 저장되는 데이터
 *  hashSet 키 중복 x , 키 순서 x 
 *  LinkedHashSet 키 중복 x, 들어간 순서대로 o  
 *  TreeSet 키 중복 x, 대소구분 자동정렬 o -- 자동으로 정렬하기때문에 다른 map보다 오래걸림 
 */
public class Review_0213_A_4 {
	
	private static int[] arr = {1,3,4,5,8};

	public static void main(String[] args) {		
		//mapApi(new HashMap<>());
		mapApi(new TreeMap<>());
		setApi(new TreeSet<>());
	}
	public static void setApi(Set<String> set) {
		set.add("My");
		set.addAll(Arrays.asList("My","Dream","Come","True"));
		
		for(String str:set) {
			System.out.println("for:" + str);
		}
		// size, contain isEmpty, remove의 기본 메서드
		System.out.println(set.size()+ " : "+ set.contains("Hello") + " : "	
							+ set.isEmpty() + " : " + set.remove("Hello"));
		
		if(set instanceof TreeSet) {
			TreeSet<String> tset = (TreeSet) set;
			System.out.println("headSet" + tset.headSet("Test")); // 해당 값보다 앞(알파벳)
			System.out.println("tailSet" + tset.tailSet("Test")); // 해당 값보다 뒤(알파벳)
			System.out.println(tset.subSet("Done","test")); 	// 해당값사이(알파벳)
			
			// 정렬된 순서에서 첫번째 객체 (first) 
			System.out.println(tset.first());
			// 정렬된 순서에서 마지막 객체
			System.out.println(tset.last());
			//제일 낮은 객체를 꺼내고 컬렉션에서 제거함
			System.out.println(tset.pollFirst());	
			//제일 높은 객체를 꺼내고 컬렉션에서 제거함
			System.out.println(tset.pollLast());	
			System.out.println(tset);
		}
		
	}
	public static void mapApi(Map<Integer, String> map) {
		// put, get, remove는 기본적인 메소드
		for (int i = 0; i < arr.length; i++) {
			map.put(i, Integer.toString(arr[i]));				
		}
		
		System.out.println(map.getClass().getName() + " : " + map);
		
		// key들을 모아 set에 넣어 리턴해준다. 
		Set<Integer> keys = map.keySet();
		
		// get(key) 로 value 출력
		for(Integer key: keys) {
			System.out.println("for " + key +" : " + map.get(key));		
		}
		System.out.println();
		// value들을 모아 Collection에 넣어 리턴해준다.
		Collection<String> values = map.values();
		System.out.println(values);
		
		// value 값 바꾸기
		map.replace(3, "6");
		
		// 해당 객체를 entrySet으로 set에 넣는다
		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		System.out.println("entries:" + entries);
		System.out.println();
		for(Entry<Integer, String> ent: entries) {
			System.out.println("entry: " + ent.getKey() +" : " + ent.getValue());
		}
		System.out.println();
		// treeMap 전용
		if(map instanceof TreeMap) {		// TreeMap 전용
			TreeMap<Integer,String> tmap = (TreeMap<Integer,String>)map;
			
			System.out.println("map.firstKey() = " + tmap.firstKey());
			System.out.println("map.lastKey() = " + tmap.lastKey());
			System.out.println("map.higherKey() = " + tmap.higherKey(4));	// 해당키보다 큰 키
			System.out.println("map.lowerKey() = " + tmap.lowerKey(3));
			System.out.println();
			System.out.println("head" + tmap.headMap(3));		// 입력한 key값 보다 작은 데이터들
			System.out.println("tail" + tmap.tailMap(5));		// 입력한 key값 보다 큰 데이터들
			System.out.println("sub" + tmap.subMap(3,5));    	// 입력한 key값 범위의 데이터들
			
		}
	}
	
}
