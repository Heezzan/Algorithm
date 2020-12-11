package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj10866_덱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String order = st.nextToken();
            if (order.equals("push_front")) {
                dq.addFirst(Integer.parseInt(st.nextToken()));
            } else if (order.equals("push_back")) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop_front")) {
                System.out.println(dq.size()==0 ? "-1" : dq.pollFirst());
            } else if (order.equals("pop_back")) {
                System.out.println(dq.size()==0 ? "-1" : dq.pollLast());
            } else if (order.equals("size")) {
                System.out.println(dq.size());
            } else if (order.equals("empty")) {
                System.out.println(dq.size()==0 ? "1" : "0");
            } else if (order.equals("front")) {
                System.out.println(dq.size()==0 ? "-1" : dq.peekFirst());
            } else if (order.equals("back")) {
                System.out.println(dq.size()==0 ? "-1" : dq.peekLast());
            }
        }
    }
}
