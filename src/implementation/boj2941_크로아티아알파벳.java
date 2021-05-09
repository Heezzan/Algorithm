package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2941_크로아티아알파벳 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cro = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String word = br.readLine();

        for (String each : cro) {
            word = word.replace(each, "0");
        }

        System.out.println(word.length());
    }
}
