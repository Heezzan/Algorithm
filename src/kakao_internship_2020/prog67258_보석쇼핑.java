package kakao_internship_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class prog67258_보석쇼핑 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "EM", "EM", "RUB", "DIA"})));
        System.out.println(Arrays.toString(solution(new String[]{"A", "A", "C", "B", "B", "C", "D", "A", "A", "B", "C", "D"})));
    }

    public static int[] solution(String[] gems) {
        int[] answer;
        int[] result = {0, 0, Integer.MAX_VALUE};

        HashSet<String> jewelry = new HashSet<>();
        for (String gem : gems) jewelry.add(gem);

        HashMap<String, Integer> buy = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            buy.put(gems[i], buy.getOrDefault(gems[i], 0)+1);
            if (buy.size() == jewelry.size()) {
                result[0] = 0;
                result[1] = i;
                result[2] = i+1;
                break;
            }
        }

        if (result[2] > jewelry.size()) {
            int si = result[0];
            int ei = result[1];
            int cnt = result[2];

            while (true) {
                if (buy.getOrDefault(gems[si], 0) > 1) {
                    buy.put(gems[si], buy.getOrDefault(gems[si], 0)-1);
                    si++;
                    cnt--;
                } else if (ei+1 < gems.length){
                    ei++;
                    buy.put(gems[ei], buy.getOrDefault(gems[ei], 0)+1);
                    cnt++;
                } else break;

                if (result[2] > cnt) {
                    result[0] = si;
                    result[1] = ei;
                    result[2] = cnt;
                    if (cnt == jewelry.size()) break;
                }
            }
        }

        answer = new int[]{result[0]+1, result[1]+1};
        return answer;
    }
}