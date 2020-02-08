package algo_basic.day6;

import java.util.LinkedList;
import java.util.Queue;

public class P303_마이쭈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalCandyCnt = 20;
		int personId =1;
		Queue<Person> queue = new LinkedList<>();
		queue.offer(new Person(personId++,1));
		
		while(true) {
			System.out.println("현재의 큐  상태: "+ queue);
			Person front = queue.poll(); // 맨앞 에 있는 사람 빼기
			int receiveCandyCnt = front.candyCnt; // 뺼 캔디
			front.candyCnt++;					// 다음엔 하나더
			//남아 있는 캔디가 적다면?
			if(totalCandyCnt < receiveCandyCnt) {
				System.out.printf("%d번이 마지막으로 %d개 가져감",front.id, totalCandyCnt);
				break;
			}else {
				totalCandyCnt-=receiveCandyCnt;
				System.out.printf("%d번이 %d개의 캔디를 가져감, 남은 캔디 %d\n",front.id,receiveCandyCnt,totalCandyCnt);
				queue.offer(front);
				queue.offer(new Person(personId++,1));
			}
		}

	}
	static class Person{
		int id;
		int candyCnt;
		public Person(int id, int candyCnt) {
			super();
			this.id = id;
			this.candyCnt = candyCnt;
		}
		@Override
		public String toString() {
			return "["+ id + ","+ candyCnt + "]";
		}
		
		
	}
	
}
