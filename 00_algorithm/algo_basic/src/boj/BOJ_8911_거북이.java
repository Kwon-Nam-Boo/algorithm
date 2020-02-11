package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
	private static int dirF;
	private static int dirB;
	private static int x;
	private static int y;
	private static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}}; // 상(1) 좌 (2) 하(3) 우(4)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			
			dirF = 0;
			dirB = 2;
			x=0;
			y=0;
			String[] order = br.readLine().split("");
			
			int minX = 0;
			int maxX = 0;
			int minY = 0;
			int maxY = 0;
			
			for (int j = 0; j < order.length; j++) {
				play(order[j]);
				minX = Math.min(minX,x);
				minY = Math.min(minY,y);
				maxX = Math.max(maxX,x);
				maxY = Math.max(maxY,y);
			}
			sb.append((maxX-minX)*(maxY-minY)).append("\n");
			
		}
		System.out.println(sb);
	
	}
	public static void play(String move) {
		switch(move){
		case "F":
			x = x + dir[dirF][0];
			y = y + dir[dirF][1];
			break;
		case "B":
			x = x + dir[dirB][0];
			y = y + dir[dirB][1];
			break;
		case "L":
			dirF++;
			dirB++;
			if(dirF>3) dirF =0;
			if(dirB>3) dirB =0;
			break;
		case "R":
			dirF--;
			dirB--;
			if(dirF<0) dirF =3;
			if(dirB<0) dirB =3;
			break;
		}
	}
}
