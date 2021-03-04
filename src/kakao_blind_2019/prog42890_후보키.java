package kakao_blind_2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class prog42890_후보키 {
    static List<int[]> list;

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"a", "b", "c"}, {"1", "b", "c"}, {"a", "b", "4"}, {"a", "5", "c"}}));
        System.out.println(solution(new String[][]{{"a", "1", "4"}, {"2", "1", "5"}, {"a", "2", "4"}}));
        System.out.println(solution(new String[][]{{"b", "2", "a", "a", "b"}, {"b", "2", "7", "1", "b"}, {"1", "0", "a", "a", "8"},
                {"7", "5", "a", "a", "9"}, {"3", "0", "a", "f", "9"}}));
        System.out.println(solution(new String[][]{{"100","ryan","music","2"},
                {"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }

    public static int solution(String[][] relation) {
        int answer = 0;
        
        List<int[]> answers = new ArrayList<>();
    
        for (int n = 1; n <= relation[0].length; n++) {
            list = new ArrayList<>();
            comb(0, 0, relation[0].length, new int[n]);

            for (int i = 0; i < list.size(); i++) {
                 int[] cand = list.get(i);

                 boolean[] check = new boolean[relation[0].length];
                 for (int j = 0; j < cand.length; j++) {
                     check[cand[j]] = true;
                 }

                 boolean pass = false;
                 for (int j = 0; j < answers.size(); j++) {
                     int[] compare = answers.get(j);
                     for (int k = 0; k < compare.length; k++) {
                         if (!check[compare[k]]) break;
                         if (k == compare.length-1) {
                             pass = true;
                             j = answers.size()-1;
                             break;
                         }
                     }
                 }

                 if (pass) continue;

                 HashSet<String> fk = new HashSet<>();
                 for (int j = 0; j < relation.length; j++) {
                     StringBuilder sb = new StringBuilder();
                     for (int k = 0; k < cand.length; k++) {
                         sb.append(relation[j][cand[k]]+" ");
                     }

                     if (!fk.add(sb.toString())) break;

                     if (fk.size() == relation.length) {
                         answer++;
                         answers.add(cand);
                     }
                 }
            }
        }
        return answer;
    }

    public static void comb(int idx, int cnt, int n, int[] result) {
        if (idx == result.length) {
            list.add(result.clone());
            return;
        }

        for (int i = cnt; i < n; i++) {
            result[idx] = i;
            comb(idx+1, i+1, n, result);
        }
    }
}
