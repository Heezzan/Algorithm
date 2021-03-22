package samsung;

import java.util.Scanner;

public class boj14889_스타트와링크 {
    static int[][] power;
    static int N, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        power = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                power[i][j] = sc.nextInt();
            }
        }

        result = Integer.MAX_VALUE;
        combination(0, 1, new int[N/2]);
        System.out.println(result);
    }

    public static void combination(int idx, int cnt, int[] team) {
        if (idx >= team.length) {

            int[] other = new int[team.length];
            int ri = 0, oi = 0;
            for (int i = 1; i <= N; i++) {
                if (ri < team.length && team[ri] == i) ri++;
                else other[oi++] = i;
            }

            int power1 = 0, power2 = 0;
            for (int i = 0; i < team.length; i++) {
                for (int j = 0; j < team.length; j++) {
                    if (i == j) continue;
                    power1 += power[team[i]][team[j]];
                }
            }

            for (int i = 0; i < other.length; i++) {
                for (int j = 0; j < other.length; j++) {
                    if (i == j) continue;
                    power2 += power[other[i]][other[j]];
                }
            }

            result = Math.min(result, Math.max(power1, power2)-Math.min(power1, power2));
            return;
        }

        if (cnt > N) return;

        team[idx] = cnt;
        combination(idx+1, cnt+1, team);
        combination(idx, cnt+1, team);
    }
}
