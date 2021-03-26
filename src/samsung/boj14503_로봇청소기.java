package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503_로봇청소기 {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 북, 동, 남, 서
    static int[][] map;

    public static class Pos {
        int i, j, d;

        Pos (int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public static int stoi(String s) {return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Pos now = new Pos(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int result = 0;

        while(true) {

            if (map[now.i][now.j] == 0) {
                map[now.i][now.j] = -1;
                result++;
            }

            // 1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면 그 방향으로 회전하고 다음 한칸을 전진하고 1번부터 진행
            // 2. 왼쪽 방향에 청소할공간이 없다면 그 방향으로 회전하고 다시 다음 방향 탐색
            boolean next = false;
            for (int d = 1; d <= 4; d++) {
                int nd = now.d-d;
                if (nd < 0) nd += 4;

                int ni = now.i + dir[nd][0];
                int nj = now.j + dir[nd][1];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
                    now = new Pos(ni, nj, nd);
                    next = true;
                }
                if (next) break;
            }

            if (next) continue;

            int ni = now.i - dir[now.d][0];
            int nj = now.j - dir[now.d][1];

            // 3. 네 방향 이미 청소가 모두 되어있거나 벽이면, 바라보는 방향 유지한채로 한칸 후진, 2번으로 돌아감
            // 4. 네 방향 모두 청소가 되어있거나, 벽이면서 뒤쪽도 벽이여서 후진할 수 없는 경우 작동 멈춤
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == -1) {
                now = new Pos(ni, nj, now.d);
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
