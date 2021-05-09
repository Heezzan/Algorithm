package kakao_internship_2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prog67259_경주로건설 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        System.out.println(solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
        System.out.println(solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
        System.out.println(solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
    }

    public static class Pos {
        int i, j, dir, cost;

        Pos(int i, int j, int dir, int cost) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int solution(int[][] board) {
        int answer = 0;

        int[][] visited = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        Queue<Pos> q = new LinkedList<>();
        visited[0][0] = 0;
        q.add(new Pos(0, 0, 0, 0));
        q.add(new Pos(0, 0, 1, 0));

        while(!q.isEmpty()) {
            Pos now = q.poll();

            if (now.i == board.length-1 && now.j == board.length-1) {
                answer = now.cost;
                continue;
            }

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                // 0 -> 0, 2  || 1 -> 1, 4
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board.length && board[ni][nj] == 0) {
                    int cost = now.cost + (now.dir%2 == d%2 ? 100 : 600);
                    if (cost <= visited[ni][nj]) {
                        visited[ni][nj] = cost;
                        q.add(new Pos(ni, nj, d, cost));
                    }
                }
            }
        }

        return answer;
    }

}
