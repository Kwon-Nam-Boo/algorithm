package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어_벨트_위의_로봇 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,K,rdx;
	private static Belt[] belt;
	private static List<Bot> botList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new Belt[2*N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = new Belt(0, Integer.parseInt(st.nextToken()));
		}
		botList = new ArrayList<>();
		rdx=1;
		int cnt = 1;
		while(true) {
			// 1. 회전
			rotate();
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다
			checkRobot();
			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
			putBot();
			// 4.
			if(checkDurab())
				break;
			cnt++;
		}
		System.out.println(cnt);
	}
	// 내구도 0이 K개 이상인지 확인
	private static boolean checkDurab() {
		int cnt = 0;
		for (int i = 0; i < belt.length; i++) {
			if(belt[i].cnt==0) cnt++;
			if(cnt == K) return true;
		}
		return false;
	}

	private static void putBot() {
		// 로봇을 리스트에 추가하고 컨테이너도 최신화
		if(belt[0].rdx ==0 && belt[0].cnt > 0) {
			botList.add(new Bot(rdx, 0));
			belt[0].rdx = rdx;
			rdx++;
			belt[0].cnt--;
		}
		
	}

	private static void checkRobot() {
		// 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
		for (int i = 0; i < botList.size(); i++) {
			Bot b = botList.get(i);
			if(belt[b.bdx+1].rdx == 0 && belt[b.bdx+1].cnt > 0) {
				// 다음 칸으로 옮기기
				belt[b.bdx+1].rdx = belt[b.bdx].rdx;
				belt[b.bdx+1].cnt--;
				// 원래칸은 비워두자
				belt[b.bdx].rdx =0;
				// 로봇 리스트 속의 컨테이너 idx도 최신화
				botList.get(i).bdx++;
			}
		}
		// 내려가는 위치라면 로봇 탈출,로봇리스트도 최신화
		if(belt[N-1].rdx != 0) {
			int tmp = belt[N-1].rdx;
			for (int i = 0; i < botList.size(); i++) {
				if(botList.get(i).rdx == tmp) {
					belt[N-1].rdx = 0;
					botList.remove(i);
					break;
				}	
			}
		}
		
	}

	private static void rotate() {
		// 회전시킨다
		Belt tmp = belt[2*N-1];
		for (int i = belt.length-2; i >=0 ; i--) {
			belt[i+1] = belt[i];
		}
		belt[0] = tmp;
		// 로봇 리스트 속의 컨테이너 idx도 최신화
		for (int i = 0; i < botList.size(); i++) {
			botList.get(i).bdx++;
		}
		// 내려가는 위치라면 로봇 탈출 ,로봇리스트도 최신화
		if(belt[N-1].rdx != 0) {
			int tmp2 = belt[N-1].rdx;
			for (int i = 0; i < botList.size(); i++) {
				if(botList.get(i).rdx == tmp2) {
					belt[N-1].rdx = 0;
					botList.remove(i);
					break;
				}	
			}
		}
		
	}

	public static class Belt{
		int rdx ,cnt;

		public Belt(int rdx, int cnt) {
			super();
			this.rdx = rdx;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Belt [rdx=" + rdx + ", cnt=" + cnt + "]";
		}
		
	}
	public static class Bot{
		int rdx, bdx ;

		public Bot(int rdx, int bdx) {
			super();
			this.rdx = rdx;
			this.bdx = bdx;
		}

		@Override
		public String toString() {
			return "Bot [rdx=" + rdx + ", bdx=" + bdx + "]";
		}

	}
}
