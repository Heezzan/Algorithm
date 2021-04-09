package cos_pro._1st;

public class p3 {

    public static int solution(String pos) {
        // Write code here.
        int answer = 0;

        int[][] dir = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int i = pos.charAt(0)-'A';
        int j = pos.charAt(1)-'1';

        for (int d = 0; d < dir.length; d++) {
            int ni = i + dir[d][0];
            int nj = j + dir[d][1];

            if (ni >= 0 && ni < 8 && nj >= 0 && nj < 8) answer++;
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        String pos = "A7";
        int ret = solution(pos);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
