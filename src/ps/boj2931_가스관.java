package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2931_가스관 {
    static char[][] map;
    static int R, C;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] block = {{false, false, false, false}, {true, true, false, false}
            , {true, false, false, true}, {false, false, true, true}, {false, true, true, false}
            , {false, true, false, true}, {true, false, true, false},{true, true, true, true}};

    static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        map = new char[R+1][C+1];

        Pos start = null;
        Pos end = null;
        for (int i = 1; i <= R; i++) {
            String in = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = in.charAt(j-1);

                if (map[i][j] == '.') continue;
                if (map[i][j] == '|') map[i][j] = '5';
                else if (map[i][j] == '-') map[i][j] = '6';
                else if (map[i][j] == '+') map[i][j] = '7';
                else if (map[i][j] == 'M') start = new Pos(i, j);
                else if (map[i][j] == 'Z') end = new Pos(i, j);
            }
        }

        boolean aroundZ = false;
        for (int d = 0; d < dir.length; d++) {
            int ni = end.i + dir[d][0];
            int nj = end.j + dir[d][1];

            if (ni <= 0 || ni > R || nj <= 0 || nj > C || map[ni][nj] == '.') continue;
            aroundZ = true;
        }

        boolean[][] visited = new boolean[R+1][C+1];
        visited[start.i][start.j] = true;

        for (int d = 0; d < dir.length; d++) {
            int ni = start.i + dir[d][0];
            int nj = start.j + dir[d][1];

            if (ni <= 0 || ni > R || nj <= 0 || nj > C || map[ni][nj] == '.') continue;
            visited[ni][nj] = true;
            dfs(new Pos(ni, nj), false, visited, aroundZ);
        }
    }
    
    public static void dfs(Pos p, boolean pipe, boolean[][] visited, boolean aroundZ) {

        if (map[p.i][p.j] == '.' && pipe) {
            boolean[] check = new boolean[4];

            for (int d = 0; d < dir.length; d++) {
                int ni = p.i + dir[d][0];
                int nj = p.j + dir[d][1];

                int nd = 1;
                if (d == 0) nd = 2;
                else if (d == 1) nd = 3;
                else if (d == 2) nd = 0;

                if (ni <= 0 || ni > R || nj <= 0 || nj > C || map[ni][nj] == '.' || map[ni][nj] == 'M') continue;
                if ((map[ni][nj] == 'Z' && !aroundZ)
                    || (map[ni][nj]-'0' > 0 && map[ni][nj]-'0' < 8 && block[map[ni][nj]-'0'][nd]))
                    check[d] = true;
            }

            for (int b = 1; b < block.length; b++) {
                if (check[0] == block[b][0] && check[1] == block[b][1]
                        && check[2] == block[b][2] && check[3] == block[b][3]) {
                    System.out.print(p.i+" "+p.j+" ");
                    if (b < 5) System.out.println(b);
                    else if (b == 5) System.out.println("|");
                    else if (b == 6) System.out.println("-");
                    else if (b == 7) System.out.println("+");
                    System.exit(0);
                }
            }
        }

        else if (map[p.i][p.j] != '.') {
            if (map[p.i][p.j] == 'Z') return;

            for (int d = 0; d < dir.length; d++) {
                if (block[map[p.i][p.j]-'0'][d]) {
                    int ni = p.i + dir[d][0];
                    int nj = p.j + dir[d][1];

                    if (ni <= 0 || ni > R || nj <= 0 || nj > C) return;
                    if (map[ni][nj] != '.' && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        dfs(new Pos(ni, nj), pipe, visited, aroundZ);
                    } else if (map[ni][nj] == '.' && !pipe){
                        visited[ni][nj] = true;
                        dfs(new Pos(ni, nj), true, visited, aroundZ);
                    }
                }
            }
        }
    }
    
}
