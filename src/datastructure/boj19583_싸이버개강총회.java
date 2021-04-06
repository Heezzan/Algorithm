package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj19583_싸이버개강총회 {

    // 1. 개총 시작 전 입장 확인 여부 확인 = 개총 시작 전 대화하거나 개총 시작하자마자 채팅
    // 2. 개총 끝~스트리밍 끝 퇴장 확인 여부 확인 = 개총 끝나자마자 채팅 | 개총 스트리밍 끝나자마자 채팅
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] schedule = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            String t = st.nextToken();
            schedule[i] += Integer.parseInt(t.split(":")[0])*60;
            schedule[i] += Integer.parseInt(t.split(":")[1]);
        }

        HashSet<String> attendant = new HashSet<>();
        int result = 0;

        String input;
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String time = st.nextToken();

            int now = Integer.parseInt(time.split(":")[0])*60;
            now += Integer.parseInt(time.split(":")[1]);

            if (now <= schedule[0]) attendant.add(st.nextToken());
            else if (now >= schedule[1] && now <= schedule[2]) {
                String name = st.nextToken();
                if (attendant.contains(name)) {
                    result++;
                    attendant.remove(name);
                }
            }
            else if (now >= schedule[2]) break;
        }

        System.out.println(result);

    }

}
