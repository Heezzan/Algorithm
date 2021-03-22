package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14719_빗물 {

    public static class Pos {
        int i, j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = stoi(st.nextToken());
        int W = stoi(st.nextToken());

        boolean[][] block = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for (int j =0; j < W; j++) {
            int h = stoi(st.nextToken());
            for (int i = 0; i < h; i++) {
                block[H-i-1][j] = true;
            }
        }

        int result = 0;

        for (int i = H-1; i >= 0; i--) {
            Queue<Pos> q = new LinkedList<>();
            boolean save = false;
            for (int j = 0; j < W; j++) {
                if (!save && block[i][j]) {
                    save = true;
                } else if (save && !block[i][j]) {
                    q.add(new Pos(i, j));
                } else if (save && block[i][j]) {
                    while(!q.isEmpty()) {
                        Pos now = q.poll();
                        block[now.i][now.j] = true;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
