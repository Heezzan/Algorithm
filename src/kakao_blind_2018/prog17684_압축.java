package kakao_blind_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class prog17684_압축 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
	}
	
    public static int[] solution(String msg) {
    	int[] answer;
        List<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i = 0; i < 26; i++)
        	dic.put(Character.toString('A'+i), i+1);
        
        
        int idx = 0;
        while(idx < msg.length()) {
        	int cnt = 0;
        	while(idx+cnt < msg.length() && dic.containsKey(msg.substring(idx, idx+cnt+1)))
        		cnt++;
        	
        	result.add(dic.get(msg.substring(idx, idx+cnt)));
        	if (idx+cnt+1 < msg.length())
        		dic.put(msg.substring(idx, idx+cnt+1), dic.size()+1);
        	
        	idx += cnt;
        }
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) 
        	answer[i] = result.get(i);
        
        return answer;
    }

}
