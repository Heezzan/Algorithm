package class3;

import java.util.Scanner;

public class boj1074_Z {
    static int idx = 0;
    static int R, C, result;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        result = 0;

        solution(0, 0, N, 0);
    }

    public static void solution(int r, int c, int N, int idx) {

        if (N == 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (R == r+i && C == c+j) {
                        System.out.println(idx);
                        System.exit(0);
                    }
                    idx++;
                }
            }
        } else {
            int size = (int) Math.pow(2, N-1);

            if (r <= R && R < r+size && c <= C && C < c+size) solution(r, c, N-1, idx);
            else if (r <= R && R < r+size && c+size <= C && C < c+size*2) solution(r, c+size, N-1, idx+size*size);
            else if (r+size <= R && R < r+size*2 && c <= C && C < c+size) solution(r+size, c, N-1, idx+size*size*2);
            else if (r+size <= R && R < r+size*2 && c+size <= C && C < c+size*2) solution(r+size, c+size, N-1, idx+size*size*3);
        }

    }
}
