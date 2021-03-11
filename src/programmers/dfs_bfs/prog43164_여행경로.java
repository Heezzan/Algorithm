package programmers.dfs_bfs;

import java.util.Arrays;
import java.util.Comparator;

public class prog43164_여행경로 {
    static String[] answer;

    public String[] solution(String[][] tickets) {
        answer = null;

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        dfs("ICN", tickets, new boolean[tickets.length], 0, new String[tickets.length+1]);


        return answer;
    }

    public void dfs(String start, String[][] tickets, boolean[] visited, int idx, String[] path) {
        if (idx == tickets.length) {
            if (answer != null) return;
            path[idx] = start;
            answer = path.clone();
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                path[idx] = tickets[i][0];
                dfs(tickets[i][1], tickets, visited, idx+1, path);
                visited[i] = false;
            }
        }
    }
}
