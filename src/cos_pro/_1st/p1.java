package cos_pro._1st;

public class p1 {
    public static void main(String[] args) {
        long num = 9949999;
        long ret = solution(num);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
        System.out.println(solution(19));
    }

    public static long solution(long num) {
        long answer = 0;

        String s = Long.toString(num+1);
        s.replace('0', '1');
        answer = Long.parseLong(s);


        return answer;
    }
}
