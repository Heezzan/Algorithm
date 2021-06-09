package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

public class prog42578_위장 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> type = new HashMap<>();
        for (String[] each : clothes) {
            type.put(each[1], type.getOrDefault(each[1], 0)+1);
        }

        int answer = 1;
        Iterator iter = type.keySet().iterator();
        while(iter.hasNext()) {
            answer *= type.get(iter.next())+1;
        }

        return answer-1;
    }

    /*
    // 시간초과 코드 = 직접 조합 구해서 적어도 옷을 하나라도 입는 경우 카운팅 => 적어도에서 힌트를 얻어야 됨!
    static int answer;
    static HashMap<String, Integer> type;

    public static int solution(String[][] clothes) {

        type = new HashMap<>();
        for (String[] each : clothes) {
            type.put(each[1], type.getOrDefault(each[1], 0)+1);
        }

        Iterator iter = type.keySet().iterator();
        String[] kindname = new String[type.keySet().size()];
        int idx = 0;
        while (iter.hasNext()) {
            kindname[idx++] = iter.next().toString();
        }
        answer = 0;
        for (int i = 1; i <= kindname.length; i++) {
            comb(0, 0, new String[i], kindname);
        }

        return answer;
    }

    public static void comb(int idx, int cnt, String[] result, String[] origin) {

        if (idx == result.length) {
            int n = 1;

            for (int i = 0; i < result.length; i++) {
                n *= type.get(result[i]);
            }

            answer += n;
            return;
        }

        if (cnt >= origin.length) return;

        comb(idx, cnt+1, result, origin);
        result[idx] = origin[cnt];
        comb(idx+1, cnt+1, result, origin);

    }
    */
}
