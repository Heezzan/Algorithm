package binarysearch;

import java.util.Scanner;

public class boj1072_게임 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        long origin = ((long)Y*100)/X;
        boolean changed = false;
        int start = 1;
        int end = X;

        long result = 0;


        while(start <= end) {
            int mid = (start + end) / 2;
            long Z = ((long)(Y+mid)*100)/(X+mid);
            System.out.println(Z);

            if (Z == origin) start = mid + 1;
            else {
                changed = true;
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(changed ? result : -1);
    }
}
