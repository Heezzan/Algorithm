package programmers.greedy;

import java.util.Arrays;

public class prog42885_구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0, right = people.length-1;

        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            answer++;
            right--;
        }

        return answer;
    }
}
