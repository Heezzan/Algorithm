package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806_부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0, sum = 0, result = Integer.MAX_VALUE;

        while(true) {
            if (sum >= S) {
                result = Math.min(result, end-start);
                sum -= num[start++];
            } else if (end == N) break;
            else {
                sum += num[end++];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);

    }
}
