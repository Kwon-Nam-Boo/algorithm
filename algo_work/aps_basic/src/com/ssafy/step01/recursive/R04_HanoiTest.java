package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R04_HanoiTest {

	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N,1,2,3);
		System.out.println(result.toString());
	}
	// ���ǰ���(�ǾƷ����ǹ�ȣ), ���۱��, �ӽñ��, �������
	private static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt ==0) return;
		// ���۱���� cnt-1 ��� ������ �ӽñ������ �ű�
		hanoi(cnt-1,from,to,temp);
		// ���۱���� cnt ���Ǹ��� ������� �ű�
		result.append(cnt+" : " + from + "->" + to +"\n");
		//�ӽñ���� cnt-1 ��� ������ ����������� �ű�
		hanoi(cnt-1,temp,from,to);
		
	}

}
