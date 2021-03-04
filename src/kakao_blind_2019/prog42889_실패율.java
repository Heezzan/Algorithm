package kakao_blind_2019;

import java.util.*;

public class prog42889_실패율 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    static class Each {
        int idx;
        float frate;

        Each(int idx, float frate) {
            this.idx = idx;
            this.frate = frate;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] user = new int[N+2][2];
        // 0번은 깬거 1번은 도전중인거

        for (int i = 0; i < stages.length; i++) {
            user[stages[i]][1]++;

            for (int j = 1; j <= stages[i]; j++) {
                user[j][0]++;
            }
        }

        List<Each> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (user[i][0] != 0)
                list.add(new Each(i, ((float)user[i][1]/(float)user[i][0])));
            else
                list.add(new Each(i, 0));
        }

        Collections.sort(list, new Comparator<Each>() {
            @Override
            public int compare(Each o1, Each o2) {
                if (o1.frate == o2.frate) return Integer.compare(o1.idx, o2.idx);
                else return -Float.compare(o1.frate, o2.frate);
            }
        });

        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i).idx;

        return answer;
    }
}
