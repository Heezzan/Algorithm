package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> byIdx = new HashMap<>();
        HashMap<String, Integer> byName = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int n = 1; n <= N; n++) {
            String s = br.readLine();
            byIdx.put(n, s);
            byName.put(s, n);
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            String s = br.readLine();

            if (s.charAt(0)-'0' >= 0 && s.charAt(0)-'0' <= 9) {
                sb.append(byIdx.get(Integer.parseInt(s))+"\n");
            } else {
                sb.append(byName.get(s)+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
