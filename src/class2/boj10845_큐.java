package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10845_큐 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] q = new int[N];
		int size = 0;
		
		while (N > 0) {
			N--;
			String s = br.readLine();
			
			if (s.equals("pop")) {
				System.out.println(size == 0 ? "-1" : q[0]);
				if (size != 0) {
					for (int i = 0; i < size; i++)
						q[i] = q[i+1];
					size--;
				}
			} else if (s.equals("size")) {
				System.out.println(size);
			} else if (s.equals("empty")) {
				System.out.println(size == 0 ? "1" : "0");
			} else if (s.equals("front")) {
				System.out.println(size == 0 ? "-1" : q[0]);
			} else if (s.equals("back")) {
				System.out.println(size == 0 ? "-1" : q[size-1]);
			} else {	// push
				int num = Integer.parseInt(s.split(" ")[1]);
				q[size++] = num;
			}
		}
	}
}
