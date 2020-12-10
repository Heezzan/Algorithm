package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18111_마인크래프트 {

    /*
    * 해멨던 부분
    * - 땅을 순차적으로 훑으며 인벤토리에서 블록을 가져올 수 없을 때
    * 더 이상 땅을 일정하게 만들 수 없다고 생각했었다.
    * - 하지만 현재 인벤토리에서 블록을 가져올 수 없더라도 다음에 블룩을 인벤토리에 넣는 경우가 있다면
    * 문제가 되지 않았다.
    * - 또한 나는 땅들을 하나씩 탐색하면서 인벤토리에 블럭을 넣고 빼는 과정을 반복했다.
    * 하지만 그럴 필요 없이 sum+inventory >= n*m*height 일 때만 걸리는 시간을 구하면 됐다...
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rtime = Integer.MAX_VALUE, rheight = 0;
        for (int c = 0; c <= 256; c++) {
            int time = 0;
            int inventory = B;
            int need = 0;
            boolean can = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > c) {   // 블록 제거
                        time += (map[i][j] - c) * 2;
                        inventory += map[i][j] - c;
                    } else if (map[i][j] < c) {    // 블록 추가 (바로 추가는 안함!)
                        need += c - map[i][j];
                        time += c - map[i][j];
                    }
                }
            }

            if (inventory >= need && time <= rtime) {
                rtime = time;
                rheight = c;
            }
        }

        System.out.println(rtime + " " + rheight);

    }
}
