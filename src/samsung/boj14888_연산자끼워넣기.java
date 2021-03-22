package samsung;

import java.util.Scanner;

public class boj14888_연산자끼워넣기 {
    static int[] nums;
    static int min, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        calculate(1, nums[0], sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int idx, int result, int plus, int minus, int mul, int div) {
        if (idx == nums.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        if (plus > 0) calculate(idx+1, result+nums[idx], plus-1, minus, mul, div);
        if (minus > 0) calculate(idx+1, result-nums[idx], plus, minus-1, mul, div);
        if (mul > 0) calculate(idx+1, result*nums[idx], plus, minus, mul-1, div);
        if (div > 0) calculate(idx+1, result/nums[idx], plus, minus, mul, div-1);
    }
}
