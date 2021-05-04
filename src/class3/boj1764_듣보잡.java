package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> names = new HashSet<>();

        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String in = br.readLine();

            if (names.contains(in)) result.add(in);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String s : result)
            System.out.println(s);

    }
}
