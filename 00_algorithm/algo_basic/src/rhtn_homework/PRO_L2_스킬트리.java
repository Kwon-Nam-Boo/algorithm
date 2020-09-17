package rhtn_homework;

import java.io.IOException;


public class PRO_L2_스킬트리 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String skill = "CBD";
		String[] skill_trees = {"CDEBA", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	
	 public static int solution(String skill, String[] skill_trees) {
		 	
	        int answer = 0;
	        
	        for (int i = 0; i < skill_trees.length; i++) {
	        	int cnt =0;
				for (int j = 0; j < skill_trees[i].length(); j++) {
					// skill 트리 안에 있는 알파벳이면서
					if(skill.indexOf(skill_trees[i].charAt(j)) > -1) {
						// 알파벳이 같으면
						if(skill.charAt(cnt) == skill_trees[i].charAt(j)){
							cnt++;
						}else {
							// 스킬트리에 실패한경우는 카운트를 줄인다
							answer--;
							break;
						}
					}
				}
				answer++;
			}
	        
	        return answer;
	        
	 }
}
