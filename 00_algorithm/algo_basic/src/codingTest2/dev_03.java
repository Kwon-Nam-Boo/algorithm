package codingTest2;

import java.util.*;

public class dev_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
		
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length+1];
        
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
			hash.put(enroll[i], i+1);
		}
        
        // 해당 사람의 부모값
        int[] parent = new int[enroll.length+1];
        
        for (int i = 0; i < referral.length; i++) {
			if(referral[i].equals("-")) continue;
			parent[i+1] = hash.get(referral[i]);
		}
        //System.out.println(Arrays.toString(parent));
        
        // seller.length
        for (int i = 0; i < seller.length; i++) {
        	int idx = hash.get(seller[i]);
        	int money = amount[i]*100;
        	
        	while(true) {
        		answer[idx]+= money-(money/10);
        		if(idx ==0) break;
        		idx = parent[idx];
        		money/=10;
        	}
        	//System.out.println(Arrays.toString(answer));
		}
        int[] ans = new int[enroll.length];
        for (int i = 0; i < ans.length; i++) {
			ans[i] = answer[i+1];
		}
        return ans;
    }
}
