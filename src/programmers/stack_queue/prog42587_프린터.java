package programmers.stack_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class prog42587_프린터 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        int lastidx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int p : priorities) pq.add(p);

        while(!pq.isEmpty()) {
            int p = pq.poll();
            answer++;

            for (int i = 0; i < priorities.length; i++) {
                int idx = (lastidx+i)%priorities.length;
                if (priorities[idx] == p) {
                    System.out.println(idx);
                    priorities[idx] = 0;
                    lastidx = idx;
                    break;
                }
            }

            if (lastidx == location) break;

        }

        return answer;
    }
}
