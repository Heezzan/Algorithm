package ps;

import java.util.Scanner;

public class boj1259_팰린드롬수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		while(true) {
			if (Integer.parseInt(N) == 0)
				break;
			
			boolean result = true;
			
			for(int i = 0; i < N.length()/2; i++) {
				if (N.charAt(i) != N.charAt(N.length()-1-i)) {
					result = false;
					break;
				}
			}
			
			System.out.println(result ? "yes" : "no");
			N = sc.next();
		}
	}

}
