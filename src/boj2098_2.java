import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj2098_2 {
    static int[][] map;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.min(result, bfs(i));
        }

        System.out.println(result);
    }

    public static int bfs (int start) {

        PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.sum-o2.sum;
            }
        });

        for (int i = 0; i < N; i++) {
            if (map[start][i] != 0)
                pq.add(new Pos(i, map[start][i], 0));
        }

        while(!pq.isEmpty()) {
            Pos now = pq.poll();

            if (now.cnt == N) {
                return now.sum;
            }

            for (int i = 0; i < N; i++) {
                if (!now.visited[i] && map[now.n][i] != 0) {
                    now.visited[i] = true;
                    pq.add(new Pos(i, now.sum+map[now.n][i], now.cnt+1, now.visited));
                    now.visited[i] = false;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static class Pos {
        int n, sum, cnt;
        boolean[] visited = new boolean[N];

        Pos(int n, int sum, int cnt) {
            this.n = n;
            this.sum = sum;
            this.cnt = cnt;
        }

        Pos(int n, int sum, int cnt, boolean[] visited) {
            this.n = n;
            this.sum = sum;
            this.cnt = cnt;
            this.visited = visited;
        }
    }
}
