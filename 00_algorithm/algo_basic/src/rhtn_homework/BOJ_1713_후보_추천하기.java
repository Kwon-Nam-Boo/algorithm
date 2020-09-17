package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1713_후보_추천하기 {

	private static StringBuilder sb = new StringBuilder();
	private static int n, student;
	private static Pair[] frame;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 후보틀 수, 후보틀
		n = Integer.parseInt(br.readLine());
		frame = new Pair[n];
		// 학생 수
		student = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < student; i++) {
			// 투표한 학생넘버
			int sn = Integer.parseInt(st.nextToken());
			// 현재 있는 학생의 모든 타임 +1 증가(시간 시뮬)
			timeCount();
			// 체크 함수를 실행해 갈아치울 후보틀 번호를 찾는다
			int del = check(sn);
			// 만약 이미 있는 번호라면 갈아치울 필요없으므로 없는 번호만 갈아치우자
			if(del !=-1) frame[del] = new Pair(sn,0);
		}
		
		// 정렬 후 출력
		Arrays.sort(frame);
		for (int j = 0; j < n; j++) {
			if(frame[j] == null) break;
			System.out.print(frame[j].num + " ");
		}
		System.out.println();
		
	}
	// 시간 증가 함수
	public static void timeCount() {
		for (int i = 0; i < n; i++) {
			if(frame[i] == null) return;
			frame[i].time++;
		}
	}
	// 갈아치울 학생 찾기
	public static int check(int sn) {
		int minCnt = student;
		int idx = 0;
		
		for (int i = 0; i < n ; i++) {
			// 아직 채워지지 않앗다면 채운다
			if(frame[i] == null) return i;
			// 이미 있는 학생이면 카운트만 증가
			if(frame[i].num == sn) {
				frame[i].cnt++;
				return -1;
			}
			// 없는 학생중에 카운트가 작다면, 최신화
			if(minCnt > frame[i].cnt) {
				idx = i;
				minCnt = frame[i].cnt;
			}else if(minCnt == frame[i].cnt) {
				// 만약 카운트가 같을때,더 오래된 것이라면  바꾼다
				if(frame[idx].time < frame[i].time) {
					idx = i;
				}
			}
		}
		return idx;
		
	}
	
	public static class Pair implements Comparable<Pair>{
		int num,cnt,time=0;

		public Pair(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		// num으로 비교
		@Override
		public int compareTo(Pair o) {
			Integer o1 = this.num;
			Integer o2 = o.num;
			return o1.compareTo(o2);
		}
		
	}
}
