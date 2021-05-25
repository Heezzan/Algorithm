import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21771_가희야거기서자는거아니야 {

    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = stoi(st.nextToken());
        int C = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int gi = stoi(st.nextToken()), gj = stoi(st.nextToken());
        int pi = stoi(st.nextToken()), pj = stoi(st.nextToken());

        char[][] map = new char[R][C];

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'P') cnt++;
            }
        }

        System.out.println(cnt == pi*pj ? 0 : 1);
    }
}
