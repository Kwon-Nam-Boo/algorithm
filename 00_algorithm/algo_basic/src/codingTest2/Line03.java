package codingTest2;
import java.util.Arrays;



public class Line03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] enter = {1,4,2};
		int[] leave = {2,1,4};
		System.out.println(Arrays.toString(solution(enter, leave)));
	}
	
	public static int[] solution(int[] enter, int[] leave) {
		
		int n = enter.length;
        int[] answer = new int[5];
        
        boolean[][] map = new boolean[1001][1001];
        
        for (int i = 0; i < n; i++) {
        	
        	int s1 = enter[i];
        	// leave의 기준점
        	int s2 = Arrays.binarySearch(leave, s1);
        	
			for (int j = 0; j < i; j++) {
				int next = enter[j];
				if(map[s1][next]) continue;
				if(Arrays.binarySearch(leave, enter[j]) > s2) {
					map[next][s1] = true;
					map[s1][next] = true;
					answer[next]++;
					answer[s1]++;
				}
			}
			
			for (int j = i+1; j < enter.length; j++) {
				int next = enter[j];
				if(map[s1][next]) continue;
				if(Arrays.binarySearch(leave, enter[j]) < s2) {
					for (int k = i; k < j; k++) {
						int next2 = enter[k];
			
						if(s1 == next2 || map[next2][s1]) continue;
						System.out.println(next2 + " " + s1);
						map[next2][s1] = true;
						map[s1][next2] = true;
						answer[next2]++;
						answer[s1]++;
						
					}
					
				}
			}
		}

        return answer;
    }
}
