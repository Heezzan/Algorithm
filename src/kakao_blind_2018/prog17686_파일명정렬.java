package kakao_blind_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class prog17686_파일명정렬 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
		System.out.println(Arrays.toString(solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
	}
	
	public static class Fname {
		String origin, head, number;
		
		Fname(String origin) {
			this.origin = origin;
			
			int si = 0, ei = 0;
			boolean find = false;
			for (int i = 0; i < origin.length(); i++) {
				if (!find && Character.isDigit(origin.charAt(i))) {
					si = i;
					find = true;
				}
				if (find && !Character.isDigit(origin.charAt(i))) {
					ei = i;
					break;
				}
			}
			
			if (ei == 0)	ei = origin.length();
			this.head = origin.substring(0, si);
			this.number = origin.substring(si, ei);
		}
	}
	
	public static String[] solution(String[] files) {
        String[] answer;
        
        List<Fname> flist = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
        	flist.add(new Fname(files[i]));
        }
        
        Collections.sort(flist, new Comparator<Fname>() {

			@Override
			public int compare(Fname o1, Fname o2) {
				if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) == 0) {
					if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) {
						return 0;
					} else {
						return Integer.parseInt(o1.number)-Integer.parseInt(o2.number);
					}
				} else { 
					return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
				}
			}
		});
        
        
        answer = new String[flist.size()];
        for (int i = 0; i < flist.size(); i++)
        	answer[i] = flist.get(i).origin;
        	
        return answer;
    }
}
