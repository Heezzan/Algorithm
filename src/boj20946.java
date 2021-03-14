//import java.io.IOException;
//import java.util.*;
//
//public class boj20946 {
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        Long N = sc.nextLong();
//
//        boolean[] prime = new boolean[1_000_000];
//        for (int i = 2; i <= N; i++) {
//            if (prime[i]) continue;
//            for (int j = 2; j*j <= N; j++) {
//                prime[i*j] = true;
//            }
//        }
//
//
//
//        // N 소인수분해
//        HashMap<Integer, Integer> nps = new HashMap<>();
//        for (int i = 2; i <= Math.sqrt(N); i++) {
//            while (N % i == 0) {
//                nps.put(i, nps.getOrDefault(i, 0)+1);
//                N /= i;
//            }
//            if (N == 1) break;
//        }
//
//        // 그 소인수분해한것들로 합성수 곱 만들꺼야
//        List<Integer> result = new ArrayList<>();
//        for (int i = 4; i < Math.sqrt(N); i++) {
//            // i가 합성수일 때
//            if (nums[i]) {
//                // i 소인수분해
//                HashMap<Integer, Integer> sub = new HashMap<>();
//                int tmp = i;
//                for (int j = 2; j <= i; j++) {
//                    while (tmp%j == 0) {
//                        sub.put(i, sub.getOrDefault(i, 0)+1);
//                        tmp/=j;
//                    }
//                    if(tmp == 1) break;
//                }
//
//                boolean can = true;
//
//                // N 소인수분해한 값들로 i만들 수 있나 확인
//                for (Map.Entry<Integer, Integer> n : sub.entrySet()) {
//                    if (!nps.containsKey(n.getKey()) || nps.get(n.getKey()) < n.getValue()) {
//                        can = false;
//                        break;
//                    }
//                }
//
//                // 만들 수 있으면 값 차감하고 더하기
//                if (can) {
//                    for (Map.Entry<Integer, Integer> n : sub.entrySet()) {
//                        nps.put(n.getKey(), nps.get(n.getKey())-n.getValue());
//                    }
//                    result.add(i);
//                }
//            }
//        }
//
//        if (result.size() == 0) System.out.println(-1);
//        else {
//            for (int i : result)
//                System.out.print(i+" ");
//        }
//    }
//}
