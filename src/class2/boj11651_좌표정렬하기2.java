package class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj11651_좌표정렬하기2 {

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y != o2.y) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(points[i].x + " " + points[i].y);
        }
    }
}
