package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 백준님께서 이렇게 짧게 짜셨는데... 나랑 메모리나 시간이나 별 차이 안남! 

public class boj10610_30_short {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		char[] s = sc.next().toCharArray();
		int sum = 0;
		
		for (int i = 0; i < s.length; i++) {
			sum += s[i]-'0';
		}
		
		Arrays.sort(s);
		if (sum%3 == 0 && s[0] == '0') {
			for (int i = s.length-1; i >= 0; i--)
				System.out.print(s[i]);
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
}
