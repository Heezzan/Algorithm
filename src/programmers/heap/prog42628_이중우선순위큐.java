package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class prog42628_이중우선순위큐 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"})));
    }

    public static class Num {
        int idx, num;

        Num(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Num> down = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });
        PriorityQueue<Num> up = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return -Integer.compare(o1.num, o2.num);
            }
        });

        HashSet<Integer> remove = new HashSet<>();

        int idx = 0;
        for(String s : operations) {
            String[] op = s.split(" ");

            if (op[0].equals("I")) {
                Num n = new Num(idx++, Integer.parseInt(op[1]));
                up.add(n);
                down.add(n);
            } else {
                if (op[1].equals("1")) {    // 최댓값 삭제
                    while(!up.isEmpty() && remove.contains(up.peek().idx)) up.poll();
                    if (!up.isEmpty()) remove.add(up.poll().idx);
                } else {
                    while(!down.isEmpty() && remove.contains(down.peek().idx)) down.poll();
                    if (!down.isEmpty()) remove.add(down.poll().idx);
                }
            }
        }

        while(!up.isEmpty() && remove.contains(up.peek().idx)) up.poll();
        if (!up.isEmpty()) answer[0] = up.poll().num;
        while(!down.isEmpty() && remove.contains(down.peek().idx)) down.poll();
        if (!down.isEmpty()) answer[1] = down.poll().num;

//        if (pq.size() == 0) {
//            answer[0] = answer[1] = 0;
//        } else {
//            answer[0] = pq.poll();
//            while(pq.size() > 1) pq.poll();
//            answer[1] = pq.poll();
//        }

        return answer;
    }
}
