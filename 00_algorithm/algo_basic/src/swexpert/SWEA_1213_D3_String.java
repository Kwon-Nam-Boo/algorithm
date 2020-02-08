package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.midi.Synthesizer;

public class SWEA_1213_D3_String {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String line = br.readLine();
			
			int flag=1;
			int count =0;
			while(flag!=-1) {
				flag = line.indexOf(word);
				if(flag>0) {
					count++;
					line = line.substring(flag+word.length());
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
