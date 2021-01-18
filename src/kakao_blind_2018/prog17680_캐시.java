package kakao_blind_2018;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class prog17680_캐시 {
	
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "la", "LA"}));
	}
	
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedHashMap<String, String> cache = new LinkedHashMap<>();
        for (int i = 0; i < cities.length; i++) {
        	if (cacheSize > 0 && cache.containsKey(cities[i].toLowerCase())) {
        		answer += 1;
        		
        		cache.remove(cities[i].toLowerCase());
        		cache.put(cities[i].toLowerCase(), cities[i].toLowerCase());
        	} else {
        		answer += 5;
        		
        		if (cache.size() < cacheSize) {
        			cache.put(cities[i].toLowerCase(), cities[i].toLowerCase());
        		} else {
        			for (Entry<String, String> e : cache.entrySet()) {
        				cache.remove(e.getKey());
        				break;
        			}
        			cache.put(cities[i].toLowerCase(), cities[i].toLowerCase());
        		}
        	}
        }
        

        return answer;
    }

}
