package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_16890_창업 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기
		String tmp = br.readLine();
		Character apple[] = new Character[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			apple[i] = tmp.charAt(i);
		}
		tmp = br.readLine();
		Character cube[] = new Character[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			cube[i] = tmp.charAt(i);
		}
	
		// 정렬
		Arrays.sort(apple);
		// 역순 정렬(Wrapper에서만 사용가능)
		Arrays.sort(cube, Collections.reverseOrder());
//		System.out.println(Arrays.toString(apple));
//		System.out.println(Arrays.toString(cube));
		
		
		
		// 카운트
		int an=0,cn = 0;
		
		int li = 0, ri = cube.length-1;
		
		int al, cl;
		// 길이가 짝수라면
		if(cube.length %2 == 1){
			al = (cube.length /2) +1;
		}else {
			al = cube.length /2;
		}
		cl = cube.length /2;
		
		char[] ans = new char[cube.length];
		for (int i = 0; i < cube.length; i++) {
			//apple 실행시
			if(i%2 == 0) {
				if((al -an) > (cl - cn)) {
					ans[li++]= apple[an++];
				}else {
					boolean check = false;
					for (int j = cn; j < cl; j++) {
						if(apple[an] < cube[j]) {
							 ans[li++] = apple[an++];
							 check = true;
							 break;
						}
					}
					if(!check) ans[ri--] = apple[an++];
				}
				//al--;
			}else {
				if((al -an) < (cl - cn)) {
					ans[li++]= cube[cn++];
				}else {
					//System.out.println(cn);
					boolean check = false;
					
					for (int j = an; j < al; j++) {
						if(apple[j] < cube[cn]) {
							 ans[li++] = cube[cn++];
							 check = true;
							 break;
						}
					}
					if(!check) ans[ri--] = cube[cn++];
				}
				//cl--;
			}
		}
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb);
		
	}
}
