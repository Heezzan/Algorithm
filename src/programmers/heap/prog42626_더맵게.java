package programmers.heap;

import java.util.PriorityQueue;

public class prog42626_더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);

        while(!pq.isEmpty()) {
            int now = pq.poll();

            if (now >= K) break;
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }

            int next = pq.poll();
            pq.add(now+(next*2));
            answer++;
        }

        return answer;
    }
}
