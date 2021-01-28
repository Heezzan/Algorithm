package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class boj10610_30 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		String N = sc.next();
		
		int sum = 0;
		int zero = 0;
		
		int[] arr = new int[N.length()];
		for (int i = 0; i < N.length(); i++) {
			arr[i] = N.charAt(i)-'0';
			if (arr[i] == 0)	zero++;
			sum += arr[i];
		}
		
		if (sum%3 == 0 && zero > 0) { 
			Arrays.sort(arr);
			for (int i = arr.length-1; i >= 0; i--)
				System.out.print(arr[i]);
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
}
