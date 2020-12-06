package class2;

import java.util.Scanner;

public class boj2869_달팽이는올라가고싶다 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int result = 0;

        if ((V-A) % (A-B) == 0) {
            result = (V-A)/(A-B) + 1;
        } else {
            result = (V-A)/(A-B) + 2;
        }

        System.out.println(result);
    }
}
