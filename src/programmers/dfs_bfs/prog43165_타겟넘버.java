package programmers.dfs_bfs;

public class prog43165_타겟넘버 {
    int cnt = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);

        answer = cnt;
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int result) {
        if (idx == numbers.length) {
            if (result == target)
                cnt++;
            return;
        }

        dfs(numbers, target, idx+1, result+numbers[idx]);
        dfs(numbers, target, idx+1, result-numbers[idx]);
    }
}
