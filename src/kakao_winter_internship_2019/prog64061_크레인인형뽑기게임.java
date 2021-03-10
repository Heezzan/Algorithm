package kakao_winter_internship_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class prog64061_크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int m = 0; m < moves.length; m++) {
            int i = 0;
            while (i < board[0].length) {
                if (board[i][moves[m]-1] > 0) {
                    list.add(board[i][moves[m]-1]);
                    board[i][moves[m]-1] = 0;
                    break;
                }
                i++;
            }
        }

        Stack<Integer> st = new Stack<>();
        st.push(list.get(0));
        for (int s = 1; s < list.size(); s++) {
            if (!st.isEmpty() && st.peek() == list.get(s)) {
                st.pop();
                answer+=2;
            } else {
                st.push(list.get(s));
            }
        }

        return answer;
    }
}
