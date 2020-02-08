package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_1232_D4_사칙연산 {
     
    public static String operator ="+-*/"; 
 
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            sb.append("#").append(i).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[][] tree = new int[N+1][2];
            String[] cal = new String[N+1];
             
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                String tmp = st.nextToken();
                cal[j] = tmp;
                if(operator.indexOf(tmp)!=-1) {
                    tree[j][0] = Integer.parseInt(st.nextToken());
                    tree[j][1] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(calcTree(1,tree,cal)).append("\n");
        }
        System.out.println(sb);
    }
     
    public static int calcTree(int r, int[][] tree,String[] cal) {
        if(operator.indexOf(cal[r])== 0) {       //+ 인경우
            return calcTree(tree[r][0],tree,cal) + calcTree(tree[r][1],tree,cal);
        }
        if(operator.indexOf(cal[r])== 1) {      // - 인경우
            return calcTree(tree[r][0],tree,cal) - calcTree(tree[r][1],tree,cal);
        }
        if(operator.indexOf(cal[r])== 2) {      // * 인경우
            return calcTree(tree[r][0],tree,cal) * calcTree(tree[r][1],tree,cal);
        }
        if(operator.indexOf(cal[r])== 3) {      // /인경우
            return calcTree(tree[r][0],tree,cal) / calcTree(tree[r][1],tree,cal);
        }
        return Integer.parseInt(cal[r]);        // 정수인 경우 현재값 리턴
         
    }
 
}