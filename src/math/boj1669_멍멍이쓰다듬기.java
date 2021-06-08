package math;

import java.util.Scanner;

public class boj1669_멍멍이쓰다듬기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        int result;

        if (X == Y) result = 0;
        else {
            int diff = Y-X;

            for (int i = 1; ; i++) {
                if (diff >= i*2) {
                    diff -= (i*2);
                } else {
                    result = (i-1)*2;
                    if (diff != 0) {
                        if (diff <= i) result += 1;
                        else result += 2;
                    }
                    break;
                }
            }
        }

        System.out.println(result);

    }
}