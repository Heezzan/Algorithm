package ps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1039_교환 {
    static Integer[] ordered;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int K = sc.nextInt();

        ordered = new Integer[N.length()];
        int[] num = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            num[i] = ordered[i] = N.charAt(i)-'0';
        }

        Arrays.sort(ordered, Collections.reverseOrder());

        if (num.length == 1 || num.length == 2 && Integer.parseInt(N)%10 == 0)
            System.out.println("-1");
        else {
            result = 0;
            change(0, num, K);
            System.out.println(result);
        }
    }

    public static void change(int idx, int[] num, int K) {
        if (K == 0) {   // 종료조건
            int n = num[0];
            for (int i = 1; i < num.length; i++) {
                n *= 10;
                n += num[i];
            }

            result = Math.max(result, n);
            return;
        }

        for (int i = idx; i < num.length; i++) {
            if (num[i] != ordered[i]) {
                idx = i;
                break;
            }
            if (i == num.length-1) {
                idx = num.length;
            }
        }

        if (idx < num.length) {
            // 젤 앞에 젤 큰수 오게 해라~
            for (int i = 0; i < num.length; i++) {
                if (num[i] == ordered[idx]) {
                    int[] changed = num.clone();
                    int tmp = changed[i];
                    changed[i] = changed[idx];
                    changed[idx] = tmp;
                    change(idx+1, changed, K-1);
                }
            }

        } else {
            int[] cnt = new int[10];
            for (int i = 0; i < num.length; i++)
                cnt[num[i]]++;

            boolean same = false;
            for (int i = 0; i < cnt.length; i++)
                if (cnt[i] >= 2) same = true;

            int[] changed = num.clone();
            if (!same && K%2 == 1) {
                int tmp = changed[changed.length-1];
                changed[changed.length-1] = changed[changed.length-2];
                changed[changed.length-2] = tmp;
            }
            change(idx, changed, 0);
        }
    }
}
