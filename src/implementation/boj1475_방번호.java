package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1475_방번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] cnt = new int[10];
        for (int i = 0; i < N.length(); i++) {
            cnt[N.charAt(i)-'0']++;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, cnt[i]);
        }

        int tmp = cnt[6]+cnt[9];
        if (tmp % 2 == 0) tmp/=2;
        else tmp = (tmp/2) + 1;

        System.out.println(max >= tmp ? max : tmp);
    }
}
