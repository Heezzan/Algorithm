package kakao_blind_2019;

import java.util.*;

public class prog42892_길찾기게임 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{5, 3}, {11, 5}, {13, 3}
        , {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2} })));
    }

    static class Node {
        int idx, x, y;

        Node (int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y != o2.y) return -Integer.compare(o1.y, o2.y);
                else return Integer.compare(o1.x, o2.x);
            }
        });

        int start = nodes.get(0).idx;
        int[][] tree = new int[nodeinfo.length+1][2];
        for (int i = 1; i < nodes.size(); i++) {
            maketree(start, nodes.get(i), tree, nodeinfo);
        }

        String[] pre = preorder(start, tree, new StringBuilder()).toString().split(" ");
        String[] post = postorder(start, tree, new StringBuilder()).toString().split(" ");

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = Integer.parseInt(pre[i]);
            answer[1][i] = Integer.parseInt(post[i]);
        }

        return answer;
    }

    public static void maketree(int idx, Node n, int[][] tree, int[][] nodeinfo) {
        
        // 현재 x 가 idx의 x보다 작으면 왼쪽 노드로 보내야됨
        if (n.x < nodeinfo[idx-1][0]) {
            if (tree[idx][0] == 0) tree[idx][0] = n.idx;
            else maketree(tree[idx][0], n, tree, nodeinfo);
        } else {
            if (tree[idx][1] == 0) tree[idx][1] = n.idx;
            else maketree(tree[idx][1], n, tree, nodeinfo);
        }
    }

    public static StringBuilder preorder(int n, int[][] tree, StringBuilder sb) {

        sb.append(n+" ");
        if (tree[n][0] != 0) preorder(tree[n][0], tree, sb);
        if (tree[n][1] != 0) preorder(tree[n][1], tree, sb);
        return sb;
    }

    public static StringBuilder postorder(int n, int[][] tree, StringBuilder sb) {
        if (tree[n][0] != 0) postorder(tree[n][0], tree, sb);
        if (tree[n][1] != 0) postorder(tree[n][1], tree, sb);
        sb.append(n+" ");
        return sb;
    }
}
