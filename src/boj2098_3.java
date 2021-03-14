import java.util.Scanner;

public class boj2098_3 {
    static int[][] map;
    static boolean[] visited;
    static int N, sum, result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1, i);
        }

        System.out.println(result);
    }

    public static void dfs(int now, int cnt, int start) {
        if (cnt == N && map[now][start] > 0) {
            sum += map[now][start];
            result = Math.min(sum, result);
            sum -= map[now][start];
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] != 0 && !visited[i]) {
                visited[i] = true;
                sum += map[now][i];
                dfs(i, cnt+1, start);
                sum -= map[now][i];
                visited[i] = false;
            }
        }
    }
}
