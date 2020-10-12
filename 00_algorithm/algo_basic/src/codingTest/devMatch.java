package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class devMatch {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n =10;
		int[][] groups = {{1, 5},{2, 7},{4, 8},{3, 6}};
		System.out.println(solution(n, groups));
	}
	
	public static int solution(int n, int[][] groups) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, true);
        
        for (int i = 0; i < groups.length; i++) {
			for (int j = groups[i][0]; j <= groups[i][1]; j++){
				visited[j] = false;
			}
		}
        for (int i = 0; i < visited.length; i++) {
			if(visited[i]) answer++;
		}
        answer--;
        Arrays.sort(groups, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] -o2[0];
			}
		} );
        for (int[] i : groups) {
			System.out.println(Arrays.toString(i));
		}
        
        
        int start = Integer.MAX_VALUE;
        int end;
        int count = 0;
        
//        //끝나는 시간을 계속 수정해주며 회의를 진행한다.
//        for(int i=0; i< groups.length; i++) {
//            if(groups[i][0] <= start) {
//                start = groups[i][0];
//                if(end>= groups[i][1])
//                count++;
//            }
//        }
//        System.out.println(count);
        
        return answer;
    }
	
	
}
