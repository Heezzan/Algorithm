package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj1744_수묶기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int zero = 0, one = 0;
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n > 1)	pos.add(n);
			else if (n == 1) one++;
			else if (n == 0) zero++;
			else	neg.add(n);
		}
		
		Collections.sort(pos);
		Collections.reverse(pos);
		Collections.sort(neg);
		
		int result = 0;
		for (int i = 0; i < pos.size()-1; i+=2)
			result += (pos.get(i)*pos.get(i+1));
		if (pos.size()%2 == 1)	result += pos.get(pos.size()-1);
		
		for (int i = 0; i < neg.size()-1; i+=2) 
			result += (neg.get(i)*neg.get(i+1));
		if (neg.size()%2 == 1 && zero == 0)	result += neg.get(neg.size()-1);
		
		System.out.println(result+one);
	}

}
