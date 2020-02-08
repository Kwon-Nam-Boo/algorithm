package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
public class SWEA_1224_D4_계산기3{
     
    private static Stack<Character> stack;  // step1에서 사용할 스택 char
    private static Stack<Integer> stack2; // step2에서 사용할 스택 int
     
    private static List<Character> postLine;
 
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
         
        for (int i = 1; i <= 10; i++) {
            sb.append("#").append(i).append(" ");
            int N = Integer.parseInt(br.readLine());
             
            stack = new Stack<>(); 
            stack2 = new Stack<>(); 
            postLine = new ArrayList<>();
             
            String line = br.readLine();
            makePost(line);
            sb.append(calculatePost()).append("\n");
        }
        System.out.println(sb);
         
    }
    public static void makePost(String line) {      //step 1 후위문으로 바꿔준다
        for (int i = 0; i < line.length(); i++) {
            char token = line.charAt(i);
            int tokenOrder = getInStackOrder(token);
            if(tokenOrder == 0) {
                postLine .add(token);
            }
            else if(token =='(') {
                stack.push(token);
            }else if(token==')') {
                while(true) {
                    char top = stack.pop();
                    if(top == '(') {
                        break;
                    }else {
                        postLine.add(top);
                    }
                }
            }else {
                while(!stack.isEmpty()) {
                    char top = stack.peek();
                    if(getInStackOrder(top) >= tokenOrder) {
                        postLine.add(stack.pop());
                    }else {
                        break;
                    }
                     
                }
                stack.push(token);
            }
        }
        while(!stack.isEmpty()) {
            postLine.add(stack.pop());
        }
         
    }
     
    public static int calculatePost(){      // step 2  후위를 가지고 계산하기
        for (int i = 0; i < postLine.size(); i++) {
            char token = postLine.get(i);
            int tokenOrder = getInStackOrder(token);
            if(tokenOrder ==0) {
                stack2.push(token -'0');
            }else {
                int b = stack2.pop();
                int a = stack2.pop();
                stack2.push(getCal(token,a,b));
            }
        }
        return stack2.pop();
    }
     
     
     
    public static int getInStackOrder(char c) {
        if(c=='*') {
            return 4;
        }
        else if(c=='+') {
            return 3;
        }
        else if(c=='('|| c==')') {
            return 1;
        }else {
            return 0;
        }
    }
     
    public static int getCal(char c, int a, int b) {
        if(c=='*') {
            return a*b;
        }else{
            return a+b;
        }
    }
 
}