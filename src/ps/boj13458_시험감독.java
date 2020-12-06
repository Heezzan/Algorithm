package ps;

import java.util.Scanner;

public class boj13458_시험감독 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] human = new int[N];
        for (int i = 0; i < N; i++) {
            human[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();

        long result = 0;
        for (int i = 0; i < N; i++) {
            int need = 0;

            if (human[i]-B <= 0) {  // 이 부분을 생각 못했다
                need = 1;
            } else if ((human[i]-B) % C == 0) {
                need = (human[i]-B)/C + 1;
            } else {
                need = (human[i]-B)/C + 2;
            }

            result += need;
        }

        System.out.println(result);

    }
}
