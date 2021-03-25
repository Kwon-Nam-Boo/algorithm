package rhtn_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PROG_기둥과보설치 {
	
	private static Pair[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PROG_기둥과보설치 prog = new PROG_기둥과보설치();
		int n = 5;
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0}};
		int[][] sol = prog.solution(n, build_frame);
		for (int i = 0; i < sol.length; i++) {
			System.out.println(Arrays.toString(sol[i]));
		}
	}
	
	public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        
        map = new Pair[n+1][n+1];
        
        for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = new Pair(0, 0);
			}
		}
        
        
        for (int i = 0; i < build_frame.length; i++) {
        	
        	
        	int x = build_frame[i][0];
        	int y = build_frame[i][1];
       
        	// 기둥 or 보
        	int a = build_frame[i][2];
        	// 삭제 or 설치
        	int b = build_frame[i][3];
        	
        	// 기둥에 대한 작업
			if(a == 0){
				// 기둥을 삭제하는 거라면
				if(b==0) {
					map[x][y].pillar--;
					// 기둥을 삭제하면 ..
					if((existPillar(n,x,y+1) && !checkPillar(n,x,y+1))
							|| ( existBeam(n,x,y) && !checkBeam(n,x,y))
							|| ( existBeam(n,x-1,y) && !checkBeam(n,x-1,y))){
						map[x][y].pillar++;
					};
				}else { // 기둥을 설치하는거라면
					// 기둥을 세울수 있다면
					if(checkPillar(n, x, y)) {
						map[x][y].pillar++;
					}
				}
				
			}
			// 보에 대한 작업
			else {
				if(b==0) { // 보를 삭제하는 거라면
					map[x][y].beam--;
					
					// 오른쪽 위치에서 있던 기둥이나 보에 의해 삭제불가능 이라면
					// 즉, 하나라도 true이면 안된다
					if((existPillar(n,x,y) && !checkPillar(n,x,y)) 
							|| (existPillar(n,x+1,y) && !checkPillar(n,x+1,y)) 
							|| ( existBeam(n,x+1,y) && !checkBeam(n,x+1,y)) 
							|| ( existBeam(n,x-1,y) && !checkBeam(n,x-1,y))) {
						map[x][y].beam++;
					}
				}else { // 보를 설치하는거라면
					if(checkBeam(n,x,y)){
						map[x][y].beam++;
					}
				}
			}
		}
        for (int i = 0; i < build_frame.length; i++) {
        	int x = build_frame[i][0];
        	int y = build_frame[i][1];
     
        }
       
        
        List<int[]> list = new ArrayList<>();
        
        for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				int[] cnt = new int[3];
	        	
	        	cnt[0] = r;
	        	cnt[1] = c;
	        	
	        	if(map[r][c].pillar == 1) {
	        		list.add(cnt);
	        	}
	        	if(map[r][c].beam == 1){
	        		cnt[2] = 1;
	        		list.add(cnt);
	        	}
			}
		}
        
        Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					if(o1[1] == o2[1]) {
						return Integer.compare(o1[2], o2[2]);
					}
					return Integer.compare(o1[1], o2[1]); 
				}
				return Integer.compare(o1[0], o2[0]);
			}
	
		});
        
        answer = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
	// 존재하면 true, 없으면 false;
	private static boolean existBeam(int n, int x, int y) {
		if(!isIn(n,x,y)) return false;
		if(map[x][y].beam > 0) return true;
		return false;
		
	}
	
	// 현재위치에 기둥이 존재하면 true, 없으면 false;
	private static boolean existPillar(int n, int x, int y) {
		// 범위내에 없는 숫자라면
		if(!isIn(n,x,y)) return false;
		if(map[x][y].pillar > 0) return true;
		return false;
	}

	// 참이면 보를 세울수 있다, 거짓이면 보를 세울수 없다
	private static boolean checkBeam(int n, int x, int y) {
		
		// 한쪽 끝 부분이 기둥 위에 있으면
		if(isIn(n,x+1,y) && map[x+1][y-1].pillar > 0) {
//			/System.out.println(x + ":" + y);
			return true;
		}
		if(isIn(n,x,y) && map[x][y-1].pillar > 0) return true;
		
		// 양쪽 끝 부분이 다른 보와 동시에 연결
		if(isIn(n,x-1,y) && isIn(n,x+1,y)&& map[x-1][y].beam > 0 && map[x+1][y].beam > 0) return true;
			
		
		
		return false;
	}
	
	// 참이면 기둥을 세울수 있다, 거짓이면 기둥을 세울수 없다
	private static boolean checkPillar(int n, int x, int y) {
		// 기둥을 세우는게 불가능 하다면 false
		
		if(y == 0) return true;
		if(map[x][y-1].pillar > 0) return true;
		if(isIn(n,x-1,y) && map[x-1][y].beam > 0) return true;
		return false;
		
	}

	public static class Pair{
		int pillar, beam;

		public Pair(int pillar, int beam) {
			super();
			this.pillar = pillar;
			this.beam = beam;
		}

		@Override
		public String toString() {
			return "Pair [pillar=" + pillar + ", beam=" + beam + "]";
		}
	}
	public static boolean isIn(int n, int x, int y){
		return x>=0 && y>=0 && x<=n && y<=n;
	}
}
