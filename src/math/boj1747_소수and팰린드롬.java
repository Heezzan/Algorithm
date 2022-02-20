package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1747_소수and팰린드롬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1_003_002];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {

            int j = 2;

            if (!isPrime[i]) continue;
            while (i*j < isPrime.length) {
                isPrime[i*j] = false;
                j++;
            }
        }

        for (int i = N; ; i++) {
            if (isPrime[i] && isPal(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPal(int n) {
        String num = Integer.toString(n);

        if (num.length() == 1) return true;

        for (int i = 0; i < num.length()/2; i++) {
            if (!(num.charAt(i) == num.charAt(num.length()-1-i)))
                return false;
        }

        return true;
    }

}
