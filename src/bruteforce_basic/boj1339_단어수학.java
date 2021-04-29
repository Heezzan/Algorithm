package bruteforce_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1339_단어수학 {
    
    static boolean[] alpha;
    static String[] words;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        alpha = new boolean[26];
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();

            for (int j = 0; j < words[i].length(); j++) {
                alpha[words[i].charAt(j)-'A'] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i]) cnt++;
        }

        answer = 0;
        perm(0, new int[cnt], new boolean[26]);
        System.out.println(answer);
    }

    public static void perm(int idx, int[] result, boolean[] visited) {
        if (idx >= result.length) {
            int[] num = new int[26];
            for (int i = 0; i < result.length; i++) {
                num[result[i]] = 9-i;
            }

            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                int tmp = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    tmp *= 10;
                    tmp += num[words[i].charAt(j)-'A'];
                }
                sum += tmp;
            }

            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] && !visited[i]) {
                visited[i] = true;
                result[idx] = i;
                perm(idx+1, result, visited);
                visited[i] = false;
            }
        }
    }
}
