package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2257_화학식량 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (now == '(') st.add(-1);
            else if (now == ')') {
                int sub = 0;
                while (!st.isEmpty()) {
                    int pop = st.pop();

                    if (pop == -1) break;
                    else sub += pop;
                }
                st.add(sub);
            } else if (Character.isDigit(now)) {
                st.add(st.pop()*(now-'0'));
            } else {
                if (now == 'H') st.add(1);
                else if (now == 'C') st.add(12);
                else if (now == 'O') st.add(16);
            }
        }

        int result = 0;
        while(!st.isEmpty()) result += st.pop();

        System.out.println(result);
    }
}
