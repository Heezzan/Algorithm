package kakao_blind_2020;

import java.util.Stack;

public class prog60058_괄호변환 {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        String answer = "";

        if (isRightBracket(p)) return p;
        answer = getRightBracket(p);

        return answer;
    }

    public static String getRightBracket(String w) {
        if (w.equals("")) return w;

        int n = seperate(w);
        String u = w.substring(0, n+1);
        String v = w.substring(n+1, w.length());
        if (isRightBracket(u)) return u+getRightBracket(v);

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(getRightBracket(v));
        sb.append(")");
        for (int i = 1; i < u.length()-1; i++) {
            if (u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    public static boolean isRightBracket(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push('(');
            else {
                if (st.size() == 0) return false;
                st.pop();
            }
        }
        return true;
    }

    public static int seperate(String s) {
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) return i;
        }

        return 0;
    }
}
