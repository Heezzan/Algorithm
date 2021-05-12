package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20166_문자열지옥에빠진호석 {

    public static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public static class Pos {
        int i, j;
        StringBuilder sb;

        Pos(int i, int j, StringBuilder sb) {
            this.i = i;
            this.j = j;
            this.sb = sb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Pos> q = new LinkedList<>();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                StringBuilder sb = new StringBuilder();
                q.add(new Pos(i, j, sb.append(map[i][j])));
            }
        }

        String[] result = new String[K];
        HashMap<String, Integer> words = new HashMap<>();
        HashSet<String> sub = new HashSet<>();
        for (int i = 0; i < K; i++) {
            result[i] = br.readLine();
            words.put(result[i], 0);
            for (int j = 0; j < result[i].length(); j++) {
                sub.add(result[i].substring(0, j+1));
            }
        }

        while(!q.isEmpty()) {
            Pos now = q.poll();

            if (words.containsKey(now.sb.toString())) {
                words.put(now.sb.toString(), words.getOrDefault(now.sb.toString(), 0)+1);
            }

            for (int d = 0; d < dir.length; d++) {
                int ni = (now.i + dir[d][0] + N) % N;
                int nj = (now.j + dir[d][1] + M) % M;

                StringBuilder sb = new StringBuilder();
                sb.append(now.sb).append(map[ni][nj]);

                if (sub.contains(sb.toString())) q.add(new Pos(ni, nj, sb));
            }
        }

        for (int i = 0; i < result.length; i++)
            System.out.println(words.getOrDefault(result[i], 0));
    }
}
