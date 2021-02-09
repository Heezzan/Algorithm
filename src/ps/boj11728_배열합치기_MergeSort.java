package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11728_배열합치기_MergeSort {

    public static void main(String[] args) throws IOException {
        // 인풋값 크면 br 쓰자...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            b[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+M];
        int ai = 0, bi = 0;
        for (int i = 0; i < N+M; i++) {
            if (ai < N && bi < M) {
                if (a[ai] < b[bi]) arr[i] = a[ai++];
                else arr[i] = b[bi++];
            } else if (ai < N) {
                arr[i] = a[ai++];
            } else if (bi < M) {
                arr[i] = b[bi++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i+" ");

        System.out.println(sb.toString());
    }
}
