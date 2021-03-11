package programmers.sort;

import java.util.Arrays;

public class prog42748_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] sub = new int[commands[i][1]-commands[i][0]+1];

            int idx = 0;
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                sub[idx++] = array[j];
            }

            Arrays.sort(sub);
            answer[i] = sub[commands[i][2]-1];
        }

        return answer;
    }
}
