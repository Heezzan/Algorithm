package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21776_가희와읽기쓰기놀이 {

    static int N, C;
    static String[] person, cards;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        person = new String[N];
        for (int i = 0; i < N; i++) {
            person[i] = br.readLine();
        }

        cards = new String[C];
        for (int i = 0; i < C; i++) {
            cards[i] = br.readLine();
        }

        int[] arr = new int[C];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int cardCnt = person[i].charAt(0)-'0';
            while(cardCnt > 0) {
                arr[idx++] = i;
                cardCnt--;
            }
        }

        answer = new TreeSet<>();
        perm(0, arr, new int[arr.length], new boolean[arr.length]);

        for (String each : answer) System.out.println(each);
    }

    static void perm(int idx, int[] arr, int[] result, boolean[] visited) {

        if (idx == result.length) {

            int[] useCard = new int[N+1];
            StringBuilder sb = new StringBuilder();
            boolean error = false;

            for (int i = 0; i < result.length; i++) {
                int cardIdx = (person[result[i]].charAt(2*useCard[result[i]]+2) -'0') - 1;
                useCard[result[i]]++;

                String[] operation = cards[cardIdx].split(",");
                for (int oidx = 0; oidx < operation.length; oidx++) {
                    String[] spl = operation[oidx].split(" ");

                    if (spl[0].equals("ADD")) {
                        sb.append(spl[1]);
                    } else {
                        if (sb.length() > Integer.parseInt(spl[1])) {
                            sb.deleteCharAt(Integer.parseInt(spl[1]));
                        } else {
                            error = true;
                            break;
                        }
                    }
                }

                if (error) break;
            }
            if (error) answer.add("ERROR");
            else {
                if (sb.length() == 0) answer.add("EMPTY");
                else answer.add(sb.toString());
            }

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                perm(idx+1, arr, result, visited);
                visited[i] = false;
            }
        }
    }
}
