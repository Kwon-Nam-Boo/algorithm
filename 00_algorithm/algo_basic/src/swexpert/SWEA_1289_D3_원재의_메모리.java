package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1289_D3_원재의_메모리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC =s.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			int count= 0;								// 카운트
			sb.append("#").append(i).append(" ");
			String[] memory = s.next().split("");		// 각 숫자를 하나씩 메모리에 저장
			String check = memory[0];					// 메모리의 처음 수
			if(check.equals("1")) count = 1;			// 만약 처음수가 1이면 카운트를 1개 올려둔다
			
			for (int j = 1; j < memory.length; j++) {
				
				if(!memory[j].equals(check)) {			// 다음수와 비교해서 다르면 카운트 올린다 
					check = memory[j];
					count++;
				}
				
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
