package programmers.bruteforce;

public class prog42842_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 3; i < (brown+yellow)/2; i++) {
            if ((brown+yellow) % i != 0) continue;
            int r = Math.max(i, (brown+yellow)/i);
            int c = Math.min(i, (brown+yellow)/i);

            if ((r-2)*2+(c*2) == brown) {
                answer[0] = r;
                answer[1] = c;
                break;
            }


        }
        return answer;
    }
}
