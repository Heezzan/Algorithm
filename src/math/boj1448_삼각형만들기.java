package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1448_삼각형만들기 {

    // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야함
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] strawArr = new int[N];

        for (int i = 0; i < N; i++) {
            strawArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(strawArr);

        boolean makeTriangle = false;
        for (int i = N-3; i >= 0; i--) {
            if (strawArr[i+2] < strawArr[i+1] + strawArr[i]) {
                makeTriangle = true;
                System.out.println(strawArr[i]+strawArr[i+1]+strawArr[i+2]);
                break;
            }
        }

        if (!makeTriangle) System.out.println(-1);
    }
}
