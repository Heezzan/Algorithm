package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20207_달력 {
    public static int stoi(String s) {return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        StringTokenizer st = null;
        int[] calendar = new int[366];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            for (int j = start; j <= end; j++)
                calendar[j]++;
        }

        int result = 0;

        for (int i = 1; i < calendar.length; i++) {
            if (calendar[i] > 0) {
                int max = 0;
                for (int j = i; j < calendar.length; j++) {
                    if (calendar[j] > 0) {
                        max = Math.max(max, calendar[j]);
                        if (j == calendar.length-1) {
                            result += max*(j-i+1);
                            i = calendar.length;
                            break;
                        }
                    } else {
                        result += max*(j-i);
                        i = j;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }

}
