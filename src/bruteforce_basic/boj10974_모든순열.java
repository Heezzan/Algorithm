package bruteforce_basic;

import java.util.Scanner;

public class boj10974_모든순열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i+1;

        do {
            for (int i = 0; i < N; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        } while(next_permutation(arr));
    }

    public static boolean next_permutation(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] >= arr[i]) i--;

        if (i <= 0) return false;

        int j = arr.length-1;
        while (arr[j] <= arr[i-1]) j--;

        int tmp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = tmp;

        j = arr.length-1;
        while(i <= j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }

        return true;
    }
}
