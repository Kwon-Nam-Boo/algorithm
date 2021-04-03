package codingTest2;

import java.util.Arrays;

public class dev_01 {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));

	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        // 0 의 개수
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < lottos.length; i++) {
        	int idx = lottos[i];
			if(idx == 0) {
				cnt++;
				continue;
			}
			if(Arrays.binarySearch(win_nums, idx)>=0) ans++;
		}
        answer[0] = 7-ans-cnt;
        answer[1] = 7-ans;
        if(answer[0] >= 6) answer[0] = 6;
        if(answer[1] >= 6) answer[1] = 6;
        return answer;
    }
}
