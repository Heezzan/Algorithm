package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class prog42746_가장큰수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}).equals("6210"));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}).equals("9534330"));
        System.out.println(solution(new int[]{5, 546}).equals("5546"));
        System.out.println(solution(new int[]{0, 0, 0, 0}).equals("0"));
        System.out.println(solution(new int[]{0, 1000, 0, 0}).equals("1000000"));
        System.out.println(solution(new int[]{12, 121}).equals("12121"));
        System.out.println(solution(new int[]{21, 212}).equals("21221"));
        System.out.println(solution(new int[]{0, 5, 10, 15, 20}).equals("52015100"));
        System.out.println(solution(new int[]{1000, 0, 5, 99, 100}).equals("99510010000"));
        System.out.println(solution(new int[]{90,908,89,898,10,101,1,8,9}).equals("990908898988110110"));
        System.out.println(solution(new int[]{40, 403}).equals("40403"));
        System.out.println(solution(new int[]{412, 41}).equals("41412"));
        System.out.println(solution(new int[]{303, 30}).equals("30330"));
        System.out.println(solution(new int[]{10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).equals("987654321101000"));
        System.out.println(solution(new int[]{90,90,90,898,10,101,1,8,9}));
        System.out.println(solution(new int[]{90,898,10,90,90,101,1,8,9}));
    }

    public static String solution(int[] numbers) {

        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return -s1.compareTo(s2);
            }
        });

//        Arrays.sort(nums, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                long num1 = Long.parseLong(o1)*(long)Math.pow(10, o2.length())+Long.parseLong(o2);
//                long num2 = Long.parseLong(o2)*(long)Math.pow(10, o1.length())+Long.parseLong(o1);
//
//                // 크니까 먼저 오게 -1리턴
//                if (num1 > num2) return -1;
////                else if (num1 == num2) return 0;
//                else return 1;
//            }
//        });

        StringBuilder sb = new StringBuilder();
        for (String s : nums) sb.append(s);

        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) zero.append("0");

        if(sb.toString().equals(zero.toString())) return "0";
        else return sb.toString();
    }
}
