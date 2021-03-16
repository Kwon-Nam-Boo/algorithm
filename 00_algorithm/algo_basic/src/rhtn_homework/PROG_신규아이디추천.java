package rhtn_homework;

public class PROG_신규아이디추천 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
       StringBuilder answer = new StringBuilder();
       // 1. 소문자
       new_id = new_id.toLowerCase();
       
       char[] ans = new_id.toCharArray();
       boolean lastDot = false;
       for (int i = 0; i < ans.length; i++) {
    	   // 2. 특수 문자 제거
    	   char c = ans[i];
    	   if(!(Character.isLetterOrDigit(c) ||(c == '-' || c=='_' || c =='.'))) continue;
    	   if(c =='.') {
    		   // 4번 조건, 3번 조건
    		   if(answer.length() == 0 || lastDot) continue;
    		   lastDot = true;
    	   }else {
			   lastDot = false;
		   }
    	   answer.append(c);
    	   
       }
       // 5번
       if(answer.length() == 0) answer.append("a");
       // 6번
       if(answer.length()>=16) {
    	   answer.setLength(15);
       }
       // 4번, 6번
       if(answer.charAt(answer.length()-1) == '.') answer.deleteCharAt(answer.length()-1);
       
       // 7번
       if(answer.length()<=2) {
    	   char c = answer.charAt(answer.length()-1);
    	   while(answer.length()<3) {
    		   answer.append(c);
    	   }
       }
       
        return answer.toString();
    }

}
