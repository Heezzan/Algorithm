package kakao_blind_2018;

public class prog17687_n진수게임 {
	
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16, 16, 2, 1));
		System.out.println(solution(16, 16, 2, 2));
	}
	
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int number = 0;
        int turn = 1;
        while (answer.length() < t) {
        	String ton = "";
        	
        	int num = number;
        	while(num >= n) {
        		int mod = num % n;
        		
        		if (mod < 10) {
        			ton += mod;
        		} else if (mod == 10) {
        			ton += 'A';
        		} else if (mod == 11) {
        			ton += 'B';
        		} else if (mod == 12) {
        			ton += 'C';
        		} else if (mod == 13) {
        			ton += 'D';
        		} else if (mod == 14) {
        			ton += 'E';
        		} else if (mod == 15) {
        			ton += 'F';
        		}
        		num/=n;
        	}
        	
        	if (num < 10) {
    			ton += num;
    		} else if (num == 10) {
    			ton += 'A';
    		} else if (num == 11) {
    			ton += 'B';
    		} else if (num == 12) {
    			ton += 'C';
    		} else if (num == 13) {
    			ton += 'D';
    		} else if (num == 14) {
    			ton += 'E';
    		} else if (num == 15) {
    			ton += 'F';
    		}
        	
        	for (int i = ton.length()-1; i >= 0; i--) {
        		if (turn == p) {
        			answer += ton.charAt(i);
        		}
        		turn++;
        		if (turn > m)	turn = 1;
        	}
        	
        	number++;
        }
        
        return answer.substring(0, t);
    }

}

/*
 * 0 1 10 11 100 101 111
 * 
 *  0111
 *  
 * 
 */
