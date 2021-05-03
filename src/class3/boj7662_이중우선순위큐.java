package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class boj7662_이중우선순위큐 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            int T = stoi(br.readLine());

            PriorityQueue<Integer> minpq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });

            PriorityQueue<Integer> maxpq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });

            HashMap<Integer, Integer> elements = new HashMap<>();

            for (int t = 1; t <= T; t++) {
                String[] input = br.readLine().split(" ");

                if (input[0].equals("I")) {   // 삽입
                    int value = stoi(input[1]);

                    minpq.add(value);
                    maxpq.add(value);
                    elements.put(value, elements.getOrDefault(value, 0)+1);
                } else {    // 삭제
                    if (elements.size() == 0) continue;

                    if (Integer.parseInt(input[1]) == 1) {    // 최대값 삭제
                        while (!elements.containsKey(maxpq.peek())) {
                            maxpq.poll();
                        }

                        int max = maxpq.poll();
                        elements.put(max, elements.get(max)-1);
                        if (elements.get(max) == 0) elements.remove(max);
                    } else {
                        while (!elements.containsKey(minpq.peek())) {
                            minpq.poll();
                        }

                        int min = minpq.poll();
                        elements.put(min, elements.get(min)-1);
                        if (elements.get(min) == 0) elements.remove(min);
                    }
                }
            }

            if (elements.size() == 0) sb.append("EMPTY\n");
            else {
                while(!elements.containsKey(minpq.peek())) minpq.poll();
                while(!elements.containsKey(maxpq.peek())) maxpq.poll();
                sb.append(maxpq.peek()+" "+minpq.peek()+"\n");
            }

        }

        System.out.println(sb.toString());

    }
}
