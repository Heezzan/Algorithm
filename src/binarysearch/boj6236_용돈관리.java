package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6236_용돈관리 {

    /*
    * N일동안 사용할 금액 계산, M번만 돈을 빼서 쓸거야
    * K원을 인출해서 하루를 보낼 수 있으면 사용, 모자라면 남은 금액을 통장에 집어넣고 다시 K원 꺼냄
    * 정확히 M번을 맞추기 위해 남은 금액이 그날 사용할 금액보다 많더라도 통장에 집어넣고 K원을 인출함
    * 
    * 최소 K를 계산하시오
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[N];
        int start = 0;
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, day[i]);
        }

        int end = N*1000;
        int result = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start+end)/2;
            int left = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (left < day[i]) {
                    cnt++;
                    left = mid;
                }

                left -= day[i];
            }

            System.out.println(mid +" : "+ cnt);

            if (cnt <= M) {
                end = mid -1;
                result = Math.min(result, mid);
            }
            else {
                start = mid+1;
            }
        }

        System.out.println(result);



        
    }
}
