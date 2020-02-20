package algo_basic.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class test1 {

	static StringBuilder sb = new StringBuilder();
	static int answer;
	static int N;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine(), 10);
		map = new int[N];
		dfsRow(0, 0);
		System.out.println(answer);
	}

	/**
	 *
	 * @param row
	 * @param r 놓은 퀴의 개수
	 */
	public static void dfsRow(int row, int r) {
		if (r == N) { // 답 --> answer++
			answer++;
			return;
		} 
		if (row == N) { // 줄 경계가 넘으면 종료
			System.out.println("a");
			return;
		}
		for (int c = 0; c < N; c++) {
			if (isPromising(row, c)) {
				map[row] = c;
				dfsRow(row + 1, r + 1);// 어차피 한 줄에는 하나의 n-queen만 가능
			}
		}
	}

	public static boolean isPromising(int row, int col) {

		for (int r = row - 1; r >= 0; r--) {
			if (map[r] == col) { // 위쪽에 혹시 없나
				return false;
			}
			if ((row - r) == Math.abs(col - map[r])) { // 대각선상에
				return false;
			}
		}
		return true;
	}

	static String src = "8";
}
