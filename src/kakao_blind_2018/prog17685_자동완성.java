package kakao_blind_2018;

import java.util.Arrays;

public class prog17685_자동완성 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"go", "gone", "guild"}));
        System.out.println(solution(new String[]{"abc", "def", "ghi", "jklm"}));
        System.out.println(solution(new String[]{"word", "war", "warrior", "world"}));
    }

    public static int solution(String[] words) {
        int answer = 0;

        Arrays.sort(words);
        String[] search = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            search[i] = words[i].substring(0, 1);
        }

        for (int i = 0; i < words.length-1; i++) {

            if (search[i].equals(search[i+1])) {
                String s = search[i];

                for (int j = i; j < words.length; j++) {
                    if (s.equals(search[j])) {
                        if (!search[j].equals(words[j]))
                            search[j] = words[j].substring(0, s.length()+1);
                    } else  break;
                }
                i--;
                continue;
            }
        }

        for (int i = 0; i < search.length; i++)
            answer += search[i].length();
        
        return answer;
    }
}
