package programmers.hash;

import java.util.HashMap;

public class prog42576_완주하지못한선수 {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> player = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            player.put(participant[i], player.getOrDefault(participant[i], 0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            if (player.get(completion[i]) == 1) {
                player.remove(completion[i]);
            } else {
                player.put(completion[i], player.get(completion[i])-1);
            }
        }

        for (String s : player.keySet())
            answer = s;

        return answer;
    }
}
