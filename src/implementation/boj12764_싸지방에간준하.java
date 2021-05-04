package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12764_싸지방에간준하 {

    public static class Time implements Comparable<Time> {
        int idx, min;
        boolean enter;

        Time(int idx, int min, boolean enter) {
            this.idx = idx;
            this.min = min;
            this.enter = enter;
        }

        @Override
        public int compareTo(Time o) {
            return Integer.compare(this.min, o.min);
        }
    }

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        StringTokenizer st;

        PriorityQueue<Time> timeline = new PriorityQueue<>();

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            timeline.add(new Time(n, stoi(st.nextToken()), true));
            timeline.add(new Time(n, stoi(st.nextToken()), false));
        }
        
        HashMap<Integer, Integer> visit = new HashMap<>(); // idx, 어디앉았는지
        int[] cnt = new int[N];
        int idx = 0;

        PriorityQueue<Integer> tmp = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        while(!timeline.isEmpty()) {
            Time now = timeline.poll();

            if (now.enter) {
                if (tmp.isEmpty()) {
                    cnt[idx]++;
                    visit.put(now.idx, idx);
                    idx++;
                } else {
                    cnt[tmp.peek()]++;
                    visit.put(now.idx, tmp.peek());
                    tmp.poll();
                }
            } else {
                tmp.add(visit.get(now.idx));
                visit.remove(now.idx);
            }
        }

        System.out.println(idx);
        for (int i = 0; i < idx; i++) System.out.print(cnt[i]+" ");
    }
}
