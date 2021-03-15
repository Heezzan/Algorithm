package kakao_blind_2020;

public class prog60059_자물쇠와열쇠 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        boolean[][] door = new boolean[key.length*2+ lock.length-2][key.length*2+ lock.length-2];
        int cnt = 0;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 1) door[i+ key.length-1][j+ key.length-1] = true;
                else cnt++;
            }
        }

        for (int i = 0; i < door.length; i++) {
            for (int j = 0; j < door.length; j++)
                System.out.print(door[i][j] ? "1 " : "0 ");
            System.out.println();
        }

        for (int d = 0; d < 4; d++) {
            for (int i = 0; i <= door.length- key.length; i++) {
                for (int j = 0; j <= door.length- key.length; j++) {
                    boolean same = true;
                    int fill = 0;

                    for (int ii = 0; ii < key.length; ii++) {
                        for (int jj = 0; jj < key.length; jj++) {

                            if (i+ii >= key.length-1 && j+jj >= key.length-1
                                    && i+ii <= door.length- key.length && j+jj <= door.length- key.length) {
                                if (!door[i+ii][j+jj] && key[ii][jj] == 1) fill++;
                                if ((door[i+ii][j+jj] && key[ii][jj] == 1) || (!door[i+ii][j+jj] && key[ii][jj] == 0)) {
                                    same = false;
                                    ii = key.length;
                                    break;
                                }
                            }
                        }
                    }
                    if (same && fill == cnt) {
                        answer = true;
                        i = door.length- key.length+1;
                        break;
                    }
                }
            }

            if (answer) break;
            lotation(key);
        }

        return answer;
    }

    public static void lotation(int[][] key) {
        int[][] tmp = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) tmp[i] = key[i].clone();

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = tmp[key.length-1-j][i];
            }
        }
    }
}
