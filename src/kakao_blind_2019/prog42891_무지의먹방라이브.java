package kakao_blind_2019;

import java.util.*;

public class prog42891_무지의먹방라이브 {

    static class Food {
        int idx, time;

        Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
        System.out.println(solution(new int[]{4, 2, 3, 6, 7, 1, 5, 8}, 16));
        System.out.println(solution(new int[]{4, 2, 3, 6, 7, 1, 5, 8}, 27));
        System.out.println(solution(new int[]{1, 1, 1, 1}, 4));
    }

    public static int solution(int[] food_times, long k) {

        long sum = 0;
        for (int time : food_times)
            sum += time;

        if (sum <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });

        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i+1, food_times[i]));
        }

        long time = 0;
        int prev = 0;
        while (time + (pq.peek().time-prev)*pq.size() <= k) {
            time += (pq.peek().time-prev)*pq.size();
            prev = pq.peek().time;
            pq.poll();
        }

        List<Food> list = new ArrayList<>();
        while(!pq.isEmpty()) list.add(pq.poll());

        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.idx, o2.idx);
            }
        });

        return list.get((int) ((k-time)%list.size())).idx;
    }
}
