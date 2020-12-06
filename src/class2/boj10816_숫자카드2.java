package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj10816_숫자카드2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		String input = br.readLine();
		st = new StringTokenizer(input);
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				map.replace(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		input = br.readLine();
		st = new StringTokenizer(input);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			if (map.containsKey(key)) {
				bw.write(map.get(key)+" ");
			} else {
				bw.write("0 ");
			}
		}
		
		bw.flush();
		
	}

}
