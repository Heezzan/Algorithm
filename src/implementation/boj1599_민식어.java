package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1599_민식어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[]{1, 2, 12, 4, 5, 0, 6, 7, 8, 0, 3, 9, 10, 11, 13, 14, 0, 15, 16, 17, 18, 0, 19, 0, 20, 0};
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.replace("ng", "c");
                String s2 = o2.replace("ng", "c");
                int len = Math.min(s1.length(), s2.length());

                for (int i = 0; i < len; i++) {
                    int val1 = alpha[s1.charAt(i)-'a'];
                    int val2 = alpha[s2.charAt(i)-'a'];

                    if (val1 == val2) continue;
                    else return Integer.compare(val1, val2);
                }

                return Integer.compare(s1.length(), s2.length());
            }
        });

        for (String s : list)
            System.out.println(s);
    }
}
