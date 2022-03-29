package ps;

import java.util.Scanner;

public class boj1094_막대기 {

    public static int X, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        result = 1;

        System.out.println(makeStick(64, 64));
    }

    public static int makeStick(int min, int total) {

        if (total <= X) return result;

        if (total - (min/2) >= X) {
            return makeStick(min/2, total-(min/2));
        } else {
            result++;
            return makeStick(min/2, total);
        }
    }
}