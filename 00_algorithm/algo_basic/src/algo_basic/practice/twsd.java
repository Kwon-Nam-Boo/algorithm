package algo_basic.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twsd {

    public static int n, m, k;
    public static int offset;
    public static long[] tree;

    // 구간합 질의 
    public static long query(int from, int to) {
        long result = 0;

        // 리프노드에서 데이터 시작 ~ 끝까지 
        from += offset;
        to += offset;

        // 루트까지 반복하면서 구간합을 찾음 
        while (from <= to) {
            // 시작 인덱스가 홀수인 경우 하나 따로 튀어나와있는거 별도로 계산 
            if (from % 2 == 1) {
                result += tree[from++];
            }
            // 끝인덱스는 짝수일 경우 하나 튀어나와있는거 별도로 계산
            if (to % 2 == 0) {
                result += tree[to--];
            }

            // 부모로 올라감 
            from /= 2;
            to /= 2;
        }

        return result;
    }

    // 단일 업데이트 
    public static void update(int index, long value) {
        // 리프노드에 데이터의 위치를 구함 
        index += offset;
        // 값을 업데이트 
        tree[index] = value;
        // 부모노드를 구함 
        index /= 2;

        // 루트까지 데이터 업데이트 
        while(index > 0) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
            index /= 2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 초기화 start
        // 리프노드의 시작 오프셋 구하기
        for (offset = 1; offset < n; offset *= 2) ;

        tree = new long[offset * 2 + 1];

        // 트리의 가장 아래 0번을 제외한 리프노드 시작번호 + 1부터 데이터를 저장 
        for (int i = 1; i <= n; i++) {
            tree[offset + i] = Integer.parseInt(br.readLine());
        }

        // 리프부터 루트까지 구간합을 업데이트 
        for (int i = offset - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
        // 초기화 end

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                update(b, c);
            } else {
                sb.append(query(b, (int) c)).append("\n");
            }
        }

        System.out.println(sb);

    }

}