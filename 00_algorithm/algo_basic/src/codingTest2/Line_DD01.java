package codingTest2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Line_DD01 {
	
	 public Map<String, String> rules = new HashMap<>();
	 public static String program = "line";
	 public static String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
	 public static String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};
	
	public static void main(String[] args) {
		Line_D01 l1 = new Line_D01();
        System.out.println(Arrays.toString(l1.solution(program, flag_rules, commands)));
	}
	
	 public boolean[] solution(String program, String[] flag_rules, String[] commands) {
	        int len = commands.length;
	        boolean[] answer = new boolean[len];
	        
	        // 플래그 룰 제작
	        makeFlagRules(flag_rules);

	        for (int i = 0; i < len; i++) {
	            StringTokenizer st = new StringTokenizer(commands[i], " ");
	            
	            String programName = st.nextToken();
	            
	            if (!checkProgramName(program, programName) || !checkCommand(st)) {
	                answer[i] = false;
	            } else {
	                answer[i] = true;
	            }
	        }
	        return answer;
	    }

	private void makeFlagRules(String[] flag_rules2) {
		
		int length = flag_rules.length;

        for (int i = 0; i < length; i++) {
            String[] words = flag_rules[i].split(" ");
            rules.put(words[0], words[1]);
        }
		
	}

	private boolean checkCommand(StringTokenizer commandToken) {
		
		 while(commandToken.hasMoreTokens()) {
	            Argument command = new Argument(rules.getOrDefault(commandToken.nextToken(), null));

	            if (command == null) return false;

	            if (command.type != "NULL") {
	                if(!command.isValidArgument(commandToken.nextToken())) return false;
	            }
	     }
		 
		return false;
	}

	private boolean checkProgramName(String program, String programName) {
		 if (program.equals(programName))
			 return true;
		 return false;
	}
	
	public static class Argument{
      
        private final String type;
        private static final String STRING_PATTERN = "^[a-zA-Z]+$";
        private static final String NUMBER_PATTERN = "^[0-9]+$";

        Argument(String type) {
            this.type = type;
        }

        public boolean isValidArgument(String argument) {

            if ("NULL".equals(type) && "".equals(argument)) {
                return true;
            } else if ("STRING".equals(type) && isMatchedPattern(STRING_PATTERN, argument)) {
                return true;
            } else if ("NUMBER".equals(type) && isMatchedPattern(NUMBER_PATTERN, argument)) {
                return true;
            }

            return false;
        }

        private boolean isMatchedPattern(String pattern, String target) {

            return Pattern.matches(pattern, target);
        }

    }

}
