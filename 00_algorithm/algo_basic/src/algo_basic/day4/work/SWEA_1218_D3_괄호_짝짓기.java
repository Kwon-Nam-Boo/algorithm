package algo_basic.day4.work;

import java.util.Scanner;
import java.util.Stack;
 
public class SWEA_1218_D3_괄호_짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
         
        for (int i = 1; i <=10; i++) {
            sb.append("#").append(i).append(" ");
            int N = sc.nextInt();       // 버림
            String bk = sc.next();
             
            Stack<Character> stack = new Stack<>();
             
            int result =1;
            for (int j = 0; j <bk.length(); j++) {
                if(bk.charAt(j) == '(' || bk.charAt(j) == '<' || bk.charAt(j) == '[' || bk.charAt(j) == '{' ) {
                    stack.push(bk.charAt(j));
                }else {
                    if(!stack.isEmpty()) {
                        if(bk.charAt(j) == ')' && stack.peek() == '(') {
                            stack.pop();
                        }
                        else if(bk.charAt(j) == '}' && stack.peek() == '{') {
                            stack.pop();
                        }
                         
                        else if(bk.charAt(j) == '>' && stack.peek() == '<') {
                            stack.pop();
                        }
                        else if(bk.charAt(j) == ']' && stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            result = 0;
                            break;
                        }
                    }else {
                            result = 0;
                            break;
                    }
                }
                 
            }
            if(stack.isEmpty() && result>0) {
                sb.append("1").append("\n");
            }else {
                sb.append("0").append("\n");
            }
                 
         
    }
        System.out.println(sb);
    }
}