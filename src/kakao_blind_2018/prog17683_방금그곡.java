package kakao_blind_2018;

public class prog17683_방금그곡 {
	
	public static void main(String[] args) {
		System.out.println(solution("ABCDEFG",new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(solution("CC#BCC#BCC#BCC#B",new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
		System.out.println(solution("ABC",new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(solution("A#",new String[] {"13:00,13:02,HAPPY,C#A#"}));
		System.out.println(solution("CDEFGAC",new String[] {"12:00,12:06,HELLO,CDEFGA"}));
		System.out.println(solution("CCB",new String[] {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"}));
	}
	
	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int ptime = 0;
        
        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
        
        for (int i = 0; i < musicinfos.length; i++) {
        	String[] info = musicinfos[i].split(",");
        	int time = Integer.parseInt(info[1].substring(0, 2))*60 + Integer.parseInt(info[1].substring(3, 5));
        	time -= (Integer.parseInt(info[0].substring(0, 2))*60 + Integer.parseInt(info[0].substring(3, 5)));
        	
        	info[3] = info[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");
        	
        	String melodi = "";
        	for (int j = 0; j < time/info[3].length(); j++) {
        		melodi += info[3];
        	}
        	melodi += info[3].substring(0, time%info[3].length());
        	
        	for (int t = 0; t < melodi.length()-m.length()+1; t++) {
        		for (int j = 0; j < m.length(); j++) {
        			if (m.charAt(j) != melodi.charAt(t+j))
        				break;
        			
        			if (j == m.length()-1 && ptime < time) {
        				ptime = time;
        				answer = info[2];
        			}
        		}
        	}
        }
        
        return ptime == 0 ? "(None)" : answer;
    }

}
