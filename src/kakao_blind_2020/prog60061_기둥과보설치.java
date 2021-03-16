package kakao_blind_2020;

import java.util.Arrays;

public class prog60061_기둥과보설치 {
    static boolean[][][] map;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}})));
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}})));
    }

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;

        map = new boolean[n+1][n+1][2];   // [0] 기둥 [1] 보
        int cnt = 0;

        for (int i = 0; i < build_frame.length; i++) {
            // 기둥, 보를 설치할 때
            if (build_frame[i][3] == 1) {
                if (isPossible(build_frame[i], n)) {    // 설치할 수 있으면 설치한다.
                    cnt++;
                    map[build_frame[i][0]][build_frame[i][1]][build_frame[i][2]] = true;
                }
            } 
            // 기둥, 보를 삭제할 때
            else if (build_frame[i][3] == 0) {
                // 우선 삭제를 하고 연관있는 기둥, 보들이 규칙에 어긋나지 않는지 확인한다.
                cnt--;
                map[build_frame[i][0]][build_frame[i][1]][build_frame[i][2]] = false;

                for (int ni = 0; ni <= n; ni++) {
                    for (int nj = 0; nj <= n; nj++) {
                        for (int nk = 0; nk < 2; nk++) {
                            if (map[ni][nj][nk] && !isPossible(new int[]{ni, nj, nk, 0}, n)) {
                                cnt++;
                                map[build_frame[i][0]][build_frame[i][1]][build_frame[i][2]] = true;
                                ni = nj = n+1;
                                break;
                            }
                        }
                    }
                }
            }
        }

        answer = new int[cnt][3];
        cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k]) {
                        answer[cnt][0] = i;
                        answer[cnt][1] = j;
                        answer[cnt][2] = k;
                        cnt++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPossible(int[] n, int h) {

        if (n[2] == 0) {    // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
            if (n[1] == 0 || (n[0] > 0 && map[n[0]-1][n[1]][1])
                    || map[n[0]][n[1]][1] || (n[1] > 0 && map[n[0]][n[1]-1][0]))
                return true;
            return false;
        } else if (n[2] == 1) { // 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다
            if ((n[1] > 0 && map[n[0]][n[1]-1][0]) || (n[0] < h && n[1] > 0 && map[n[0]+1][n[1]-1][0])
                    || (n[0] > 0 && n[0] < h && map[n[0]+1][n[1]][1] && map[n[0]-1][n[1]][1]))
                return true;
            return false;
        }

        return false;
    }
}
