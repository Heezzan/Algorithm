package greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1541_잃어버린괄호 {
	/*
	 * 정규식을 사용하면 편한것을 알지만.. 정규식을 잘 모르겠어서 직접 자름
	 * 다른 사람 코드를 보니 우선 -로 split한 후 split 결과로 생성된 배열을 돌며 그 안에서 +로 split
	 * 이 때 첫번째 -로 split된 곳에서 +만 +를 진행하고 그 외에서는 다 -
	 * 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		Queue<Integer> nums = new LinkedList<>();
		Queue<Character> ops = new LinkedList<>();
		
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num *= 10;
				num += (s.charAt(i)-'0');
			} else {
				nums.add(num);
				ops.add(s.charAt(i));
				num = 0;
			}
		}
		nums.add(num);
		
		num = nums.poll();
		boolean once = false;
		while(nums.size() > 0) {
			char op = ops.poll();
			
			if (op == '+' && !once) {
				num += nums.poll();
			} else {
				once = true;
				num -= nums.poll();
			}
		}
		
		System.out.println(num);
		
	}

}
