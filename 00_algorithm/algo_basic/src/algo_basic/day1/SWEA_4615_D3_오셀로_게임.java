package algo_basic.day1;

import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA_4615_D3_오셀로_게임{
     
    public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{-1,1},{1,-1}};
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
         
        int TC = sc.nextInt();
         
        for (int i = 1; i <= TC; i++) {
            sb.append("#").append(i).append(" ");
            int N = sc.nextInt();
             
            char[][] game = new char[N][N];
            for(char[] a: game)
                Arrays.fill(a, 'N');
            game[(N/2)-1][(N/2)-1] = 'W';                   // 초기화
            game[(N/2)-1][(N/2)] = 'B';
            game[(N/2)][(N/2)-1] = 'B';
            game[(N/2)][(N/2)] = 'W';
             
            int M = sc.nextInt();
            int[][] play = new int[M][3];
            for (int j = 0; j < M; j++) {
                for (int j2 = 0; j2 < 2; j2++) {
                    play[j][j2] =sc.nextInt()-1;
                }
                play[j][2] = sc.nextInt();
            }
             
            for (int j = 0; j < M; j++) {
                int x =play[j][0];
                int y =play[j][1];
                char color;
                if(play[j][2] ==1) color ='B';
                else color= 'W';
                 
                 
                for (int k = 0; k < dir.length; k++) {
                    int nx = x+dir[k][0];           
                    int ny = y+dir[k][1];
                    int dirx = dir[k][0];
                    int diry = dir[k][1];
                     
                    if(isInColor(game,nx,ny,color)) {   // 8방향중 배열 안에 있으며 다른색인 칸이라면
                        checkAndFill(game,nx,ny,dirx,diry,color); //체크필 함수를 시도한다.
                    }
                }
            }
            int countB =0;
            int countW =0;
            for (int r = 0; r < game.length; r++) {          // 색깔별로 돌의 수 세기
                for (int c = 0; c < game.length; c++) {
                    if(game[r][c]=='B') countB++;
                    if(game[r][c]=='W') countW++;
                }
            }
            sb.append(countB).append(" ").append(countW).append("\n");
        }
        System.out.println(sb);
    }
     
    // 해당 dir방향 위치로 같은색으로 다른색을 둘러싸는 게 있는지 check 하고  있으면 그사이 값을 fill 한다
    public static void checkAndFill(char[][] game,int nx,int ny,int dirx,int diry,char color) {
        boolean check = false;
        int count =1;
        int NextX= nx + dirx;
        int NextY = ny + diry;
        int rev;
        if(color == 'B') rev ='W';
        else rev ='B';
        for (int i = 0; i < game.length; i++) {
            if(isIn(game, NextX,NextY)) {           // 배열안을 안벗어나면서
                if(game[NextX][NextY] == color) {   // 같은색으로 다른색을 둘러싸고 있다면 
                    check=true;                     // 체크 완료
                    break;
                }
                if(game[NextX][NextY] == rev) {
                    count++;
                }
                if(game[NextX][NextY] == 'N'){
                    break;
                }
            }else {                                 // 배열안에 없으면 break
                break;
            }
            NextX+=dirx;                            // 다음칸으로 이동
            NextY+=diry;
        }
         
        int tmpx =nx;
        int tmpy =ny;
        if(check==true) {                           // 만약 같은색 사이에 다른색이 둘러싸고 있다면
            game[nx-dirx][ny-diry] =color;          // 현재 위치부터 색을 넣어주고
            for (int i = 0; i < count; i++) {        // 그사이 값의 색을 현재색으로 바꿔준다
                game[tmpx][tmpy] = color;
                tmpx+=dirx;         
                tmpy+=diry;
            }
        }
    }
     
    public static boolean isIn(char[][] game, int row, int col) {   
        return row>=0 && col>=0 && row < game.length && col < game.length;
    }
     
    public static boolean isInColor(char[][] game, int row, int col, int color) {   // 배열안의 색이 반대인 칸이 만나면
        int rev;
        if(color == 'B') rev ='W';
        else rev ='B';
        return row>=0 && col>=0 && row < game.length && col < game.length && game[row][col] == rev;
    }
 
}