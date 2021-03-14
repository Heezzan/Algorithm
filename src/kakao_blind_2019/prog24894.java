package kakao_blind_2019;

public class prog24894 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}}));
        System.out.println(solution(new int[][]{{0,0,0,0,0},{1,0,0,2,0},{1,2,2,2,0},{1,1,0,0,0},{0,0,0,0,0}}));
        System.out.println(solution(new int[][]{{0,0,0,0,0,0,0,0,0,0}
                ,{0,0,0,2,2,0,0,0,0,0}
                ,{0,0,0,2,1,0,0,0,0,0}
                ,{0,0,0,2,1,0,0,0,0,0}
                ,{0,0,0,0,1,1,0,0,0,0}
                ,{0,0,0,0,0,0,0,0,0,0}}
        ));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}
                        ,{0, 2, 2, 0, 0}
                        ,{0, 2, 1, 0, 0}
                        ,{0, 2, 1, 0, 0}
                        ,{0, 0, 1, 1, 0}}));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        boolean atLeast = true;
        int[] top = new int[board[0].length];
        while(atLeast) {
            atLeast = false;
            for (int j = 0; j < board[0].length; j++) {
                for (int i = top[j]; i < board.length-1; i++) {
                    if (board[i][j] > 0) break;
                    if (board[i][j] == 0 && board[i+1][j] > 0) {
                        top[j] = i;
                        board[i][j] = -1;
                        if (i-1 >= 0 && (board[i-1][j] == 0 || board[i-1][j] == -1)) {
                            top[j] = i-1;
                            board[i-1][j] = -1;
                        }
                        break;
                    }
                }
            }

//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    System.out.print(board[i][j] == -1 ? board[i][j]+" " : " "+board[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("-------------------");
//            System.out.println(Arrays.toString(top));

            for (int j = 0; j < board[0].length; j++) {
                for (int i = top[j]; i < board.length-1; i++) {
                    int type = makeBlocks(i, j, board);
                    if (type == 0) continue;
                    else {
                        atLeast = true;
                        answer++;
                        removeBlock(type, i, j, board);
                    }
                }
            }
        }

        return answer;
    }

    public static int makeBlocks(int i, int j, int[][] board) throws IndexOutOfBoundsException{
        int[] square = new int[6];
        int blockNum, cnt;
        boolean make = false;

        if (i+2 < board.length && j+1 < board[0].length) {

            square[0] = board[i][j];    square[1] = board[i][j+1];
            square[2] = board[i+1][j];  square[3] = board[i+1][j+1];
            square[4] = board[i+2][j];  square[5] = board[i+2][j+1];

            cnt = 0; blockNum = 0;
            for (int k = 0; k < square.length; k++) {
                if (square[k] == 0) return 0;
                if (square[k] == -1) cnt++;
                else {
                    if (blockNum == 0) blockNum = square[k];
                    else {
                        if (blockNum != square[k]) break;
                        if (k == square.length-1 && cnt == 2) return 1;
                    }
                }
            }
        }

        if (i+1 < board.length && j+2 < board[0].length) {
            square[0] = board[i][j];    square[1] = board[i][j+1];  square[2] = board[i][j+2];
            square[3] = board[i+1][j];  square[4] = board[i+1][j+1];square[5] = board[i+1][j+2];

            cnt = 0; blockNum = 0;
            for (int k = 0; k < square.length; k++) {
                if (square[k] == 0) return 0;
                if (square[k] == -1) cnt++;
                else {
                    if (blockNum == 0) blockNum = square[k];
                    else {
                        if (blockNum != square[k]) break;
                        if (k == square.length-1 && cnt == 2) return 2;
                    }
                }
            }
        }

        return 0;
    }

    public static void removeBlock(int type, int i, int j, int[][] board) {

        if (type == 1) {
            board[i][j] = board[i][j+1] = board[i+1][j] = board[i+1][j+1] = board[i+2][j] = board[i+2][j+1] = 0;
        } else if (type == 2) {
            board[i][j] = board[i][j+1] = board[i][j+2] = board[i+1][j] = board[i+1][j+1] = board[i+1][j+2] = 0;
        }
    }

}
