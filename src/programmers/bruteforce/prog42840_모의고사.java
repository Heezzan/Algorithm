package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class prog42840_모의고사 {

    public int[] solution(int[] answers) {
        int[] answer;

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[idx1++]) score[0]++;
            if (idx1 >= p1.length) idx1 = 0;

            if (answers[i] == p2[idx2++]) score[1]++;
            if (idx2 >= p2.length) idx2 = 0;

            if (answers[i] == p3[idx3++]) score[2]++;
            if (idx3 >= p3.length) idx3 = 0;
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == score[i]) tmp.add(i+1);
        }

        answer = new int[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}
