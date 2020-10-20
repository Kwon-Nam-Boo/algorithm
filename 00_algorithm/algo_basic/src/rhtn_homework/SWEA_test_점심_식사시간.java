package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_test_점심_식사시간 {

	private static StringBuilder sb = new StringBuilder();
	private static int N, f, s, ans ;
	private static Pair fs,ss;
	private static List<Pair> list;
	private static List<Stair> fsList,ssList;
	private static List<Stair> fStair,sStair;
	private static Queue<Stair> fsq, ssq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			boolean flag = false;
			ans = Integer.MAX_VALUE;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) list.add(new Pair(r,c));
					else if(tmp > 1) {
						if(!flag) {
							fs = new Pair(r,c);
							f = tmp;
							flag =true;
						}
						else {
							s = tmp;
							ss = new Pair(r,c);
						}
					}
				}
			}
			subset();
			sb.append("#").append(t +" ").append(ans).append("\n");	
		}
		System.out.println(sb);
	}
	

	private static void subset() {
		for (int i = 0; i < (1<<list.size()); i++) {
			fsList = new ArrayList<>();
			ssList = new ArrayList<>();
			fStair = new ArrayList<>();
			sStair = new ArrayList<>();
			fsq = new LinkedList<>();
			ssq = new LinkedList<>();
			for (int j = 0; j < list.size(); j++) {
				Pair p = list.get(j);
				if((i &(1<<j))> 0) {
					int d = Math.abs(fs.r - p.r) + Math.abs(fs.c - p.c);
					fsList.add(new Stair(d,0));
				}else {
					int d = Math.abs(ss.r - p.r) + Math.abs(ss.c - p.c);
					ssList.add(new Stair(d,0));
				}
			}
			int cnt = 0;
			
			Collections.sort(fsList);
			Collections.sort(ssList);
			
			while(true){
				cnt++;
				if(count()) {
					ans = Math.min(ans, cnt);
					break;
				}

			}
		}
		
	}


	private static boolean count() {
		// 계단에 내려간 사람이 있으면 제거해주자
		int x = fStair.size();
		for (int i = 0; i < x; i++) {
			if(fStair.get(0).cnt == 0) {
				fStair.remove(0);
			}else break;
		}
		x = sStair.size();
		for (int i = 0; i < x; i++) {
			if(sStair.get(0).cnt == 0) {
				sStair.remove(0);
			}else break;
		}
		// 계단에 잇는 사람들의 내려가는 카운팅
		x = fStair.size();
		for (int i = 0; i < x; i++) {
			fStair.get(i).cnt--;
		}
		x = sStair.size();
		for (int i = 0; i < x; i++) {
			sStair.get(i).cnt--;
		}
		// 만약 계단이 3명미안이면, 대기큐에서 가능한 만큼 계단으로 투입
		while(fStair.size()<3) {
			if(fsq.isEmpty()) break;
			else {
				Stair st = fsq.poll();
				fStair.add(new Stair(st.d, f-1));
			}
		}
		while(sStair.size()<3) {
			if(ssq.isEmpty()) break;
			else {
				Stair st = ssq.poll();
				sStair.add(new Stair(st.d, s-1));
			}
		}
		// 사람들을 이동 시킨다, 해당 위치에 도착햇으면 일단 대기큐로 넣어준다
		int size = fsList.size();
		for (int i = 0; i < size; i++) {
			fsList.get(i).d--;
			if(fsList.get(i).d ==0) continue;
		}
		for (int i = 0; i < size; i++) {
			if(fsList.get(0).d ==0) {
				fsq.offer(fsList.get(0));
				fsList.remove(0);
			}
			else break;
		}
		size = ssList.size();
		for (int i = 0; i < size; i++) {
			ssList.get(i).d--;
			if(ssList.get(i).d ==0) continue;
		}
		for (int i = 0; i < size; i++) {
			if(ssList.get(0).d ==0) {
				ssq.offer(ssList.get(0));
				ssList.remove(0);
			}
			else break;
		}
		// 종료 조건 모든 list, queue가 비었다면 종료
		if(fsList.size() == 0 && ssList.size() == 0 && fStair.size() == 0 && sStair.size() == 0 && fsq.isEmpty() && ssq.isEmpty())
			return true;
		else
			return false;
	}
	
	
	public static class Stair implements Comparable<Stair>{
		int d, cnt;

		public Stair(int d, int cnt) {
			super();
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Stair [d=" + d + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Stair o) {
			Integer d1 =this.d;
			Integer d2 = o.d;
			return d1.compareTo(d2);
		}
		
	}

	public static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
