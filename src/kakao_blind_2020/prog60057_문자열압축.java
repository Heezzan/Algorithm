package kakao_blind_2020;

public class prog60057_문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = 0;
        String answer_str = s;

        for (int i = 1; i <= s.length()/2; i++) {   // 얘는 몇개로 자를건지
            StringBuilder sb = new StringBuilder(); // 얘는 i개로 자른 애들 압축해볼꺼임
            int cnt = 1;

            for (int j = 1; i*j <= s.length(); j++) {
                if (i*(j+1) <= s.length()
                        && s.substring(i*(j-1), i*j).equals(s.substring(i*j, i*(j+1)))) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(s.substring(i*(j-1), i*j));
                    } else {
                        sb.append(cnt);
                        sb.append(s.substring(i*(j-1), i*j));
                    }
                    cnt = 1;
                }
                if (i*(j+1) > s.length() && i*j < s.length()) sb.append(s.substring(i*j, s.length()));
            }
            if (sb.toString().length() < answer_str.length()) answer_str = sb.toString();
        }
        answer = answer_str.length();
        return answer;
    }

}
