package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1756_피자굽기 {

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

        int result = D+1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pizza = stoi(st.nextToken());
            if (result == 0) continue;

            for (int d = result-1; d >= 0; d--) {
                if (pizza <= oven[d]) {
                    result = d;
                    break;
                }
                if (d == 0) result = 0;
            }
        }

        System.out.println(result);

    }
}
