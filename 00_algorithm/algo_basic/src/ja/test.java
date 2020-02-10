package ja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class test {
    public static class Point implements Comparable<Point> {
        int s;
        int e;
 
        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
 
        @Override
		public String toString() {
			return "Point [s=" + s + ", e=" + e + "]";
		}


		@Override
        public int compareTo(Point o) {
            return this.e - o.e;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] ref = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ref[i] = new Point(a, b);
        }
        int count = 1;
        // 끝을 기준으로 정렬
        Arrays.sort(ref);
        System.out.println(Arrays.toString(ref));
        Point p = ref[0]; //초기값 저장
        int i = 1;
        while(i < N) {
            if (ref[i].s > p.e) {
                p = ref[i];
                count++;
            }            
            i++;
        }
        System.out.println(count);
    }
}
