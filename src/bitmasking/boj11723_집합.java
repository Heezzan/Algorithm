package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if (method.equals("add")) {
                S |= (1<<Integer.parseInt(st.nextToken()));
            } else if (method.equals("remove")) {
                S &= ~(1<<Integer.parseInt(st.nextToken()));
            } else if (method.equals("check")) {
                sb.append((S & (1<<Integer.parseInt(st.nextToken()))) != 0 ? 1 : 0);
                sb.append("\n");
            } else if (method.equals("toggle")) {
                S ^= (1<<Integer.parseInt(st.nextToken()));
            } else if (method.equals("all")) {
                S = (1<<20)-1;
//                S = Integer.parseInt("111111111111111111111", 2);
            } else if (method.equals("empty")) {
                S = 0;
            }
        }

        System.out.println(sb.toString());
    }
}
