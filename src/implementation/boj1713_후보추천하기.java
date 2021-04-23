package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj1713_후보추천하기 {

    public static class Candidate {
        int idx, cnt;

        Candidate(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int vote = sc.nextInt();

        List<Candidate> list = new ArrayList<>();
        for (int i = 0; i < vote; i++) {
            int idx = sc.nextInt();
            boolean add = false;

            int minIdx = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).idx == idx) {
                    list.get(j).cnt += 1;
                    add = true;
                }

                if (list.get(minIdx).cnt > list.get(j).cnt) minIdx = j;
            }

            if (!add) {
                if (list.size() < N) list.add(new Candidate(idx, 1));
                else {
                    list.remove(minIdx);
                    list.add(new Candidate(idx, 1));
                }
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i).idx;
        Arrays.sort(result);
        for (int i = 0; i < N; i++) System.out.print(result[i]+" ");
        System.out.println();
    }
}
