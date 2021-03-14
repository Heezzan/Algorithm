package kakao_blind_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class prog42891_2 {

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
        int answer = 0;

//        List<Food> list = new ArrayList<>();
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < food_times.length; i++) {
            list.put(i+1, food_times[i]);
//            list.add(new Food(i+1, food_times[i]));
        }

        int idx = 0;
        int time = 0;
        List<Integer> remove = new ArrayList<>();
        while (true) {
            if (list.size() == 0) {
                answer = -1;
                break;
            }
            if (time == k) {
                while(!list.containsKey(idx)) {
                    idx++;
                }
                answer = idx;
//                answer = list.get(idx).idx;
                break;
            }

            list.put(idx, list.get(idx)-1);
//            list.get(idx).time--;
            if (list.get(idx) == 0) {
                remove.add(idx);
            }
            idx++;
            time++;

            if (idx >= list.size()) {
                for (int n: remove)
                    list.remove(n);
                idx = 0;
            }
        }

        return answer;
    }
}
