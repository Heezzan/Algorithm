package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003_수들의합2_투포인터 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
        }

        int sidx = 0, eidx = 0, sum = 0, result = 0;

        while (true) {
            if (sum >= M) sum -= num[sidx++];
            else if (eidx == N) break;
            else sum += num[eidx++];

            if (sum == M) result++;
        }

        System.out.println(result);
    }
}
