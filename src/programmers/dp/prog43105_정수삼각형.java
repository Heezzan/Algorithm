package programmers.dp;

public class prog43105_정수삼각형 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) dp[i] = new int[i+1];

        dp[0][0] = triangle[0][0];

        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+triangle[i+1][j]);
                if (j+1 <= i+1) dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+triangle[i+1][j+1]);
            }
        }

        int len = triangle.length-1;
        for (int i = 0; i < dp[len].length; i++)
            answer = Math.max(answer, dp[len][i]);

        return answer;
    }
}
