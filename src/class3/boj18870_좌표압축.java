package class3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            set.add(arr[n]);
        }

        HashMap<Integer, Integer> result = new HashMap<>();
        while(!set.isEmpty()) {
            result.put(set.pollLast(), set.size());
        }

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            sb.append(result.get(arr[n])+" ");
        }

        System.out.println(sb.toString());
    }
}
