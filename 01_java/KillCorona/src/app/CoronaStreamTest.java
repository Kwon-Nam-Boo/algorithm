package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import virus.Corona;

public class CoronaStreamTest {
	
	private static int count;
	public static void main(String[] args) {
		List<Corona> list = new ArrayList<Corona>();
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			String name = "Corona" + i;
			int level = r.nextInt(50);
			//System.out.println(level);
			String spreadSpeed = "S" + r.nextInt(10); 
			list.add(new Corona(name, level, spreadSpeed));
		} 
		// 구현해 보세요.
		// 객체 생성
		Stream<Corona> cor = list.stream();
		//중간연산
		count =0;
		cor.filter(x -> x.getLevel() > 30).forEach(x -> count++);
		
		System.out.println("Corona Count : " + count);
	}
}