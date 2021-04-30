package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11279_최대힙_직접구현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heap = new int[N+1];
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (idx == 0) sb.append("0\n");
                else if (idx == 1) {
                    sb.append(heap[1]+"\n");
                    heap[idx--] = 0;
                } else {
                    sb.append(heap[1]+"\n");

                    heap[1] = heap[idx];
                    heap[idx--] = 0;
                    int now = 1;

                    while(true) {   // 자식중 나보다 큰 값이 있으면 교환
                        // 자식 중 나보다 큰 값이 있으면 교환해
                        // 근데 자식 둘이 다 나보다 크면 둘 중 큰 값이랑 교환해야해
                        int child1 = now*2 >= N ? N-1 : now*2;
                        int child2 = now*2+1 >= N ? N-1 : now*2+1;

                        if (heap[now] > heap[child1] && heap[now] > heap[child2]) break;
                        else if (heap[child1] > heap[child2]) {
                            swap(now, child1, heap);
                            now = child1;
                        } else {
                            swap(now, child2, heap);
                            now = child2;
                        }
                    }
                }
            } else {
                // 맨 아래에 넣고 쭉쭉 올라가
                heap[++idx] = input;
                int now = idx;

                while (true) {
                    if (heap[now] > heap[now/2] && now/2 > 0) {
                        swap(now, now/2, heap);
                        now = now/2;
                    } else break;
                }
            }
        }

        System.out.println(sb.toString());

    }

    public static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
