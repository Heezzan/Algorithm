package datastructure;

import java.util.*;

public class boj1302_베스트셀러 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<String, Integer> bookCnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = sc.next();
            bookCnt.put(book, bookCnt.getOrDefault(book, 0)+1);
        }

        String[] books = bookCnt.keySet().toArray(new String[bookCnt.size()]);
        String bestSeller = books[0];
        for (int i = 1; i < books.length; i++) {

            if (bookCnt.get(bestSeller) < bookCnt.get(books[i])) {
                bestSeller = books[i];
            } else if (bookCnt.get(bestSeller) == bookCnt.get(books[i])) {
                if (bestSeller.compareTo(books[i]) > 0) {
                    bestSeller = books[i];
                }
            }
        }

        System.out.println(bestSeller);
    }
}
