package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1808_D4_지희의_고장난_계산기 {
	
	private static List<Integer> numList;
	private static List<Integer> reList;
	private static int[] lenArr;
	private static int R;
	private static int rNum;
	private static int[] result;
	private static int len;
	private static int min;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			numList = new  ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				if(Integer.parseInt(st.nextToken())==1) {
					numList.add(i);
				}
			}
			
			min =-1;
			rNum = Integer.parseInt(br.readLine());
			len = (int) Math.log10(rNum)+1;
			if(rNum == 1) {
				min =2;
			}
			
			reList = new ArrayList<>();
			for (int i = 1; i <= len; i++) {			// 정답의 자리수보다 작은 경우의 순열만 확인
				R = i;
				result = new int[R];
				nPr(0);
			}
			if(reList.contains(1)) {
				reList.remove((Integer) 1);
			}
			if(reList.contains(0)) {
				reList.remove((Integer) 0);
			}
			
			if(reList.isEmpty()) {
				sb.append(min).append("\n");
			}else {
				lenArr = new int[reList.size()]; 
				for (int i = 0; i < reList.size(); i++) {
					lenArr[i]= (int) Math.log10(reList.get(i))+1;
				}
				min = Integer.MAX_VALUE;
				for (int i = 0; i < reList.size(); i++) {
					dfs(i,rNum/reList.get(i),lenArr[i]);
				}
				
				sb.append(min==Integer.MAX_VALUE ? -1:min).append("\n");
			}
		}
		System.out.println(sb);
			
	}
	public static void dfs(int k, int sum, int count) {
		if(sum == 1) {
			min = Math.min(min, count+1);
		}
		for (int i = k; i < reList.size(); i++) {
			if(sum%reList.get(i) == 0) {
				sum/=reList.get(i);
				dfs(k,sum,count+lenArr[i]+1);
				sum*=reList.get(i);
			}
		}
	}
	
	
	public static void nPr(int r) {
		if(r == R) {
			int tmp = makeToNum();
			if(reList.indexOf((Integer) tmp)<0 && (tmp == 0 || rNum % tmp ==0)) {
				reList.add(tmp);
			}
			return;
		}
		for (int i = 0; i < numList.size(); i++) {
			result[r] = numList.get(i);
			nPr(r+1);
		}
	}
	public static int makeToNum() {
		String tmp = "";
		for (int i = 0; i< result.length ; i++) {
			tmp += Integer.toString(result[i]);
		}
		return Integer.parseInt(tmp);
	}
	
}
