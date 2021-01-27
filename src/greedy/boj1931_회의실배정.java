package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj1931_회의실배정 {
	
	public static class Conf {
		int start, end;
		
		Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Conf> confs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			confs.add(new Conf(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(confs, new Comparator<Conf>() {

			@Override
			public int compare(Conf o1, Conf o2) {
				if (o1.end == o2.end)
					return Integer.compare(o1.start, o2.start);
				return Integer.compare(o1.end, o2.end);
			}
		});
		
		int last = confs.get(0).end;
		int result = 1;
		for (int i = 1; i < confs.size(); i++) {
			if (confs.get(i).start >= last) {
				result++;
				last = confs.get(i).end;
			}
		}
		
		System.out.println(result);
	}

}
