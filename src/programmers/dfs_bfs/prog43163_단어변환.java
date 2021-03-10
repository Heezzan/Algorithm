package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class prog43163_단어변환 {

    public static class Word {
        String s;
        int cnt;

        Word(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];

        while(!q.isEmpty()) {
            Word now = q.poll();

            if (now.s.equals(target)) {
                answer = now.cnt;
                break;
            }

            for (int w = 0; w < words.length; w++) {
                int diff = 0;

                for (int idx = 0; idx < words[w].length(); idx++) {
                    if (!visited[w] && words[w].charAt(idx) != now.s.charAt(idx)) diff++;
                }
                if (diff == 1) {
                    visited[w] = true;
                    q.add(new Word(words[w], now.cnt+1));
                }
            }
        }

        return answer;
    }
}
