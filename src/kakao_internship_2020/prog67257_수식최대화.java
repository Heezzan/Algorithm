package kakao_internship_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class prog67257_수식최대화 {

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }

    public static long solution(String expression) {
        long answer = 0;

        String[] priority = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};

        List<String> splt = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                splt.add(Integer.toString(num));
                splt.add(Character.toString(expression.charAt(i)));
                num = 0;
            } else {
                num *= 10;
                num += expression.charAt(i)-'0';
            }
        }
        splt.add(Integer.toString(num));

        for (int i = 0; i < priority.length; i++) {

            Stack<String> tmp = new Stack<>();
            for (String s : splt) tmp.push(s);
            
            Stack<String> calc = new Stack<>();
            while(!tmp.isEmpty()) calc.push(tmp.pop());

            for (int p = 0; p < 3; p++) {

                while(!calc.isEmpty()) {
                    String pop = calc.pop();

                    if (pop.equals(Character.toString(priority[i].charAt(p)))) {
                        if (pop.equals("+")) {
                            Long result = Long.parseLong(tmp.pop())+Long.parseLong(calc.pop());
                            tmp.add(Long.toString(result));
                        } else if (pop.equals("-")) {
                            Long result = Long.parseLong(tmp.pop())-Long.parseLong(calc.pop());
                            tmp.add(Long.toString(result));
                        } else {
                            Long result = Long.parseLong(tmp.pop())*Long.parseLong(calc.pop());
                            tmp.add(Long.toString(result));
                        }
                    } else {
                        tmp.add(pop);
                    }
                }

                while(!tmp.isEmpty()) {
                    calc.add(tmp.pop());
                }
            }

            answer = Math.max(answer, Math.abs(Long.parseLong(calc.pop())));

        }

        return answer;
    }

}
