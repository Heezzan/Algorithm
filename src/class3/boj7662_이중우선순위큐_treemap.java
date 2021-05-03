package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class boj7662_이중우선순위큐_treemap {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            int T = stoi(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int t = 1; t <= T; t++) {
                String[] input = br.readLine().split(" ");

                if (input[0].equals("I")) {   // 삽입
                    int value = stoi(input[1]);
                    map.put(value, map.getOrDefault(value, 0)+1);
                } else {    // 삭제
                    if (map.size() == 0) continue;

                    if (Integer.parseInt(input[1]) == 1) remove(map.lastKey(), map);
                    else remove(map.firstKey(), map);
                }
            }

            if (map.size() == 0) sb.append("EMPTY\n");
            else sb.append(map.lastKey()+" "+map.firstKey()+"\n");

        }

        System.out.println(sb.toString());

    }

    public static void remove(int key, TreeMap<Integer, Integer> map) {
        if (map.get(key) > 1) map.put(key, map.get(key)-1);
        else map.remove(key);
    }
}
