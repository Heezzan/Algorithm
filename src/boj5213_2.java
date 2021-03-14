import java.util.*;

public class boj5213_2 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static class Pos {
        int i, j;
        ArrayList<Integer> path;

        Pos(int i, int j, ArrayList<Integer> path) {
            this.i = i;
            this.j = j;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][][] tile = new int[N+1][N+1][3];

        int idx = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i%2 == 0 && j == N) continue;
                tile[i][j][0] = idx++;
                tile[i][j][1] = sc.nextInt();
                tile[i][j][2] = sc.nextInt();
            }
        }

        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        visited[0][0] = true;

        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        q.add(new Pos(0, 0, path));

        int maxidx = 0;
        List<Integer> result = null;

        while(!q.isEmpty()) {
            Pos now = q.poll();

            if (tile[now.i][now.j][0] == idx-1) {
                result = now.path;
                break;
            }

            for (int d = 0; d < dir.length; d++) {
                int ni = now.i + dir[d][0];
                int nj = now.j + dir[d][1];

                if (ni > 0 && ni <= N && nj > 0 && nj <= N && tile[ni][nj][0] > 0 && !visited[ni][nj]) {
                    boolean move = false;
                    // 오른쪽
                    if (d == 0 && tile[now.i][now.j][2] == tile[ni][nj][1]) move = true;
                    else if (d == 1) {  // 아래
                        if (now.i % 2 != 0) {   // 홀수
//                            if (tile[now.i][now.j][0] == tile[ni][nj])
                        } else {

                        }
                    }
                    if (d == 0) {   // 오른쪽
                        if (tile[now.i][now.j][2] == tile[ni][nj][1]) move = true;
                    } else if (d == 1) {    // 아래

                    } else if (d == 2) {    // 왼쪽

                    } else {    // 위에

                    }

                    if (move) {

                    }
                }
            }

            // 오른쪽으로 가
            if (now.j+1 <= N && tile[now.i][now.j][0] != 0
                    && tile[now.i][now.j][2] == tile[now.i][now.j+1][1]
                    && !visited[now.i][now.j+1]) {
                visited[now.i][now.j+1] = true;
                now.path.add(tile[now.i][now.j][0]);
                q.add(new Pos(now.i, now.j, path));
            }

            // 왼쪽으로 가
            if (now.j-1 > 0 && tile[now.i][now.j][1] == tile[now.i][now.j-1][2] && !visited[now.i][now.j-1]) {
                visited[now.i][now.j-1] = true;
                now.path.add(tile[now.i][now.j-1][0]);
                q.add(new Pos(now.i, now.j-1, path));
            }
            // 왼쪽으로 가
            // 위로가
            // 아래로 가

            // 만약 [i][j][1] 이면 [i][j][2] 이동 가능
//            if (now.k == 1) q.add(new Pos(now.i, now.j, 2, now.path));

            // [i][j][2] == [i][j+1][1]
//            if (now.k == 2 && (now.j+1 <= N && tile)
            // 홀수 일 때
            // [i][j][0] [i+1][j-1][1] / [i][j][1] [i+1][j][0]
            // [i][j][0]  [i-1][j][1] / [i][j][1] [i-1][j+1][0]

            // 짝수 일 때
            // [i][j][0] [i+1][j][1] / [i][j][1] [i+1][j+1][0]
            // [i][j][0] [i-1][j][1] / [i][j][1] [i-1][j+1][0]

            if (tile[now.i][now.j][0] > maxidx) result = now.path;
        }

        System.out.println(result.size());
        for (int i : path)
            System.out.print(i+" ");
    }
}
