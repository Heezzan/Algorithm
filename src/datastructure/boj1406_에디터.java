package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj1406_에디터 {
	// 입력 100,000 출력 최대 600,000여서 br/bw로 해줘야된다...
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for (int i = 0; i < origin.length(); i++) {
			left.push(origin.charAt(i));
		}
		
		for (int m = 0; m < M; m++) {
			String[] command = br.readLine().split(" ");
			
			if (command[0].equals("L") && left.size() > 0) {
				right.push(left.pop());
			} else if (command[0].equals("D") && right.size() > 0) {
				left.push(right.pop());
			} else if (command[0].equals("B") && left.size() > 0) {
				left.pop();
			} else if (command[0].equals("P")){
				left.push(command[1].charAt(0));
			}
		}
		
		while(!left.empty()) {
			right.push(left.pop());
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(!right.empty()) {
			bw.write(right.pop());
		}
		bw.flush();
	}

}
