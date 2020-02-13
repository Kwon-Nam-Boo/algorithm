package algo_basic.day7;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapApiTest {

	public static void main(String[] args) {
		useMap(new HashMap<>());
		useMap(new LinkedHashMap<>());
		useMap(new TreeMap<>());

	}
	public static void useMap(Map<Integer, String> map) {
		int arr[] = {-1,-1,0,2,-2,1};
		
		for(int i:arr) {
			// map에 데이터 추가
			map.put(i, Integer.toString(i+1));
		}
		// HashMap - 키 중복 x, 순서 x, (value는 중복 가능)
		System.out.println(map.getClass().getName() + " : " + map);
		
		//key와 value  따로 유사한 가능 제공
		Set<Integer> keys = map.keySet();
		//Collection<String> vals = map.values();
		
		for (Integer key:keys) {
			System.out.println("for: " + key +" : " + map.get(key));
		}
		
		
		Set<Entry<Integer, String>> entrys = map.entrySet();
		for(Entry<Integer, String> ent: entrys) {
			System.out.println("entry: " + ent.getKey() +" : " + ent.getValue());
		}
		
		if(map instanceof TreeMap) {
			TreeMap<Integer,String> tmap = (TreeMap<Integer,String>)map;
			System.out.println("head" + tmap.headMap(0));
			System.out.println("tail" + tmap.tailMap(0));
			System.out.println("sub" + tmap.subMap(-1,1));
		}
		
	}

}
