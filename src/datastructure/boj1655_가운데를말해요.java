package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1655_가운데를말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 내림차순
        PriorityQueue<Integer> minpq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            if (minpq.size() == maxpq.size()) minpq.add(Integer.parseInt(br.readLine()));
            else maxpq.add(Integer.parseInt(br.readLine()));

            while (!minpq.isEmpty() && !maxpq.isEmpty() && minpq.peek() > maxpq.peek()) {
                maxpq.add(minpq.poll());
                minpq.add(maxpq.poll());
            }

            sb.append(minpq.peek() + "\n");
        }
        System.out.println(sb.toString());
    }
}
