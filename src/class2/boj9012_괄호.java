package class2;

import java.util.Scanner;
import java.util.Stack;

public class boj9012_괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int tc = 0; tc < TC; tc++) {
            String s = sc.next();
            boolean can = true;
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push('(');
                } else if (s.charAt(i) == ')') {
                    if (st.size() == 0) {
                        can = false;
                    } else {
                        st.pop();
                    }
                }
            }

            if (can && st.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
