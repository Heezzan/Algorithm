package class2;

import java.util.Scanner;
import java.util.Stack;

public class boj1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        int cnt = 1;
        boolean can = true;

        for (int i = 0; i < n; i++) {
            if (!can)
                continue;

            while (st.size() == 0 || st.peek() < nums[i]) {
                st.add(cnt++);
                result.append("+\n");
            }

            if (st.peek() == nums[i]) {
                st.pop();
                result.append("-\n");
            } else {
                can = false;
            }
        }

        if (can)
            System.out.println(result.toString());
        else
            System.out.println("NO");
    }
}
