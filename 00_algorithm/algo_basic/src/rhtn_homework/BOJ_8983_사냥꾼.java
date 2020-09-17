package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {

	private static StringBuilder sb = new StringBuilder();
	private static int n,m,l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m =Integer.parseInt(st.nextToken());
		n =Integer.parseInt(st.nextToken());
		l =Integer.parseInt(st.nextToken());
		// 사대 리스트
		int[] mList = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < mList.length; i++) {
			mList[i] = Integer.parseInt(st.nextToken());
		}
		// 순서대로 정렬
		Arrays.sort(mList);
		// 동물 지점 리스트
		List<Pair> animal = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// L 범위를 넘어가는건 사전차단
			if(y > l || x > (mList[m-1] + l)) continue;
			animal.add(new Pair(x, y));
		}
		// y의 asc, x의 asc로 정렬 해준다
		Collections.sort(animal);
		
		int ans = 0;
		for (int i = 0; i < animal.size(); i++) {
			// 해당 동물에 대한 이진탐색
			int left =0;
			int right = m-1;
			
			while(left<=right) {
				int mid=(left+right)/2;
				// 사냥 조건 에 맞으면 카운트후 break
				if(Math.abs(animal.get(i).x - mList[mid]) + animal.get(i).y <= l) {
					ans++;
					break;
				}
				// 해당 좌표보다 x가 오른쪽에 위치하면 오른쪽 범위치로 범위 좁히기, 혹은 반대
				if(mList[mid] < animal.get(i).x) left = mid +1;
				else right = mid-1;
			}
		}
		System.out.println(ans);
		
	}
	
	public static class Pair implements Comparable<Pair>{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Pair o) {
			Integer x1 = this.x;
			Integer y1 = this.y;
			Integer x2 = o.x;
			Integer y2 = o.y;
			if(x1 == x2) {
				return y1.compareTo(y2);
			}
			return x1.compareTo(x2);
		}
		
	}
}
