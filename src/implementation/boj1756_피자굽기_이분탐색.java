package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1756_피자굽기_이분탐색 {

    public static int stoi(String s) {return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] oven = new int[D+1];

        int max = 1_000_000_000;
        for (int i = 1; i <= D; i++) {
            oven[i] = stoi(st.nextToken());
            if (oven[i] > max) oven[i] = max;
            else max = oven[i];
        }
        int result = -1;

        st = new StringTokenizer(br.readLine());
        max = D;

        for (int i = 0; i < N; i++) {
            int pizza = stoi(st.nextToken());

            if (result == 0) continue;

            int left = 1, right = max;
            int cand = -1;
            while (left <= right) {
                int mid = (left+right)/2;

                if (oven[mid] < pizza) right = mid-1;
                else {
                    left = mid+1;
                    cand = mid;
                }
            }

            if (cand == -1) result = 0;
            else {
                result = cand;
                max = cand-1;
            }
        }

        System.out.println(result);

    }
}
