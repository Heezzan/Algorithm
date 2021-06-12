package programmers.greedy;

import java.util.Stack;

public class prog42883_큰수만들기 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {

        Stack<Integer> st = new Stack<>();
        st.push(number.charAt(0)-'0');

        for (int i = 1; i < number.length(); i++) {
            while(!st.isEmpty() && k > 0 && st.peek() < number.charAt(i)-'0') {
                st.pop();
                k--;
            }
            st.push(number.charAt(i)-'0');
        }

        if (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}
