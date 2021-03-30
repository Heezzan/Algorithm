package kakao_internship_2020;

public class prog67256_키패드누르기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
    public static String solution(int[] numbers, String hand) {
        int[][] num = {{3, 1}, {0, 0}, {0, 1}, {0, 2}
                        , {1, 0}, {1, 1, 0}, {1, 2}
                        , {2, 0}, {2, 1, 0}, {2, 2}, {3, 0}, {3, 2}};

        String answer = "";

        int left = 10;
        int right = 11;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int now = numbers[i];
            if (num[now][1] == 0) {
                left = now;
                sb.append("L");
            } else if (num[now][1] == 2) {
                right = now;
                sb.append("R");
            } else {
                int ld = Math.abs(num[now][0]-num[left][0])+Math.abs(num[now][1]-num[left][1]);
                int rd = Math.abs(num[now][0]-num[right][0])+Math.abs(num[now][1]-num[right][1]);
                if (ld < rd || (ld == rd && hand.equals("left"))) {
                    left = now;
                    sb.append("L");
                } else {
                    right = now;
                    sb.append("R");
                }
            }
        }

        return sb.toString();
    }


}
