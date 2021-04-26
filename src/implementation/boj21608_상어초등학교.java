package implementation;

import java.util.Scanner;

public class boj21608_상어초등학교 {

    public static class Student {
        int idx;
        boolean[] like = new boolean[N*N+1];

        Student(int idx, int a, int b, int c, int d) {
            this.idx = idx;
            this.like[a] = this.like[b] = this.like[c] = this.like[d] = true;
        }
    }

    public static class Pos {
        int i, j, empty, like;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
            this.empty = 0;
            this.like = 0;
        }
    }

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Student[][] space = new Student[N][N];
        Student[] st = new Student[N*N];

        for (int i = 0; i < N*N; i++) {
            st[i] = new Student(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for (int s = 0; s < st.length; s++) {
            Pos tmp = null;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // 학생이 있지 않을 경우
                    if (space[i][j] == null) {
                        Pos now = new Pos(i, j);

                        for (int d = 0; d < dir.length; d++) {
                            int ni = i + dir[d][0];
                            int nj = j + dir[d][1];

                            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                if (space[ni][nj] == null) now.empty++;
                                else if (st[s].like[space[ni][nj].idx]) now.like++;
                            }
                        }

                        if (tmp == null || tmp.like < now.like
                        || (tmp.like == now.like && tmp.empty < now.empty)
                        || (tmp.like == now.like && tmp.empty == now.empty && tmp.i > now.i)
                        || (tmp.like == now.like && tmp.empty == now.empty && tmp.i == now.i && tmp.j > now.j))
                            tmp = now;

                    }
                }
            }

            space[tmp.i][tmp.j] = st[s];
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;

                for (int d = 0; d < dir.length; d++) {
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];

                    if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                        if (space[i][j].like[space[ni][nj].idx]) cnt++;
                    }
                }

                if (cnt == 1) result += 1;
                else if (cnt == 2) result += 10;
                else if (cnt == 3) result += 100;
                else if (cnt == 4) result += 1000;
            }
        }

        System.out.println(result);
    }
}
