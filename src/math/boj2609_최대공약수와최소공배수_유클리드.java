package math;

import java.io.IOException;
import java.util.Scanner;

public class boj2609_최대공약수와최소공배수_유클리드 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int g = gcd(A, B);
        int l = g * (A/g) * (B/g);

        System.out.println(g);
        System.out.println(l);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }

}
