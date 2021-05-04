package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12886_돌그룹 {

    public static class Stone {
        int a, b, c;

        Stone(int[] arr) {
            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stone stone = (Stone) o;
            return a == stone.a &&
                    b == stone.b &&
                    c == stone.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stones = new int[3];
        stones[0] = Integer.parseInt(st.nextToken());
        stones[1] = Integer.parseInt(st.nextToken());
        stones[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(stones);

        Queue<int[]> q = new LinkedList<>();
        HashSet<Stone> visited = new HashSet<>();
        q.add(stones);
        visited.add(new Stone(stones));

        boolean possible = false;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            List<Stone> list = new ArrayList<>(visited);
            for (Stone s : list)
                System.out.print("("+s.a+" "+s.b+" "+s.c+") ");
            System.out.println();

            if (now[0] == now[1] && now[0] == now[2]) {
                possible = true;
                break;
            }

            if (now[0] < now[1] && now[1] != now[0]*2) {
                int[] tmp = {now[0]*2, now[1]-now[0], now[2]};
                Arrays.sort(tmp);
                if (!visited.contains(new Stone(tmp))) {
                    visited.add(new Stone(tmp));
                    q.add(tmp);
                }
            }

            if (now[0] < now[2] && now[2] != now[0]*2) {
                int[] tmp = {now[0]*2, now[1], now[2]-now[0]};
                Arrays.sort(tmp);
                if (!visited.contains(new Stone(tmp))) {
                    visited.add(new Stone(tmp));
                    q.add(tmp);
                }
            }
        }

        System.out.println(possible ? 1 : 0);
    }

}
