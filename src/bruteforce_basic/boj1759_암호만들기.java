package bruteforce_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759_암호만들기 {

    /*
    * 암호는 서로 다른 L개의 알파벳 소문자로 구성, 최소 한개의 모음 + 최소 두 개의 자음
    * 증가하는 순서로 배열
    * C가지의 문자 종류가 있을 때 가능성 있는 암호들 모두 구하기
    *
    * 순열 = nPr = n!/(n-r)!
    * 조합 = nCr = nPr/r! = n!/r!(n-r)!
    * */
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] words = new char[C];
        for (int i = 0; i < C; i++) words[i] = st.nextToken().charAt(0);

        Arrays.sort(words);

        sb = new StringBuilder();
        comb(0,0, 0, 0, new char[L], words);

        System.out.println(sb.toString());
    }

    public static void comb(int idx, int cnt, int con, int vow, char[] result, char[] words) {
        if (idx >= result.length) {
            if (con >= 2 && vow >= 1) {
                for (char c : result)
                    sb.append(c);
                sb.append("\n");
            }
            return;
        }

        if (cnt >= words.length) return;

        result[idx] = words[cnt];
        if (words[cnt] == 'a' || words[cnt] == 'e' || words[cnt] == 'i' || words[cnt] == 'o' || words[cnt] == 'u' ) {
            comb(idx+1, cnt+1, con, vow+1,  result, words);
        } else {
            comb(idx+1, cnt+1, con+1, vow, result, words);
        }
        comb(idx, cnt+1, con, vow, result, words);
    }
}
