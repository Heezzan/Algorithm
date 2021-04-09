package cos_pro._1st;

public class p2 {

    public static int solution(int n) {
        // Write code here.
        int answer = 0;

        int[][] map = new int[n][n];
        int si = 0, sj = 0;
        int ei = n-1, ej = n-1;
        int num = 1;

        while(si <= ei && sj <= ej) {
            for (int j = sj; j <= ej; j++) map[si][j] = num++;
            for (int i = si+1; i <= ei; i++) map[i][ej] = num++;
            for (int j = ej-1; j >= sj; j--) map[ei][j] = num++;
            for (int i = ei-1; i > si; i--) map[i][si] = num++;
            si++; sj++;
            ei--; ej--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(map[i][j]+" ");
            System.out.println();
        }

        for (int i = 0; i < n; i++) answer += map[i][i];

        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        int n1 = 3;
        int ret1 = solution(n1);


        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int n2 = 2;
        int ret2 = solution(n2);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret2 + " .");

        System.out.println(solution(5));
    }
}
