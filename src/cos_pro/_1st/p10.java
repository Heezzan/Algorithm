package cos_pro._1st;

public class p10 {

    // 연산자 앞 뒤의 숫자
    static class Pair{
        public int firstNum;
        public int secondNum;
    }

    // 실제 연산자에 따라 계산을해서 리턴을 하는 함수
    public static int func_a(int numA, int numB, char exp){
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }

    // 문자열을 입력으로 받고 연산자의 위치를 리턴하는 함수
    public static int func_b(String exp){
        for(int i = 0; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }
    
    // 연산자의 앞 뒤 숫자를 Pair 쌍으로 리턴하는 함수
    public static Pair func_c(String exp, int idx){
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }

    public static int solution(String expression) {
        int expIndex = func_b(expression);
        Pair numbers = func_c(expression, expIndex);
        int result = func_a(numbers.firstNum, numbers.secondNum, expression.charAt(expIndex));
        return result;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        String expression = "123+12";
        int ret = solution(expression);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }


}
