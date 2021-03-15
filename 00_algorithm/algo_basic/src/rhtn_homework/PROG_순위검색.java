package rhtn_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PROG_순위검색 {
	// 단어에 대한 해쉬맵
	private static Map<String, Integer> Wordmap = new HashMap<String, Integer>();
	// 4차원 배열에 내부를 리스트로 하거나, 하나 기다란 리스트에 내부를 리스트로 하거나 .. 해당 건은 후자
	private static List<List<Integer>> ScoreList = new ArrayList<>();

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(info, query)));
	}
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
	
		Wordmap.put("-", 0);
		Wordmap.put("cpp", 1);
		Wordmap.put("java", 2);
		Wordmap.put("python", 3);
		Wordmap.put("backend", 1);
		Wordmap.put("frontend", 2);
		Wordmap.put("junior", 1);
		Wordmap.put("senior", 2);
		Wordmap.put("chicken", 1);
		Wordmap.put("pizza", 2);

		// 4*3*3*3개의 리스트 공간 생성
		for (int i = 0; i < 4*3*3*3; i++) {
			ScoreList.add(new ArrayList<>());
		}
		
		// 해당 info가 들어갈수 있는 모든 곳에 score를 넣어줌( -가 존재하므로 부분집합 만큼 넣어줌)
		for (String str : info) {
			String[] word = str.split(" ");
		
			int[] arr = {Wordmap.get(word[0])*3*3*3,
						Wordmap.get(word[1])*3*3,
						Wordmap.get(word[2])*3,
						Wordmap.get(word[3])
				};
			int score = Integer.parseInt(word[4]);
			
			
			for (int i = 0; i < (1<<4); i++) {
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					if((i & (1<<j))>0) {
						idx+=arr[j];
					}
				}
				ScoreList.get(idx).add(score);
			}	
		}
		
		// 이진탐색을 위한 정렬
		for (int i = 0; i < 4*3*3*3; i++) {
			Collections.sort(ScoreList.get(i));
		}
		
		// 해당 위치의 리스트를 이진탐색 검색하여 명수를 구한다
		for (int i = 0; i< query.length;i++) {
			String[] word = query[i].split(" ");
			int idx = (Wordmap.get(word[0])*3*3*3)+(Wordmap.get(word[2])*3*3)+(Wordmap.get(word[4])*3)+Wordmap.get(word[6]);
			int score = Integer.parseInt(word[7]);
			int re = Collections.binarySearch(ScoreList.get(idx), score);
			// 주의: 이진탐색 메소드 잘기억하기
			// 음수 인경우--> 원하는값이 어디에 있어야하는 위치가 음수값으로 표현되므로 +1한 값을 양수로 바꾸면 기준점이됨 
			if(re < 0) {
				re = -(re+1);
			}else {
				// 만약 중복된 값이 있으면 가장 왼쪽의 위치를 찾아야함
				for (int j = re-1; j >=0; j--) {
					if(ScoreList.get(idx).get(j) == score) {
						re = j;
					}else{
						break;
					}
				}
			}
			// 해당 위치부터 마지막 까지의 개수가 기준의 점수 이상받은 사람의 수
			answer[i] = ScoreList.get(idx).size() - re;
		}

        return answer;
    }

}
