package codingTest2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Line_D01 {
	
	public Map<String, ArgumentType> rules = new HashMap<>();

    public enum ArgumentType {
        NULL("NULL"), STRING("STRING"), NUMBER("NUMBER");

        private final String type;
        private static final String STRING_PATTERN = "^[a-zA-Z]+$";
        private static final String NUMBER_PATTERN = "^[0-9]+$";

        ArgumentType(String type) {
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

        public static ArgumentType getType(String type) {

            if ("NULL".equals(type)) {
                return ArgumentType.NULL;
            } else if ("STRING".equals(type)) {
                return ArgumentType.STRING;
            } else if ("NUMBER".equals(type)) {
                return ArgumentType.NUMBER;
            } else {
                return null;
            }
        }
    }

    public void makeFlagRules(String[] flag_rules) {

        int length = flag_rules.length;

        for (int i = 0; i < length; i++) {
            String[] words = flag_rules[i].split(" ");
            rules.put(words[0], ArgumentType.getType(words[1]));
        }
    }

    public boolean isValidProgram(String program, String command) {

        if (program.equals(command)) {
            return true;
        }

        return false;
    }

    public boolean isValidCommand(StringTokenizer tokens) {

        while(tokens.hasMoreTokens()) {
            ArgumentType type = rules.getOrDefault(tokens.nextToken(), null);
          
            if (type == null) return false;

            if (type != ArgumentType.NULL) {
                boolean isValid = type.isValidArgument(tokens.nextToken());

                if(!isValid) return false;
            }
        }

        return true;
    }


    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        int length = commands.length;
        boolean[] answer = new boolean[length];

        makeFlagRules(flag_rules);

        for (int i = 0; i < length; i++) {
            StringTokenizer tokens = new StringTokenizer(commands[i], " ");
            
            String programName = tokens.nextToken();
            
            if (!isValidProgram(program, programName) || !isValidCommand(tokens)) {
                answer[i] = false;
            } else {
                answer[i] = true;
            }
        }
        return answer;
    }

    public static String program = "line";
    public static String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
    public static String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};

    public static void main(String[] args) {
    	Line_D01 l1 = new Line_D01();
        System.out.println(Arrays.toString(l1.solution(program, flag_rules, commands)));
    }

}
