package algo_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class index_tree {
	
	 public static long[] tree;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        // 2진트리로 표현해야하기 때문에 배열사이즈는 항상 2^n으로 나오게 합니다.
        // 구간합이기 때문에 실제 배열보다 큰 부분은 0으로 채울 경우 계산에 영향을 미치지 않습니다.
        int S = 1;
        while (S < N)
            S <<= 1;
        System.out.println(S);
        // 사이즈보다 두 배 크게 만들면 기존 배열과 그 부모노드들이 모두 들어갈 수 있는 크기가 됩니다.
        tree = new long[2 * S];
        for (int i = S; i <= S + N - 1; i++)
            tree[i] = Long.parseLong(br.readLine().trim());
        for (int i = S; i <= S + N - 1; i++) {
            int P = i / 2;
            while (P != 0) {
                tree[P] = tree[P] + tree[i];
                P /= 2;
            }
        }
        System.out.println(Arrays.toString(tree));
	}

}
