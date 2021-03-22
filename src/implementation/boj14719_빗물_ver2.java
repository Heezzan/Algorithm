package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14719_빗물_ver2 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = stoi(st.nextToken());
        int W = stoi(st.nextToken());

        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) block[i] = stoi(st.nextToken());

        int result = 0;
        for (int i = 0; i < W; i++) {
            int left = block[i], right = block[i];

            for (int j = i-1; j >= 0; j--) left = Math.max(left, block[j]);
            for (int j = i+1; j < W; j++) right = Math.max(right, block[j]);

            result += Math.min(left, right)-block[i];
        }
        System.out.println(result);
    }
}
