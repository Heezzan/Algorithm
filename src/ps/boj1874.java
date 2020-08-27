package ps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class boj1874 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String result = "";
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Stack<Number> st = new Stack<>();
		int idx = 0;
		
		for (int i = 1; i <= N; i++) {
			st.push(i);
			result += "+\n";
			
			while(idx < N && !st.empty() && nums[idx] == (int)st.peek()) {
				st.pop();
				result += "-\n";
				idx++;
			}
		}
		
		if (st.size() == 0) {
			bw.write(result);
			bw.flush();
		} else {
			System.out.println("NO");
		}
	}
}
