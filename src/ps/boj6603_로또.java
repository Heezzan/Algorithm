package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6603_로또 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			if (N == 0)
				break;
			
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0, arr, new int[6]);
			System.out.println();
		}
	}
	
	public static void combination(int idx, int cnt, int[] origin, int[] result) {
		
		if (idx == result.length) {
			for (int i = 0; i < result.length; i++)
				System.out.print(result[i]+" ");
			System.out.println();
			return;
		}
		
		if (cnt >= origin.length)
			return;
		
		result[idx] = origin[cnt];
		combination(idx+1, cnt+1, origin, result);
		combination(idx, cnt+1, origin, result);
	}
}
