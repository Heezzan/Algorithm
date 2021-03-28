package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110_공유기설치 {

    public static int stoi(String s) {return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int C = stoi(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++)
            house[i] = stoi(br.readLine());

        Arrays.sort(house);
        int left = 1;
        int right = house[N-1]-house[0];
        int result = 0;

        while(left <= right) {
            int mid = (left+right)/2;
            int cnt = 1;
            int lastidx = 0;

            // mid 차이만큼 공유개 C개 설치할 수 있나 해보자
            for (int i = 1; i < N; i++) {
                if (house[lastidx]+mid <= house[i]) {
                    cnt++;
                    lastidx = i;
                }
                if (cnt > C) break;
            }
            if (cnt < C) {
                right = mid-1;
            } else {
                result = mid;
                left = mid+1;
            }
        }

        System.out.println(result);
    }
}