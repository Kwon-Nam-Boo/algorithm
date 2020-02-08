package algo_basic.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class ListApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addTest();
		updateTest();
		searchTest();
		//remove();
		System.out.println("---------test ");
		sequencialAdd(new ArrayList<>(), 1);
		sequencialAdd(new LinkedList<>(), 1);
		System.out.println("---------test2 ");
		sequencialAdd(new ArrayList<>(), 2);
		sequencialAdd(new LinkedList<>(), 2);
	}
	//static List<Integer> list = new ArrayList<>();
	static List<Integer> list = new LinkedList<>();
	
	public static void addTest() {
		list.add(1);
		list.add(2);			// 순차적인 데이터 추가
		list.add(2);
		System.out.println(list);
		list.add(0,-1);			// 비순차적인 데이터 추가
		list.add(0,-2);
		
		System.out.println(list);
		
	}

	public static void updateTest() {
		list.set(0, -100);				// index 데이터 변경
		System.out.println(list);
	}
	public static void searchTest() {
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.get(1));
		System.out.println(list.contains(1));
		Integer i2 =-100;							// 숫자를 검색하고 싶으면  int 객체를 검색하면 된다.
		System.out.println("-------");
		System.out.println(list.indexOf(i2));
		
		
		
	}
	
	public static void remove() {
		int i = Integer.valueOf(1);
		Integer i2 =-100;
		
		list.remove(i2);							// -100이라는 값이 있는걸 지운다
		list.remove(3);								// 3번째 위치의 값을 지운다
		System.out.println(list);
		
	/*	for (int j = 0; j < list.size(); j++) {		// 원하는 대로 삭제 다 안된다 ! size가 가변적이기 때문
			list.remove(j);	
		}
		
		System.out.println(list);*/
		list.clear();					//list 초기화
			
	}
	public static void sequencialAdd(List<Integer> list ,int type)		// 순차와 연결리스트의 시간 비교
	{
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			if(type==1) {
				list.add(i);
			}else {
				list.add(0,i);
			}
		}
		System.out.println(System.currentTimeMillis() -start);
	}
	
}
