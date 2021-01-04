package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class boj10799_쇠막대기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		Stack<Integer> st = new Stack<>();
		
		int result = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				st.add(i);
			} else if (input.charAt(i) == ')') {
				if (st.peek() == i-1) {	// 레이저일 경우
					st.pop();
					result += st.size();
				} else {	// 아닐 경우
					st.pop();
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}

}
