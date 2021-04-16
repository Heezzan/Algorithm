package bitmasking;

import java.util.Scanner;

public class boj1052_물병 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int buy = 0;

        while(true) {
            String toBinary = Integer.toBinaryString(N+buy);

            int cnt = 0;
            boolean move = true;

            for (int i = 0; i < toBinary.length(); i++) {
                if (cnt > K) {
                    move = false;
                    break;
                }
                if (toBinary.charAt(i) == '1') cnt++;
            }

            if (move && cnt <= K) {
                System.out.println(buy);
                break;
            }

            buy++;
        }

    }
}