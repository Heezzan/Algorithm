package class2;

import java.util.Scanner;
import java.util.Stack;

public class boj4949_균형잡힌세상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.nextLine();
            boolean balance = true;

            if (s.charAt(0) == '.')
                break;

            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (balance) {
                 if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                     st.push(s.charAt(i));
                 } else if (s.charAt(i) == ')') {
                     if (st.size() > 0 && st.peek() == '(')
                         st.pop();
                     else
                         balance = false;
                 } else if (s.charAt(i) == ']') {
                     if (st.size() > 0 && st.peek() == '[')
                         st.pop();
                     else
                         balance = false;
                 }
                }
            }

            System.out.println((balance && st.size() == 0) ? "yes" : "no");

        }
    }
}