package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바보야... 크기 체크 제대로 해라...
public class boj2805_나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 1_000_000_000;

        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) sum += (trees[i]-mid);
            }

            if (sum >= M) {
                result = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }

        System.out.println(result);
    }

}
