package cos_pro._1st;

public class p7 {
    // n일동안 한번만 살 수 있고, 한번만 팔 수 있음.
    // 산 날에 바로 팔 수 없고, 하루가 지나야 팔 수 있음.
    // 적어도 한 번은 사야되고 한 번은 팔아야 함.
    public static int solution(int[] prices){
        int INF = 1000000001;
        int tmp = INF;   // 젤 최소값 저장
        int answer = -INF;
        for(int price : prices){
            if(tmp != INF)
                answer = Math.max(answer, price - tmp);
            tmp = Math.min(tmp, price);
        }
        return answer;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3};
        int ret1 = solution(prices1);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int[] prices2 = {3, 1};
        int ret2 = solution(prices2);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }

}
