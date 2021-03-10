package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class prog43162_네트워크 {

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    answer++;
                    bfs(new Pos(i, j), computers);
                }
            }
        }
        return answer;
    }

    public static void bfs(Pos p, int[][] computers) {
        Queue<Pos> q = new LinkedList<>();
        computers[p.i][p.j] = computers[p.j][p.i] = 0;
        q.add(p);

        while(!q.isEmpty()) {
            Pos now = q.poll();

            for (int i = 0; i < computers[0].length; i++) {
                if (computers[now.j][i] == 1) {
                    computers[now.j][i] = computers[i][now.j] = 0;
                    q.add(new Pos(now.j, i));
                }
            }
        }
    }
}
