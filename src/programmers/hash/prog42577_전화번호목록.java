package programmers.hash;

import java.util.Arrays;

public class prog42577_전화번호목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if(phone_book[i].charAt(0) != phone_book[j].charAt(0)) break;

                if (phone_book[j].length() > phone_book[i].length()
                        && phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
                    return false;
                } else break;
            }
        }
        return answer;
    }
}
