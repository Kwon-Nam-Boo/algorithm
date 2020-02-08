package swexpert;

import java.util.Scanner;

public class SWEA_1234_D3_비밀번호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
	
        
		for (int i = 1; i <= 10; i++) {
           sb.append("#").append(i).append(" ");
           
           int n = sc.nextInt();
           String word =sc.next();
            
           boolean more =false;
           while(true) {
        	   String [] password = word.split("");
        	   String newWord;
        	   
        	   for (int j = 1; j < password.length; j++) {
           	   	if(password[j].equals(password[j-1])) {
           	   		newWord = word.substring(0,j-1) + word.substring(j+1);
           	   		word = newWord;
           	   		more = true;
           	   		break;
           	   	}
              }
        	  if(!more) {
        		  sb.append(word);
        		  break;
        	  }
        	  more=false;
           }
           sb.append("\n");
		}
		System.out.println(sb);
	}

}
