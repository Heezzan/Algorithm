package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class prog42627_디스크컨트롤러 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public static int solution(int[][] jobs) {
        int idx = 0, time = 0, sum = 0;

        // 시간 순대로 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 작업 시간이 짧은 순대로 pq 만듦. 이 때 작업 시간 같으면 먼저 온게 먼저 나갈 수 있도록!
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.add(jobs[0]);
        time = jobs[0][0];
        idx++;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            time += now[1];
            sum += (time-now[0]);

            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty() && idx < jobs.length) {
                pq.add(jobs[idx]);
                time = jobs[idx][0];
                idx++;
            }
        }

        return sum/jobs.length;
    }

}
