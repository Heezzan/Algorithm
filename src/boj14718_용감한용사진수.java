import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14718_용감한용사진수 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[][] power = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                power[i][j] = stoi(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int a = 0; a < N; a++) {
                        if (power[i][0] >= power[a][0] && power[j][1] >= power[a][1] && power[k][2] >= power[a][2]) {
                            cnt++;
                        }
                    }

                    if (cnt >= K) {
                        result = Math.min(result, power[i][0]+power[j][1]+power[k][2]);
                    }
                }
            }
        }

        System.out.println(result);
    }

/*
    public static void comb(int idx, int cnt, int[] power) {

        if (idx == K) {
            result = Math.min(result, power[0]+power[1]+power[2]);
            return;
        }

        if (cnt >= soldier.length) {
            System.out.println("LK");
            return;
        }

        int p1 = Math.max(power[0], soldier[cnt][0]);
        int p2 = Math.max(power[1], soldier[cnt][1]);
        int p3 = Math.max(power[2], soldier[cnt][2]);

        comb(idx+1, cnt+1, new int[]{p1, p2, p3});
        comb(idx, cnt+1, power);
    }
*/

}
