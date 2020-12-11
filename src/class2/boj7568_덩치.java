package class2;

import java.util.Scanner;

public class boj7568_덩치 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] people = new int[N][3];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }

        for (int i = 0 ; i < N; i++) {
            int bt = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    bt++;
                }
            }
            people[i][2] = bt+1;
        }

        for (int i = 0; i < N; i++)
            System.out.print(people[i][2]+" ");

    }
}
