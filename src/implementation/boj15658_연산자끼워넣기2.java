package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15658_연산자끼워넣기2 {

    public static int[] arr;
    public static int min, max;

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = stoi(st.nextToken());

        int[] op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = stoi(st.nextToken());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(1, op, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int idx, int[] op, int val) {

        if (idx >= arr.length) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                if (i == 0) dfs(idx+1, op, val+arr[idx]);
                else if (i == 1) dfs(idx+1, op, val-arr[idx]);
                else if (i == 2) dfs(idx+1, op, val*arr[idx]);
                else dfs(idx+1, op, val/arr[idx]);

                op[i]++;
            }
        }
    }
}
