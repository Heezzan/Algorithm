package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2469_사다리타기 {

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] order = new int[K];
        String in = br.readLine();
        for (int i = 0; i < K; i++) order[in.charAt(i)-'A'] = i;

        boolean[][][] map = new boolean[N+1][K][2];
        int resultIdx = 0;
        for (int i = 0; i < N; i++) {
            in = br.readLine();

            if (in.charAt(0) == '?') {
                resultIdx = i;
                continue;
            }

            for (int j = 0; j < in.length(); j++) {
                if (in.charAt(j) == '-') {
                    map[i][j][1] = true;
                    if (j+1 < K) map[i][j+1][0] = true;
                }
            }
        }

        boolean impossible = false;

        for (int k = 0; k < K; k++) {
            Pos p = new Pos(0, k);  // 얘는 출발하는거야
            Pos tmp = null; // ?를 만났을 때
            int tmpIdx = 0;

            if (impossible) break;

            while(true) {

                // 맨 아랫줄에 도착한 경우
                if (p.i == N) {
                    if (tmp == null) break;

                    if (p.j == order[k]) {
                        if (tmpIdx == 0) {
                            map[tmp.i][tmp.j][0] = true;
                            if (tmp.j > 0) map[tmp.i][tmp.j-1][1] = true;
                        } else if (tmpIdx == 1) {
                            map[tmp.i][tmp.j][1] = true;
                            if (tmp.j+1 < K) map[tmp.i][tmp.j+1][0] = true;
                        }
                        break;
                    } else {
                        if (tmpIdx < 3) {
                            p = tmp;
                            tmpIdx++;
                            continue;
                        } else {
                            impossible = true;
                            break;
                        }
                    }
                }

                // 만약 여기가 ? 인데야
                if (p.i == resultIdx) {
                    tmp = new Pos(p.i, p.j);
                    if (tmpIdx == 0) {
                        if (p.j > 0) p.j -= 1;
                        else {
                            tmpIdx++;
                            continue;
                        }
                    }
                    else if (tmpIdx == 1) {
                        if (p.j+1 < K) p.j += 1;
                        else {
                            tmpIdx++;
                            continue;
                        }
                    }
                    p.i += 1;
                    continue;
                }

                if (map[p.i][p.j][0] && p.j > 0) p.j -= 1;
                else if (map[p.i][p.j][1] && p.j+1 < K) p.j += 1;
                p.i += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (impossible) {
            for (int i = 0; i < K - 1; i++) sb.append("x");
        } else {
            for (int j = 0; j < K-1; j++) {
                if (map[resultIdx][j][1]) sb.append("-");
                else sb.append("*");
            }
        }

        System.out.println(sb.toString());
    }
}
